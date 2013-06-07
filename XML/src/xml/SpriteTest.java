
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
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Vector;
import javax.sound.midi.Soundbank;
import javax.swing.JApplet;

/**
 *
 * @author rNdm
 */
public class SpriteTest extends JApplet 
    implements KeyListener, MouseListener, MouseMotionListener{
    
    private enum Direction{
        LEFT,RIGHT
    }
    
    private static ArrayList<Texture> sprites;
    private static ArrayList<Texture> fonts;
    
    private ArrayList<BufferedImage> gameFonts;
    
    private Image backdrop;
    private ArrayList<Image> numbers = new ArrayList<>();
    
    private SpriteSheet ss;
    private SpriteSheet bg;
    private SpriteSheet dl;
    
    private Animation animator;
        
    private Point speed = new Point(0, 0);
    private Point velocity = new Point((int)0.01f, (int)0.01f);
    
    private Point birdPosition = new Point(0, 0);
    private Point2D birdPoint;
    
    
    private Point2D mousePointer = new Point();
       
    
    private float x = 0;
    private float y = 0;
    
    private float backgroundX = 0f;
    private float backgroundY = 0f;
    
    private float numbersX = 1920f;
    private float numbersY = 540f;
    
    private Rectangle clipping;
    
    private Direction d = Direction.RIGHT;
    
    private boolean hit = false;
    
    private Dimension dim;
    
    /**
     * Initialization method that will be called after the applet is loaded into
     * the browser.
     */
    @Override
    public void init() {
        setFocusable(true);
        requestFocusInWindow();
        
        dim = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(dim.width, dim.height);
        
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
        
        x = 200;
        y = getHeight() / 2;
        
        addKeyListener(this);
        addMouseMotionListener(this);
        addMouseListener(this);
    }
        
    @Override
    public void start() {
        this.requestFocusInWindow();
    }
    
    Image dbImage;        
    Graphics dpg;
        
    @Override
    public void paint(Graphics g){         
        dbImage = createImage(getWidth(), getHeight());
        dpg = dbImage.getGraphics();
        paintComponent((Graphics2D) dpg);
        g.drawImage(dbImage, 0,0,null);
    }
    
    public void paintComponent(Graphics2D g){
        
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
        
        if (!hit) {
            for (int i = 0; i < numbers.size(); i++) {            
                g.drawImage(numbers.get(i), 
                    (int)numbersX +(50*i), 
                    (int)numbersY, 
                    numbers.get(i).getWidth(this), 
                    numbers.get(i).getHeight(this), 
                    null
                );     
            }
        }
        
        
                 
        
        if (animator != null) {
            animator.update(System.currentTimeMillis());
            
            birdPosition.x += speed.x;
            birdPosition.y += speed.y;
            
            System.out.println(mousePointer.distance(birdPosition));
            
            if (birdPosition.x < mousePointer.getX()) {
                speed.x = 5;
            }
            
            if (birdPosition.x > mousePointer.getX()) {
                speed.x = -5;
            }
            
            if (birdPosition.y < mousePointer.getY()) {
                speed.y = 5;
            }
            
            if (birdPosition.y > mousePointer.getY()) {
                speed.y = -5;
            }
            
            //{
            //    speed = new Point(0, 0);
            //}
//            clipping = new Rectangle(
//                    (birdPosition.x + (animator.sprite.getWidth() / 2)) - 20, 
//                    (birdPosition.y + (animator.sprite.getHeight() / 2)) - 20,
//                    40,40
//            );
            
            clipping = new Rectangle(
                    (birdPosition.x + 20), 
                    (birdPosition.y + 20),
                    animator.sprite.getWidth() - 20,
                    animator.sprite.getHeight() - 20
            );
            
            if (clipping.contains(new Point(
                    (int)numbersX + (numbers.get(0).getWidth(this) / 2),
                    (int)numbersY + (numbers.get(0).getWidth(this) / 2)
            ))) {
                //System.out.println(hit);
                hit = true;
                numbersX = 1920f;
                numbersY = new Random().nextInt(999-numbers.get(0).getHeight(this)); 
                hit = false;
            } 
            
            //System.out.println(getContentPane().getHeight());
            
            
            switch(d){
                case LEFT:
                    g.drawImage(animator.sprite, 
                        birdPosition.x + animator.sprite.getWidth() , 
                        birdPosition.y, 
                        -animator.sprite.getWidth(), 
                        animator.sprite.getHeight(),                    
                        null
                    );
                    break;
                case RIGHT:
                    g.drawImage(animator.sprite, 
                        birdPosition.x, 
                        birdPosition.y, 
                        animator.sprite.getWidth(), 
                        animator.sprite.getHeight(),                    
                        null
                    );
                    break;            
            }
            
            
            
            g.dispose();

            
            if (numbersX > -10) {
                numbersX -= 3f;
            }
            else{
                numbersX = 1920f;
            }
            
            
            if (backgroundX > 5955 * -1) {
                backgroundX -= 0.5f * 2f;
            }
            else{
                backgroundX = 0;
            }
        }
        repaint();
    }
   
    // TODO overwrite start(), stop() and destroy() methods

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
    
    @Override
    public void keyTyped(KeyEvent ke) {
    }

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
}
