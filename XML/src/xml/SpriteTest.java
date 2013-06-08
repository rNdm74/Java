
package xml;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
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
import javax.swing.JApplet;

/**
 *
 * @author rNdm
 */
public class SpriteTest extends JApplet 
    implements KeyListener, MouseListener, MouseMotionListener{

    private enum Direction{
        LEFT,
        RIGHT,
        UP,
        DOWN
    }
    
    private ArrayList<BufferedImage> gameFonts;
    
    private static ArrayList<Texture> sprites;
    private static ArrayList<Texture> fonts;
    private static ArrayList<Equation> oneTimesTable;
    
    
    
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
    
    private boolean hit = false;
    
    private Dimension dim;
    
    private Image doubleBufferedImage;        
    private Graphics doubleBufferedGraphics;
    
    private Desyrel[] scoreLabel;
    
    private ArrayList<Desyrel> score = new ArrayList<>();
    
    private int playerScore = 1000;
    
    private int q = 0;
    
    private int w ;
    
    private FontManager fm;
    
    //<editor-fold defaultstate="collapsed" desc=" Applet Overrides ">
    @Override
    public void init() {
        setFocusable(true);
        requestFocusInWindow();
        
        dim = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(dim.width, dim.height);
        
        oneTimesTable = new ReadXML("tables.xml").getTableData("One");
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
        
        backdrop = bg.getSprite(0, 0, 5955, dim.height);
        
        gameFonts = createSprites(dl, fonts);
                       
        for(Image i: gameFonts){
            numbers.add(i);
        }
        
        animator = new Animation(createSprites(ss, sprites));
        animator.setSpeed(90);
        animator.start();
        
        try {
            fm = new FontManager(fonts);
            
            q = new Random().nextInt(oneTimesTable.size());
            
            oneTimesTable.get(q).updateEquation(fm);   
            
            w = oneTimesTable.get(q).getEquationSize().width;
            
            oneTimesTable.get(q).setEquationLocation(new Point(dim.width/2 - w/2, dim.height - 140));
            
            //System.out.println(oneTimesTable.get(0).getEquation());
        
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
                
        addKeyListener(this);
        addMouseMotionListener(this);
        addMouseListener(this);
    }
        
    @Override
    public void start() {
        this.requestFocusInWindow();
    }
    
    @Override
    public void stop(){}
    
    @Override
    public void destroy(){}
    
    @Override
    public void paint(Graphics g){         
        doubleBufferedImage = createImage(getWidth(), getHeight());
        doubleBufferedGraphics = doubleBufferedImage.getGraphics();
        paintComponent((Graphics2D) doubleBufferedGraphics);
        g.drawImage(doubleBufferedImage, 0,0,null);
    }    
    public void paintComponent(Graphics2D g){        
        updateBackground(g);
        
        updateAnswer(g);
        
        updateBird(g);
        
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
            numbersX = 1920f;
        }
        
        if (!hit) {
            oneTimesTable.get(q).setAnswerLocation(new Point((int)numbersX, (int)numbersY));
            oneTimesTable.get(q).updateAnswer(fm);        
            oneTimesTable.get(q).drawAnswer(g);
        }
    }
    
    private void updateBird(Graphics2D g) {
        if (animator != null) {
            animator.update(System.currentTimeMillis());
            
            clipping = new Rectangle(
                    (birdPosition.x + 20), 
                    (birdPosition.y + 20),
                    animator.sprite.getWidth() - 20,
                    animator.sprite.getHeight() - 20
            );
            
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
                        
            
            if (clipping.contains(new Point(
                    (int)numbersX + (numbers.get(0).getWidth(this) / 2),
                    (int)numbersY + (numbers.get(0).getWidth(this) / 2)
            ))) {
                
                playerScore += 100;
                
                updateScore();
                
                hit = true;
                numbersX = dim.width;
                q = new Random().nextInt(oneTimesTable.size());
                numbersY = new Random().nextInt(dim.height-numbers.get(0).getHeight(this)); 
                hit = false;
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
        //Dimension d = //oneTimesTable.get(q).getEquationSize();
        oneTimesTable.get(q).setEquationLocation(new Point(dim.width/2 - w/2, dim.height - 140));
        oneTimesTable.get(q).updateEquation(fm);        
        oneTimesTable.get(q).drawEquation(g);
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
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseMoved(MouseEvent me) {
        
    }
    //</editor-fold>
}
