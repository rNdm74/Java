package com.base.menu;

import org.newdawn.slick.Color;
import org.newdawn.slick.UnicodeFont;
import org.newdawn.slick.font.effects.ColorEffect;
import org.newdawn.slick.font.effects.ShadowEffect;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.util.ResourceLoader;

import java.awt.*;
import java.io.InputStream;

/**
 * Created by rNdm.
 */
public class MenuText {
    private UnicodeFont font;

    private String text;

    private float x;
    private float y;
    private float fontSize;

    private Color color;

    private int id;

    public MenuText(String text, float x, float y, float fontSize, int id){
        this.text = text;
        this.x = x;
        this.y = y;
        this.setFontSize(fontSize);
        this.color = Color.white;

        this.id = id;

        init();
    }

    public void init() {
        // load font from a .ttf file
        try {
            InputStream inputStream	= ResourceLoader.getResourceAsStream("res/" + "GeekAByte" + ".ttf");
            Font awtFont = Font.createFont(Font.TRUETYPE_FONT, inputStream);
            awtFont = awtFont.deriveFont(getFontSize()); // set font size
            font = new UnicodeFont(awtFont);
            font.getEffects().add(new ShadowEffect(java.awt.Color.lightGray, 2 , 2, 0.7f));
            font.getEffects().add(new ColorEffect(java.awt.Color.white));
            font.addAsciiGlyphs();
            font.loadGlyphs();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void render() {
        font.drawString(getX(), getY(), getText(), getColor());
    }

    public Rectangle getBounds(){
        return new Rectangle(getX(), getY(), font.getWidth(getText()), font.getHeight(getText()));
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getID() {
        return id;
    }

    public float getFontSize() {
        return fontSize;
    }

    public void setFontSize(float fontSize) {
        this.fontSize = fontSize;
    }

    public String getText() {
        return text;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }
}
