package com.base.global;

import org.lwjgl.opengl.DisplayMode;

import java.util.ArrayList;

/**
 * Created by rNdm.
 */
public final class Global {
    public static ArrayList<Integer>        previousMenu                    = new ArrayList<>();
    public static ArrayList<DisplayMode>    displayModes                    = new ArrayList<>();


    public static boolean                   fullscreen                      = false;
    public static boolean                   vsync                           = false;
    public static boolean                   antialiasing                    = false;

    public static String                    resolution                      = "foo";



    //public static int                       WINDOW_WIDTH                    = 800;
    //public static int                       WINDOW_HEIGHT                   = 600;
}
