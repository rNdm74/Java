/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pnewspapersubscriber;

/**
 *
 * @author rndm
 */
public abstract class NewspaperSubscriber {
    //Attributes
    protected String addresss;
    protected double rate;
    
    // Operations
    public NewspaperSubscriber(String address){};
    public boolean equals(NewspaperSubscriber nos){return false;};
    public String getAddress(String address){return null;};
    public double getRate(){return 0;};
    public void setRate(){};
}
