/**
 * Created by rNdm on 7/1/13.
 */
public class GOBall extends GameObject {

    public static final int SIZE = 16;

    public static final float MAX_SPEEDX = 4f;
    public static final float MAX_SPEEDY = 8f;
    public static final float DAMPING = 0.05f;

    public float velX;
    public float velY;

    public float startX;
    public float startY;

    public GOBall(float x, float y){
        this.x = x;
        this.y = y;

        startX = x;
        startY = y;

        this.sx = SIZE;
        this.sy = SIZE;

        velX = -MAX_SPEEDX;
        velY = 0;
    }

    @Override
    public void update() {
        x += velX;
        y += velY;
    }

    public void resetPosition(){
        x = startX;
        y = startY;

        velY = 0;
        velX *= -1;
    }

    public void reverseX(float center){
        velX *= -1;
        velY += (getCenterY() - center) * DAMPING;

        if (velY > MAX_SPEEDY)velY = MAX_SPEEDY;
        if (velY < -MAX_SPEEDY)velY = -MAX_SPEEDY;
    }

    public void reverseY(){
        velY *= -1;
    }
}
