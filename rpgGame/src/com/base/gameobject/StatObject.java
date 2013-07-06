package com.base.gameobject;

import com.base.engine.GameObject;

/**
 * Created by rNdm.
 */
public class StatObject extends GameObject {
    protected Stats stats;

    public void damage(int amt){
        stats.damage(amt);
    }

    public StatObject(){

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
}
