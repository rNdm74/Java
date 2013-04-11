/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pphone;

/**
 *
 * @author rndm
 */

public class Person {
    private String firstName; 
    private String lastName;
    private String room;
    private String title;
    private String phone;


    public Person(String firstName, String lastName,  String room, String title, String phone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.room = room;
        this.title = title;
        this.phone = phone;
    }

    public void setFirstName(String firstName){ this.firstName= firstName;}
    public void setLastName(String lastName){ this.lastName= lastName;}
    public void setroom(String room) {this.room = room;}
    public void settitle(String title) {this.title = title;}
    public void setPhone(String phone){ this.phone = phone;}

    public String getFirstName(){ return firstName;}
    public String getLastName(){ return lastName;}
    public String getRoom() {return room;}
    public String gettitle() {return title;}
    public String getPhone(){ return phone;}
        
    @Override
    public String toString(){
        return firstName +" "+lastName +" "+" "+phone;
    }
}
