package gui;

import animations.BallJumpAnimation;
import animations.ColorChangeAnimation;
import animations.GravityAnimation;
import config.GuiConfig;
import config.SpriteConfig;
import utils.GuiUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.util.function.Consumer;

public class SinglePlayer extends JFrame {
    private JFrame PREVIOUS_FRAME;
    private JPanel mainPanel;
    private JLabel ballLabel;
    private JLabel circleLabel1;


    private Thread ballGravityAnimation;
    private Thread balljumpAnimation;
    private Thread CircleAnimation;

    public SinglePlayer(JFrame previousFrame) {
        super("MainMenu|Dashboard|SinglePlayer");

        this.PREVIOUS_FRAME = previousFrame;

        setContentPane(mainPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);

        pack();
        setLocationRelativeTo(null);


        initCustomComponent();
        initHedge();
        initSinglePlayerListeners();
        initAnimations();
        SwitchColors();

    }

    private void createUIComponents() {
        mainPanel=new JPanel();
        mainPanel.setLayout(null);
    }

    private void initCustomComponent() {
        ballLabel = new JLabel();
        ballLabel.setSize(20, 20);

        int x = ballLabel.getWidth();
        int y = ballLabel.getHeight();

        ballLabel.setIcon(SpriteConfig.createIcon(x, y, SpriteConfig.BALL_URL));
        ballLabel.setLocation(200, 50);

        mainPanel.add(ballLabel,"text2");
    }

    private void initHedge() {
        circleLabel1 = new JLabel();
        circleLabel1.setSize(50, 50);

        int x = circleLabel1.getWidth();
        int y = circleLabel1.getHeight();

        circleLabel1.setLocation(200,400);

        circleLabel1.setIcon(SpriteConfig.createIcon(x, y, SpriteConfig.CIRCLE_URL));
        mainPanel.add(circleLabel1,"tex1");
    }

    private void initAnimations() {

        balljumpAnimation = new BallJumpAnimation(ballLabel, () -> {
            System.out.println("this is the method"); });

        balljumpAnimation.start();

        ballGravityAnimation = new GravityAnimation(ballLabel, this::gameOver);
        ballGravityAnimation.start();

    }

    private void initSinglePlayerListeners() {
        GuiUtils.addMouseReleasedListener(mainPanel, e -> {
            GravityAnimation.halt = true;
            new BallJumpAnimation(ballLabel, () -> GravityAnimation.halt = false).start(); });
    }

    private void gameOver() {
        System.out.println("GameOver!");
        WindowEvent closingEvent = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(closingEvent);
    }


    private void SwitchColors() {
        switch (ChangeColor.SingleBackGroundColor) {
            case "Red":
                Consumer<Color> stepCallback = (color) -> mainPanel.setBackground(color);
                Runnable endCallback = () -> mainPanel.setBackground(GuiConfig.COLOR_RED);
                new ColorChangeAnimation(mainPanel.getBackground(), GuiConfig.COLOR_RED, stepCallback, endCallback).start();
                break;
            case "Blue":
                stepCallback = (color) -> mainPanel.setBackground(color);
                endCallback = () -> mainPanel.setBackground(GuiConfig.COLOR_BLUE);
                new ColorChangeAnimation(mainPanel.getBackground(), GuiConfig.COLOR_BLUE, stepCallback, endCallback).start();
                break;
            case "Pink":
                stepCallback = (color) -> mainPanel.setBackground(color);
                endCallback = () -> mainPanel.setBackground(GuiConfig.COLOR_PINK);
                new ColorChangeAnimation(mainPanel.getBackground(), GuiConfig.COLOR_PINK, stepCallback, endCallback).start();
                break;
            case "Purple":
                stepCallback = (color) -> mainPanel.setBackground(color);
                endCallback = () -> mainPanel.setBackground(GuiConfig.COLOR_PURPLE);
                new ColorChangeAnimation(mainPanel.getBackground(), GuiConfig.COLOR_PURPLE, stepCallback, endCallback).start();
                break;
            case "Green":
                stepCallback = (color) -> mainPanel.setBackground(color);
                endCallback = () -> mainPanel.setBackground(GuiConfig.COLOR_GREEN);
                new ColorChangeAnimation(mainPanel.getBackground(), GuiConfig.COLOR_GREEN, stepCallback, endCallback).start();
                break;
            case "DEFAULT":
                stepCallback = (color) -> mainPanel.setBackground(color);
                endCallback = () -> mainPanel.setBackground(GuiConfig.COLOR_DEFAULT);
                new ColorChangeAnimation(mainPanel.getBackground(), GuiConfig.COLOR_DEFAULT, stepCallback, endCallback).start();
                break;


        }
    }

}