/**
 * Created by rNdm on 7/1/13.
 */
public class GOWall extends GameObject {
    public static  final int STDSIZE = 16;
    private GOBall ball;

    public GOWall(float x, float y, float sx, float sy, GOBall ball){
        this.x = x;
        this.y = y;
        this.sx = sx;
        this.sy = sy;
        this.ball = ball;
    }

    @Override
    void update() {
        if(Physics.checkCollisions(this,ball))ball.reverseY();
    }
}
