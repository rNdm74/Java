
package S6TimesTables;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;

/**
 *
 * @author rNdm
 */
public class BufferedImageLoader {
    public BufferedImage loadImage(String path) throws IOException{
        URL url = this.getClass().getResource(path);        
        BufferedImage img = ImageIO.read(url);        
        return img;
    }
}
