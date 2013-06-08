
package xml;

import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author rNdm
 */
public class FontManager {
    private SpriteSheet dl;
    
    private ArrayList<Texture> fonts;
    private ArrayList<Desyrel> gameFonts = new ArrayList<>();
    
    private BufferedImage desyrel = null;
    private BufferedImageLoader loader = new BufferedImageLoader();
    
    public FontManager(ArrayList<Texture> fonts) throws IOException{
        this.fonts = fonts;
        
        desyrel = loader.loadImage("desyrel.png");
        dl = new SpriteSheet(desyrel);
        
        for (int texture = 1; texture < fonts.size(); texture++) {
            Point p = new Point(
                    fonts.get(texture).getLocation().x,
                    fonts.get(texture).getLocation().y
            );
            
            int width = fonts.get(texture).getSize().width;
            int height = fonts.get(texture).getSize().height;
                        
            String letter = fonts.get(texture).getName();
            
            gameFonts.add(new Desyrel(letter, dl.getSprite(p.x, p.y, width, height)));
        }
    } 
    
    public Desyrel getLetter(CharSequence letter){
        Desyrel foundLetter = null;
        
        for(Desyrel font: gameFonts){
            if (font.getLetter().contentEquals(letter)) {
                foundLetter =  font;
            }
        }       
        return foundLetter;
    }
}
