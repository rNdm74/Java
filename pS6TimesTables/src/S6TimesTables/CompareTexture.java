
package xml;

import java.util.Comparator;

/**
 *
 * @author Adam Charlton
 */
public class CompareTexture implements Comparator<Texture> {
    
    /**
     *
     * @param o1 first variable to compare
     * @param o2 second variable to compare
     * @return returns either a zero or the > of the two variables
     */
    @Override
    public int compare(Texture o1, Texture o2) {
        return (o1 !=  null && o2 != null) ? 
                o1.getID() - o2.getID() : 0;
    }
}
