package gui;

import models.User;

import javax.swing.*;
import java.Database;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.PreparedStatement;

import javax.swing.*;
import javax.swing.*;

public class RegisterMenu extends JFrame{
    private JTextField textField1;
    private JPasswordField passwordField1;
    private JButton exitButton;
    private JPanel mainpanel;


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
        exitButton.addActionListener(
                e -> {
                    User user = new User(textField1.getText(), passwordField1.getPassword());
                    System.out.println(user);
                    Database.insertIntoUser(user);
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

