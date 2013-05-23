package pprogramming3assignmentone;

/**
 *
 * @author rndm
 */
public class Binary {
    public String binarySearch(int[] numbers, int wanted){
        int left = 0;
        int right = numbers.length - 1;
        
        while(left <= right && right >= left){
            
            int middle = (left + right) / 2;
            
            if (numbers[middle] == wanted) {  
                return "Number found at slot number " + middle;
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
        
        return "Number not found";
    }
    
    public String binarySearch(String[] words, String wanted){
        int left = 0;
        int right = words.length - 1;
                
        while(left <= right && right >= left){
            int middle = (left + right) / 2;
            
            if (wanted.equals(words[middle])) {  
                return "Word found at slot number " + middle;
            }
            else
            {
                if (wanted.compareTo(words[middle]) < 0) {                    
                    right = middle - 1;   
                }
                
                if (wanted.compareTo(words[middle]) > 0) {
                    left = middle + 1;
                }
            }
        }
        
        return "Word not found";
    }
}
