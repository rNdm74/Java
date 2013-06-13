
package xml;


import java.applet.AudioClip;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
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
import javax.swing.JPanel;

/**
 *
 * @author rNdm
 */
public class Game extends JPanel implements KeyListener, MouseListener, MouseMotionListener {

    public Game(SpriteTest spriteTest, Object[] sounds) throws HeadlessException { 
        this.spriteTest = spriteTest;        
                
        bird = (AudioClip) sounds[0];
        eat = (AudioClip) sounds[1];
        newLevel = (AudioClip) sounds[2];
        wrong = (AudioClip) sounds[3];
                
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
         
        BufferedImageLoader loader = new BufferedImageLoader();
        BufferedImage spriteSheet;
        BufferedImage background;
        BufferedImage desyrel;
        
        try{
            spriteSheet = loader.loadImage("atlas.png");
            background = loader.loadImage("bg.png");
            desyrel = loader.loadImage("desyrel.png");
            
            ss = new SpriteSheet(spriteSheet);
            bg = new SpriteSheet(background);
            dl = new SpriteSheet(desyrel);
            
            fonts = new ReadXML("desyrel.xml").getImageData("char");
            sprites = new ReadXML("atlas.xml").getImageData("SubTexture");

            Collections.sort(fonts, new CompareTexture());
            fm = new FontManager(fonts);
            
        } catch(IOException e){           
        }
        
                
        for (String s: levels) {
            timesTables.add(new TimesTable(s));
        }
        
        backdrop = bg.getSprite(0, 200, 5955, 768);
        
        gameFonts = createSprites(dl, fonts);
                       
        for(Image i: gameFonts){
            numbers.add(i);
        }
          
        for (int l = 0; l < timesTables.size(); l++) {
            
            for (int i = 0; i < timesTables.get(l).getTimesTable().size(); i++) {
                timesTables.get(l).getTimesTable().get(i).updateQuestion(fm);
                timesTables.get(l).getTimesTable().get(i).updateAnswer(fm);
            }
        }
        
        // pulls timetable from list e.g. timetable 3
        table = timesTables.get(level);
        
        loadPlayedQuestions();
        
        currentQuestion = playedQuestions.get(question);
                                    
        table.getTimesTable().get(currentQuestion).updateQuestion(fm);  

        questionWidth = table.getTimesTable().get(currentQuestion).getQuestionSize().width;

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
            fm.getLetter("W"),
            fm.getLetter("E"),
            fm.getLetter("L"),
            fm.getLetter("L"),
            fm.getLetter("D"),
            fm.getLetter("O"),
            fm.getLetter("N"),
            fm.getLetter("E")
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
        
        animator = new Animation(createSprites(ss, sprites), bird);
        animator.setSpeed(90);
        animator.start();
                        
        updateScore();
            
        randomizeTimeTableQuestions();
        
        menu = Display.MENU;
        
        updateScreenBounds();
        
        setMousePointer(new Point(150, 768 / 2));
        
        endGame = new EndGame(fm);
        endGame.getBack().setQuestionLocation(new Point(150, 768 - 100));
        
        correctAnswer = new Answer(table, currentQuestion, fm);
        falseAnswer1 = new Answer(table, falseQuestion1, fm);
        falseAnswer2 = new Answer(table, falseQuestion2, fm);        
                
        addMouseMotionListener(this);
        addMouseListener(this);
        addKeyListener(this);
    }

    private void updateScreenBounds() {
        contentPaneDimensions = new Dimension(1366, 768);
        
        gameContentArea.y = 200;
        gameContentArea.width = contentPaneDimensions.width;
        gameContentArea.height = contentPaneDimensions.height - 200;
        
        top.y = gameContentArea.y;
        center.y = gameContentArea.y + gameContentArea.height / 3;
        bottom.y = gameContentArea.height;
        System.out.println(contentPaneDimensions);
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
        super.paint(g);
        doubleBufferedImage = createImage(getWidth(), getHeight());
        doubleBufferedGraphics = doubleBufferedImage.getGraphics();
        
        paintComponent((Graphics2D) doubleBufferedGraphics);
        
        g.drawImage(doubleBufferedImage, 0,0,null);
    }    
        
    public void paintComponent(Graphics2D g){          
        //updateScreenBounds();
        updateBackground(g);
        
        switch(menu){
            case MENU:  
                menu((Graphics2D) g);
                break;
            case PLAY:
                
                play(g);
                break; 
            case END:
                end(g);
                break;
        }
                        
        //updateGameOver(g);
        
        g.dispose();
        repaint();
    }   

