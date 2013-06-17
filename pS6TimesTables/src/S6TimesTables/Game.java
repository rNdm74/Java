
package S6TimesTables;

import java.util.Timer;
import java.awt.*;
import java.util.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.IOException;
import java.applet.AudioClip;
import java.awt.image.BufferedImage;

/**
 *
 * @author Adam Charlton
 */
public final class Game extends JPanel 
    implements MouseListener, MouseMotionListener, Runnable{

    // Constructor
    public Game(Object[] setup) {
        run = (MainApp)setup[0];    
        birdSound = (AudioClip) setup[1];
        correctSound = (AudioClip) setup[2];
        roundCompleteSound = (AudioClip) setup[3];
        wrongSound = (AudioClip) setup[4];
        backSound = (AudioClip) setup[5];
        selectSound = (AudioClip) setup[6];
        validateSound = (AudioClip) setup[7];
        poopSound = (AudioClip) setup[8];
                  
        contentPaneDimensions = run.getPreferredSize();
        
        display = Display.TITLE;
        
        updateScreenBounds();
        
        initializeGame();                             
    }

    //<editor-fold defaultstate="collapsed" desc=" Paint ">
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
        
        switch(display){
            case TITLE:
                title(g);
                break;
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
        
        super.repaint();
    }   
      
    private void menu(Graphics2D g) {
        menu.update(g, getMousePointer());
    }    
    private void play(Graphics2D g) {
        drawLabels(g);     
        drawBird(g);
    }    
    private void title(Graphics2D g) {
        lm.drawPlay(g);
        //lm.drawStage6Label(g);               
        //lm.drawTimesTableLabel(g);
        drawBird(g);
    }         
    private void end(Graphics2D g) {
        lm.drawGameOver(g);
        lm.drawMenu(g);
        lm.drawScoreLabel(g); 
        lm.updateScore(g, getPlayerScore());
        drawBird(g);
        //lm.updateGameOverLabel(g);
    }
        
    private void drawBackground(Graphics2D g) {        
        g.drawImage(backdrop, 
                (int)backgroundX,
                (int)backgroundY,
                backdrop.getWidth(this), 
                backdrop.getHeight(this), 
                null
        );
        
        g.drawImage(backdrop, 
                (int)backgroundX + 1600 - 1,
                (int)backgroundY,
                backdrop.getWidth(this), 
                backdrop.getHeight(this), 
                null
        );
    }         
    private void drawLabels(Graphics2D g){
        if (answeredTrue){
            lm.updateCorrectLabel(g);
        }
        if (answeredFalse){
            lm.updateWrongLabel(g);
        }
        if (!answeredTrue && !answeredFalse){
            lm.drawPickedTimesTableQuestion(g, pickedTimesTable);
        }
        
        lm.drawScoreLabel(g);
        lm.updateScore(g, getPlayerScore());
        
        lm.drawWrongAnwser1(g, wrongAnswer1, top);
        lm.drawPickedTimesTableAnwser(g, pickedTimesTable, center);
        lm.drawWrongAnwser2(g, wrongAnswer2, bottom);
     
        lm.drawMenu(g);
    }
    //</editor-fold>  

    //<editor-fold defaultstate="collapsed" desc=" Gets / Sets ">
    public void setLevel(int level) {
        //this.playerLevel = level;
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
        
    //<editor-fold defaultstate="collapsed" desc=" Bird ">
    private Bird createBird() {        
        return new Bird(new Animation(createSprites(ss, sprites), birdSound));
    }
    
    boolean clicked = false;
    boolean pooped = false;
    
    public void drawBird(Graphics2D g) {     
        lm.drawPoop(g, getBird().getCenter().getLocation());
        
        getBird().updateBird(g);
        birdPoop();      
    }
    
    public Bird getBird() {
        return bird;
    }
    
    public void setBird(Bird bird) {
        this.bird = bird;
    }
    //</editor-fold>     
    
    //<editor-fold defaultstate="collapsed" desc=" Enums ">
    public static enum Display{
        TITLE,
        MENU,
        PLAY,        
        WRONG,
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
    
    //<editor-fold defaultstate="collapsed" desc=" Methods ">
    private void initializeGame() {
        try{
            BufferedImageLoader loader = new BufferedImageLoader();
            
            sprites = new ReadXML("atlas.xml").getImageData("SubTexture");            
            birdSpriteSheet = loader.loadImage("atlas.png");
            ss = new SpriteSheet(birdSpriteSheet);
            
            background = loader.loadImage("bg.png");
            backdrop = new SpriteSheet(background).getSprite(0, 200, 1600, contentPaneDimensions.height);
            
            fonts = new ReadXML("desyrel.xml").getImageData("char");            
            Collections.sort(fonts, new CompareTexture());            
            fm = new FontManager(fonts);
            lm = new LabelManager(fm, contentPaneDimensions , table);
            
            menu = new Menu(fm, lm, this);

            bird = createBird();

            addMouseListener(this);
            addMouseListener(menu); 
            addMouseMotionListener(this);
            addMouseMotionListener(menu);            
        } catch(IOException e){
            System.out.println("Unable to start game please check xml and images");
        }
    }
    
    private ArrayList<BufferedImage> createSprites(
            SpriteSheet spriteSheet, 
            ArrayList<Texture> textures) {
        ArrayList<BufferedImage> images = new ArrayList<>();
        for (int i = 0; i < textures.size() - 1; i++) {
            Point p = new Point(
                    textures.get(i).getLocation().x,
                    textures.get(i).getLocation().y
            );        

            int width = textures.get(i).getSize().width;
            int height = textures.get(i).getSize().height;
                
            if(textures.size() < 90){            
                if (((String)textures.get(i).getText()).contains("flight")) {                  
                    images.add(spriteSheet.getSprite(p.x, p.y, width, height));
                }
            }
            else{
                if (isInteger((String)textures.get(i).getText())) {
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
    
    public void updateHitDetection(){
        Rectangle r1 = bird.getClipping();
        Rectangle r2 = lm.answers.get(pickedTimesTable).get(0).getBounds();
        Rectangle r3 = lm.answers.get(wrongAnswer1).get(0).getBounds();
        Rectangle r4 = lm.answers.get(wrongAnswer2).get(0).getBounds();
        
        if (new CollisionDetection().hitDetection(r1, r2)) {
            currentlyColliding = true;
            answeredTrue = true;
            correctSound.play();
            
            if (pickedTimesTable < 71) {
                pickedTimesTable++;
            }
            else{                
                pickedTimesTable = 0;
            }
            
            handleCollision(); 
            // add to players score
            playerScore += 100;
            
        }else if (new CollisionDetection().hitDetection(r1, r3)) {
            currentlyColliding = true;
            answeredFalse = true;
            wrongSound.play();
            handleCollision(); 
            // add to players score
            playerScore -= 50;
            
        } else if (new CollisionDetection().hitDetection(r1, r4)) {
            currentlyColliding = true;
            answeredFalse = true;
            wrongSound.play();
            handleCollision(); 
            // add to players score
            playerScore -= 50;
            
        }
    }
               
    private void shuffleAnswersPlacement(){
        ArrayList<Point> points = new ArrayList();
        
        points.add(top);
        points.add(center);
        points.add(bottom);
        
        Collections.shuffle(points);
         
        top = points.get(0);
        center = points.get(1);
        bottom = points.get(2);
    }
     
    public void clickMenu(){
        for (int i = 0; i < lm.menu.size(); i++) {
            if (lm.menu.get(i).getBounds().contains(mousePointer)) {                
                backSound.play();
                MainApp.music.stop();
                mousePointer = new Point(150, 300);
                display = Display.TITLE;
                
            }
        }
    }
    
    public void clickPlay(){
        for (int i = 0; i < lm.play.size(); i++) {
            if (clicked &&
                display.equals(Display.TITLE)) {
                validateSound.play();
                clicked = false;
                display = Display.MENU;                
            }
        }
    }
    
    public int[] pickRandomAnswer(){
        ArrayList<Integer> shuffledNumbers = new ArrayList();
        
        if(pickedTimesTable % 12 == 0){
            if (playerScore != 0) {
                startNumber = pickedTimesTable;
                MainApp.music.stop();
                roundCompleteSound.play();
                display = Display.END;
            }
            
        }
        
        for (int i = startNumber; i < startNumber + 12; i++){            
            if (i != pickedTimesTable){                
                shuffledNumbers.add(i);
            }
        }
        
        Collections.shuffle(shuffledNumbers);
        
        roundCount++;
                    
        return new int[]{shuffledNumbers.get(0), shuffledNumbers.get(shuffledNumbers.size()-1)};
    }
       
    private void updateScreenBounds() {        
        gameContentArea.y = 150;
        gameContentArea.width = getContentPaneDimensions().width;
        gameContentArea.height = getContentPaneDimensions().height - 150;
        
        top.y = gameContentArea.y;
        center.y = getContentPaneDimensions().height / 2;
        bottom.y = gameContentArea.height;
    } 
     
    public void moveBackground() {
        if (backgroundX > 1600  * -1) {
            backgroundX -= 0.02f * 3f;
        }
        else{
            backgroundX = 0;
        }
    }
        
    public void moveAnswers() {
        if (count > 15) {
            top.x -= 1f;
            center.x -= 1f;
            bottom.x -= 1f;
            count = 0;
        }
        
        if (top.x <= 10){
            resetAnswersPosition();                
        }        
        
        count++;
    }

    public void resetAnswersPosition() {
        top.x = getContentPaneDimensions().width + 200;
        center.x = getContentPaneDimensions().width + 200;
        bottom.x = getContentPaneDimensions().width + 200;
    }

    private void handleCollision() {
        // resets the x position
        resetAnswersPosition();
        
        // reset bird position
        mousePointer = new Point(150, 300);
        bird.birdStopped = false;
        bird.SPEED = 3;
        
        // get new wrongs answers for next question
        int[] answers = pickRandomAnswer();            
        wrongAnswer1 = answers[0];
        wrongAnswer2 = answers[1];

        // set where answers are placed on screen
        shuffleAnswersPlacement();        
    }

    public void checkAnswersLocation() {
        if (center.x < contentPaneDimensions.width + 100) {
            currentlyColliding = false; 
            previouslyColliding = false;
            answeredTrue = false;
            answeredFalse = false;
        }
    }

    private void playPoop() {
        poopSound.play();
        pooped = true;
    }

    public void birdPoop() {
        if (new Random().nextInt(10000)==0) {
            playPoop();
        }
        
        
        if(pooped){
            lm.move += 0.5f;
        }
        
        if (lm.poop.get(0).getCenter().y > 600) {               
            lm.move = 0;
            clicked = false;
            pooped = false;
        }
    }    
    //</editor-fold>
        
    //<editor-fold defaultstate="collapsed" desc=" Overrides "> 
    @Override
    public void run() {
        timer = new Timer();
        timer.scheduleAtFixedRate(new Task(this), 0, 1);
    } 
    
    @Override
    public void mouseDragged(MouseEvent me) {
    }

    @Override
    public void mouseMoved(MouseEvent me) {
        for (int i = 0; i < lm.play.size(); i++) {
            if(lm.play.get(i).getBounds().contains(me.getPoint()) && 
              (display.equals(Display.TITLE))){     
                Point p = lm.play.get(0).getCenter();
                getBird().birdCenter.setLocation(p.x - 120, p.y);
                getMousePointer().setLocation(p.x - 120, p.y);
            }
        }
    }
    
    @Override
    public void mouseClicked(MouseEvent me) {
        for (int i = 0; i < lm.play.size(); i++) {
            if(lm.play.get(i).getBounds().contains(me.getPoint())){                 
                clicked = true;
            }
        }
        
        if(getBird().getCenter().contains(me.getPoint())){
            playPoop();
        }
    }

    @Override
    public void mousePressed(MouseEvent me) {        
        if (!display.equals(Display.MENU)) {
            
            for (int i = 0; i < lm.menu.size(); i++) {
                if (!lm.menu.get(i).getBounds().contains(me.getPoint())) {
                    setMousePointer(me.getPoint());
                    bird.birdStopped = false;
                    bird.SPEED = 2;
                }
            }            
        }        
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
    
    //<editor-fold defaultstate="collapsed" desc=" Variables ">
    public int pickedTimesTable;
    public int wrongAnswer1;
    public int wrongAnswer2;
    
    boolean correctAnswerHit = false;
    boolean falseAnswerHit  = false;
    boolean birdReset = false;
    
    int count = 0;   
    int roundCount = 0;
    int startNumber = 0;
    int questionCount = 0;
    
    boolean previouslyColliding = false;
    boolean currentlyColliding = false;
    
    public Menu menu;
    public Display display;  
    
    private MainApp run;
    private Timer timer;
    
    private ArrayList<Texture> fonts;
    private ArrayList<Texture> sprites;    
    private ArrayList<TimesTable> timesTables;
    
    private TimesTable table;    
    private Image backdrop;
    
    private SpriteSheet ss;
    
    private Bird bird;
    
    private int playerScore; 
    
    private float backgroundX = 0f;
    private float backgroundY = 0f;    
          
    private Image doubleBufferedImage;        
    private Graphics doubleBufferedGraphics;
    
    private Dimension contentPaneDimensions;   
    
    private LabelManager lm;
    private FontManager fm;
    
    public AudioClip backSound;
    public AudioClip selectSound;
    public AudioClip validateSound;
    private AudioClip birdSound;
    private AudioClip correctSound;
    public AudioClip roundCompleteSound;
    private AudioClip wrongSound;
    public AudioClip poopSound;
    
    private Rectangle clipping;
    private Rectangle gameContentArea = new Rectangle();
    
    private Point top = new Point();
    private Point center = new Point();
    private Point bottom = new Point();    
    private Point mousePointer = new Point();
        
    public boolean answeredTrue;
    public boolean answeredFalse;
    
    private BufferedImage birdSpriteSheet;
    private BufferedImage background;
    //</editor-fold>
}
