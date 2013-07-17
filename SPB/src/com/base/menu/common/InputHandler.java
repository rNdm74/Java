package com.base.menu.common;

import com.base.engine.Main;
import com.base.global.Global;
import com.base.constants.Constants;
import com.base.menu.MenuText;
import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.AMDDebugOutput;
import org.lwjgl.opengl.Display;
import org.newdawn.slick.*;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeOutTransition;

public class InputHandler {
    private MenuText[] menuText;

    private int selectedItem = 0;

    private int up = 0;
    private int down = 0;
    private int enter = 1;

    public InputHandler(MenuText[] menuText) {
        this.menuText = menuText;
    }

    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int delta) throws SlickException {
        moveSelectItemUp();
        moveSelectItemDown();
        resetSelectedItem();
        executeSelectedMenuItem(stateBasedGame);
        hoverSelectedItem(gameContainer);
        activeSelectedItem();
    }

    private void moveSelectItemUp() {
        if (Keyboard.isKeyDown(Input.KEY_UP)) {
            if (up <= 0) selectedItem++;
            up++;
        } else {
            up = 0;
        }
    }

    private void moveSelectItemDown() {
        if (Keyboard.isKeyDown(Input.KEY_DOWN)) {
            if (down <= 0) selectedItem--;
            down++;
        } else {
            down = 0;
        }
    }

    private void executeSelectedMenuItem(StateBasedGame stateBasedGame) {
        if (Keyboard.isKeyDown(Input.KEY_ENTER) || Mouse.isButtonDown(Input.MOUSE_LEFT_BUTTON)) {
            if (enter == 0){
                execute(menuText[selectedItem].getID(), stateBasedGame);
            }

            enter++;
        } else {
            enter = 0;
        }
    }

    private void execute(int id, StateBasedGame stateBasedGame) {
        switch (id) {
            case Constants.GRAPHICS_ANTIALIASING:
                Global.antialiasing = !Global.antialiasing;
                break;
            case Constants.GRAPHICS_RESOLUTION:
                ChangeResolution();
                break;
            case Constants.GRAPHICS_FULLSCREEN:
                Global.fullscreen = !Global.fullscreen;
                break;
            case Constants.GRAPHICS_VSYNC:
                Global.vsync = !Global.vsync;
                break;
            case Constants.EXIT:
                System.exit(0);
                break;
            case Constants.BACK:
                stateBasedGame.enterState(Global.previousMenu.get(Global.previousMenu.size() - 1));
                Global.previousMenu.remove(Global.previousMenu.size() - 1);
                break;
            default:
                Global.previousMenu.add(stateBasedGame.getCurrentStateID());
                stateBasedGame.enterState(menuText[selectedItem].getID());
                break;
        }
    }

    private void ChangeResolution() {}

    private void resetSelectedItem() {
        if(selectedItem < 0) selectedItem = menuText.length-1;
        selectedItem %= menuText.length;
    }

    private void hoverSelectedItem(GameContainer gc) {
        float x = Mouse.getX();
        float y = gc.getHeight() - Mouse.getY();

        for (int i = 0; i < menuText.length; i++)
            if (menuText[i].contains(x, y)) {
                if (selectedItem != i && !Keyboard.isKeyDown(Input.KEY_DOWN)) selectedItem = i;
                break;
            }
    }

    private void activeSelectedItem() {
        int i = 0;
        while (i < menuText.length) {
            menuText[i].setColor((i == selectedItem) ? Color.yellow : Color.white);
            i++;
        }
    }
}