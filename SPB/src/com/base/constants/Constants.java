package com.base.constants;

import com.base.engine.Main;
import com.base.global.Global;
import org.lwjgl.opengl.Display;

import java.util.Locale;

/**
 * Created by rNdm.
 */
public final class Constants {
    public static final int                 WINDOW_WIDTH                    = 800;
    public static final int                 WINDOW_HEIGHT                   = 600;

    public static final int                 TITLE_X                         = 200;
    public static final int                 TITLE_Y                         = 200;

    public static final int                 MAIN_MENU                       = 0;

    public static final int                 MAIN_NEW_GAME                   = 1;
    public static final int                 MAIN_LOAD_GAME                  = 2;
    public static final int                 MAIN_OPTIONS                    = 3;


    public static final int                 OPTIONS_GRAPHICS                = 5;
    public static final int                 GRAPHICS_FULLSCREEN             = 51;
    public static final int                 GRAPHICS_VSYNC                  = 52;
    public static final int                 GRAPHICS_ANTIALIASING           = 53;
    public static final int                 GRAPHICS_RESOLUTION             = 54;

    public static final int                 OPTIONS_SOUND                   = 6;

    public static final int                 OPTIONS_CONTROLS                = 7;



    public static final int                 EXIT                            = 4;
    public static final int                 BACK                            = 8;



    public static final String[]            MAIN_ITEMS                      = {"EXIT",
                                                                               "OPTIONS",
                                                                               "LOAD GAME",
                                                                               "NEW GAME"
                                                                               };

    public static final int[]               MAIN_IDS                        = {EXIT,
                                                                               MAIN_OPTIONS,
                                                                               MAIN_LOAD_GAME,
                                                                               MAIN_NEW_GAME,
                                                                               };

    public static final String[]            OPTION_ITEMS                    = {"BACK",
                                                                               "GRAPHICS",
                                                                               "SOUND",
                                                                               "CONTROLS",
                                                                               };

    public static final int[]               OPTION_IDS                      = {BACK,
                                                                               OPTIONS_GRAPHICS,
                                                                               OPTIONS_SOUND,
                                                                               OPTIONS_CONTROLS,
                                                                               };

    public static final String[]            GRAPHICS_ITEMS                   = {"BACK",
                                                                                "WINDOWED",
                                                                                "V SYNC",
                                                                                "ANTI ALIASING",
                                                                                "RESOLUTION"
                                                                                };

    public static final int[]               GRAPHICS_IDS                     = {BACK,
                                                                                GRAPHICS_FULLSCREEN,
                                                                                GRAPHICS_VSYNC,
                                                                                GRAPHICS_ANTIALIASING,
                                                                                GRAPHICS_RESOLUTION
                                                                                };

    public static final String[]            SOUND_ITEMS                      = {"BACK",
                                                                                "MUSIC",
                                                                                "EFFECTS",
                                                                                "VOLUME"};

    public static final int[]               SOUND_IDS                        = {BACK,
                                                                                OPTIONS_GRAPHICS,
                                                                                OPTIONS_SOUND,
                                                                                OPTIONS_CONTROLS};

    public static final String[]            CONTROLS_ITEMS                   = {"BACK",
                                                                                "KEYBOARD / MOUSE",
                                                                                "CONTROLLER",
                                                                                "KEY BINDINGS"};

    public static final int[]               CONTROLS_IDS                     = {BACK,
                                                                                OPTIONS_GRAPHICS,
                                                                                OPTIONS_SOUND,
                                                                                OPTIONS_CONTROLS};

}
