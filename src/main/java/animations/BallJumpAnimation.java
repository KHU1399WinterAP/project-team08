package animations;
import javax.swing.*;
public class BallJumpAnimation extends Thread {
    private final JLabel BALL_LABEL;
    private final int DURATION;
    private final int DISTANCE;
    private final int SLEEP = 10;
    private final Runnable END_CALLBACK;
    public BallJumpAnimation(JLabel ballLabel , int distance,int duration,Runnable endCallback) {
        this.BALL_LABEL = ballLabel;
        this.DURATION = duration;
        this.DISTANCE=distance;
        this.END_CALLBACK = endCallback;
    }

    public BallJumpAnimation(JLabel ballLabel, Runnable endCallback) {
        this(ballLabel,80,100,endCallback );
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
