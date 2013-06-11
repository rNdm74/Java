
package xml;


import java.applet.AudioClip;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author rNdm
 */
public class Game extends JPanel implements KeyListener, MouseListener, MouseMotionListener {

    private void play(Graphics2D g) {
        updateAnswer(g);
    
        updateBird(g);

        updateTimesTableLabels(g);
        updateScoreLabel(g);
        updateQuestion(g);
        updateCorrect(g);
        updateTryAgain(g);
    }

    private void updateMenuScreen(Graphics2D g) {
        mtt.update(g, contentPaneDimensions, mousePointer, this);
    }
        
    private void sleep() { }

    private void updateGameOver(Graphics2D g) {
        if (gameEnd) {
            for (int i = 0; i < gameOver.length; i++) {
                gameOver[i].update();
                gameOver[i].setCentre(new Point(
                        ((contentPaneDimensions.width / 2) - 120) + (40 * i),
                        contentPaneDimensions.height / 2 - 50
                ));
            
                gameOver[i].draw(g);
            }   
        }
    }
      
    public Game(SpriteTest spriteTest, Object[] sounds) throws HeadlessException { 
        this.spriteTest = spriteTest;        
        
        Xeq = new Thread();
        
        if (Xeq == null) {  
            Xeq.start();   
        }
        
        bird = (AudioClip) sounds[0];
        eat = (AudioClip) sounds[1];
        newLevel = (AudioClip) sounds[2];
        wrong = (AudioClip) sounds[3];
        
        setFocusable(true);
        requestFocusInWindow();
                
        Dimension res = Toolkit.getDefaultToolkit().getScreenSize();  
        
        setSize(res.width, res.height);
        
        //mousePointer = new Point(res.width /2, res.height/2);
        
        contentPaneDimensions = getSize();
        
        String[] levels = {
            //"One",
            //"Two",
            "Three",
            "Four",
            //"Five",
            "Six",
            "Seven",
            "Eight",
            "Nine",
            //"Ten",
            //"Eleven",
            //"Twelve"                        
        };
        
        for (String s: levels) {
            timesTables.add(new TimesTable(s));
        }
        
        fonts = new ReadXML("desyrel.xml").getImageData("char");
        sprites = new ReadXML("atlas.xml").getImageData("SubTexture");
                        
        Collections.sort(fonts, new CompareTexture());
        
        BufferedImageLoader loader = new BufferedImageLoader();
        BufferedImage spriteSheet = null;
        BufferedImage background = null;
        BufferedImage desyrel = null;
        
        try{
            spriteSheet = loader.loadImage("atlas.png");
            background = loader.loadImage("bg.png");
            desyrel = loader.loadImage("desyrel.png");
        } catch(IOException e){           
        }
        
        ss = new SpriteSheet(spriteSheet);
        bg = new SpriteSheet(background);
        dl = new SpriteSheet(desyrel);
        
        backdrop = bg.getSprite(0, 200, 5955, res.height - 81);
        
        gameFonts = createSprites(dl, fonts);
                       
        for(Image i: gameFonts){
            numbers.add(i);
        }
        
        animator = new Animation(createSprites(ss, sprites), bird);
        animator.setSpeed(90);
        animator.start();
        
        table = timesTables.get(level);
        
        while(playedQuestions.size() != table.getTimesTable().size()) {
            int questionNumber = new Random().nextInt(table.getTimesTable().size());                
            if (!playedQuestions.contains(questionNumber)) {
                playedQuestions.add(questionNumber);
            }
        }
        
        try {
            fm = new FontManager(fonts);
            
            currentQuestion = playedQuestions.get(question);
                                    
            table.getTimesTable().get(currentQuestion).updateQuestion(fm);   
            
            questionWidth = table.getTimesTable().get(currentQuestion).getQuestionSize().width;
            
            table.getTimesTable().get(currentQuestion).setQuestionLocation(new Point(contentPaneDimensions.width/2 - questionWidth/2, contentPaneDimensions.height - 100));
            
            levelLabels = new ArrayList<>();
            
            updateLevelLabels();
            
            mtt = new MenuTimesTables(fm);
            
            correct = new Desyrel[]{
                fm.getLetter("C"),
                fm.getLetter("O"),
                fm.getLetter("R"),
                fm.getLetter("R"),
                fm.getLetter("E"),
                fm.getLetter("C"),
                fm.getLetter("T")
            };
            
            tryAgain = new Desyrel[]{
                fm.getLetter("T"),
                fm.getLetter("R"),
                fm.getLetter("Y"),
                fm.getLetter("A"),
                fm.getLetter("G"),
                fm.getLetter("A"),
                fm.getLetter("I"),
                fm.getLetter("N")
            };
            
            gameOver = new Desyrel[]{
                fm.getLetter("G"),
                fm.getLetter("A"),
                fm.getLetter("M"),
                fm.getLetter("E"),
                fm.getLetter("O"),
                fm.getLetter("V"),
                fm.getLetter("E"),
                fm.getLetter("R")
            };
                        
            timesTableLabel = new Desyrel[]{
                fm.getLetter("T"),
                fm.getLetter("i"),
                fm.getLetter("m"),
                fm.getLetter("e"),
                fm.getLetter("s"),
                fm.getLetter("T"),
                fm.getLetter("a"),
                fm.getLetter("b"),
                fm.getLetter("l"),
                fm.getLetter("e"),
                fm.getLetter(":")
            };
        
            scoreLabel = new Desyrel[]{
                fm.getLetter("s"),
                fm.getLetter("c"),
                fm.getLetter("o"),
                fm.getLetter("r"),
                fm.getLetter("e"),
                fm.getLetter(":")                    
            };
        } catch (IOException ex) {
        }
                
        updateScore();
            
        randomizeTimeTableQuestions();
        
        menu = Display.MENU;
        
        
        addMouseMotionListener(this);
        addMouseListener(this);
        addKeyListener(this);
    }

