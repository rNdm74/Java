package com.base.game;

/**
 * Created by rNdm.
 */
public class Delay {
    private int length;
    private long endTime;
    private boolean start;

    public Delay(int length){
        this.length = length;
        start = false;
    }

    public boolean isActive(){
        return start;
    }

    public boolean isOver(){
        if(!start) return false;

        return (Time.getTime() >= endTime);
    }

    public void restart(){
        start = true;
        endTime = length * 1000000 + Time.getTime();
    }

    public void stop(){
        start = false;
    }

    public void terminate(){
        start = true;
        endTime = 0;
    }
}
