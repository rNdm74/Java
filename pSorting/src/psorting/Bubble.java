/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package psorting;

/**
 *
 * @author rndm
 */
public class Bubble {
    private int[] numbers;
    
    public Bubble(int[] numbers){
        this.numbers = numbers;        
    }
    
        
    public void bubbleSortVersion1(){
        int temp = 0;       
        
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = 0; j < numbers.length - 1; j++) {
                if (numbers[j] > numbers[j + 1]){
                    temp = numbers[j];
                    numbers[j] = numbers[j+1];
                    numbers[j + 1] = temp;
                }    
            }   
        }
    }  
    
    public void bubbleSortVersion2(){
        int temp = 0;       
        
        for (int i = 0; i < numbers.length - 1; i++) {
            // Modified inner loop
            for (int j = 0; j < (numbers.length - 1) - i; j++) {
                if (numbers[j] > numbers[j + 1]){
                    temp = numbers[j];
                    numbers[j] = numbers[j+1];
                    numbers[j + 1] = temp;
                }    
            }   
        }
    }
    
    public void bubbleSortVersion3(){
        int temp = 0;   
        
        int i = 0;
        
        boolean sorted = false;
        
        while (i < numbers.length && !sorted){
            
            sorted = true;
            
            for (int j = 0; j < (numbers.length - 1) - i; j++) {
                if (numbers[j] > numbers[j + 1]){
                    sorted = false;
                    temp = numbers[j];
                    numbers[j] = numbers[j+1];
                    numbers[j + 1] = temp;
                }    
            }
            
            i++;            
        }
    }
}
