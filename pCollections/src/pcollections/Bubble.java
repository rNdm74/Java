/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pcollections;

/**
 *
 * @author rndm
 */
public class Bubble {
    private int[] numbers;
    //private String[] words;
    
    public Bubble(int[] numbers){
        this.numbers = numbers;        
    }
    
    public Bubble(){
        //this.words = words;        
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
        int temp = 0;  //string 
        
        int i = 0;
        
        boolean sorted = false;
        
        while (i < numbers.length && !sorted){
            
            sorted = true;
            
            for (int j = 0; j < (numbers.length - 1) - i; j++) {
                if (numbers[j] > numbers[j + 1]){ //.compareto
                    sorted = false;
                    temp = numbers[j];
                    numbers[j] = numbers[j+1];
                    numbers[j + 1] = temp;
                }    
            }
            
            i++;            
        }
    }
    
    public void bubbleSortString(String[] words){
        String temp;  //string 
        
        int i = 0;
        
        boolean sorted = false;
        
        while (i < words.length && !sorted){
            
            sorted = true;
            
            for (int j = 0; j < (words.length - 1) - i; j++) {
                if (words[j].compareTo(words[j+1]) > 0){ //.compareto
                    sorted = false;
                    temp = words[j];
                    words[j] = words[j+1];
                    words[j + 1] = temp;
                }    
            }
            
            i++;            
        }
    }
    
    public void bubbleSortString(Friend[] array){
        Friend temp;  //string 
        
        int i = 0;
        
        boolean sorted = false;
        
        while (i < array.length && !sorted){
            
            sorted = true;
            
            for (int j = 0; j < (array.length - 1) - i; j++) {
                if (array[j].getLastName().compareTo(array[j+1].getLastName()) > 0){ //.compareto
                    sorted = false;
                    temp = array[j];
                    array[j] = array[j+1];
                    array[j + 1] = temp;
                }    
            }
            
            i++;            
        }
    }
}
