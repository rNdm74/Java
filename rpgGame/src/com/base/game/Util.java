package com.base.game;

import com.base.engine.GameObject;

/**
 * Created by rNdm.
 */
public class Util {
    public static boolean LineOfSight(GameObject o1, GameObject o2){
        return true;
    }

    public static float dist(float x1, float y1, float x2, float y2){
        float x = x2 - x1;
        float y = y2 - y1;

        return (float)Math.sqrt((x*x) + (y*y));
    }
}
