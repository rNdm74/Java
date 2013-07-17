package com.base.menu.options.graphics;

import com.base.global.Global;
import com.base.constants.Constants;
import com.base.menu.common.InputHandler;
import com.base.menu.common.MenuText;
import com.base.menu.common.InitMenuItems;
import org.lwjgl.opengl.Display;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

/**
 * Created by rNdm.
 */
public class Graphics extends BasicGameState {
    private InitMenuItems initMenuItems;
    private InputHandler inputHandler;
    private MenuText[] menuText;
    private MenuText[] menuTextOptions;
    private String[] items;
    private int[] ids;

    public Graphics(int state) {
        items = Constants.GRAPHICS_ITEMS;
        ids = Constants.GRAPHICS_IDS;

        menuText = new MenuText[items.length];
        menuTextOptions = new MenuText[items.length];
    }

    @Override
    public int getID() {
        return Constants.OPTIONS_GRAPHICS;
    }

    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {
        initMenuItems = new InitMenuItems(gameContainer, menuText, items, ids);
        inputHandler = new InputHandler(menuText);
    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, org.newdawn.slick.Graphics graphics) throws SlickException {
        for(MenuText font: menuText) font.render(graphics);
    }

    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int delta) throws SlickException {
        inputHandler.update(gameContainer, stateBasedGame, delta);

        gameContainer.setVSync(Global.vsync);
        gameContainer.setFullscreen(Global.fullscreen);
    }

    public void updateText(GameContainer gameContainer) {
        Global.resolution = Display.getDisplayMode().toString();
        items = Constants.GRAPHICS_ITEMS;
        initMenuItems = new InitMenuItems(gameContainer, menuText, items, ids);
        inputHandler = new InputHandler(menuText);
    }
}