    private void updateScreenBounds() {
        contentPaneDimensions = getSize();
        
        gameContentArea.y = 200;
        gameContentArea.width = contentPaneDimensions.width;
        gameContentArea.height = contentPaneDimensions.height - 200;
        
        top.y = gameContentArea.y;
        center.y = gameContentArea.y + gameContentArea.height / 3;
        bottom.y = gameContentArea.height;
    }
    
    private int returnLevelNumber(Levels l){
        switch(l){
            case ONE:
                return 1;
            case TWO:
                return 2;
            case THREE:
                return 3;
            case FOUR:
                return 4;
            case FIVE:
                return 5;
            case SIX:
                return 6;
            case SEVEN:
                return 7;
            case EIGHT:
                return 8;
            case NINE:
                return 9;
            case TEN:
                return 10;
            case ELEVEN:
                return 11;
            case TWELVE:
                return 12;
            default:
                return 0;            
        }        
    }
    
    @Override
    public void paint(Graphics g){        
        doubleBufferedImage = createImage(getWidth(), getHeight());
        doubleBufferedGraphics = doubleBufferedImage.getGraphics();
        
        paintComponent((Graphics2D) doubleBufferedGraphics);
        
        g.drawImage(doubleBufferedImage, 0,0,null);
    }    
        
    public void paintComponent(Graphics2D g){          
        updateScreenBounds();
        updateBackground(g);
        
        switch(menu){
            case MENU:  
                updateMenuScreen((Graphics2D) g);
                break;
            case PLAY:
                play(g);
                break;        
        }
                        
        updateGameOver(g);
        
        g.dispose();
        repaint();
    }   

    /**
     * @param level the level to set
     */
    public void setLevel(int level) {
        this.level = level;
    }
    
    //<editor-fold defaultstate="collapsed" desc=" Applet Enums ">
    public static enum Display{
        MENU,
        PLAY        
    }
        
    private enum Direction{
        LEFT,
        RIGHT,
        UP,
        DOWN
    }
    
