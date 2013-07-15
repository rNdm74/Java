package com.base.gameobject;

import com.base.engine.GameObject;
import com.base.game.Delay;
import com.base.game.Game;
import com.base.game.Time;
import com.base.game.Util;
import com.base.item.Item;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;

import java.util.ArrayList;

import static org.lwjgl.opengl.GL11.glTranslatef;

/**
 * Created by Adam Charlton.
 */
public class Player extends StatObject {
    public static final int SIZE = 32;

    public static final int FORWARD = 0;
    public static final int BACKWARD = 1;
    public static final int LEFT = 2;
    public static final int RIGHT = 3;

    private Inventory inventory;
    private Equipment equipment;

    private int attackDamage;
    private int attackRange;
    private Delay attackDelay;

    private int facingDirection;

    private int moveAmountX;
    private int moveAmountY;

    public Player(float x, float y){
        init(x, y, 0.1f, 1f, 0.25f, SIZE, SIZE, PLAYER_ID);

        stats = new Stats(0, true);
        inventory = new Inventory(20);
        equipment = new Equipment(inventory);

        moveAmountX = 0;
        moveAmountY = 0;

        attackDamage = 1;
        attackRange = 49;

        attackDelay = new Delay(500); // MILLISECONDS
        attackDelay.terminate();

        facingDirection = 0;
    }

    @Override
    public void update(){
//        StringBuilder sb = new StringBuilder();
//
//        sb.append("Speed: " + getSpeed());
//        sb.append("     Level: " + getLevel());
//        sb.append("     XP: " + getXp());
//        sb.append("     MaxHP: " + getMaxHealth());
//        sb.append("     HP: " +  getCurrentHealth());
//        sb.append("     Strength: " + Math.round(getStrength()));
//        sb.append("     Magic: " + Math.round(getMagic()));
//
//        Display.setTitle(sb.toString());

        float newX = x + (float)moveAmountX;
        float newY = y + (float)moveAmountY;

        moveAmountX = 0;
        moveAmountY = 0;

        ArrayList<GameObject> objects = Game.rectangleCollide(newX,  newY, newX + SIZE, newY + SIZE);

        ArrayList<GameObject> items = new ArrayList<>();

        boolean move = true;

        for (GameObject go: objects){
            if (go.getType() == GameObject.ITEM_ID){
                items.add(go);
            }

            if (go.isSolid()){
                move = false;
            }
        }

        if(!move) return;

        x = newX;
        y = newY;

        for(GameObject go: items){
            System.out.println(((Item)go).getName());
            go.remove();
            addItem((Item)go);
        }
    }

    public void getInput(){
        if(Keyboard.isKeyDown(Keyboard.KEY_W)){
            move(0,1);
        }
        if(Keyboard.isKeyDown(Keyboard.KEY_S)){
            move(0,-1);
        }
        if(Keyboard.isKeyDown(Keyboard.KEY_A)){
            move(-1,0);
        }
        if(Keyboard.isKeyDown(Keyboard.KEY_D)){
            move(1,0);
        }
        if(Keyboard.isKeyDown(Keyboard.KEY_SPACE) && attackDelay.isOver()){
            attack();
        }
    }

    public void attack(){
        //Find objects in attack range
        ArrayList<GameObject> objects = new ArrayList<>();

        if (facingDirection == FORWARD)
            objects = Game.rectangleCollide(x, y, x + SIZE, y + attackRange);
        else if (facingDirection == BACKWARD)
            objects = Game.rectangleCollide(x, y - attackRange + SIZE, x + SIZE, y);
        else if (facingDirection == LEFT)
            objects = Game.rectangleCollide(x - attackRange + SIZE, y, x, y + SIZE);
        else if (facingDirection == RIGHT)
            objects = Game.rectangleCollide(x, y, x + attackRange, y + SIZE);

        //Find objects that are enemies
        ArrayList<Enemy> enemies = new ArrayList<>();

        for(GameObject go: objects){
            if(go.getType() == ENEMY_ID) {
                enemies.add((Enemy)go);
            }
        }

        //FIND closset enemy if one exists
        if(enemies.size() > 0){
            Enemy target = enemies.get(0);

            if(enemies.size() > 1){
                for(Enemy e: enemies){
                    if(Util.dist(x, y, e.getX(),e.getY()) < Util.dist(x, y, target.getX(), target.getY())){
                        target = e;
                    }
                }
            }

            // ATTACK ENEMY
            target.damage(attackDamage);
            System.out.println(": " + target.getCurrentHealth() + "/" + target.getMaxHealth());
        }
        else
            System.out.println(": NO TARGET");

        attackDelay.restart();
    }

    @Override
    public void render(){

        glTranslatef(Display.getWidth() / 2 - Player.SIZE / 2, Display.getHeight() / 2 - Player.SIZE / 2, 0);
        sprite.render();
        glTranslatef(-x,-y,0);
    }

    private void move(float magX, float magY) {

        if(magX == 0 && magY == 1) facingDirection = FORWARD;
        if(magX == 0 && magY == -1) facingDirection = BACKWARD;
        if(magX == -1 && magY == 0) facingDirection = LEFT;
        if(magX == 1 && magY == 0) facingDirection = RIGHT;

        moveAmountX += 4f * magX * Time.getDelta()*14f; //TODO: Add speed based scale
        System.out.println(Time.getDelta()*14f);
        moveAmountY += 4f * magY * Time.getDelta()*14f;
    }

    public void addXp(float amount){
        stats.addXp(amount);
    }

    public void addItem(Item item){
        inventory.add(item);
    }
}
