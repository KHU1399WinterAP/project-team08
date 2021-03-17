package gui;

import models.User;

import javax.swing.*;
import java.Database;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class RegisterMenu extends JFrame {
    private JTextField Usernamefield1;
    private JPasswordField passwordField1;
    private JButton exitButton;
    private JPanel mainpanel;
    private JButton BackButton;


    public RegisterMenu(JFrame previousFrame) {
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

        initBackBottomListener();
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
        exitButton.addActionListener(
                e -> {
                    User user = new User(Usernamefield1.getText(), passwordField1.getPassword());
                    System.out.println(user);
                    closeWindow();
                }
                );
        exitButton.addActionListener(e -> {
            Dashboard dashboard=new Dashboard(this);
            this.setVisible(false);
            dashboard.setVisible(true);

        });
    }



    private void initBackBottomListener() {
        BackButton.addActionListener(e -> {
            MainMenu mainMenu = new MainMenu();
            this.setVisible(false);
            mainMenu.setVisible(true);
        });
    }


    private void closeWindow() {
        this.dispose();

    }
}

