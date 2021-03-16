package gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Dashboard extends javax.swing.JFrame {

    private JPanel mainpanel;
    private JButton multiPlayerButton;
    private JButton settingButton;
    private JButton singlePlayerButton;
    private JButton logOutButton;
    private final JFrame MAIN_MENU_FRAME;


    public Dashboard(JFrame MainMenu) {


        this.MAIN_MENU_FRAME = MainMenu;
        setContentPane(mainpanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        pack();
        setLocationRelativeTo(null);

        singlePlayerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }

    private void initListeners() {
        initLogoutBottomListeners() ; initsinglePlayerButtonListeners();
    }

    private void initLogoutBottomListeners() {

        logOutButton.addActionListener(e -> {
            MainMenu mainMenu = new MainMenu();
            this.setVisible(false);
            mainMenu.setVisible(true);

        });
    }
    private void initsinglePlayerButtonListeners(){
        singlePlayerButton.addActionListener(e -> {
           SinglePlayer singleplayer = new SinglePlayer();
            this.setVisible(false);
           singleplayer.setVisible(true);


        });
    }

}

