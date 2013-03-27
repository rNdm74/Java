/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package psorting;

/**
 *
 * @author rndm
 */
public class Selection {
    private int[] numbers;
    
    public Selection(int[] numbers){
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
                int temp = 0;
                temp = numbers[i];
                numbers[i] = numbers[smallestPos];
                numbers[smallestPos] = temp;
            }
        }
    }    
}
