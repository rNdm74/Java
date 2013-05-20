
package pduck;

public class BlueDuck extends Duck{
    public BlueDuck(){
        setFlyBehavior(new FlyWithWings());
        setQuackBehavior(new Whistles());
    }    

    @Override
    public String display() {
        return "duckType= BlueDuck,";
    }    
}
