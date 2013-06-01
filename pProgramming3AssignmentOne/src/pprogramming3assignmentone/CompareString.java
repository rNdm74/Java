
package pprogramming3assignmentone;

import java.util.Comparator;

/**
 *
 * @author Adam Charlton
 */
public class CompareString implements Comparator<String> {
    
    /**
     *
     * @param o1 first variable to compare
     * @param o2 second variable to compare
     * @return returns either a zero or the > of the two variables
     */
    @Override
    public int compare(String o1, String o2) {
        return (o1 !=  null && o2 != null) ? 
                o1.compareToIgnoreCase(o2) : 0;
    }
}
