
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;

import java.util.ArrayList;

/**
 * Created by rNdm on 7/1/13.
 */
public class Game {

    private ArrayList<GameObject> objects;
    private GOPlayer player;
    private GOEnemy enemy;
    private GOBall ball;

    private int playerScore;
    private int enemyScore;

    public Game(){
        objects = new ArrayList<>();

        playerScore = 0;
        enemyScore = 0;

        ball = new GOBall(Display.getWidth() / 2 - GOBall.SIZE / 2, Display.getHeight() / 2 - GOBall.SIZE / 2);

        player = new GOPlayer(10, Display.getHeight() / 2 - GOPlayer.SIZEY / 2, ball);

        enemy = new GOEnemy(Display.getWidth() - GOEnemy.SIZEX - 10, Display.getHeight() / 2 - GOEnemy.SIZEY / 2, ball);

        GOWall south = new GOWall(0,0, Display.getWidth(), GOWall.STDSIZE, ball);
        GOWall north = new GOWall(0,Display.getHeight() - GOWall.STDSIZE, Display.getWidth(), GOWall.STDSIZE, ball);

        objects.add(ball);
        objects.add(player);
        objects.add(enemy);
        objects.add(north);
        objects.add(south);
    }

    public void getInput(){
        if (Keyboard.isKeyDown(Keyboard.KEY_W) || Keyboard.isKeyDown(Keyboard.KEY_UP))player.move(1);
        if (Keyboard.isKeyDown(Keyboard.KEY_S) || Keyboard.isKeyDown(Keyboard.KEY_DOWN))player.move(-1);
    }

    public void update(){
        for(GameObject o: objects)o.update();

        if(ball.getX() > Display.getWidth()){
            playerScore++;
            ball.resetPosition();
        }

        if(ball.getX() < 0){
            enemyScore++;
            ball.resetPosition();
        }
    }

    public void render(){
        for(GameObject o: objects)o.render();

        Display.setTitle("Score: P" + playerScore + " E" + enemyScore);
    }
}
