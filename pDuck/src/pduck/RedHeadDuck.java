
package pduck;

public class RedHeadDuck extends Duck{
    public RedHeadDuck(){
        setFlyBehavior(new FlyWithWings());
        setQuackBehavior(new Quack());
    }

    @Override
    public String display() {
        return "duckType= RedHeadDuck,";
    }
    
}
