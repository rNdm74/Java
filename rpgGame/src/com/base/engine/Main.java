package com.base.engine;

import com.base.game.Game;

import com.base.game.Time;
import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

import java.util.ArrayList;

import static org.lwjgl.opengl.GL11.*;

/**
 * Created by Adam Charlton.
 */
public class Main {
    public static void main(String[] args){
        initDisplay();
        initGL();
        initGame();
        gameLoop();
        cleanUp();
    }

    private static void initDisplay(){
        try {
            Display.setDisplayMode(new DisplayMode(800, 600));
            Display.create();
            Keyboard.create();
            Display.setVSyncEnabled(true);
        } catch (LWJGLException e) {
            e.printStackTrace();
        }
    }

    private static void initGL(){
        glMatrixMode(GL_PROJECTION);
        glLoadIdentity(); // clear matrix
        glOrtho(0, Display.getWidth(), 0 , Display.getHeight(), -1, 1);
        glMatrixMode(GL_MODELVIEW);
        glDisable(GL_DEPTH_TEST);

        glClearColor(0, 0, 0, 0); // Black
    }

    private static void initGame(){
        Game.game = new Game();
    }

    private static void gameLoop(){
        Time.init();

        while (!Display.isCloseRequested()){
            Time.update();
            getInput();
            update();
            render();
        }
    }

    private static void getInput(){
        Game.game.getInput();
    }

    private static void update(){
        Game.game.update();
    }

    private static void render(){
        glClear(GL_COLOR_BUFFER_BIT); // clear the screen
        glLoadIdentity(); // Reset matrix

        Game.game.render();

        Display.update();//Display to screen

        Display.sync(60); //Set frame rate
    }

    private static void cleanUp(){
        Display.destroy(); // Clean up display
        Keyboard.destroy(); // Clean up keyboard input
    }
}
