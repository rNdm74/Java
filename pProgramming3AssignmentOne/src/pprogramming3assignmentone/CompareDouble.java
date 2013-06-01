
package pprogramming3assignmentone;

import java.util.Comparator;

/**
 *
 * @author Adam Charlton
 */
public class CompareDouble implements Comparator<Double> {

    /**
     *
     * @param o1 first variable to compare
     * @param o2 second variable to compare
     * @return returns either a zero or the > of the two variables
     */
    @Override
    public int compare(Double o1, Double o2) {
        return ((o1 !=  null && o2 != null) ? 
                       o1.compareTo(o2) : 0);
    }
}
