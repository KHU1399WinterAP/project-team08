//package animations;
//
//import javax.swing.*;
//
//public class CircleAnimation extends Thread{
//    private final int SLEEP = 10;
//    private final JPanel PANEL;
//    private final int INTERVAL;
//    private final int SPEED;
//
//    public CircleAnimation(JPanel panel, int interval, int speed) {
//        this.PANEL = panel;
//        this.INTERVAL = interval;
//        this.SPEED = speed;
//
//    }
//    public CircleAnimation(JPanel panel, JLabel ballLabel, Runnable gameOverCallback) {
//        this(panel, 1800, 2);
//    }
//    @Override
//    public void run() {
//        try {
//            while (true) {
//
//                sleep(INTERVAL);
//            }
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }
//}
//
//

