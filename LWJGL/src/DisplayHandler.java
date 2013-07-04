import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.*;

import java.awt.*;
import java.awt.DisplayMode;

import static org.lwjgl.opengl.Display.*;

/**
 * Created by rNdm on 7/1/13.
 */
public class DisplayHandler {

    public void setDisplayMode(int width, int height, boolean fullscreen) {

        // return if requested DisplayMode is already set
        if ((getDisplayMode().getWidth() == width) &&
                (getDisplayMode().getHeight() == height) &&
                (isFullscreen() == fullscreen)) {
            return;
        }

        try {
            DisplayMode targetDisplayMode = null;

            if (fullscreen) {
                org.lwjgl.opengl.DisplayMode[] modes = Display.getAvailableDisplayModes();
                int freq = 0;

                for (int i=0;i<modes.length;i++) {
                    org.lwjgl.opengl.DisplayMode current = modes[i];

                    if ((current.getWidth() == width) && (current.getHeight() == height)) {
                        if ((targetDisplayMode == null) || (current.getFrequency() >= freq)) {
//                            if ((targetDisplayMode == null) || (current.getBitsPerPixel() > targetDisplayMode.getBitsPerPixel())) {
//                                targetDisplayMode = current;
//                                freq = targetDisplayMode.getFrequency();
//                            }
                        }

                        // if we've found a match for bpp and frequence against the
                        // original display mode then it's probably best to go for this one
                        // since it's most likely compatible with the monitor
                        if ((current.getBitsPerPixel() == getDesktopDisplayMode().getBitsPerPixel()) &&
                                (current.getFrequency() == getDesktopDisplayMode().getFrequency())) {
                            //targetDisplayMode = current;
                            break;
                        }
                    }
                }
            } else {
                //targetDisplayMode = new DisplayMode(width,height);
            }

            if (targetDisplayMode == null) {
                System.out.println("Failed to find value mode: "+width+"x"+height+" fs="+fullscreen);
                return;
            }

            //Display.setDisplayMode(targetDisplayMode);
            setFullscreen(fullscreen);

        } catch (LWJGLException e) {
            System.out.println("Unable to setup mode "+width+"x"+height+" fullscreen="+fullscreen + e);
        } //catch (LWJGLException e) {
            //e.printStackTrace();
        //}
    }

}
