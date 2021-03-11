package gui;
import models.User;

import javax.swing.*;
import java.Database;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.*;

public class LoginMenu extends JFrame{
    private JTextField colorSwitchTextField;
    private JTextField textField2;
    private JTextField usernameTextField;
    private JTextField passwordTextField;
    private JPasswordField passwordField1;
    private JButton loginButton;
    private JPanel mainpanel;


    public LoginMenu(JFrame previousFrame) {
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
        loginButton.addActionListener(
                e -> {
                    String username=usernameTextField.getText();
                    String password =String.valueOf(passwordField1.getPassword());
                    User user= Database.getUserByUsername(username);

                    if(user !=null && user.password.equals(password)){
                        Dashboard dashboard= new Dashboard(PREVIOUS_FRAME);
                        dashboard.setVisible(true);
                        this.dispose();
                    }
                }

        );
    }
    public void initMainMenuButtonListeners(){
        passwordField1.addActionListener(
                e -> closeWindow());

    }


    private void closeWindow(){
        this.dispose();
        PREVIOUS_FRAME.setVisible(true);
    }


}