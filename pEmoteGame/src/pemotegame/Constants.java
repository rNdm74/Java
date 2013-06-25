package pemotegame;

import java.awt.*;

/**
 * Created by
 * Adam Charlton
 */
public final class Constants {
    private static final GraphicsDevice     GRAPHICS_DEVICE             = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();

    public static final int                 SCREEN_WIDTH                = GRAPHICS_DEVICE.getDisplayMode().getWidth();
    public static final int                 SCREEN_HEIGHT               = GRAPHICS_DEVICE.getDisplayMode().getHeight();

    public static final int                 DEFAULT_SCREEN_X_SIZE       = 800;
    public static final int                 DEFAULT_SCREEN_Y_SIZE       = 600;
    public static final int                 DEFAULT_CLIPPING_SIZE       = 200;
    public static final int                 DEFAULT_X_PADDING           = 20;
    public static final int                 DEFAULT_Y_PADDING           = 60;
    public static final int                 DEFAULT_FONT_SIZE           = 14;

    public static final int                 TIMER_INTERVAL              = 10;
    public static final int                 UPDATE_INTERVAL             = 20;

    public static final int                 GROUND_HEIGHT               = 100;

    public static final int                 POOP_DELAY                  = 500;
    public static final int                 WAIT_DELAY                  = 2000;
    public static final int                 RANDOM_DELAY                = 2000;

    public static final int                 GRAVITY                     = 6;
    public static final int                 SPEED                       = 2;
    public static final int                 DIRECTION                   = -1;

    public static final int                 MAXIMUM                     = 1000;
    public static final int                 MINIMUM                     = 0;

    public static final int                 PEDESTRIAN_WIDTH            = 25;
    public static final int                 PEDESTRIAN_HEIGHT           = 50;
    public static final int                 POOP_WIDTH                  = 5;
    public static final int                 POOP_HEIGHT                 = 5;



    public static final boolean             DEFAULT_VISIBILITY          = true;

}
