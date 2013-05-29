
package pprogramming3assignmentone;

import java.util.Comparator;

/**
 *
 * @author rndm
 */
public class CompareDouble implements Comparator<Double> {

    @Override
    public int compare(Double o1, Double o2) {
        return ((o1 !=  null && o2 != null) ? 
                       o1.compareTo(o2) : 0);
    }
}
