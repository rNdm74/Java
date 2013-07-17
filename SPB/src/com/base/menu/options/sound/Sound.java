package com.base.menu.options.sound;

import com.base.constants.Constants;
import com.base.menu.common.InputHandler;
import com.base.menu.common.MenuText;
import com.base.menu.common.InitMenuItems;
import org.newdawn.slick.*;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

/**
 * Created by rNdm.
 */
public class Sound extends BasicGameState {
    private InputHandler inputHandler;
    private MenuText[] menuText;
    private String[] items;
    private int[] ids;

    public Sound(int state) {
        items = Constants.SOUND_ITEMS;
        ids = Constants.SOUND_IDS;
        menuText = new MenuText[items.length];
    }

    @Override
    public int getID() {
        return Constants.OPTIONS_SOUND;
    }

    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {
        new InitMenuItems(gameContainer, menuText, items, ids);
        inputHandler = new InputHandler(menuText);
    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {
        for(MenuText font: menuText) font.render(graphics);
    }

    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int delta) throws SlickException {
        inputHandler.update(gameContainer, stateBasedGame, delta);
    }
}
