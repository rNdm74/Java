
package pduck;

public class MallardDuck extends Duck{
    public MallardDuck(){
        setFlyBehavior(new FlyWithWings());
        setQuackBehavior(new Quack());
    }

    @Override
    public String display() {
        return "duckType= Mallard,";
    }
    
}
