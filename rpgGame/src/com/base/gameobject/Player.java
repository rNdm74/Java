package com.base.gameobject;

import com.base.game.Time;
import com.base.gameobject.item.Item;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;

/**
 * Created by Adam Charlton.
 */
public class Player extends StatObject {
    public static final int SIZE = 32;

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
        x += getSpeed() * magX * Time.getDelta();
        y += getSpeed() * magY * Time.getDelta();
    }

    public void addXp(float amount){
        stats.addXp(amount);
    }

    public void addItem(Item item){
        inventory.add(item);
    }
}
