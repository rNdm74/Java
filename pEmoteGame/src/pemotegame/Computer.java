
package pemotegame;

import java.awt.*;
import java.util.ArrayList;


class Computer {
    public float speedX = Constants.COMPUTER_SPEED;
    public float speedY = 0;
    
    public boolean playerInBounds;
    
    //private final ArrayList<Boolean> hitPoop;

    public boolean crap;

    private long directionTrigger;
    private long waitTrigger;
    private long poopTrigger;

    protected String talk = "";

//    public Computer(Rectangle rect, Game game) {
//        //super(rect, game);
//        hitPoop = new ArrayList<>();
//    }
    
    public synchronized void draw(Graphics2D g){
        //BOUNDS
//        if(game.showBounds){
//            g.setColor(Color.CYAN.darker());
//            if(playerInBounds)g.setColor(Color.PINK.darker());
//            g.draw(clip);
//        }

        //CLIPPING
        g.setColor(Color.GREEN.darker());
        //g.draw(clipping);

        //TALK
        //if(!talk.isEmpty()) new SpeechBubble(clipping, talk, g, center);
    }

    public void update(Player p, ArrayList<Poop> poops){
        talk = "";
        updateBounds();
        computerWait();
        computerClippingCheck(poops);
        computerBoundsCheck(p);
        randomizeDirection();
        changeDirection();
        groundPoop();
        poopCheck();
        move();
    }

    private synchronized void updateBounds() {
//        clip.setFrame(
//                clipping.getCenterX() - (Constants.DEFAULT_CLIPPING_SIZE/2),
//                1,
//                Constants.DEFAULT_CLIPPING_SIZE,
//                game.getHeight() - game.ground-2);
    }

    public synchronized void changeDirection() {
//        if (clipping.getX() < 10) {
//            speedX *= speedX;
//        }else if ((clipping.getX() + Constants.COMPUTER_WIDTH) > game.getBounds().width - 10) {
//            speedX *= -speedX;
//        }
    }

    private synchronized void computerClippingCheck(ArrayList<Poop> poops) {
        //hitPoop.clear();
        //for (Poop poop: poops) hitPoop.add(clipping.contains(poop.center));
    }
    
    
    
    private synchronized void computerBoundsCheck(Player p) {
//        if(clip.contains(p.center)){
//            playerInBounds = true;
//            talk = "I'M GONNA POOP ON YOU!";
//        }
//        else{
//            playerInBounds = false;
//        }
    }



    private synchronized void poopCheck(){
        //for (Poop poop: poops) if (top.intersects(poop.clipping)) poopTrigger = System.currentTimeMillis();

        if (poopTrigger > 0) {
            talk ="OH CRAP!";
//            if(new Sleep(this).start(Constants.POOP_DELAY, poopTrigger)){
//                poopTrigger = 0;
//                crap = true;
//            }
        }
    }
    
    private synchronized void randomizeDirection() {
        //directionTrigger = new Sleep(this).invoke("THERE IS A BIG ONE BREWING!", directionTrigger, Constants.MAXIMUM);
    }

    private synchronized void computerWait(){
        //waitTrigger = new Sleep(this).invoke("WHO CAN I POOP ON TODAY!", waitTrigger, Constants.MAXIMUM);
    }


    public synchronized void move() {
        //x += speedX;
        //y += speedY;
    }

    private synchronized void groundPoop() {
        //for(boolean hp: hitPoop) if(hp)talk = "THERE IS POOP ON THE GROUND!";
    }
}
