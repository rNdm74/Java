package com.base.engine;

import java.util.ArrayList;

/**
 * Created by Adam Charlton on 7/5/13.
 */
public class Animation {
    private ArrayList<Frame> frames;
    private int currentFrame;

    public Animation(){
        frames = new ArrayList<>();
    }

    public void render(){
        Frame temp = frames.get(currentFrame);

        if(temp.render()) {
            currentFrame++;
            currentFrame %= frames.size(); // return to zero
        }
    }
}
