
package S6TimesTables;

import java.awt.image.BufferedImage;

/**
 *
 * @author rNdm
 */
public class SpriteSheet {
    public BufferedImage spriteSheet;
    
    public SpriteSheet(BufferedImage spriteSheet){
        this.spriteSheet = spriteSheet;
    }
    
    public BufferedImage getSprite(int x, int y, int width, int height){
        BufferedImage sprite = spriteSheet.getSubimage(x, y, width, height);
        return sprite;
    }
    
}
