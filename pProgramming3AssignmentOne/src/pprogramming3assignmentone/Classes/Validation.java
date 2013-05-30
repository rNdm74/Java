
package pprogramming3assignmentone.Classes;

/**
 *
 * @author Adam Charlton
 */
public class Validation {
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
