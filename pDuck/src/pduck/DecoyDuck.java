
package pduck;

public class DecoyDuck extends Duck{
    public DecoyDuck(){
        setFlyBehavior(new FlyNoWings());
        setQuackBehavior(new MuteQuack());
    }

    @Override
    public String display() {
        return "duckType= DecoyDuck,";
    }
    
}
