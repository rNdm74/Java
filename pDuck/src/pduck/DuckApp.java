
package pduck;

import java.util.ArrayList;

public class DuckApp {

    public static void main(String[] args) {
        ArrayList<Duck> ducks = new ArrayList<>();
        
        ducks.add(new MallardDuck());
        ducks.add(new RedHeadDuck());
        ducks.add(new DecoyDuck());
        ducks.add(new RubberDuck());
        ducks.add(new BlueDuck());
        
        for(Duck d: ducks){
            System.out.println(d.toString());
        }
    }
}
