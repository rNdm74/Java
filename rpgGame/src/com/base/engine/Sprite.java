package com.base.engine;

import static org.lwjgl.opengl.GL11.*;

/**
 * Created by rNdm on 7/5/13.
 */
public class Sprite {
    private float red;
    private float green;
    private float blue;

    private float sx;
    private float sy;

    public Sprite(float red, float green, float blue, float sx, float sy){
        this.red = red;
        this.green = green;
        this.blue = blue;
        this.setSx(sx);
        this.setSy(sy);
    }

    public void render() {
        glBegin(GL_QUADS);
        {
            glColor3f(red,green,blue);
            glVertex2f(0,0);
            glVertex2f(0, getSy());
            glVertex2f(getSx(), getSy());
            glVertex2f(getSx(), 0);
        }
        glEnd();
    }

    // GETS & SETS
    public float getSx() {
        return sx;
    }

    public void setSx(float sx) {
        this.sx = sx;
    }

    public float getSy() {
        return sy;
    }

    public void setSy(float sy) {
        this.sy = sy;
    }
}
