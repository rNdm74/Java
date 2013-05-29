package pprogramming3assignmentone;

/**
 *
 * @author rndm
 */
public class Binary {
    public int binarySearch(int[] numbers, int wanted){
        int left = 0;
        int right = numbers.length - 1;
        
        while(left <= right && right >= left){
            
            int middle = (left + right) / 2;
            
            if (numbers[middle] == wanted) {  
                return middle;
            }
            else
            {
                if (wanted < numbers[middle]) {
                        right = --middle;
                }
                
                if (wanted > numbers[middle]) {
                    left = ++middle;
                }
            }
        }
        
        return -1;
    }
    
    public int binarySearch(String[] strings, String wanted){
        int left = 0;
        int right = strings.length - 1;
                
        while(left <= right && right >= left){
            int middle = (left + right) / 2;
            
            if (wanted.equals(strings[middle])) {  
                return middle;
            }
            else
            {
                if (wanted.compareTo(strings[middle]) < 0) {                    
                    right = middle - 1;   
                }
                
                if (wanted.compareTo(strings[middle]) > 0) {
                    left = middle + 1;
                }
            }
        }
        
        return -1;
    }
}