    private enum Levels{
        ONE,
        TWO,
        THREE,
        FOUR,
        FIVE,
        SIX,
        SEVEN,
        EIGHT,
        NINE,
        TEN,
        ELEVEN,
        TWELVE
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc=" Applet Methods ">
    private ArrayList<BufferedImage> createSprites(SpriteSheet spriteSheet, ArrayList<Texture> textures) {
        ArrayList<BufferedImage> images = new ArrayList<>();
        for (int i = 0; i < textures.size() - 1; i++) {
            Point p = new Point(
                    textures.get(i).getLocation().x,
                    textures.get(i).getLocation().y
            );        

            int width = textures.get(i).getSize().width;
            int height = textures.get(i).getSize().height;
                
            if(textures.size() < 90){            
                if (textures.get(i).getName().contains("flight")) {                  
                    images.add(spriteSheet.getSprite(p.x, p.y, width, height));
                }
            }
            else{
                if (isInteger(textures.get(i).getName())) {
                    images.add(spriteSheet.getSprite(p.x, p.y, width, height));
                }                
            }
        }
        return images;
    }   
    
    private boolean isInteger(String s){
        try{
            Integer.parseInt(s); 
            return true;
        }catch(Exception e){
            return false;
        }
    }  
        
    private void answersReset(String answered) {   
                
        numbersX = contentPaneDimensions.width + 200;
        
        if (question == playedQuestions.size() - 1) {
            newLevel.play();
            if (playerScore > 1000) {
                // progress to next level
                question = 0;
                level++;
                table = timesTables.get(level);
                updateLevelLabels();
            }
            else{
                gameEnd = true;
                menu = Display.MENU;
                // reset game to 3 times table
                playerScore = 0;
                question = 0;
                currentQuestion = 0;
                playedQuestions.clear();
                
                while(playedQuestions.size() != table.getTimesTable().size()) {
                    int questionNumber = new Random().nextInt(table.getTimesTable().size());              
                
                    if (!playedQuestions.contains(questionNumber)) {
                        playedQuestions.add(questionNumber);
                    }
                }
            }                                
        }else{
            // if answer is correct move to next question
            if (answered.equals("correct")) {
                currentQuestion = playedQuestions.get(++question);
            }            
        }
        
        updateScore();
    }
        
    private void updateLevelLabels() {
        for (int timesTable = 0; timesTable < timesTables.size(); timesTable++) {
            
            String s = "";
            
            String tableName = timesTables.get(timesTable).getName();
                        
            for (int i = 0; i < Levels.values().length; i++) {
                if(tableName.equalsIgnoreCase(Levels.values()[i].toString())){
                    s = Integer.toString(returnLevelNumber(Levels.values()[i]));
                }              
            }
            
            Desyrel[] chars = new Desyrel[s.length()];
            
            for (int i = 0; i < s.length(); i++) {                    
                char c = s.charAt(i);                    
                chars[i] = fm.getLetter(Character.toString(c));
            }                
            
            levelLabels.add(chars);
        }
    }

    private void updateBackground(Graphics2D g) {
        if (backgroundX > 5955 * -1) {
            backgroundX -= 0.5f * 2f;
        }
        else{
            backgroundX = 0;
        }
        
        g.drawImage(backdrop, 
                (int)backgroundX,
                (int)backgroundY,
                backdrop.getWidth(this), 
            backdrop.getHeight(this), 
                null
        );
        
        g.drawImage(backdrop, 
                (int)backgroundX + 5955,
                (int)backgroundY,
                backdrop.getWidth(this), 
                backdrop.getHeight(this), 
                null
        );
    }
    
