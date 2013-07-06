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
    public boolean over(){
        if(!start) return false;

        return (Time.getTime() >= endTime);
    }

    public void start(){
        start = true;
        endTime = length * 1000000 + Time.getTime();
    }

    public void reset(){
        start = false;
    }

    public boolean active(){
        return start;
    }

    public void end(){
        start = true;
        endTime = 0;
    }
}
