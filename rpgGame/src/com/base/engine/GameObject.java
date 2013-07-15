package com.base.engine;

import com.base.game.Game;

import static org.lwjgl.opengl.GL11.*;

/**
 * Created by rNdm on 7/5/13.
 */
public abstract class GameObject {
    public static final int DEFAULT_ID = 0;
    public static final int ITEM_ID = 1;
    public static final int PLAYER_ID = 2;
    public static final int ENEMY_ID = 3;

    protected float x;
    protected float y;

    protected int type;
    protected Sprite sprite;

    //Flag
    protected boolean[] flags = new boolean[2];

    public void update(){}

    public void render(){
        glPushMatrix(); //creates objects own matrix
        {
            glTranslatef(x,y,0);
            sprite.render();
        }
        glPopMatrix(); // return to primary model view matrix
    }

    //GETS & SETS
    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getSx() {
        return sprite.getSx();
    }

    public float getSy() {
        return sprite.getSy();
    }

    public int getType(){
        return type;
    }

    public boolean isRemove(){
        return flags[0];
    }

    public boolean isSolid(){
        return flags[1];
    }

    public void remove(){
        flags[0] = true;
    }

    public void setSolid(boolean value){
        flags[1] = value;
    }

    protected void init(float x, float y, float r,float g, float b, float sx, float sy, int type){
        this.x = x;
        this.y = y;
        this.type = type;
        this.sprite = new Sprite(r,g,b,sx,sy);
    }
}
