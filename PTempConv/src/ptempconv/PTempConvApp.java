/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ptempconv;

import java.text.DecimalFormat;

/**
 *
 * @author Tanvi
 */
public class PTempConvApp {

    public static void main(String[] args) 
    {
        TempConv temperature=new TempConv(22.3);
        
        System.out.println(temperature.toString());
        System.out.println(temperature.getCel());
        System.out.println(temperature.getFah());
        System.out.println(temperature.getKel());
        
        DecimalFormat formater=new DecimalFormat("0.##");
        
        System.out.println(formater.format(temperature.getCel()));
        System.out.println(formater.format(temperature.getFah()));
        System.out.println(formater.format(temperature.getKel()));
        
    }
}
