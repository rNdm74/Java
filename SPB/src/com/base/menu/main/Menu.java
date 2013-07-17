package com.base.menu.main;

import com.base.constants.Constants;
import com.base.menu.common.InitMenuItems;
import com.base.menu.common.InputHandler;
import com.base.menu.common.MenuText;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

/**
 * Created by Adam Charlton.
 */
public class Menu extends BasicGameState {
    private InputHandler inputHandler;
    private MenuText[] menuText;
    private String[] items;
    private int[] ids;

    public Menu(int state) {
        items = Constants.MAIN_ITEMS;
        ids = Constants.MAIN_IDS;
        menuText = new MenuText[items.length];
    }

    @Override
    public int getID() {
        return Constants.MAIN_MENU;
    }

    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {
        new InitMenuItems(gameContainer, menuText, items, ids);
        inputHandler = new InputHandler(menuText);
    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, org.newdawn.slick.Graphics graphics) throws SlickException {
        for(MenuText font: menuText) font.render(graphics);
    }

    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int delta) throws SlickException {
        inputHandler.update(gameContainer, stateBasedGame, delta);
    }
}
