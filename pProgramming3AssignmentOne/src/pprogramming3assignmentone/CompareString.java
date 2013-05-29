
package pprogramming3assignmentone;

import java.util.Comparator;

/**
 *
 * @author rndm
 */
public class CompareString implements Comparator<String> {
    
    @Override
    public int compare(String o1, String o2) {
        return (o1 !=  null && o2 != null) ? 
                o1.compareToIgnoreCase(o2) : 0;
    }
}
