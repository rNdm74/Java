package com.base.engine;

/**
 * Created by rNdm on 7/5/13.
 */
public class Frame {
    private int length;
    private Sprite sprite;
    private int numDisplayed;

    public Frame(Sprite sprite, int length){
        this.length = length;
        this.sprite = sprite;
        numDisplayed = 0;
    }

    public boolean render() {
        sprite.render();

        numDisplayed++;

        if(numDisplayed >= length){
            numDisplayed = 0;
            return true;
        }

        return false;
    }
}
