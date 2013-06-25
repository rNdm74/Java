package pemotegame;

/**
 * Created by
 * Adam Charlton
 */
public class Sleep implements Runnable{
    boolean finished;
    long time = 0;
    Computer computer;

    public Sleep(Computer computer){
        this.computer = computer;
    }

    @Override
    public void run() {
        long sTime = System.nanoTime();
        while (!finished && time < 1000000){
            time++;
        }
        long tPassed = System.nanoTime() - sTime;
        System.out.println(tPassed);

        //finished = true;
        time = 0;
        computer.aBoolean = true;
    }
}
