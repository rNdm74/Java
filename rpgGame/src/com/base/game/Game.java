package com.base.game;

import com.base.engine.GameObject;
import com.base.engine.Physics;
import com.base.gameobject.Player;
import com.base.item.Wall;
import org.lwjgl.opengl.Display;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by rNdm on 7/5/13.
 */
public class Game{
    public static Game game;

    private ArrayList<GameObject> objects;
    private ArrayList<GameObject> remove;
    private Player player;

    public void generateTestLevel(){
        int wall_thickness = 15;
        //Generate first room
        objects.add(new Wall(200,200, wall_thickness, 300)); // West
        objects.add(new Wall(500,200, wall_thickness, 100)); // East
        objects.add(new Wall(500,400, wall_thickness, 100)); // East
        objects.add(new Wall(200,200, 300, wall_thickness)); // South
        objects.add(new Wall(200,500, 98, wall_thickness));  // North
        objects.add(new Wall(402,500, 100, wall_thickness)); // North

        //Generate hallway1
        objects.add(new Wall(298,500, wall_thickness, 200)); // West
        objects.add(new Wall(400,500, wall_thickness, 200)); // East

        //Generate second room
        objects.add(new Wall(400,700, 100, wall_thickness)); // South
        objects.add(new Wall(200,700, 100, wall_thickness)); // South
        objects.add(new Wall(200,700, wall_thickness, 300)); // West
        objects.add(new Wall(500,700, wall_thickness, 300)); // East
        objects.add(new Wall(200,1000, 302, wall_thickness));// North

        //Generate hallway2
        objects.add(new Wall(500,300, 200, wall_thickness)); // East
        objects.add(new Wall(500,400, 200, wall_thickness)); // East

        //Generate third room
        objects.add(new Wall(700,400, wall_thickness, 100)); // West
        objects.add(new Wall(700,200, wall_thickness, 100)); // West
        objects.add(new Wall(700,200, 300, wall_thickness)); // South
        objects.add(new Wall(700,500, 300, wall_thickness)); // North
        objects.add(new Wall(1000,200, wall_thickness, 302));// East
    }

    public Game(){
        objects = new ArrayList<>();
        remove = new ArrayList<>();

        player = new Player(Display.getWidth() / 2 - Player.SIZE / 2, Display.getHeight() / 2 - Player.SIZE / 2);

        objects.add(player);
        generateTestLevel();
//        objects.add(new Poop(132, 132));
//        objects.add(new Birdie(0, Display.getHeight() - Birdie.SIZE, 1));
//

    }

    public void getInput(){
        player.getInput();
    }

    public void update(){
        for(GameObject go: objects) if (go.isRemove()) remove.add(go); else go.update();

        for(GameObject go: remove) objects.remove(go);
    }

    public void render(){
        for(GameObject go: objects)go.render();
    }

    public ArrayList<GameObject> getObjects(){
        return objects;
    }

    public static ArrayList<GameObject> sphereCollide(float x, float y, float radius){
        ArrayList<GameObject> result = new ArrayList<>();

        for(GameObject go: game.getObjects()){
            if(Util.dist(go.getX(), go.getY(), x, y) < radius){
                result.add((go));
            }
        }

        return result;
    }

    public static ArrayList<GameObject> rectangleCollide(float x1, float y1, float x2, float y2) {
        ArrayList<GameObject> result = new ArrayList<>();

        float sx = x2 - x1;
        float sy = y2 - y1;

        Rectangle collider = new Rectangle((int)x1,(int) y1, (int)sx, (int)sy);

        for(GameObject go: game.getObjects()){
            if(Physics.checkCollision(collider, go) != null) result.add(go);
        }

        return result;
    }
}
