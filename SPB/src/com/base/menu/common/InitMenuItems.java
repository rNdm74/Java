package com.base.menu.common;

import org.newdawn.slick.GameContainer;

public class InitMenuItems {
    private final GameContainer gameContainer;
    private final MenuText[] menuText;
    private final String[] items;
    private final int[] ids;

    public InitMenuItems(GameContainer gameContainer, MenuText[] menuText, String[] items, int[] ids) {
        this.gameContainer = gameContainer;
        this.menuText = menuText;
        this.items = items;
        this.ids = ids;

        init();
    }

    private void init(){
        float aspectRatio = 1f / ((float) gameContainer.getWidth() / (float) gameContainer.getHeight());
        float fontSize = (100f / (float) gameContainer.getHeight())*100f;

        float startY = (float) gameContainer.getHeight() -100;

        for (int i = 0; i < menuText.length; i++) {
            menuText[i] = new MenuText(items[i], 50, startY - ((fontSize * 2) * i), fontSize, ids[i]);
        }
    }
}