/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package psimplemaths;

import java.awt.List;
import java.util.ArrayList;


/**
 *
 * @author rNdm
 */
public class SimpleMaths {
    public float doAddition(float a, float b){
        return a+b;
    }
    
    public float doSubtraction(float a, float b){
        return a-b;
    }

    public float doMultiplication(float a, float b){
        return a*b;
    }

    public float doDivision(float a, float b){
        if(b == 0) {
            throw new ArithmeticException("Devision By Zero Error");
        }
        return a/b;
    }

    public float getBiggest(float a, float b){
        return a>b?a:b;
    }

    public float getBiggest(float a, float b, float c){   
        float MAX = a>b ? a:b;        
        return MAX> c ? MAX : c;
    }


    public float getAverage(int[] numbers){
        
        if (numbers == null) {
            throw new NullPointerException("Array is not initalized");
        }
    
        int total = 0;
        
        for(int element: numbers){
            total += element;
        }
    
    return (float)total / numbers.length;
    }
}