    private void updateAnswer(Graphics2D g) {
        if (numbersX > -10) {
            numbersX -= 3f;
        }
        else{
            numbersX = contentPaneDimensions.width +200;
        }
        
        if (numbersX < contentPaneDimensions.width) {
            answeredCorrect = false;
            answeredWrong = false;
        }
        
        correctAnswerPoint.x = (int)numbersX;
        falseAnswer1Point.x = (int)numbersX;
        falseAnswer2Point.x = (int)numbersX;
        
        correctAnswer = new Answer(table, currentQuestion, fm);
        correctAnswer.setLocation(correctAnswerPoint);
        correctAnswer.update(g);
        
        falseAnswer1 = new Answer(table, falseQuestion1, fm);
        falseAnswer1.setLocation(falseAnswer1Point);
        falseAnswer1.update(g);
        
        falseAnswer2 = new Answer(table, falseQuestion2, fm);
        falseAnswer2.setLocation(falseAnswer2Point);
        falseAnswer2.update(g); 
    }
    
    private void updateBird(Graphics2D g) {
        
        if (animator != null) {
            animator.update(System.currentTimeMillis());
            
            switch(birdDirection){
                case LEFT:
                    clipping = new Rectangle(
                        birdCenter.x - 80, 
                        (birdCenter.y) + (animator.sprite.getHeight()/2) - 80,
                        50,
                        50
                    );
                    break;
                case RIGHT:
                    clipping = new Rectangle(
                        birdCenter.x + 20, 
                        (birdCenter.y) + (animator.sprite.getHeight()/2) - 80,
                        50,
                        50
                    );
                    break;
                case UP:
                    break;
                case DOWN:
                    break;                
            }
            
            
            birdCenter.x += speed.x;
            birdCenter.y += speed.y;
                                    
            Rectangle centre = new Rectangle(
                    birdCenter.x - 10,
                    birdCenter.y - 10,
                    20,20
            );
            
            if (!centre.contains(mousePointer)) {
                if (birdCenter.x < mousePointer.x) {                    
                    birdDirection = Direction.RIGHT;
                    speed.x = 10;
                }
                else{
                    if (birdCenter.x > mousePointer.x - 20 &&
                        birdCenter.x < mousePointer.x + 20) {
                        birdCenter.x = mousePointer.x;
                    }                    
                }

                if (birdCenter.x > mousePointer.x) {
                    birdDirection = Direction.LEFT;
                    speed.x = -10;
                }
                else{
                    if (birdCenter.x > mousePointer.x - 20 &&
                        birdCenter.x < mousePointer.x + 20) {
                        birdCenter.x = mousePointer.x;
                    }                    
                }

                
                if (birdCenter.y < mousePointer.y) {
                    speed.y = 10;
                }
                else{
                    if (birdCenter.y > mousePointer.y - 20 &&
                        birdCenter.y < mousePointer.y + 20) {
                        birdCenter.y = mousePointer.y;
                    }
                }

                if (birdCenter.y > mousePointer.y) {
                    speed.y = -10;
                }
                else{
                    if (birdCenter.y > mousePointer.y - 20 &&
                        birdCenter.y < mousePointer.y + 20) {
                        birdCenter.y = mousePointer.y;
                    }
                }
                
            }else{
                birdCenter = mousePointer;
                speed.x = 0;
                speed.y = 0;
            }
                  
            if (clipping.intersects(correctAnswer.clipping)) {
                sleep();
                answeredCorrect = true;
                correctAnswer.setIsHit(true);
                
                playerScore += 100;
        
                eat.play();
                
                answersReset("correct");
                
                randomizeQuestions();
                
                randomizeTimeTableQuestions();
                
                correctAnswer.setIsHit(false);
            }
            
            if (clipping.intersects(falseAnswer1.clipping)) {
                sleep();
                answeredWrong = true;
                falseAnswer1.setIsHit(true);
                
                playerScore -= 50;
                
                wrong.play();
                                                
                answersReset("wrong");
                
                randomizeQuestions();
                
                randomizeTimeTableQuestions();
                
                falseAnswer1.setIsHit(false);
            }
            
            if (clipping.intersects(falseAnswer2.clipping)) {
                sleep();
                answeredWrong = true;
                falseAnswer2.setIsHit(true);
                
                playerScore -= 150;
                
                wrong.play();
                
                answersReset("wrong");
                
                randomizeQuestions();
                
                randomizeTimeTableQuestions();
                
                falseAnswer1.setIsHit(false);
            }
            
            
                                                
            switch(birdDirection){
                case LEFT:
                    birdPosition.x = (birdCenter.x - animator.sprite.getWidth() / 2) + animator.sprite.getWidth();
                    birdPosition.y = birdCenter.y - animator.sprite.getHeight() / 2;
            
                    g.drawImage(animator.sprite, 
                        birdPosition.x, 
                        birdPosition.y, 
                        -animator.sprite.getWidth(), 
                        animator.sprite.getHeight(),                    
                        null
                    );
                    break;
                case RIGHT:
                    birdPosition.x = (birdCenter.x - animator.sprite.getWidth() / 2);
                    birdPosition.y = birdCenter.y - animator.sprite.getHeight() / 2;
                    
                    
                    
                    g.drawImage(animator.sprite, 
                        birdPosition.x, 
                        birdPosition.y, 
                        animator.sprite.getWidth(), 
                        animator.sprite.getHeight(),                    
                        null
                    );
                    break;            
            }
            
            g.draw(clipping);
        }
    }
    
