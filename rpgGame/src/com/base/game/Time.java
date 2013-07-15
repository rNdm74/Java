package com.base.game;

/**
 * Created by rNdm.
 */
public class Time {
    public static final float DAMPING = 18000000f;

    private static long currentTime;
    private static long lastTime;

    public static long getTime(){
        return System.nanoTime();
    }

    public static float getDelta(){ // Time between frames
        return (currentTime - lastTime) / DAMPING;
    }

    public static void update(){
        lastTime = currentTime;
        currentTime = getTime();
    }
    public static void init(){
        lastTime = getTime();
        currentTime = getTime();
    }
}
