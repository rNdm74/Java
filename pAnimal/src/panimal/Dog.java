/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package panimal;

/**
 *
 * @author rndm
 */
public class Dog extends Animal implements Domesticated{
    
    public Dog(String name) {
        super(name);
        this.type = "dog";
    }
    
    @Override
    public String speak(){
        return "WOOF!";        
    }    

    @Override
    public String work() {
        return "herd sheep";
    }

    @Override
    public String rewarded() {
        return "bones";
    }
    
    @Override
    public String toString(){
        String result = super.toString() + ", " 
                            + "I " + work() 
                            + " and when I do well give me " 
                            + rewarded() + ". " + REGFEE;
                            
        return result;
    }
}
