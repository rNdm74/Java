package pnameinstars;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Author Adam Charlton, class takes string input and then has a function 
 * that returns a concatenated string.
 */

public class NameInStars {
    
    private String name;
    
    public NameInStars(String name)
    {
        this.name = name;
    }
    
    public String surrondNameinStars()
    {
        return "****" + name + "****\n" + 
               "****" + name + "****\n" +
               "****" + name + "****"; 
    }    
}
