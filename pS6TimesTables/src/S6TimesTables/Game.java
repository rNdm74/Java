
package S6TimesTables;

import java.util.Timer;
import java.awt.*;
import java.util.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.IOException;
import java.applet.AudioClip;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

/**
 *
 * @author Adam Charlton
 */
public final class Game extends JPanel implements MouseListener, MouseMotionListener{

    // Contructor
    public Game(Object[] setup) throws HeadlessException { 
        timer = new Timer();
        task = new Task(this);
        timer.schedule(task, 0,  1);
        
        run = (Run)setup[0];    
        birdSound = (AudioClip) setup[1];
        correctSound = (AudioClip) setup[2];
        roundCompleteSound = (AudioClip) setup[3];
        wrongSound = (AudioClip) setup[4];
                
       
        
        
        
        contentPaneDimensions = run.getPreferredSize();
        
        updateScreenBounds();
        
        
                        
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
        
        backdrop = bg.getSprite(0, 200, 1600, contentPaneDimensions.height);
        
        gameFonts = createSprites(dl, fonts);
                   
        for (int l = 0; l < timesTables.size(); l++) {            
            for (int i = 0; i < timesTables.get(l).getTimesTable().size(); i++) {
                timesTables.get(l).getTimesTable().get(i).updateQuestion(fm);
                timesTables.get(l).getTimesTable().get(i).updateAnswer(fm);
            }
        }
        
        // pulls timetable from list e.g. timetable 3
        table = timesTables.get(playerLevel);
        
        populateShuffledQuestions();
        
        //currentQuestion = playedQuestions.get(question);
                                    
        //table.getTimesTable().get(currentQuestion).updateQuestion(fm);  

        //questionWidth = table.getTimesTable().get(currentQuestion).getQuestionSize().width;

        mainMenu = new Menu(fm, this);

        lm = new LabelManager(fm, contentPaneDimensions);
        
        //createLabels();
        
        bird = createBird();
                        
        //updateScore();
            
        shuffleQuestions();
        
        menu = Display.MENU;
        
        
        
        setMousePointer(new Point(150, 300));
        
        completeGame = new CompleteGame(fm);
        completeGame.getBack().setQuestionLocation(new Point(50, getContentPaneDimensions().height - 50));
        
        createQuestionAnswers();  
        
        addMouseListener(this);
        addMouseListener(mainMenu);        
        addMouseMotionListener(mainMenu);
    }

    //<editor-fold defaultstate="collapsed" desc=" Applet Paint ">
    @Override
    public void paint(Graphics g){   
        super.paint(g);
        doubleBufferedImage = createImage(getWidth(), getHeight());
        doubleBufferedGraphics = doubleBufferedImage.getGraphics();
        
        paintComponent((Graphics2D) doubleBufferedGraphics);
        
        g.drawImage(doubleBufferedImage, 0,0,null);
    }            
    public void paintComponent(Graphics2D g){ 
        drawBackground(g);        
        switch(menu){
            case MENU:  
                menu(g);
                break;
            case PLAY:                
                play(g);
                break; 
            case END:
                end(g);
                break;
        }                 
        g.dispose();
        repaint();
    }   
          
    private void play(Graphics2D g) {
        drawLabels(g);
        
        drawAnswers(g);
        
        drawQuestion(g);
               
                
        drawBird(g);
    }
    private void menu(Graphics2D g) {
        mainMenu.update(g, getMousePointer());
    }      
    private void end(Graphics2D g) {
        completeGame.update(g, getMousePointer(), this);
        
        lm.updateScoreLabel(g); 
        lm.updateGameOverLabel(g);
    }
    //</editor-fold>  

    //<editor-fold defaultstate="collapsed" desc=" Applet Gets / Sets ">
    public void setLevel(int level) {
        this.playerLevel = level;
    }
    public void setTable(TimesTable table) {
        this.table = table;
    }
    public ArrayList<TimesTable> getTimesTables() {
        return timesTables;
    }
    public Rectangle getClipping() {
        return clipping;
    }
    public void setClipping(Rectangle clipping) {
        this.clipping = clipping;
    }
    public Point getMousePointer() {
        return mousePointer;
    }
    public void setMousePointer(Point mousePointer) {
        this.mousePointer = mousePointer;
    }
    public int getPlayerScore() {
        return playerScore;
    }
    public void setPlayerScore(int playerScore) {
        this.playerScore = playerScore;
    }
    public Dimension getContentPaneDimensions() {
        return contentPaneDimensions;
    }
    public void setContentPaneDimensions(Dimension contentPaneDimensions) {
        this.contentPaneDimensions = contentPaneDimensions;
    }
    //</editor-fold>
      
        
    private void drawLabels(Graphics2D g){
        if (answeredCorrect)lm.updateCorrectLabel(g);
        if (answeredWrong)lm.updateWrongLabel(g);
        lm.updateScoreLabel(g);
        lm.updateScore(getPlayerScore());
    }
    
