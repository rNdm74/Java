
package xml;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JApplet;

/**
 *
 * @author rNdm
 */
public class SpriteTest extends JApplet implements MouseListener, MouseMotionListener{
    private static ArrayList<Texture> textures;
    
    private Image backdrop;
    
    private SpriteSheet ss;
    private SpriteSheet bg;
    
    private Animation animator;
    
    private float speed = 0.05f;
    private float velocity = 3f;
    
    private Point mousePointer = new Point();
    
    int direction = 1;
    
    
    private float x = 0;
    private float y = 0;
    
    private float backgroundY = 0f;
    
    /**
     * Initialization method that will be called after the applet is loaded into
     * the browser.
     */
    @Override
    public void init() {
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(dim.width, dim.height);
        //setSize(320, 480);
        setMaximumSize(new Dimension(320, 480));
        addMouseMotionListener(this);
        addMouseListener(this);
        
        textures = new ReadXML().getImageData();
        
        BufferedImageLoader loader = new BufferedImageLoader();
        BufferedImage spriteSheet = null;
        BufferedImage background = null;
        
        try{
            spriteSheet = loader.loadImage("atlas.png");
            background = loader.loadImage("bg.png");
        } catch(IOException e){           
        }
        
        ss = new SpriteSheet(spriteSheet);
        bg = new SpriteSheet(background);
        
        backdrop = bg.getSprite(0, 0, 321, 2495);
                
        ArrayList<BufferedImage> sprites = new ArrayList<>();
        
        for (int i = 0; i < textures.size() - 1; i++) {
            if (textures.get(i).getName().contains("flight")) {
                Point p = new Point(
                    textures.get(i).getLocation().x,
                    textures.get(i).getLocation().y
                );        
                
                int width = textures.get(i).getSize().width;
                int height = textures.get(i).getSize().height;  
                sprites.add(ss.getSprite(p.x, p.y, width, height));
            }
        }
        
        animator = new Animation(sprites);
        animator.setSpeed(90);
        animator.start();
        
        x = getWidth() / 2 - 166 / 2;
        y = getHeight() - 166;
    }
    
    @Override
    public void start() {
    }
    
    /**
     *
     * @param g
     */
    Image dbImage;        
    Graphics dpg;
        
    @Override
    public void paint(Graphics g){         
        dbImage = createImage(getWidth(), getHeight());
        dpg = dbImage.getGraphics();
        paintComponent(dpg);
        g.drawImage(dbImage, 0,0,null);
    }
    
    public void paintComponent(Graphics g){
        
        g.drawImage(backdrop, 
                0,
                (-(backdrop.getHeight(this)) + getHeight()) + (int)backgroundY,
                backdrop.getWidth(this), 
                backdrop.getHeight(this), 
                null);
        
        if (animator != null) {
            animator.update(System.currentTimeMillis());
                        
            g.drawImage(animator.sprite, 
                    (int)x,
                    (int)y, 
                    animator.sprite.getWidth() * direction, 
                    animator.sprite.getHeight(), 
                    null
            );
            
            if (x+animator.sprite.getWidth() < mousePointer.x) {
                //direction = 1;
                x+= speed * velocity;
            }
            
            if (x > mousePointer.x) {
                //direction = -1;
                x-= speed * velocity;
            }
            
            if (y < mousePointer.y) {
                y+= speed * velocity;
            }
            
            if (y + animator.sprite.getHeight() > mousePointer.y) {
                y-= speed * velocity;
            }
            
//            if (y > 0) {
//                y -= speed * velocity;
//            } 
//            else{
//                //animator.pause();
//                //System.out.println(backgroundY);
//                if (backgroundY < 2000f) {
//                    backgroundY += 0.1f * 2f;
//                }                
//            }
        }
        repaint();
    }
    // TODO overwrite start(), stop() and destroy() methods

    @Override
    public void mouseDragged(MouseEvent e) {
        //speed+=0.25f;
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        //mousePointer = new Point(e.getPoint());
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        mousePointer = e.getPoint();
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
        speed+=0.2f;
        //System.out.println("foo");
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        speed = 0.05f;
    }

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}
}
