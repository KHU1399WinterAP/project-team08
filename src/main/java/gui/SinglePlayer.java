package gui;

import animations.BallJumpAnimation;
import animations.GravityAnimation;
import config.SpriteConfig;
import utils.GuiUtils;
import javax.swing.*;



public class SinglePlayer extends JFrame {
    private JPanel mainpanel;
    private JFrame PREVIOUS_FRAME;
    private JLabel ball;

    private Thread ballGravityAnimation;

    public SinglePlayer(JFrame previousFrame) {
        super("MainMenu|Dashboard|SinglePlayer");
        this.PREVIOUS_FRAME = previousFrame;
        setContentPane(mainpanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        pack();
        setLocationRelativeTo(null);

         new ChangeColor(mainpanel);
         initCustomComponents();
         initAnimations();
         initSinglePlayerListeners();

    }

      private void initCustomComponents(){
       ball=new JLabel();
       ball.setIcon(SpriteConfig.BALL);
       ball.setSize(100,100);
       ball.setLocation(50,50);
          mainpanel.add(ball);
          mainpanel.setLayout(null);

}

    private void initAnimations(){
        ballGravityAnimation= new GravityAnimation(ball);
        ballGravityAnimation.start();


}

    private void initSinglePlayerListeners(){
    GuiUtils.addMouseReleasedListener(mainpanel, e ->{
        GravityAnimation.halt=true;
      new BallJumpAnimation(ball,() -> GravityAnimation.halt=false).start();
         }
            );
    }
}
