/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package psorting;

/**
 *
 * @author rndm
 */
public class Bucket {
    private int[] numbers;
    
    public Bucket(int[] numbers){
        this.numbers = numbers; 
    } 
    
    public void bucketSort(){
        int tally = 0;
        
        int[] buckets = new int[findMax() + 1];
        
        for (int b = 0; b < numbers.length; b++) { 
           buckets[numbers[b]] = buckets[numbers[b]] + 1;            
        }
        
        for (int b = 0; b < buckets.length; b++){
            for (int i = 0; i < buckets[b]; i++){
                numbers[tally++] = b;
            }
        }        
    } 
    
    private int findMax(){
        int max = numbers[0];
        
        for (int i = 0; i < numbers.length; i++) {
            if(numbers[i] > max){ max = numbers[i];}
        }
        
        return max;
    }
}
