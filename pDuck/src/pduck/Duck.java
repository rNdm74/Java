
package pduck;

public abstract class Duck {
    private FlyBehavior flyBehavior;
    private QuackBehavior quackBehavior;
    
    public abstract String display();
    
    public String preformFly(){
        return flyBehavior.fly();
    }
    
    public String preformQuack(){
        return quackBehavior.quack();
    }
    
    public String swim(){
        return " swimBehavior= can float.";
    }
    
    public void setFlyBehavior(FlyBehavior fb){
        flyBehavior = fb;
    }
    
    public void setQuackBehavior(QuackBehavior qb){
        quackBehavior = qb;
    } 
    
    @Override
    public String toString(){
        return display() + 
               " flyBehavior=" + 
               preformFly() + 
               ", quackBehavior=" + 
               preformQuack() + 
               "," + swim(); 
    }
}
