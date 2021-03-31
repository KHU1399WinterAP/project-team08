package gui;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.IOException;
import javax.swing.*;

public class MainMenu extends JFrame {
    private JButton loginButton;
    private JButton exitButton;
    private JButton registerButton;
    private JPanel mainpanel;



    public static void main (String[]args){

   MainMenu frame= new MainMenu();
           frame.setVisible(true);
           frame.pack();

           frame.setContentPane(frame.mainpanel);
           frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
           frame.setVisible(true);

           frame.pack();
           frame.setLocationRelativeTo(null);

           frame.initListeners();

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

    private void createUIComponents() {
        mainpanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                try {
                    var image = ImageIO.read(getClass().getResource("/main/resources/background.png"));
                    g.drawImage(image, 0, 0, this);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };
    }


    class CustomJpanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            g.drawImage(new ImageIcon(getClass().getResource("/resources/background.png")).getImage(), 0, 0, null);
        }
    }


}
