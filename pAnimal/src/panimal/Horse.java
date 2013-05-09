/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package panimal;

import static panimal.Domesticated.REGFEE;

/**
 *
 * @author rndm
 */
public class Horse extends Animal implements Domesticated{    
    public Horse(String name) {
        super(name);
        this.type = "horse";
    }

    @Override
    public String speak() {
        return "NEIGH!";
    }

    @Override
    public String work() {
        return "plough fields";
    }

    @Override
    public String rewarded() {
        return "apples";
    }
    
    @Override
    public String toString(){
        String result = super.toString() + ", " 
                            + "I " + work() 
                            + " and when I do well give me " 
                            + rewarded() + ". " + "My registration is $" + Math.round(REGFEE);
                            
        return result;
    }    
}