    private void randomizeQuestions(){
        ArrayList<Point> points = new ArrayList();
        
        points.add(top);
        points.add(center);
        points.add(bottom);
        
        java.util.Collections.shuffle(points);
            
        correctAnswerPoint = points.get(0);
        falseAnswer1Point = points.get(1);
        falseAnswer2Point = points.get(2);
    }
      
    private void randomizeTimeTableQuestions(){
        ArrayList<Integer> questions = new ArrayList();
        
        for (int i = 0; i < 12; i++) {
            if (i != currentQuestion) {
                questions.add(i);
            }
        }
        
        java.util.Collections.shuffle(questions);
            
        falseQuestion1 = questions.get(0);
        falseQuestion2 = questions.get(questions.size()-1);
    }
    
    private void updateTimesTableLabels(Graphics2D g){
        for (int i = 0; i < levelLabels.get(level).length; i++) {
            levelLabels.get(level)[i].update();
            levelLabels.get(level)[i].setCentre(new Point((contentPaneDimensions.width - 60) + (50*i), 50));
            levelLabels.get(level)[i].draw(g);
        }
        
        for (int i = 0; i < timesTableLabel.length; i++) {
            timesTableLabel[i].update();
            timesTableLabel[i].setCentre(new Point((contentPaneDimensions.width - 450) + (30*i), 50));
            timesTableLabel[i].draw(g);
        }
    }
    
    private void updateCorrect(Graphics2D g) {        
        if (answeredCorrect) {
            for (int i = 0; i < correct.length; i++) {
                correct[i].update();
                correct[i].setCentre(new Point(
                        ((contentPaneDimensions.width / 2) - 120) + (40 * i),
                        contentPaneDimensions.height - 50
                ));
            
                correct[i].draw(g);
            }  
        }                   
    }
    
    private void updateTryAgain(Graphics2D g) {
        if (answeredWrong) {
            for (int i = 0; i < tryAgain.length; i++) {
                tryAgain[i].update();
                tryAgain[i].setCentre(new Point(
                        ((contentPaneDimensions.width / 2) - 130) + (40 * i),
                        contentPaneDimensions.height - 50
                ));

                tryAgain[i].draw(g);
            } 
        }           
    }
    
    private void updateScoreLabel(Graphics2D g) {
        for (int i = 0; i < scoreLabel.length; i++) {
            scoreLabel[i].update();
            scoreLabel[i].setCentre(new Point(
                    50 + (30 * i),
                    50
            ));
            
            scoreLabel[i].draw(g);
        }
        
        for (int i = 0; i < score.size(); i++) {
            score.get(i).update();
            score.get(i).setCentre(new Point(300 + (40*i), 50));
            score.get(i).draw(g);
        }
        
    }

    private void updateScore() {
        score.clear();
        String ps = Integer.toString(playerScore);

        for (int i = 0; i < ps.length(); i++) {                
            score.add(fm.getLetter(Character.toString(ps.charAt(i))));
            score.get(i).setCentre(new Point(300 + (40*i), 50));
        }
    }

