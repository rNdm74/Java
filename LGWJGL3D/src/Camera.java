
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.util.glu.GLU.*;
/**
 * Created by rNdm on 7/2/13.
 */
public class Camera {
    //Location
    private float x;
    private float y;
    private float z;

    //Rotation
    private float rx;
    private float ry;
    private float rz;

    //Field Of View
    private float fov;

    //Aspect Ratio
    private float aspect;

    //Near Clipping Plain
    private float near;

    //Far Clipping Plain
    private float far;

    public Camera(float fov, float aspect, float near, float far){
        x=0;
        y=0;
        z=0;
        rx=0;
        ry=0;
        rz=0;

        this.fov = fov;
        this.aspect = aspect;
        this.near = near;
        this.far = far;

        initProjection();
    }

    private void initProjection(){
        glMatrixMode(GL_PROJECTION);
        glLoadIdentity();
        gluPerspective(fov,aspect,far,near);
        glMatrixMode(GL_MODELVIEW);

        glEnable(GL_DEPTH_TEST);
    }

    public void useView(){
        glRotatef(rx, 1, 0, 0);
        glRotatef(ry, 0, 1, 0);
        glRotatef(rz, 0, 0, 1);
        glTranslatef(x,y,z);
    }

    public void rotateY(float amt){
        ry += amt;
    }
    public void move(float amt, float dir){
        z += amt * Math.sin(Math.toRadians(ry + 90 * dir));
        x += amt * Math.cos(Math.toRadians(ry + 90 * dir));
    }

    public void moveX(float amt){
        x += amt;
    }

    public void movey(float amt){
        y += amt;
    }

    //GETS SETS
    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getZ() {
        return z;
    }

    public void setZ(float z) {
        this.z = z;
    }

    public float getRx() {
        return rx;
    }

    public void setRx(float rx) {
        this.rx = rx;
    }

    public float getRy() {
        return ry;
    }

    public void setRy(float ry) {
        this.ry = ry;
    }

    public float getRz() {
        return rz;
    }

    public void setRz(float rz) {
        this.rz = rz;
    }
}