    private void checkPlayerScore() {
        if (getPlayerScore() > 1000) {
             
            // progress to next level
            question = 0;
            playerLevel++;
            setTable(getTimesTables().get(playerLevel));
            //();
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

    
    boolean correctAnswerHit = false;
    boolean falseAnswerHit;
    
    public void hitDetection(Rectangle2D clipping) {
        //correctAnswerHit = 
        falseAnswerHit = (clipping.intersects(falseAnswer1.getClipping()) ||
            clipping.intersects(falseAnswer2.getClipping())) ? true : false;
            
        //System.out.println(correctAnswerHit);
        //System.out.println(falseAnswerHit);
        boolean t = (clipping.intersects(correctAnswer.getClipping()));        
        
        //System.out.println(t);
        
            
        if (correctAnswerHit != t) {  
            correctSound.play(); 
            answeredCorrect = true;            
            correctAnswer.setHit(answeredCorrect);
                       
            resetQuestion(getPlayerScore() + 100, "correct");
            
            System.out.println(question);
            
        }
        correctAnswerHit = t;    
        if (falseAnswerHit) {            
//                answeredWrong = true;  
//                falseAnswer1.setHit(answeredWrong);
//                falseAnswer2.setHit(answeredWrong);            
//                wrongSound.play();            
//                resetQuestion(getPlayerScore() - 50, "wrong");
        }             
    }
    
    private void resetQuestion(int setScore, String result) {        
        
        setPlayerScore(setScore);

        answersReset(result);
        
        shuffleQuestionsPosition();
        
        shuffleQuestions();
        
        setMousePointer(new Point(150, 300));
    }
      
    private void answersReset(String answered) {                  
        numbersX = getContentPaneDimensions().width + 200;
        
        
        
        if (question == playedQuestions.size()) {
            // return to menu
            run.getMusic().stop();
            roundCompleteSound.play();
            
            setPlayerScore(0);
            
            question = 0;
            currentQuestion = 0;
            playedQuestions.clear(); 
            
            
            answeredCorrect = false;
            answeredWrong = false;
            
            //Collections.shuffle(playedQuestions);
            
            menu = Display.END;
            
        }else{
            // if answer is correct move to next question
            if (answered.equals("correct")) {
                System.out.println(question);
                run.getAppletContext().showStatus(Integer.toString(question));
                currentQuestion = playedQuestions.get(question++);                
        }            
        }
        
        lm.updateScore(getPlayerScore());
    }
           
    private void shuffleQuestionsPosition(){
        ArrayList<Point> points = new ArrayList();
        
        points.add(top);
        points.add(center);
        points.add(bottom);
        
        java.util.Collections.shuffle(points);
            
        correctAnswerPoint = points.get(0);
        falseAnswer1Point = points.get(1);
        falseAnswer2Point = points.get(2);
    }
     
    private void shuffleQuestions(){
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
    
    
   
    private void updateScreenBounds() {        
        gameContentArea.y = 150;
        gameContentArea.width = getContentPaneDimensions().width;
        gameContentArea.height = getContentPaneDimensions().height - 150;
        
        top.y = gameContentArea.y;
        center.y = getContentPaneDimensions().height / 2;
        bottom.y = gameContentArea.height;
    } 
    
    
    //<editor-fold defaultstate="collapsed" desc=" Applet Bird ">
    private Bird createBird() {        
        return new Bird(new Animation(createSprites(ss, sprites), birdSound));
    }
        
    public void drawBird(Graphics2D g) {         
        getBird().updateBird(g);
    }
    
    public Bird getBird() {
        return bird;
    }
    
    public void setBird(Bird bird) {
        this.bird = bird;
    }
    //</editor-fold>  

    public void moveBackground() {
        if (backgroundX > 1600 * -1) {
            backgroundX -= 0.02f * 3f;
        }
        else{
            backgroundX = 0;
        }
    }
    public void moveAnswers() {
        if (numbersX > -10) {
            numbersX -= 0.06f * 2f;
        }
        else{
            numbersX = getContentPaneDimensions().width + 200;
        }
    }

               
    public void updateAnswers() {        
        correctAnswerPoint.x = (int)numbersX;
        falseAnswer1Point.x = (int)numbersX;
        falseAnswer2Point.x = (int)numbersX;
        
        
        if (numbersX < getContentPaneDimensions().width) {
            answeredCorrect = false;
            answeredWrong = false;
            correctAnswer.setHit(answeredCorrect);
            falseAnswer1.setHit(answeredWrong);
            falseAnswer2.setHit(answeredWrong);
            
            
        }
        
        falseAnswer1.setTable(table);
        falseAnswer1.setQuestion(falseQuestion1);
        falseAnswer1.setAnswerLocation(falseAnswer1Point);
        
        
        falseAnswer2.setTable(table);
        falseAnswer2.setQuestion(falseQuestion2);
        falseAnswer2.setAnswerLocation(falseAnswer2Point);
        
        
        correctAnswer.setTable(table);
        correctAnswer.setQuestion(currentQuestion);
        correctAnswer.setAnswerLocation(correctAnswerPoint);
            
    }     
    public void updateCorrectAnswer() {
        correctAnswer.setQuestionLocation(new Point(
                    (getContentPaneDimensions().width / 2) - 40,
                    getContentPaneDimensions().height - 50
            ));
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
     
    private void drawBackground(Graphics2D g) {
        //moveBackground();
        
        g.drawImage(backdrop, 
                (int)backgroundX,
                (int)backgroundY,
                backdrop.getWidth(this), 
            backdrop.getHeight(this), 
                null
        );
        
        g.drawImage(backdrop, 
                (int)backgroundX + 1600,
                (int)backgroundY,
                backdrop.getWidth(this), 
                backdrop.getHeight(this), 
                null
        );
    }  
    private void drawAnswers(Graphics2D g){
        falseAnswer1.drawAnswer(g);
        falseAnswer2.drawAnswer(g);
        correctAnswer.drawAnswer(g);    
    }
    private void drawQuestion(Graphics2D g) {        
        if (!answeredCorrect && !answeredWrong)correctAnswer.drawQuestion(g);                
    }
    
    
    
        
    private void createQuestionAnswers() {
        correctAnswer = new EquationManager(table, currentQuestion, fm);
        falseAnswer1 = new EquationManager(table, falseQuestion1, fm);
        falseAnswer2 = new EquationManager(table, falseQuestion2, fm);
    }
        
    private void populateShuffledQuestions() {
        for (int i = 0; i < table.getTimesTable().size(); i++)playedQuestions.add(i);
        
        Collections.shuffle(playedQuestions);
    }

    
    //</editor-fold>
        
    //<editor-fold defaultstate="collapsed" desc=" Applet Overrides ">    
    @Override
    public void mouseDragged(MouseEvent me) {
    }

    @Override
    public void mouseMoved(MouseEvent me) {
    }
    
    @Override
    public void mouseClicked(MouseEvent me) {
        
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
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc=" Applet Variables ">
    Timer timer;    
    Task task;
    
    private Menu mainMenu;
    private CompleteGame completeGame;    
    private Run run;
    
    public Display menu;
    
    private int question;
    
    private ArrayList<Texture> fonts;
    private ArrayList<Texture> sprites;
    //private ArrayList<Desyrel[]> levelLabels;    
    private ArrayList<BufferedImage> gameFonts;
    
    //private ArrayList<Desyrel> score = new ArrayList<>();
    
    private ArrayList<TimesTable> timesTables = new ArrayList<>();
    private ArrayList<Integer> playedQuestions = new ArrayList<>();
    
    
    private TimesTable table;    
    private Image backdrop;
    
    private SpriteSheet ss;
    private SpriteSheet bg;
    private SpriteSheet dl;
    
    private Bird bird;
    
    
    
    private float backgroundX = 0f;
    private float backgroundY = 0f;    
    private float numbersX = 1000;
    
    private Rectangle clipping;
            
    private Dimension contentPaneDimensions;
    
    private Image doubleBufferedImage;        
    private Graphics doubleBufferedGraphics;
    
    private int playerLevel = 0;
    private int playerScore = 0;    
    private int currentQuestion = 0;    
    private int falseQuestion1;
    private int falseQuestion2; 
    
    private LabelManager lm;
    private FontManager fm;
    
    private AudioClip birdSound;
    private AudioClip correctSound;
    private AudioClip roundCompleteSound;
    private AudioClip wrongSound;
    
    private Rectangle gameContentArea = new Rectangle();
    
    private Point top = new Point();
    private Point center = new Point();
    private Point bottom = new Point();
    
    private Point correctAnswerPoint = top;
    private Point falseAnswer1Point = center;
    private Point falseAnswer2Point = bottom;
    
    //private Point mousePosition;
    private Point mousePointer = new Point(150, 300);
    
    
    
    private EquationManager correctAnswer;
    private EquationManager falseAnswer1;
    private EquationManager falseAnswer2;
    
    private boolean answeredCorrect;
    private boolean answeredWrong;
    
    private boolean gameEnd;
        
    //</editor-fold>
}