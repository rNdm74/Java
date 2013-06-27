package pemotegame;

import java.awt.*;
import java.util.Comparator;

/**
 * Created by
 * Adam Charlton
 */
public class ResCompare implements Comparator<DisplayMode> {
    @Override
    public int compare(DisplayMode displayMode, DisplayMode displayMode2) {
        return ((displayMode != null) && (displayMode2 != null)) ? displayMode.getWidth() - displayMode2.getWidth() : 0;
    }
}
