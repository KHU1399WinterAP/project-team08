package gui;

import animations.ColorChangeAnimation;
import config.GuiConfig;

import javax.swing.*;
import java.awt.*;
import java.util.function.Consumer;

public class ChangeColor extends JFrame {
    private JButton redButton;
    private JPanel mainpanel;
    private JButton blueButton;
    private JButton pinkButton;
    private JButton purpleButton;
    private JButton backButton;
    private JFrame PREVIOUS_FRAME;


    public ChangeColor(JFrame previousFrame) {
        super("mainmenu|dashboard|setting|changecolor");
        this.PREVIOUS_FRAME = previousFrame;


        setContentPane(mainpanel);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);


        pack();
        setLocationRelativeTo(null);

        initListener();


    }

    private void initListener() {
        initRedButtonListener();
        initBlueButtonListener();
        initPinkButtonListener();
        initPurpleButtonListeners();
        initBackButtonListener();
    }

    private void initRedButtonListener() {
        redButton.addActionListener(e -> {
            Consumer<Color> stepCallback = (color) -> mainpanel.setBackground(color);
            Runnable endCallback = () -> mainpanel.setBackground(GuiConfig.COLOR_RED);
            new ColorChangeAnimation(mainpanel.getBackground(), GuiConfig.COLOR_RED, stepCallback, endCallback).start();
        });
    }

    private void initBlueButtonListener() {
        blueButton.addActionListener(e -> {
            Consumer<Color> stepCallback = (color) -> mainpanel.setBackground(color);
            Runnable endCallback = () -> mainpanel.setBackground(GuiConfig.COLOR_BLUE);
            new ColorChangeAnimation(mainpanel.getBackground(), GuiConfig.COLOR_BLUE, stepCallback, endCallback).start();
        });
    }

    private void initPinkButtonListener() {
        pinkButton.addActionListener(e -> {
            Consumer<Color> stepCallback = (color) -> mainpanel.setBackground(color);
            Runnable endCallback = () -> mainpanel.setBackground(GuiConfig.COLOR_PINK);
            new ColorChangeAnimation(mainpanel.getBackground(), GuiConfig.COLOR_PINK, stepCallback, endCallback).start();
        });
    }

    private void initPurpleButtonListeners() {
        purpleButton.addActionListener(e -> {
            Consumer<Color> stepCallback = (color) -> mainpanel.setBackground(color);
            Runnable endCallback = () -> mainpanel.setBackground(GuiConfig.COLOR_PURPLE);
            new ColorChangeAnimation(mainpanel.getBackground(), GuiConfig.COLOR_PURPLE, stepCallback, endCallback).start();
        });
    }

    private void initBackButtonListener() {
        backButton.addActionListener(e -> {
            Setting setting = new Setting(this);
            this.setVisible(false);
            setting.setVisible(true);
        });
    }
}

