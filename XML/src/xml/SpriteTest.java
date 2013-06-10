
package xml;

import java.applet.AudioClip;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Shape;
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
import javax.swing.JApplet;

/**
 *
 * @author rNdm
 */
public class SpriteTest extends JApplet 
    implements KeyListener, MouseListener, MouseMotionListener{
    private int question;

    private void updateLevelLabels() {
        for (int timesTable = 0; timesTable < timesTables.size(); timesTable++) {
            
            String s = timesTables.get(timesTable).getName();
            
            Desyrel[] chars = new Desyrel[s.length()];
            
            for (int i = 0; i < s.length(); i++) {                    
                char c = s.charAt(i);                    
                chars[i] = fm.getLetter(Character.toString(c));
            }                
            
            levelLabels.add(chars);
        }
    }

    private void answersReset() {       
        
        updateScore();
                
        numbersX = dim.width + 200;
        
        if (question == playedQuestions.size()-1) {
            newLevel.play();
            question = 0;
            level++;
            table = timesTables.get(level);
            updateLevelLabels();                    
        }else{
            q = playedQuestions.get(++question);
        }
    }

    private enum Direction{
        LEFT,
        RIGHT,
        UP,
        DOWN
    }
    
    private ArrayList<BufferedImage> gameFonts;
    
    private static ArrayList<Texture> sprites;
    private static ArrayList<Texture> fonts;
    //private static ArrayList<Equation> oneTimesTable;
    
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
    private float numbersY = 540f;
    
    private Rectangle clipping;
    
    private Direction d = Direction.RIGHT;
        
    private Dimension dim;
    
    private Image doubleBufferedImage;        
    private Graphics doubleBufferedGraphics;
    
    private Desyrel[] scoreLabel;
    
    private Desyrel[] timesTableLabel;
    
    private ArrayList<Desyrel[]> levelLabels;
    
    private ArrayList<Desyrel> score = new ArrayList<>();
    
    private int playerScore = 1000;
    
    private int q = 0;
    private int fq1 = new Random().nextInt(12);
    private int fq2 = new Random().nextInt(12);
    
    private int w ;
    
    private FontManager fm;
    
    private AudioClip bird;
    private AudioClip music;
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
    
    
    private int level = 0;
    
    //<editor-fold defaultstate="collapsed" desc=" Applet Overrides ">
    @Override
    public void init() {
        
        bird = getAudioClip(getDocumentBase(), "wing_flap.wav");
        music = getAudioClip(getDocumentBase(), "music.wav");
        eat = getAudioClip(getDocumentBase(), "eat.wav");
        newLevel = getAudioClip(getDocumentBase(), "level.wav");
        wrong = getAudioClip(getDocumentBase(), "wrong.wav");
        
        setFocusable(true);
        requestFocusInWindow();
                
        Dimension res = Toolkit.getDefaultToolkit().getScreenSize();
        
        setSize(res.width, res.height);
        
        dim = getContentPane().getSize();
        
        String[] levels = {
            "One",
            "Two",
            "Three",
            "Four",
            "Five",
            "Six",
            "Seven",
            "Eight",
            "Nine",
            "Ten",
            "Eleven",
            "Twelve"                        
        };
        
        for (String s: levels) {
            timesTables.add(new TimesTable(s));
        }
        
        //System.out.println(timesTables.get(10).getTimesTable());
        
        //oneTimesTable = new ReadXML("tables.xml").getTableData("One");
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
        
        backdrop = bg.getSprite(0, 0, 5955, res.height - 81);
        
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
            
            q = playedQuestions.get(question);
            
            
            
            table.getTimesTable().get(q).updateQuestion(fm);   
            
            w = table.getTimesTable().get(q).getQuestionSize().width;
            
            table.getTimesTable().get(q).setQuestionLocation(new Point(dim.width/2 - w/2, dim.height - 100));
            
            levelLabels = new ArrayList<>();
            
            updateLevelLabels();
            
//            levelLabels.add(new Desyrel[]{
//                fm.getLetter("O"),
//                fm.getLetter("n"),
//                fm.getLetter("e")                
//            });
            
            timesTableLabel = new Desyrel[]{
                fm.getLetter("L"),
                fm.getLetter("e"),
                fm.getLetter("v"),
                fm.getLetter("e"),
                fm.getLetter("l"),
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
        
        //System.out.println(playedQuestions.get(0) + 1);
        
        
        for (int i: playedQuestions) {
            //System.out.println(i+1);
        }
        
        updateScore();
                
        addKeyListener(this);
        addMouseMotionListener(this);
        addMouseListener(this);
    }
        
    @Override
    public void start() {
        //eat.play();
        music.loop();
        this.requestFocusInWindow();
    }
    
    @Override
    public void stop(){
        bird.stop();
        music.stop();
        eat.stop();
    }
    
    @Override
    public void destroy(){}
    
    @Override
    public void paint(Graphics g){  
        dim = getContentPane().getSize();
        
        gameContentArea.y = 200;
        gameContentArea.width = dim.width;
        gameContentArea.height = dim.height - 200;
        
        System.out.println(gameContentArea.height);
        
        top.y = gameContentArea.y;
        center.y = gameContentArea.y + gameContentArea.height / 3;
        bottom.y = gameContentArea.height;
        
        
        
        doubleBufferedImage = createImage(getWidth(), getHeight());
        doubleBufferedGraphics = doubleBufferedImage.getGraphics();
        paintComponent((Graphics2D) doubleBufferedGraphics);
        g.drawImage(doubleBufferedImage, 0,0,null);
    }    
    public void paintComponent(Graphics2D g){          
        
        updateBackground(g);
        
        updateAnswer(g);
        
        updateBird(g);
        
        updateTimesTableLabels(g);
        updateScoreLabel(g);
        updateQuestion(g);
                        
        g.dispose();
        repaint();
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
            numbersX = dim.width +200;
        }
        
        correctAnswerPoint.x = (int)numbersX;
        falseAnswer1Point.x = (int)numbersX;
        falseAnswer2Point.x = (int)numbersX;
        
        correctAnswer = new Answer(table, q, fm);
        correctAnswer.setLocation(correctAnswerPoint);
        correctAnswer.update(g);
        
        falseAnswer1 = new Answer(table, fq1, fm);
        falseAnswer1.setLocation(falseAnswer1Point);
        falseAnswer1.update(g);
        
        falseAnswer2 = new Answer(table, fq2, fm);
        falseAnswer2.setLocation(falseAnswer2Point);
        falseAnswer2.update(g); 
    }
    
    private void updateBird(Graphics2D g) {
        if (animator != null) {
            animator.update(System.currentTimeMillis());
            
            switch(d){
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
                    d = Direction.RIGHT;
                    speed.x = 10;
                }
                else{
                    if (birdCenter.x > mousePointer.x - 20 &&
                        birdCenter.x < mousePointer.x + 20) {
                        birdCenter.x = mousePointer.x;
                    }                    
                }

                if (birdCenter.x > mousePointer.x) {
                    d = Direction.LEFT;
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
                correctAnswer.setIsHit(true);
                
                playerScore += 100;
        
                eat.play();
                
                answersReset();
                
                correctAnswerPoint = top;
                
                correctAnswer.setIsHit(false);
            }
            
            if (clipping.intersects(falseAnswer1.clipping)) {
                falseAnswer1.setIsHit(true);
                
                playerScore -= 50;
                
                wrong.play();
                
                answersReset();
                
                falseAnswer1Point = center;
                
                fq1 = new Random().nextInt(12);
                falseAnswer1.setIsHit(false);
            }
            
            if (clipping.intersects(falseAnswer2.clipping)) {
                falseAnswer2.setIsHit(true);
                
                playerScore -= 50;
                
                wrong.play();
                
                answersReset();
                
                falseAnswer2Point = bottom;
                
                fq2 = new Random().nextInt(12);
                falseAnswer1.setIsHit(false);
            }
            
            
                                                
            switch(d){
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
    
    private Point randomPosition(Rectangle contentArea){
        int low = contentArea.y;
        int high = contentArea.y + contentArea.height;

        int x = (int)numbersX;
        int y = new Random().nextInt(high - low) + low; 

        return new Point(x,y);        
    }
    
    private void updateTimesTableLabels(Graphics2D g){
        for (int i = 0; i < levelLabels.get(level).length; i++) {
            levelLabels.get(level)[i].update();
            levelLabels.get(level)[i].setCentre(new Point((dim.width - 180) + (35*i), 50));
            levelLabels.get(level)[i].draw(g);
        }
        
        for (int i = 0; i < timesTableLabel.length; i++) {
            timesTableLabel[i].update();
            timesTableLabel[i].setCentre(new Point((dim.width - 450) + (30*i), 50));
            timesTableLabel[i].draw(g);
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
        table.getTimesTable().get(q).setQuestionLocation(new Point(dim.width/2 - w/2, dim.height - 50));
        table.getTimesTable().get(q).updateQuestion(fm);        
        table.getTimesTable().get(q).drawQuestion(g);
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc=" Implements Overrides ">
    @Override
    public void keyTyped(KeyEvent ke) {}

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_A:
                d = Direction.LEFT;
                speed.x = -10;
                break;
            case KeyEvent.VK_D:
                d = Direction.RIGHT;
                speed.x = 10;
                break;
            case KeyEvent.VK_S:
                speed.y = 10;
                break;
            case KeyEvent.VK_W:
                speed.y = -10;
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        //speed = new Point(0,0);
        
        switch (e.getKeyCode()) {
            case KeyEvent.VK_A:
                speed.x = 0;
                break;
            case KeyEvent.VK_D: 
                speed.x = 0;
                break;
            case KeyEvent.VK_S:
                speed.y = 0;
                break;
            case KeyEvent.VK_W:
                speed.y = 0;
                break;
        }
    }
    
    @Override
    public void mouseClicked(MouseEvent me) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mousePressed(MouseEvent me) {
        mousePointer = me.getPoint();
    }

    @Override
    public void mouseReleased(MouseEvent me) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent me) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent me) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseDragged(MouseEvent me) {
        //mousePointer = me.getPoint();
    }

    @Override
    public void mouseMoved(MouseEvent me) {
        
    }
    //</editor-fold>
}
