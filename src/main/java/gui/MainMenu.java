package gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import javax.swing.*;

public class MainMenu extends JFrame {
    private JPanel mainpanel;
    private JButton loginButton;
    private JButton exitButton;
    private JButton registerButton;



        public MainMenu() {

            setContentPane(mainpanel);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


            pack();
            setLocationRelativeTo(null);

            initListeners();

        }


        private void initListeners() {
            initRegisterButtonListeners();
            initLoginButtonListeners();
            initExitButtonListeners();
        }
        private void initRegisterButtonListeners() {
            registerButton.addActionListener(
                    e -> {
                        RegisterMenu registermenu = new RegisterMenu(this);
                        this.setVisible(false);
                        registermenu.setVisible(true);
                    }
            );
        }

        private void initLoginButtonListeners() {
            loginButton.addActionListener(
                    e -> {
                        LoginMenu loginmenu = new LoginMenu(this);
                        this.setVisible(false);
                        loginmenu.setVisible(true);
                    }
            );
        }

        private void initExitButtonListeners(){
            exitButton.addActionListener(e -> dispatchEvent(new WindowEvent(this,WindowEvent.WINDOW_CLOSING)));

        }
}
