/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pdice;

import java.util.Random;

/**
 *
 * @author rNdm
 */
public class Dice {
    private final int MAX = 7;
    private int faceValue;
    
    public Dice(){
        faceValue = 1;
    };
    
    public int roll(){         
        return new Random().nextInt(MAX);
    };
    
    public void setFaceValue(int value){
        this.faceValue = value;
    };
    
    public int getFaceValue(){
        return faceValue;
    };
    
    @Override
    public String toString(){return "You rolled a " + faceValue;};
}
