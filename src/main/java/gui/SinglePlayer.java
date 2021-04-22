package gui;

import animations.BallJumpAnimation;
import animations.GravityAnimation;
import config.SpriteConfig;
import utils.GuiUtils;
import javax.swing.*;
import java.awt.event.WindowEvent;
import java.awt.*;


public class SinglePlayer extends JFrame {
    private JPanel mainpanel;
    private JFrame PREVIOUS_FRAME;
    private JLabel ball;
    private Thread ballGravityAnimation;
    private Thread balljumpAnimation;
    private Thread CircleAnimation;


    public SinglePlayer(JFrame previousFrame) {
        super("MainMenu|Dashboard|SinglePlayer");
        this.PREVIOUS_FRAME = previousFrame;
        setContentPane(mainpanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        pack();
        setLocationRelativeTo(null);

         new ChangeColor(mainpanel);

         initAnimations();
         initSinglePlayerListeners();
         initCustomComponents();

    }


      private void initCustomComponents(){
          var width = SpriteConfig.BALL.getIconWidth();
          var height = SpriteConfig.BALL.getIconHeight();
       ball=new JLabel();
       ball.setIcon(SpriteConfig.BALL);
       ball.setSize(width,height);
       ball.setLocation(50,50);
          mainpanel.add(ball);
          mainpanel.setLayout(null);


}

    private void initAnimations(){
        balljumpAnimation = new BallJumpAnimation(ball ,);
        balljumpAnimation.start();
        ballGravityAnimation= new GravityAnimation(ball ,this::gameOver);
        ballGravityAnimation.start();


}

    private void initSinglePlayerListeners(){
    GuiUtils.addMouseReleasedListener(mainpanel, e ->{
        GravityAnimation.halt=true;
      new BallJumpAnimation(ball,() -> GravityAnimation.halt=false).start();
         }
            );
    }
    private void gameOver (){
        System.out.println( "gameover!");
        WindowEvent closingEvent = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(closingEvent);
    }
}
