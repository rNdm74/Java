/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package panimal;

/**
 *
 * @author rndm
 */
public abstract class Animal {
    protected String name;
    protected String type;

    public Animal(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }    
    public void setName(String name){
        this.name = name;
    }
    public String getType() {
        return type;
    }    
    public abstract String speak();
    
    @Override
    public String toString(){
        String result = " \nMy name is " + name + "\n" +
                        "I am a " +  type + 
                        " and I go " + speak();
        return result;        
    }
}

