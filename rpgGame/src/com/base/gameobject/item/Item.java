package com.base.gameobject.item;

import com.base.engine.GameObject;
import com.base.engine.Physics;
import com.base.engine.Sprite;
import com.base.gameobject.Player;

/**
 * Created by rNdm.
 */
public class Item extends GameObject{
    protected String name;
    protected Player player;

    public Item(Player player){
        this.player = player;
    }

    public String getName(){
        return name;
    }

    public void pickUp(){
        System.out.println("You just picked up a " + name + "!");
        player.addItem(this);
        remove();
    }

    public void update(){
        if(Physics.checkCollision(this, player) != null) pickUp();
    }

    protected void init(float x, float y, float r,float g, float b, float sx, float sy, String name){
        this.x = x;
        this.y = y;
        this.type = ITEM_ID;
        this.sprite = new Sprite(r,g,b,sx,sy);
        this.name = name;
    }
}
