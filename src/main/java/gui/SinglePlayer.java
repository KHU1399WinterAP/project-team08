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
        initAnimations();

        SwitchColors();
    }

    private void initCustomComponent() {
        ballLabel = new JLabel();
        ballLabel.setSize(20,20);

        int x=ballLabel.getWidth();
        int y=ballLabel.getHeight();

        ballLabel.setIcon(SpriteConfig.createIcon(x,y));
        ballLabel.setLocation(200, 100);

        mainPanel.add(ballLabel);
    }

    private void initAnimations() {

        ballGravityAnimation = new GravityAnimation(ballLabel);
        ballGravityAnimation.start();
    }

    private void initSinglePlayerListeners() {
        GuiUtils.addMouseReleasedListener(mainPanel, e -> {
            GravityAnimation.halt = true;
            new BallJumpAnimation(ballLabel, () -> GravityAnimation.halt = false).start();
        });
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
            default:
                stepCallback = (color) -> mainPanel.setBackground(color);
                endCallback = () -> mainPanel.setBackground(GuiConfig.Default);
                new ColorChangeAnimation(mainPanel.getBackground(), GuiConfig.Default, stepCallback, endCallback).start();
                break;
        }
    }
}