package com.base.engine;

import org.lwjgl.opengl.DisplayMode;

import java.util.Comparator;

/**
* Created by rNdm.
*/
public class DisplayModeSort implements Comparator {
    @Override
    public int compare(Object o, Object o2) {
        return ((DisplayMode)o).getWidth() - ((DisplayMode)o2).getWidth();
    }
}
