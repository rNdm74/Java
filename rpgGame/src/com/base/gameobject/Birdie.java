package com.base.gameobject;

/**
 * Created by rNdm.
 */
public class Birdie extends Enemy{
    public static final int SIZE = 32;

    public Birdie(int level, float x, float y) {
        super(level);

        init(x, y, 0.2f, 0.2f, 1f, SIZE, SIZE, 0);

        setAttackDelay(200);
    }
}
