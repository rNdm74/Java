package com.base.engine;

import com.base.constants.Constants;
import com.base.global.Global;
import com.base.menu.main.*;
import com.base.menu.main.Menu;
import com.base.menu.options.controls.Controls;
import com.base.menu.options.graphics.Graphics;
import com.base.menu.options.sound.Sound;
import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.*;
import org.lwjgl.opengl.DisplayMode;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import java.util.Arrays;
import java.util.Collections;

/**
 * Created by rNdm.
 */
public class Game extends StateBasedGame {
    public Game(String name) {
        super(name);

        this.addState(new Menu(Constants.MAIN_MENU));

        this.addState(new Start(Constants.MAIN_NEW_GAME));
        this.addState(new Load(Constants.MAIN_LOAD_GAME));
        this.addState(new Options(Constants.MAIN_OPTIONS));

        this.addState(new Controls(Constants.OPTIONS_CONTROLS));
        this.addState(new Graphics(Constants.OPTIONS_GRAPHICS));
        this.addState(new Sound(Constants.OPTIONS_SOUND));
    }

    @Override
    public void initStatesList(GameContainer gameContainer) throws SlickException {
        try {
            DisplayMode[] dm = Display.getAvailableDisplayModes();
            Arrays.sort(dm, new DisplayModeSort());
            Collections.addAll(Global.displayModes, dm);
            Global.resolution = Display.getDisplayMode().toString();
            System.out.println(Global.resolution);
            //for (DisplayMode d: dm) System.out.println(d);
            //Display.setDisplayMode(dm[2]);
        } catch (LWJGLException e) {}

        //System.out.println(Global.displayModes);

        this.getState(Constants.MAIN_MENU).init(gameContainer, this);

        this.getState(Constants.MAIN_NEW_GAME).init(gameContainer, this);
        this.getState(Constants.MAIN_LOAD_GAME).init(gameContainer, this);
        this.getState(Constants.MAIN_OPTIONS).init(gameContainer, this);

        this.getState(Constants.OPTIONS_CONTROLS).init(gameContainer, this);
        this.getState(Constants.OPTIONS_GRAPHICS).init(gameContainer, this);
        this.getState(Constants.OPTIONS_SOUND).init(gameContainer, this);

        this.enterState(Constants.MAIN_MENU);
    }
}
