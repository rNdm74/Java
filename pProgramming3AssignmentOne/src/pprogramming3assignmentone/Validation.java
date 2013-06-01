
package pprogramming3assignmentone;

/**
 *
 * @author Adam Charlton
 */
public class Validation {
    /**
     *
     * @param input variable to check is a number
     * @return true false
     */
    public boolean number(Object input){ 
       try  
       {  
          Double.parseDouble((String) input);  
          return true;  
       }  
       catch( Exception e)  
       {  
          return false;  
       }  
    }    
}
