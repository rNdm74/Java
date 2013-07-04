import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.util.glu.GLU.*;

/**
 * Created by rNdm on 7/2/13.
 */
public class Main {
    public static void main (String[] args){
        initDisplay();

        gameLoop();
    }

    public static void gameLoop(){
        float fov = 70f;
        float aspect = (float)Display.getWidth() / (float)Display.getHeight();
        float near = 0.3f;
        float far = 1000f;

        Camera cam = new Camera(fov, aspect, near, far);

        float x = 0;

        while(!Display.isCloseRequested()){
            if (Keyboard.isKeyDown(Keyboard.KEY_W) || Keyboard.isKeyDown(Keyboard.KEY_UP))
                cam.move(0.001f, 1);
            if (Keyboard.isKeyDown(Keyboard.KEY_S) || Keyboard.isKeyDown(Keyboard.KEY_DOWN))
                cam.move(-0.001f, 1);
            if (Keyboard.isKeyDown(Keyboard.KEY_A))
                cam.move(0.001f, 0);
            if (Keyboard.isKeyDown(Keyboard.KEY_D))
                cam.move(-0.001f, 0);

            if (Keyboard.isKeyDown(Keyboard.KEY_LEFT))cam.rotateY(0.01f);
            if (Keyboard.isKeyDown(Keyboard.KEY_RIGHT))cam.rotateY(-0.01f);

            glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
            glLoadIdentity();
            cam.useView();

            glPushMatrix();
            {
                glTranslatef(0, 0, -10f);
                glRotatef(x, 1,1,0);
                glBegin(GL_QUADS);
                {
                    //FrontFace
                    glColor3f(1.0f, 0f, 0f); //RED
                    glVertex3f(-1, -1, 1);
                    glVertex3f(1, -1, 1);
                    glVertex3f(1, 1, 1);
                    glVertex3f(-1, 1, 1);

                    //BackFace
                    glColor3f(1.0f, 1f, 0f);
                    glVertex3f(-1, -1, -1);
                    glVertex3f(-1, 1, -1);
                    glVertex3f(1, 1, -1);
                    glVertex3f(1, -1, -1);

                    //TopFace
                    glColor3f(0f, 1f, 0f); //GREEN
                    glVertex3f(1, -1, -1);
                    glVertex3f(1, -1, 1);
                    glVertex3f(1, 1, 1);
                    glVertex3f(1, 1, -1);

                    //BottomFace
                    glColor3f(0f, 0f, 1f); //BLUE
                    glVertex3f(-1, -1, -1);
                    glVertex3f(-1, -1, 1);
                    glVertex3f(-1, 1, 1);
                    glVertex3f(-1, 1, -1);



                    //LeftFace
                    glColor3f(0f, 1f, 1f);

                    glVertex3f(-1, -1, -1);
                    glVertex3f(1, -1, -1);
                    glVertex3f(1, -1, 1);
                    glVertex3f(-1, -1, 1);

                    //RightFace
                    glColor3f(1f, 0f, 1f);

                    glVertex3f(-1, 1, -1);
                    glVertex3f(1, 1, -1);
                    glVertex3f(1, 1, 1);
                    glVertex3f(-1, 1, 1);
                }
                glEnd();
            }
            glPopMatrix();

            x+=0.01f;

            Display.update();


        }
    }

    public static void cleanUp(){
        Display.destroy();
    }


    public static void initDisplay(){
        try {
            Display.setDisplayMode(new DisplayMode(800,600));
            Display.create();
        } catch (LWJGLException e) {
            e.printStackTrace();
        }
    }
}
