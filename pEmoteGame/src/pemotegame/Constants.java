package pemotegame;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by
 * Adam Charlton
 */
public final class Constants {
    public static final ArrayList<DisplayMode> AVAILABLE_RESOLUTIONS    = new ArrayList<>();

    private static final GraphicsDevice     GRAPHICS_DEVICE             = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();

    public static final int                 SCREEN_WIDTH                = GRAPHICS_DEVICE.getDisplayMode().getWidth();
    public static final int                 SCREEN_HEIGHT               = GRAPHICS_DEVICE.getDisplayMode().getHeight();

    public static final DisplayMode[]       DEFAULT_RESOLUTIONS         = GRAPHICS_DEVICE.getDisplayModes();

    public static final int                 DEFAULT_SCREEN_X_SIZE       = DEFAULT_RESOLUTIONS[0].getWidth();
    public static final int                 DEFAULT_SCREEN_Y_SIZE       = DEFAULT_RESOLUTIONS[0].getHeight();

    public static final int                 DEFAULT_CLIPPING_SIZE       = 200;
    public static final int                 DEFAULT_X_PADDING           = 20;
    public static final int                 DEFAULT_Y_PADDING           = 60;
    public static final int                 DEFAULT_FONT_SIZE           = 14;

    public static final int                 TIMER_INTERVAL              = 17;
    public static final int                 UPDATE_INTERVAL             = 17;

    public static final int                 GROUND_HEIGHT               = 100;

    public static final int                 POOP_DELAY                  = 1000;
    public static final int                 WAIT_DELAY                  = 2000;
    public static final int                 RANDOM_DELAY                = 2000;

    public static final float               DEFAULT_JUMPSPEED           = 5.8f;
    public static final int                 DIRECTION                   = -1;

    public static final int                 MAXIMUM                     = 2000;
    public static final int                 MINIMUM                     = 0;

    public static final int                 PLAYER_START_X              = DEFAULT_SCREEN_X_SIZE / 2;
    public static final int                 PLAYER_START_Y              = 50;
    public static final int                 PLAYER_WIDTH                = 50;
    public static final int                 PLAYER_HEIGHT               = 50;
    public static final float               PLAYER_SPEED                = 3f;

    public static final int                 COMPUTER_WIDTH              = 50;
    public static final int                 COMPUTER_HEIGHT             = 50;
    public static final float               COMPUTER_SPEED              = 1f;

    public static final int                 POOP_WIDTH                  = 5;
    public static final int                 POOP_HEIGHT                 = 5;



    public static final boolean             DEFAULT_VISIBILITY          = true;

}
