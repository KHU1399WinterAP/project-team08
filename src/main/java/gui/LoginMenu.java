package gui;

import models.User;

import javax.swing.*;
import java.Database;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.*;

public class LoginMenu extends JFrame {
    private JTextField usernameTextField;
    private JPasswordField passwordField1;
    private JButton loginButton;
    private JPanel mainpanel;
    private JTextField UsernameField;
    private JButton backButton;


    public LoginMenu(JFrame previousFrame) {
        this.PREVIOUS_FRAME = previousFrame;
        setContentPane(mainpanel);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setResizable(false);

        pack();
        setLocationRelativeTo(null);


        initlisteners();


    }

    private void initlisteners() {
        initRegisterButtonListeners();
        initMainMenuButtonListeners();
        initBackBottonlisteners();
    }

    private final JFrame PREVIOUS_FRAME;

    private void initWindowListener() {
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


    private void initRegisterButtonListeners() {
        loginButton.addActionListener(
                e -> {
                    String username = usernameTextField.getText();
                    String password = String.valueOf(passwordField1.getPassword());
                    User user = Database.getUserByUsername(username);

                    if (user != null && user.password.equals(password)) {
                        Dashboard dashboard = new Dashboard(PREVIOUS_FRAME);
                        dashboard.setVisible(true);
                        this.dispose();
                    }
                }

        );
    }

    private void initBackBottonlisteners() {
        backButton.addActionListener(e -> {
            MainMenu mainMenu = new MainMenu();
            this.setVisible(false);
            mainMenu.setVisible(true);
        });
    }

    public void initMainMenuButtonListeners() {
        passwordField1.addActionListener(
                e -> closeWindow());

    }


    private void closeWindow() {
        this.dispose();
        PREVIOUS_FRAME.setVisible(true);
    }


}