package com.base.engine;

import com.base.constants.Constants;
import com.base.global.Global;
import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.SlickException;

/**
 * Created by rNdm.
 */
public class Main {
    public static AppGameContainer game;


    public static void main(String[] args){

        try{
            game = new AppGameContainer(new Game("SUPER BIRDIE POOP"));
            game.setDisplayMode(Global.WINDOW_WIDTH, Global.WINDOW_HEIGHT, false);
            game.start();
        }catch(SlickException e){}

        while(!Display.isCloseRequested()){
            Display.update();
        }
    }
}
