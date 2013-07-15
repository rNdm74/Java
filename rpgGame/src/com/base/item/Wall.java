package com.base.item;

/**
 * Created by rNdm.
 */
public class Wall extends Item {
    public Wall(float x, float y, float sizeX, float sizeY){
        init(x, y, 1f, 1f, 1f, sizeX, sizeY, DEFAULT_ID);
        setSolid(true);
    }
}
