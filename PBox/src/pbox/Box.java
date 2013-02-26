/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pbox;

public class Box {    
    private double bHeight;
    private double bLength;
    private double bWidth;
    
    // Constructor    
    public Box(double bHeight, double bLength, double bWidth){
    this.bHeight = bHeight;
    this.bLength = bLength;
    this.bWidth = bWidth;    
    };
    
    public Box(double squareBase, double bHeight){
    this.bLength = this.bWidth = squareBase;
    this.bHeight = bHeight;
    };
    
    public Box(double side){
    this.bHeight = this.bLength = this.bWidth = side;
    };    
    
    public double getHeight(){return bHeight;};    
    public double getLength(){return bLength;};
    public double getWidth(){return bWidth;};
    
    public void setbHeight(double bHeight){
        this.bHeight = bHeight;
    };      
    public void setbLength(double bLength){
        this.bLength = bLength;
    };
    public void setbWidth(double bWidth){
        this.bWidth = bWidth;
    };
    
    public double calcVolume(){return bHeight * bWidth * bLength;};
    public double getSurfaceArea(){return ((bHeight * bLength) *  2) +
                                          ((bWidth * bLength) *  2) + 
                                          ((bWidth * bHeight) *  2);
    };
    
    @Override
    public String toString(){ return " Height is " + bHeight + "\n" +
                                     " Width is " + bWidth + "\n" +
                                     " Length is " + bLength + "\n" + 
                                     " Volume is " + calcVolume() + "\n" +
                                     " Surface Area is " + getSurfaceArea() + "\n";
    };
}
