package com.base.gameobject;

/**
 * Created by rNdm.
 */
public class Birdie extends Enemy{
    public static final int SIZE = 32;

    public Birdie(float x, float y, int level) {
        super(level);

        init(x, y, 0.2f, 0.2f, 1f, SIZE, SIZE, 3);

        setAttackDelay(1500);
    }
}
