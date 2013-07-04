import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.newdawn.slick.BasicGame;


public class Main {
    KeyHandler keyHandler;
    FrameHandler frameHandler;
    Render render;



    public void start(){
        try {
            Display.setDisplayMode(new DisplayMode(800,600));
            Display.create();
            keyHandler = new KeyHandler();
            render = new Render();
            frameHandler = new FrameHandler(render);

        } catch (LWJGLException e) {
            e.printStackTrace();
            System.exit(0);
        }

        // init OpenGL here
        render.initGL();
        frameHandler.getDelta();
        frameHandler.lastFPS = frameHandler.getTime();

        while (!Display.isCloseRequested()) {
        // render OpenGL here
            int delta = frameHandler.getDelta();
            frameHandler.update(delta);
            render.renderGL();
            //keyHandler.pollInput();
            Display.update();
            //Display.sync(60);
        }
        Display.destroy();
    }

    public static void main(String[] args){
        //Main displayExample = new Main();
        //displayExample.start();

        Slickgame slickgame = new Slickgame("RNDM");
        slickgame.start();
        

    }
}