    public void setLevel(int level) {
        this.level = level;
    }

    public void setTable(TimesTable table) {
        this.table = table;
    }

    public ArrayList<TimesTable> getTimesTables() {
        return timesTables;
    }
    
    private void play(Graphics2D g) {
        updateAnswer(g);
        updateBird(g);

        //updateTimesTableLabels(g);
        updateScoreLabel(g);
        updateQuestion(g);
        updateCorrect(g);
        updateTryAgain(g);
    }

    private void menu(Graphics2D g) {
        mtt.update(g, contentPaneDimensions, getMousePointer(), this);
        //updateBird(g);
    }
      
    private void end(Graphics2D g) {
        updateScoreLabel(g);
        
        
        endGame.update(g, getMousePointer(), this);
        
        for (int i = 0; i < gameOver.length; i++) {
            gameOver[i].update();
            
            gameOver[i].setCentre(new Point(
                    ((1366 / 2) - 120) + (40 * i),
                    768 / 2 - 50
            ));

            gameOver[i].draw(g);
       } 
        
        
    }
      
    private void checkPlayerScore() {
        if (getPlayerScore() > 1000) {
             
            // progress to next level
            question = 0;
            level++;
            setTable(getTimesTables().get(level));
            updateLevelLabels();
        }
        else{
            //gameEnd = true;
            menu = Display.MENU;
            // reset game to 3 times table
            setPlayerScore(0);
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
    }

    private void loadPlayedQuestions() {
        for (int i = 0; i < table.getTimesTable().size(); i++) {
             playedQuestions.add(i);
        }
        
        Collections.shuffle(playedQuestions);
    }

    private void hitDetection() {
        if (getClipping().intersects(correctAnswer.getClipping())) {
            
            eat.play();
            
            correctAnswer.setHit(true);
                            
            answeredCorrect = true;
            
            setMousePointer(new Point(150, getHeight() / 2));
            
            setPlayerScore(getPlayerScore() + 100);
    
            answersReset("correct");
            
            randomizeQuestions();
            
            randomizeTimeTableQuestions();
        }
        
        if (getClipping().intersects(falseAnswer1.getClipping())) { 
            
            wrong.play();
                        
            falseAnswer1.setHit(true);
                            
            answeredWrong = true;
            
            setMousePointer(new Point(150, getHeight() / 2));
                            
            setPlayerScore(getPlayerScore() - new Random().nextInt(100));
                                                
            answersReset("wrong");
            
            randomizeQuestions();
            
            randomizeTimeTableQuestions();
        }
        
        if (getClipping().intersects(falseAnswer2.getClipping())) {   
            
            wrong.play();
            
            falseAnswer2.setHit(true);
                            
            answeredWrong = true;
            
            setMousePointer(new Point(150, getHeight() / 2));
                            
            setPlayerScore(getPlayerScore() - new Random().nextInt(100));
            
            answersReset("wrong");
            
            randomizeQuestions();
            
            randomizeTimeTableQuestions();
        }
    }

    /**
     * @return the clipping
     */
    public Rectangle getClipping() {
        return clipping;
    }

    /**
     * @param clipping the clipping to set
     */
    public void setClipping(Rectangle clipping) {
        this.clipping = clipping;
    }

    /**
     * @return the mousePointer
     */
    public Point getMousePointer() {
        return mousePointer;
    }

    /**
     * @param mousePointer the mousePointer to set
     */
    public void setMousePointer(Point mousePointer) {
        this.mousePointer = mousePointer;
    }

    /**
     * @return the playerScore
     */
    public int getPlayerScore() {
        return playerScore;
    }

    /**
     * @param playerScore the playerScore to set
     */
    public void setPlayerScore(int playerScore) {
        this.playerScore = playerScore;
    }
    
    //<editor-fold defaultstate="collapsed" desc=" Applet Enums ">
    public static enum Display{
        MENU,
        PLAY,
        END
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
            // return to menu
            spriteTest.getMusic().stop();
            newLevel.play();
            setMousePointer(new Point());
            //playerScore = 0;
            question = 0;
            currentQuestion = 0;
            
            answeredCorrect = false;
            answeredWrong = false;
            
            Collections.shuffle(playedQuestions);
            
            menu = Display.END;
            
        }else{
            // if answer is correct move to next question
            if (answered.equals("correct")) {
                currentQuestion = playedQuestions.get(++question);
            }            
        }
        
        updateScore();
    }
        
