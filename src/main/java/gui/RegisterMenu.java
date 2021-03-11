package gui;

import models.User;

import javax.swing.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.PreparedStatement;

import javax.swing.*;

public class RegisterMenu extends JFrame {
    private JPanel mainpanel;
    private JButton exitButton;
    private JTextField usernameTextField;
    private JTextField textField2;
    private JTextField passwordTextField;
    private JPasswordField passwordField1;
    private JButton registerButton;



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
        registerButton.addActionListener(
                e -> {
                    User user = new User(usernameTextField.getText(), passwordField1.getPassword());
                    System.out.println(user);
                    closeWindow();
                }

        );
    }
    public void initMainMenuButtonListeners(){
        exitButton.addActionListener(
                e -> closeWindow());

    }


    private void closeWindow(){
        this.dispose();
        PREVIOUS_FRAME.setVisible(true);
    }
}


