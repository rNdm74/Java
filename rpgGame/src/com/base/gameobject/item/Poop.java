package com.base.gameobject.item;

import com.base.gameobject.Player;

/**
 * Created by rNdm.
 */
public class Poop extends Item{
    public static final float SIZE = 8f;

    public Poop(float x, float y, Player player){
        super(player);
        init(x, y, 1.0f, 0.5f, 0.0f, SIZE, SIZE, "Poop");
    }
}
