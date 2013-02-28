/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ptempconv;

public class TempConv 
{
   private double cel;
   private double fah;
   private double kel;
   
   public TempConv (double cel)
   {
       setCel(cel);
   }
   
   public double getCel()
   {
       return cel;
   }
   
   public double getFah()
   {
       return (cel*1.8)+32;
   }
   
   public double getKel()
   {
       return (cel+273);
   }
   
   public void setCel(double cel)
   {
     this.cel=cel;
     fah=(cel*1.8)+32;
     kel=(cel+273);
   }
   
   public void setFah(double fah)
   {
       this.fah=fah;
       cel=(fah-32)/1.8;
       kel=(cel+273);
   }
   
   public void setKel(double kel)
   {
       this.kel=kel;
       cel=(kel-273);
       fah=(cel*1.8)+32;
   }
   
   public String toString()
   {
       return "Celsius is " + this.cel+ 
              "Fahrenheit is " + this.fah+ 
              "Kelvin is " + this.kel;
   }
   
    
}
