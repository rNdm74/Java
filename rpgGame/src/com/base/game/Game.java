package com.base.game;

import com.base.engine.GameObject;
import com.base.engine.Physics;
import com.base.gameobject.Birdie;
import com.base.gameobject.Player;
import com.base.gameobject.item.Poop;
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

    public Game(){
        objects = new ArrayList<>();
        remove = new ArrayList<>();

        player = new Player(Display.getWidth() / 2 - Player.SIZE / 2, Display.getHeight() / 2 - Player.SIZE / 2);

        objects.add(player);
        objects.add(new Poop(132, 132));
        objects.add(new Birdie(0, Display.getHeight() - Birdie.SIZE, 1));
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
