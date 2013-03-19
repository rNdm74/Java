/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package parrayutilities;

/**
 *
 * @author rndm
 */
public class ArrayUtilitiesApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayUtilities worker = new ArrayUtilities();
        
        int[] numbers = new int[100];
        for (int i = 0; i < numbers.length; i++) {
            
            numbers[i] = (int)(100* Math.random()+1);
            
            //System.out.println(numbers[i]);
        }
        
        System.out.println(worker.findMax(numbers));
        System.out.println(worker.findMin(numbers));
        System.out.println(worker.findIt(numbers, 50));
    }
}
