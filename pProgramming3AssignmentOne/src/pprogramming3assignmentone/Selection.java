
package pprogramming3assignmentone;

/**
 *
 * @author rndm
 */
public class Selection {
    private double[] numbers;
    
    public Selection(double[] numbers){
        this.numbers = numbers;        
    }
    
    public void selectionSortVersion1(){
        int smallestPos;
        
        for (int i = 0; i < numbers.length - 1; i++) {
            smallestPos = i;
            
            for (int j = i; j < numbers.length - 1; j++) {
                
                if (numbers[j + 1] < numbers[smallestPos]) {
                    smallestPos = j + 1;
                }
            }
            
            // Swap if needed
            if (smallestPos != i) {                
                double temp = 0;
                temp = numbers[i];
                numbers[i] = numbers[smallestPos];
                numbers[smallestPos] = temp;
            }
        }
    }    
}
