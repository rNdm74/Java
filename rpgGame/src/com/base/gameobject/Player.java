package com.base.gameobject;

import com.base.engine.GameObject;
import com.base.gameobject.item.Item;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;

/**
 * Created by Adam Charlton.
 */
public class Player extends GameObject {
    public static final int SIZE = 32;

    private Stats stats;
    private Inventory inventory;

    public Player(float x, float y){
        init(x, y, 0.1f, 1f, 0.25f, SIZE, SIZE, PLAYER_ID);

        stats = new Stats(0, true);
        inventory = new Inventory(20);
    }

    @Override
    public void update(){
        StringBuilder sb = new StringBuilder();

        sb.append("Speed: " + getSpeed());
        sb.append("     Level: " + getLevel());
        sb.append("     XP: " + getXp());
        sb.append("     MaxHP: " + getMaxHealth());
        sb.append("     HP: " +  getCurrentHealth());
        sb.append("     Strength: " + getStrength());
        sb.append("     Magic: " + getMagic());

        Display.setTitle(sb.toString());
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
    }

    private void move(float magX, float magY) {
        x += getSpeed() * magX;
        y += getSpeed() * magY;
    }

    public float getSpeed(){
        return stats.getSpeed();
    }

    public float getXp(){
        return stats.getXp();
    }

    public int getLevel(){
        return stats.getLevel();
    }

    public int getMaxHealth(){
        return stats.getMaxHealth();
    }

    public int getCurrentHealth(){
        return stats.getCurrentHealth();
    }

    public float getStrength(){
        return stats.getStrength();
    }

    public float getMagic(){
        return stats.getMagic();
    }

    public void addXp(float amount){
        stats.addXp(amount);
    }

    public void addItem(Item item){
        inventory.add(item);
    }
}