    private void updateQuestion(Graphics2D g) {
        
        if (!answeredCorrect && !answeredWrong){
            table.getTimesTable().get(currentQuestion).setQuestionLocation(new Point(contentPaneDimensions.width/2 - questionWidth / 2 , contentPaneDimensions.height - 50));
            table.getTimesTable().get(currentQuestion).updateQuestion(fm);        
            table.getTimesTable().get(currentQuestion).drawQuestion(g);
        }        
    }
    //</editor-fold>
        
    //<editor-fold defaultstate="collapsed" desc=" Applet Overrides ">
    @Override
    public void keyTyped(KeyEvent ke) {
    }

    @Override
    public void keyPressed(KeyEvent ke) {
    }

    @Override
    public void keyReleased(KeyEvent ke) {
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        //System.out.println(me.getPoint());
    }

    @Override
    public void mousePressed(MouseEvent me) {
        mousePointer = me.getPoint();
    }

    @Override
    public void mouseReleased(MouseEvent me) {
    }

    @Override
    public void mouseEntered(MouseEvent me) {
    }

    @Override
    public void mouseExited(MouseEvent me) {
    }

    @Override
    public void mouseDragged(MouseEvent me) {
        //mousePointer = me.getPoint();
        //spriteTest.showStatus(me.getPoint().toString());
    }

    @Override
    public void mouseMoved(MouseEvent me) {
        
    }    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc=" Applet Variables ">
    private SpriteTest spriteTest;
    
    Display menu;
    
    private int question;
    
    private ArrayList<BufferedImage> gameFonts;
    
    private ArrayList<Texture> sprites;
    private ArrayList<Texture> fonts;
    
    private ArrayList<TimesTable> timesTables = new ArrayList<>();
    
    TimesTable table;
    
    private Image backdrop;
    
    private ArrayList<Image> numbers = new ArrayList<>();
    
    private SpriteSheet ss;
    private SpriteSheet bg;
    private SpriteSheet dl;
    
    private Animation animator;
        
    private Point speed = new Point();    
    private Point birdCenter = new Point();
    private Point birdPosition = new Point();
    private Point mousePointer = new Point();
       
    
    private float backgroundX = 0f;
    private float backgroundY = 0f;
    
    private float numbersX = 1920f;
    
    private Rectangle clipping;
    
    private Direction birdDirection = Direction.RIGHT;
        
    private Dimension contentPaneDimensions;
    
    private Image doubleBufferedImage;        
    private Graphics doubleBufferedGraphics;
        
    private MenuTimesTables mtt;
    
    private Desyrel[] scoreLabel;    
    private Desyrel[] timesTableLabel;    
    private Desyrel[] correct;
    private Desyrel[] tryAgain;
    private Desyrel[] gameOver;
    
    
    private ArrayList<Desyrel[]> levelLabels;
    
    private ArrayList<Desyrel> score = new ArrayList<>();
    
    private int playerScore = 0;
    
    private int currentQuestion = 0;
    private int falseQuestion1;
    private int falseQuestion2;
    
    private int questionWidth ;
    
    private FontManager fm;
    
    private AudioClip bird;
    private AudioClip eat;
    private AudioClip newLevel;
    private AudioClip wrong;
    
    private Rectangle gameContentArea = new Rectangle();
    
    private Point top = new Point(1920, 280);
    private Point center = new Point(1920, 540);
    private Point bottom = new Point(1920, 800);
    
    private Point correctAnswerPoint = top;
    private Point falseAnswer1Point = center;
    private Point falseAnswer2Point = bottom;
    
    private ArrayList<Integer> playedQuestions = new ArrayList<>();
    
    private Answer correctAnswer;
    private Answer falseAnswer1;
    private Answer falseAnswer2;
    
    boolean answeredCorrect;
    boolean answeredWrong;
    boolean gameEnd;
    
    private int level = 0;
    
    private long timer = 0;
    
    Thread Xeq;
    //</editor-fold>
}
