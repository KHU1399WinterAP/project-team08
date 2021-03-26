package gui;

import models.User;

import javax.swing.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class RegisterMenu extends JFrame{
    private JTextField textField1;
    private JPasswordField passwordField1;
    private JButton exitButton;
    private JPanel mainpanel;
    private JTextField colorSwitchTextField;
    private JTextField usernameTextField;
    private JTextField passwordTextField;
    private JButton backButton;


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

    private void initWindowListener(){
        this.addWindowListener(
                new WindowListener() {
                    @Override
                    public void windowOpened(WindowEvent e) {

                    }

                    @Override
                    public void windowClosing(WindowEvent e) {
                        closeWindow();
                    }

                    @Override
                    public void windowClosed(WindowEvent e) {

                    }

                    @Override
                    public void windowIconified(WindowEvent e) {

                    }

                    @Override
                    public void windowDeiconified(WindowEvent e) {

                    }

                    @Override
                    public void windowActivated(WindowEvent e) {

                    }

                    @Override
                    public void windowDeactivated(WindowEvent e) {

                    }
                }
        );
    }



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
}

