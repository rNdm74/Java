package com.base.gameobject;

import com.base.gameobject.item.Item;

/**
 * Created by rNdm.
 */
public class Stats {
    public static final double LEVEL_CONST = 25.0 * Math.pow(3.0, 3.0/2.0);

    private int level;
    private float xp;
    private int health;
    private boolean levelable;

    public Stats(float xp, boolean levelable){
        this.levelable = levelable;

        if(levelable){
            this.xp = xp;
            this.level = 1;
        }
        else{
            this.xp = -1;
            this.level = (int)xp;
        }

        health = getMaxHealth();
    }

    public float getSpeed(){
        return 4f;
    }

    public float getXp(){
        return xp;
    }

    public int getLevel(){
        if (!levelable) return level;

        double x = xp + 105.0;
        double a = Math.sqrt(243.0 * ( x * x) + 4040.0 * x + 17500.0);
        double c = (3.0 * x + 25.0) / 25.0;
        double d = Math.cbrt(a / LEVEL_CONST + c);

        return (int)(d - 1.0/d * 3.0) - 1;
    }

    public int getMaxHealth(){
        return getLevel() * 10;
    }

    public int getCurrentHealth(){
        int max  = getMaxHealth();
        if (health > max)health = max;
        return health;
    }

    public float getStrength(){
        return getLevel() * 4f;
    }

    public float getMagic(){
        return getLevel() * 4f;
    }

    public void addXp(float amount){
        xp += amount;
    }

    public void addItem(Item item){
        //addXp(120);
        //Adding to inventory
    }
    public void damage(int amt){
        health -= amt;
    }
}
