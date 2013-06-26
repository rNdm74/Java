package pemotegame;

/**
 * Created by
 * Adam Charlton
 */
public class Sleep{
    private Computer computer;

    public Sleep(Computer computer){
        this.computer = computer;
    }

    public boolean start(int waitTime, long trigger){
        long moveTime = System.currentTimeMillis() - trigger;
        //COMPUTER STOP
        computer.speedX = 0f;

        //COMPUTER START
        if (moveTime > waitTime) {
            computer.speedX = 1f;
            return true;
        }

        return false;
    }

    public long invoke(String text, long trigger, int max) {
        int rand = (int)(Math.random() * max);

        if(rand == Constants.MINIMUM) trigger = System.currentTimeMillis();

        if(trigger > 0) {
            computer.talk = text;
            if(start(Constants.WAIT_DELAY, trigger)){
                if((Math.random() * 10) == 0) computer.speedX *= Constants.DIRECTION;
                return 0;
            }
        }

        return trigger;
    }
}
