
package S6TimesTables;

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
    
    private ArrayList<GameText> gameFonts = new ArrayList<>();
    
    private BufferedImage desyrel = null;
    private BufferedImageLoader loader = new BufferedImageLoader();
    
    public FontManager(ArrayList<Texture> fonts) throws IOException{        
        desyrel = loader.loadImage("desyrel.png");
        dl = new SpriteSheet(desyrel);
        
        for (int texture = 1; texture < fonts.size(); texture++) {
            Point p = new Point(
                    fonts.get(texture).getLocation().x,
                    fonts.get(texture).getLocation().y
            );
            
            int width = fonts.get(texture).getSize().width;
            int height = fonts.get(texture).getSize().height;
                        
            char letter = ((String)fonts.get(texture).getText()).charAt(0);
            
            gameFonts.add(new GameText(letter, dl.getSprite(p.x, p.y, width, height)));
        }
    } 
    
    public GameText getLetter(char letter){
        GameText foundLetter = null;
        
        for(GameText font: gameFonts){
            if (font.getChar() == letter) {
                foundLetter =  font;
            }
        }       
        return foundLetter;
    }
}
