package gui;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;


public class ChangeColor extends JFrame {
    private JButton redButton;
    private JPanel mainpanel;
    private JButton blueButton;
    private JButton pinkButton;
    private JButton purpleButton;
    private JButton backButton;
    private JButton greenButton;
    private JFrame PREVIOUS_FRAME;
    static String SingleBackGroundColor="DEFAULT";

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
            SingleBackGroundColor="Red"; });
    }

    private void initBlueButtonListener() {
        blueButton.addActionListener(e -> {
            SingleBackGroundColor="Blue"; });
    }

    private void initPinkButtonListener() {
        pinkButton.addActionListener(e -> {
            SingleBackGroundColor="Pink";
        });
    }

    private void initPurpleButtonListeners() {
        purpleButton.addActionListener(e -> {
            SingleBackGroundColor="Purple";
        });
    }


    private void initGreenButtonListener() {
        greenButton.addActionListener(e -> {
            SingleBackGroundColor="Green";
        });
    }

    private void initBackButtonListener() {
        backButton.addActionListener(e -> {
            Setting setting = new Setting(this);
            this.setVisible(false);
            setting.setVisible(true);
        });
    }
    private void createUIComponents() {
        mainpanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                try {
                    var image = ImageIO.read(this.getClass().getResource("/resources/background.png"));
                    g.drawImage(image, 0, 0, this);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };
    }
}

