/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pcomputer;

/**
 *
 * @author rndm
 */
public class Laptop extends Computer {
    private static final String DEFAULT_MAN = "Intel";
    private double screenSize;
    private double weight;

    public Laptop(String manufacturer, String processor, int ramSize, int diskSize,
                         double screenSize, double weight) {
        super(manufacturer, processor, ramSize, diskSize);        
        this.screenSize = screenSize;
        this.weight = weight;
    }
    
    public Laptop(String processor, int ramSize, int diskSize, 
                    double screenSize, double weight) {
        this(DEFAULT_MAN, processor, ramSize, diskSize, screenSize, weight);
    }
        
    @Override
    public String toString(){
        String result = super.toString() 
                + "\n" + screenSize + " inches"
                + "\n" + weight + "\n\n";
        return result;
    }
}
