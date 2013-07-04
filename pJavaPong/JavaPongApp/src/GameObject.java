import java.util.ArrayList;

/**
 * Created by rNdm on 7/1/13.
 */
public abstract class GameObject {
    protected float x;
    protected float y;
    protected float sx;
    protected float sy;

    public GameObject(){
    }

    public void getInput(){
    }

    abstract void update();

    public void render(){
        Draw.rect(x, y, sx, sy);
    }

    public float getX(){
        return x;
    }

    public float getY(){
        return y;
    }

    public float getSX(){
        return sx;
    }

    public float getSY(){
        return sy;
    }

    public float getCenterY(){
        return y + sy / 2;
    }
}
