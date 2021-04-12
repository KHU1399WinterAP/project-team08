package gui;

import animations.ColorChangeAnimation;
import config.GuiConfig;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.function.Consumer;

public class ChangeColor extends JFrame {
    private JButton redButton;
    private JPanel mainpanel;
    private JButton blueButton;
    private JButton pinkButton;
    private JButton purpleButton;
    private JButton backButton;
    private JButton greenButton;
    private JFrame PREVIOUS_FRAME;
    private JPanel MAIN_PANEL;

public ChangeColor(JPanel mainpanel){
this.MAIN_PANEL=mainpanel;
}

    public ChangeColor(JFrame previousFrame) {
        super("MainMenu|Dashboard|Setting|ChangeColor");
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
        initGreenButtonListener();
    }

    private void initRedButtonListener() {
        redButton.addActionListener(e -> {
            Consumer<Color> stepCallback = (color) -> MAIN_PANEL.setBackground(color);
            Runnable endCallback = () -> MAIN_PANEL.setBackground(GuiConfig.COLOR_RED);
            new ColorChangeAnimation(MAIN_PANEL.getBackground(), GuiConfig.COLOR_RED, stepCallback, endCallback).start();
        });
    }

    private void initBlueButtonListener() {
        blueButton.addActionListener(e -> {
            Consumer<Color> stepCallback = (color) -> MAIN_PANEL.setBackground(color);
            Runnable endCallback = () -> MAIN_PANEL.setBackground(GuiConfig.COLOR_BLUE);
            new ColorChangeAnimation(MAIN_PANEL.getBackground(), GuiConfig.COLOR_BLUE, stepCallback, endCallback).start();
        });
    }

    private void initPinkButtonListener() {
        pinkButton.addActionListener(e -> {
            Consumer<Color> stepCallback = (color) -> MAIN_PANEL.setBackground(color);
            Runnable endCallback = () -> MAIN_PANEL.setBackground(GuiConfig.COLOR_PINK);
            new ColorChangeAnimation(MAIN_PANEL.getBackground(), GuiConfig.COLOR_PINK, stepCallback, endCallback).start();
        });
    }

    private void initPurpleButtonListeners() {
        purpleButton.addActionListener(e -> {
            Consumer<Color> stepCallback = (color) -> MAIN_PANEL.setBackground(color);
            Runnable endCallback = () -> MAIN_PANEL.setBackground(GuiConfig.COLOR_PURPLE);
            new ColorChangeAnimation(MAIN_PANEL.getBackground(), GuiConfig.COLOR_PURPLE, stepCallback, endCallback).start();
        });
    }

    private void initBackButtonListener() {
        backButton.addActionListener(e -> {
            Setting setting = new Setting(this);
            this.setVisible(false);
            setting.setVisible(true);
        });
    }
    private void initGreenButtonListener(){
        greenButton.addActionListener(e -> {
            Consumer<Color> stepCallback = (color) -> MAIN_PANEL.setBackground(color);
            Runnable endCallback = () -> MAIN_PANEL.setBackground(GuiConfig.COLOR_GREEN);
            new ColorChangeAnimation(MAIN_PANEL.getBackground(), GuiConfig.COLOR_GREEN, stepCallback, endCallback).start();

        });
    }
}

