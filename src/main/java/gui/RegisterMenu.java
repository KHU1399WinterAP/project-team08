package gui;

import models.User;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class RegisterMenu extends JFrame{
    private JTextField textField1;
    private JPasswordField passwordField1;
    private JButton exitButton;
    private JPanel mainpanel;
    private JButton backButton;
    private JLabel Usernamelable;
    private JLabel Passwordlable;


    public RegisterMenu(JFrame previousFrame){
        this.PREVIOUS_FRAME= previousFrame;
        setContentPane(mainpanel);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setResizable(false);

        pack();
        setLocationRelativeTo(null);

        initlisteners();

    }


    private void initlisteners(){
        initRegisterButtonListeners();
        initMainMenuButtonListeners();
        initBackBottomListener();
    }

    private final JFrame PREVIOUS_FRAME;

    private void  initRegisterButtonListeners() {
        exitButton.addActionListener(
                e -> {
                    User user = new User(textField1.getText(), passwordField1.getPassword());
                    System.out.println(user);

                    closeWindow();
                    });


        exitButton.addActionListener(
                e -> {
                    Dashboard dashboard = new Dashboard(this);
                    this.setVisible(false);
                    dashboard.setVisible(true);
                });
        ;


    }
    public void initMainMenuButtonListeners(){
        exitButton.addActionListener(
                e -> closeWindow());

    }


    private void initBackBottomListener() {
        backButton.addActionListener(e -> {
            MainMenu mainMenu = new MainMenu();
            this.setVisible(false);
            mainMenu.setVisible(true);
        });
    }
    private void closeWindow(){
        this.dispose();

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

