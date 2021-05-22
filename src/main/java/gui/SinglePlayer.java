package gui;
import animations.BallJumpAnimation;
import animations.ColorChangeAnimation;
import animations.GravityAnimation;
import config.GuiConfig;
import config.SpriteConfig;
import utils.GuiUtils;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.*;
import java.util.function.Consumer;
public class SinglePlayer extends javax.swing.JFrame {
    private JFrame PREVIOUS_FRAME;
    private JPanel mainpanel;
    private JLabel ball;
    private JButton backButton;
    private Thread ballGravityAnimation;
    private Thread balljumpAnimation;
    private Thread CircleAnimation;

    public SinglePlayer(JFrame previousFrame) {
        super("MainMenu|Dashboard|SinglePlayer");
        this.PREVIOUS_FRAME = previousFrame;
        setContentPane(mainpanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
        initAnimations();
        initSinglePlayerListeners();


     switch (ChangeColor.SingleBackGroundColor) {
        case "Red":
            Consumer<Color> stepCallback = (color) -> mainpanel.setBackground(color);
            Runnable endCallback = () -> mainpanel.setBackground(GuiConfig.COLOR_RED);
            new ColorChangeAnimation(mainpanel.getBackground(), GuiConfig.COLOR_RED, stepCallback, endCallback).start();
            break;
        case "Blue":
            stepCallback = (color) -> mainpanel.setBackground(color);
            endCallback = () -> mainpanel.setBackground(GuiConfig.COLOR_BLUE);
            new ColorChangeAnimation(mainpanel.getBackground(), GuiConfig.COLOR_BLUE, stepCallback, endCallback).start();
            break;
        case "Pink":
            stepCallback = (color) -> mainpanel.setBackground(color);
            endCallback = () -> mainpanel.setBackground(GuiConfig.COLOR_PINK);
            new ColorChangeAnimation(mainpanel.getBackground(), GuiConfig.COLOR_PINK, stepCallback, endCallback).start();
            break;
        case "Purple":
            stepCallback = (color) -> mainpanel.setBackground(color);
            endCallback = () -> mainpanel.setBackground(GuiConfig.COLOR_PURPLE);
            new ColorChangeAnimation(mainpanel.getBackground(), GuiConfig.COLOR_PURPLE, stepCallback, endCallback).start();
            break;
        case "Green":
            stepCallback = (color) -> mainpanel.setBackground(color);
            endCallback = () -> mainpanel.setBackground(GuiConfig.COLOR_GREEN);
            new ColorChangeAnimation(mainpanel.getBackground(), GuiConfig.COLOR_GREEN, stepCallback, endCallback).start();
            break;
    }
}

    private void initAnimations() {
        balljumpAnimation = new BallJumpAnimation(ball, () -> { System.out.println("this is a method"); });
        balljumpAnimation.start();
      ballGravityAnimation = new GravityAnimation(ball);
               //, this::gameOver);
       ballGravityAnimation.start();
    }
    private void initSinglePlayerListeners() {
        GuiUtils.addMouseReleasedListener(mainpanel, e -> {
            GravityAnimation.halt = true;
            new BallJumpAnimation(ball, () -> GravityAnimation.halt= false).start();
        });
    }

    private void gameOver() {
        System.out.println("gameover!");
        WindowEvent closingEvent = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(closingEvent);
    }



}