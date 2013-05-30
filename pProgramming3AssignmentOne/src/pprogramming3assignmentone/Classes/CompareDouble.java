
package pprogramming3assignmentone.Classes;

import java.util.Comparator;

/**
 *
 * @author Adam Charlton
 */
public class CompareDouble implements Comparator<Double> {

    @Override
    public int compare(Double o1, Double o2) {
        return ((o1 !=  null && o2 != null) ? 
                       o1.compareTo(o2) : 0);
    }
}
