import org.lwjgl.opengl.Display;

import static org.lwjgl.opengl.GL11.*;

/**
 * Created by rNdm on 7/1/13.
 */
public class Draw {
    public static void rect(float x, float y, float width, float height){
        rect(x, y, width, height, 0);
    }

    private static void rect(float x, float y, float width, float height, float rot){


        glPushMatrix();
        {
            glTranslatef(x, y, 0);
            glRotatef(rot, 0, 0, 1);

            glBegin(GL_QUADS);
            {
                glVertex2f(0,0);
                glVertex2f(width,0);
                glVertex2f(width,height);
                glVertex2f(0,height);
            }
            glEnd();
        }
        glPopMatrix();


    }
}
