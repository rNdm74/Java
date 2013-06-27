package pemotegame;

/**
 * Created by
 * Adam Charlton
 */
public class Sleep{
    private Bird bird;

    public Sleep(Bird bird){
        this.bird = bird;
    }

    public boolean start(int waitTime, long trigger){
        long moveTime = System.currentTimeMillis() - trigger;
        //COMPUTER STOP
        bird.speed.x = 0f;

        //COMPUTER START
        if (moveTime > waitTime) {
            bird.speed.x = 1f;
            bird.talk = "";
            return true;
        }

        return false;
    }

    public long invoke(String text, long trigger, int max) {
        int rand = (int)(Math.random() * max);

        if(rand == Constants.MINIMUM) trigger = System.currentTimeMillis();

        if(trigger > 0) {
            bird.talk = text;
            if(start(Constants.WAIT_DELAY, trigger)){
                if((Math.random() * 10) == 0) bird.speed.x *= Constants.DIRECTION;
                return 0;
            }
        }

        return trigger;
    }
}
