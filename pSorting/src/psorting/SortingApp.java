/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package psorting;

/**
 *
 * @author rndm
 */
public class SortingApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] numbers = {5, 2, 8 ,6, 1, 9, 7, 3, 4 };
        
        //Bubble sort = new Bubble(numbers);
        //Selection sort = new Selection(numbers);
        Bucket sort = new Bucket(numbers);
        
        //sort.bubbleSortVersion1();
        //sort.bubbleSortVersion2();
        //sort.bubbleSortVersion3();
        
        //sort.selectionSortVersion1();
        
        sort.bucketSort();
        
        for (int item : numbers) {
            System.out.print(item);
        }
    }
}