    private void updateLevelLabels() {
        for (int timesTable = 0; timesTable < getTimesTables().size(); timesTable++) {
            
            String s = "";
            
            String tableName = getTimesTables().get(timesTable).getName();
                        
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
        correctAnswerPoint.x = (int)numbersX;
        falseAnswer1Point.x = (int)numbersX;
        falseAnswer2Point.x = (int)numbersX;
            
        if (numbersX > -10) {
            numbersX -= 3f;
        }
        else{
            numbersX = contentPaneDimensions.width +200;
        }
        
        if (numbersX < contentPaneDimensions.width) {
            correctAnswer.setHit(false);
            falseAnswer1.setHit(false);
            falseAnswer2.setHit(false);
            
            answeredCorrect = false;
            answeredWrong = false;
        }
        
        falseAnswer1.setTable(table);
        falseAnswer1.setQuestion(falseQuestion1);
        falseAnswer1.setLocation(falseAnswer1Point);
        falseAnswer1.drawAnswer(g);
        
        falseAnswer2.setTable(table);
        falseAnswer2.setQuestion(falseQuestion2);
        falseAnswer2.setLocation(falseAnswer2Point);
        falseAnswer2.drawAnswer(g);
        
        correctAnswer.setTable(table);
        correctAnswer.setQuestion(currentQuestion);
        correctAnswer.setLocation(correctAnswerPoint);
        correctAnswer.drawAnswer(g);
        
    }
    
    public void updateBird(Graphics2D g) {
        
        if (animator != null) {
            animator.update(System.currentTimeMillis());
            
            switch(birdDirection){
                case LEFT:
                    setClipping(new Rectangle(
                         birdCenter.x - 80, 
                         (birdCenter.y) + (animator.sprite.getHeight()/2) - 80,
                         50,
                         50
                     ));
                    break;
                case RIGHT:
                    setClipping(new Rectangle(
                         birdCenter.x + 20, 
                         (birdCenter.y) + (animator.sprite.getHeight()/2) - 80,
                         50,
                         50
                     ));
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
                if (birdCenter.x < getMousePointer().x) {                    
                    birdDirection = Direction.RIGHT;
                    speed.x = 10;
                }
                else{
                    if (birdCenter.x > getMousePointer().x - 20 &&
                        birdCenter.x < getMousePointer().x + 20) {
                        birdCenter.x = getMousePointer().x;
                    }                    
                }

                if (birdCenter.x > getMousePointer().x) {
                    birdDirection = Direction.LEFT;
                    speed.x = -10;
                }
                else{
                    if (birdCenter.x > getMousePointer().x - 20 &&
                        birdCenter.x < getMousePointer().x + 20) {
                        birdCenter.x = getMousePointer().x;
                    }                    
                }

                
                if (birdCenter.y < getMousePointer().y) {
                    speed.y = 10;
                }
                else{
                    if (birdCenter.y > getMousePointer().y - 20 &&
                        birdCenter.y < getMousePointer().y + 20) {
                        birdCenter.y = getMousePointer().y;
                    }
                }

                if (birdCenter.y > getMousePointer().y) {
                    speed.y = -10;
                }
                else{
                    if (birdCenter.y > getMousePointer().y - 20 &&
                        birdCenter.y < getMousePointer().y + 20) {
                        birdCenter.y = getMousePointer().y;
                    }
                }
                
            }else{
                birdDirection = Direction.RIGHT;
                birdCenter = getMousePointer();
                speed.x = 0;
                speed.y = 0;
            }
            
            try{
                hitDetection();
            }catch(Exception e){}
            
            
                                                            
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
            
            //g.draw(clipping);
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
        String ps = Integer.toString(getPlayerScore());

        for (int i = 0; i < ps.length(); i++) {                
            score.add(fm.getLetter(Character.toString(ps.charAt(i))));
            score.get(i).setCentre(new Point(300 + (40*i), 50));
        }
    }

    private void updateQuestion(Graphics2D g) {        
        if (!answeredCorrect && !answeredWrong){  
            correctAnswer.drawQuestion(g);
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
        setMousePointer(me.getPoint());
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
    private boolean hit;
    
    private EndGame endGame;
    
    private SpriteTest spriteTest;
    
    public Display menu;
    
    private int question;
    
    private ArrayList<BufferedImage> gameFonts;
    
    private ArrayList<Texture> sprites;
    private ArrayList<Texture> fonts;
    
    private ArrayList<TimesTable> timesTables = new ArrayList<>();
    
    private TimesTable table;
    
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
    //</editor-fold>
}
