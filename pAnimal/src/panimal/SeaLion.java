/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package panimal;

/**
 *
 * @author rndm
 */
public class SeaLion extends Animal {

    public SeaLion(String name) {
        super(name);
        this.type = "sea lion";
    }
    
    @Override
    public String speak() {
        return "ROAR!";
    }
}
