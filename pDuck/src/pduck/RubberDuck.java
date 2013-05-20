
package pduck;

public class RubberDuck extends Duck {
    public RubberDuck(){
        setFlyBehavior(new FlyNoWings());
        setQuackBehavior(new Squeak());
    }

    @Override
    public String display() {
        return "duckType= RubberDuck,";
    }
    
}
