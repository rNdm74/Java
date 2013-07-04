import org.lwjgl.Sys;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;

/**
 * Created by rNdm on 7/1/13.
 */
public class FrameHandler {
    public FrameHandler(Render render){
        this.render = render;
    }

    private Render render;


    /** time at last frame */
    public long lastFrame;

    /** frames per second */
    public int fps;
    /** last fps time */
    public long lastFPS;

    public void update(int delta) {
        // rotate quad
        render.rotation += 0.15f * delta;

        if (Keyboard.isKeyDown(Keyboard.KEY_LEFT)) render.x -= 0.35f * delta;
        if (Keyboard.isKeyDown(Keyboard.KEY_LEFT))System.out.println("left kwy");
        if (Keyboard.isKeyDown(Keyboard.KEY_RIGHT)) render.x += 0.35f * delta;


        if (Keyboard.isKeyDown(Keyboard.KEY_UP)) render.y -= 0.35f * delta;
        if (Keyboard.isKeyDown(Keyboard.KEY_DOWN)) render.y += 0.35f * delta;

        // keep quad on the screen
        if (render.x < 0) render.x = 0;
        if (render.x > 800) render.x = 800;
        if (render.y < 0) render.y = 0;
        if (render.y > 600) render.y = 600;

        updateFPS(); // update FPS Counter
    }

    /**
     * Calculate how many milliseconds have passed
     * since last frame.
     *
     * @return milliseconds passed since last frame
     */
    public int getDelta() {
        long time = getTime();
        int delta = (int) (time - lastFrame);
        lastFrame = time;

        return delta;
    }

    /**
     * Get the accurate system time
     *
     * @return The system time in milliseconds
     */
    public long getTime() {
        return (Sys.getTime() * 1000) / Sys.getTimerResolution();
    }

    /**
     * Calculate the FPS and set it in the title bar
     */
    public void updateFPS() {
        if (getTime() - lastFPS > 1000) {
            Display.setTitle("FPS: " + fps);
            fps = 0;
            lastFPS += 1000;
        }
        fps++;
    }

}
