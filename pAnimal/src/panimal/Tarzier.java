/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package panimal;

/**
 *
 * @author rndm
 */
public class Tarzier extends Animal{
    public Tarzier(String name) {
        super(name);
        this.type = "tarzier";
    }

    @Override
    public String speak() {
        return "I AM UGLY!";
    }    
}
