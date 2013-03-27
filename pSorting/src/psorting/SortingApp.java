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
        int[] numbers = new int[] {5, 2, 8 ,6, 1, 9, 7, 3, 4 };
        
        //Bubble sort = new Bubble(numbers);
        Selection sort = new Selection(numbers);
        
        //sort.bubbleSortVersion1();
        //sort.bubbleSortVersion2();
        //sort.bubbleSortVersion3();
        
        sort.selectionSortVersion1();
        
        for (int item : numbers) {
            System.out.println(item);
        }
    }
}
