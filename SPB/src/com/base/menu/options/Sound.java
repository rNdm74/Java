package com.base.menu.options;

import com.base.constants.Constants;
import com.base.menu.InputHandler;
import com.base.menu.MenuText;
import com.base.menu.main.InitMenuItems;
import org.newdawn.slick.*;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.GameState;
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
        for(MenuText font: menuText) font.render();
    }

    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int delta) throws SlickException {
        inputHandler.update(gameContainer, stateBasedGame, delta);
    }
}
