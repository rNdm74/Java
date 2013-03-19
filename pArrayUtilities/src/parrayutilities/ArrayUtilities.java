/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package parrayutilities;

/**
 *
 * @author rndm
 */
public class ArrayUtilities {
    
    public int findMax(int[] numbers){
        int max = numbers[0];
        
        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i] > max) {
                max = numbers[i];
            }
        }
        
        return max;
    }
    
    public int findMin(int[] numbers){
        int min = numbers[0];
        
        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i] < min) {
                min = numbers[i];
            }
        }
        
        return min;
    }
    
    public String findIt(int[] numbers, int wanted){
        StringBuilder sb = new StringBuilder();        
        
        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i] == wanted) {
                sb.append(wanted).append(" was found");
                break;
            }
            else{
               sb.append(wanted).append(" was not found");
               break;
            }
        }
        
        return sb.toString();
    }
    
}
