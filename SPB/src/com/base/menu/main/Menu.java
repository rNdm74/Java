package com.base.menu.main;

import com.base.constants.Constants;
import com.base.menu.InputHandler;
import com.base.menu.MenuText;
import org.lwjgl.input.Mouse;
import org.newdawn.slick.Color;
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
        graphics.setAntiAlias(false);
        for(MenuText font: menuText) font.render();

        graphics.setColor(Color.red);
        graphics.fillRect(Mouse.getX() - 2, gameContainer.getHeight() - Mouse.getY() - 2, 5, 5);
    }

    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int delta) throws SlickException {
        inputHandler.update(gameContainer, stateBasedGame, delta);
    }
}
