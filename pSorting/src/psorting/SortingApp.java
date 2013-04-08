/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package psorting;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author rndm
 */
public class SortingApp {

    /**
     * @param args the command line arguments
     */
    private static int lineCount(BufferedReader in) throws FileNotFoundException, IOException{
        int count = 0;    
        
        while ((in.readLine()) != null) {
                count++;
        }
        
        return count;
    }
    
    private static int[] populateIntArray(String fileName) throws FileNotFoundException, IOException{
        BufferedReader in = new BufferedReader(new FileReader(fileName));
        String line;
        int index = 0;
        
        int[] myArray = new int[10000];
        
        while (((line = in.readLine()) != null) && (index<10000)) {
                myArray[index] = Integer.parseInt(line);
                index++;
            }      
                
        return myArray;
    }
    
    private static String[] populateStringArray(String fileName) throws FileNotFoundException, IOException{
        BufferedReader in = new BufferedReader(new FileReader(fileName));
        String line;
        int index = 0;
        
        //int[] myArray = new int[10000];
        String[] myArray = new String[1291];
        while (((line = in.readLine()) != null) && (index<1291)) {
                myArray[index] = line;
                index++;
            }      
                
        return myArray;
    }
    
    public static void main(String[] args) throws FileNotFoundException, IOException {
        //int[] numbers = populateIntArray("sort04.txt");
        String[] words = populateStringArray("threebears.txt");
        //int[] numbers = {5, 2, 8 ,6, 1, 9, 7, 3, 4 };
        //String[] words = {"b", "f", "a", "e", "c", "d"};
        
        Bubble sort = new Bubble();
        //Bubble sort = new Bubble(numbers);
        //Selection sort = new Selection(numbers);
        //Bucket sort = new Bucket(numbers);
        
        //Bubble sort = new Bubble(numbers);
        sort.bubbleSortString(words);
        
        
        Binary search = new Binary();  
        
        String word = search.binarySearch(words, "bad"); 
        
        System.out.println(word);
        
        //sort.bubbleSortVersion1();
        //sort.bubbleSortVersion2();
        //sort.bubbleSortVersion3();
        
        //sort.selectionSortVersion1();
        
        //sort.bucketSort();
        
        //for (int item : numbers) {
        //    System.out.println(item);
        //}
        //System.out.println(numbers.length);
    }
}
