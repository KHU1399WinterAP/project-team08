package animations;
import javax.swing.*;
public class BallJumpAnimation extends Thread {
    private final JLabel BALL_LABEL;
    private final int DURATION;
    private final int DISTANCE;
    private final int SLEEP = 10;
    private final Runnable END_CALLBACK;
    public BallJumpAnimation(JLabel ballLabel , int distance,int duration,Runnable endcallback) {
        this.BALL_LABEL = ballLabel;
        this.DURATION = duration;
        this.DISTANCE=distance;
        this.END_CALLBACK = endcallback;
    }
    public BallJumpAnimation(JLabel ballLabel, Runnable endcallback) {
        this(ballLabel,80,100, endcallback);
    }
    @Override
    public void run() {
        var deltay= (DISTANCE *SLEEP *1.0)/DURATION;
        try {
            for(int i=1; i<=DURATION/SLEEP;i++){

                BALL_LABEL.setLocation(BALL_LABEL.getX(),(int) (BALL_LABEL.getY()-deltay));


                sleep(SLEEP);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        END_CALLBACK.run();
    }
}
