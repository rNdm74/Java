package com.base.engine;

import org.lwjgl.opengl.DisplayMode;

import java.util.Comparator;

/**
 * Created with IntelliJ IDEA.
 * User: rndm
 * Date: 16/07/13
 * Time: 9:23 PM
 * To change this template use File | Settings | File Templates.
 */
public class DisplayModeSort implements Comparator {

    @Override
    public int compare(Object o, Object o2) {
        return ((DisplayMode)o).getWidth() - ((DisplayMode)o2).getWidth();
    }
}
