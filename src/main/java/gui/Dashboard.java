package gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.*;
import java.awt.event.*;
import javax.swing.GroupLayout;
import java.awt.image.*;

public class Dashboard extends javax.swing.JFrame {

    private JPanel mainpanel;
    private JButton logOutButton;
    private JButton settingButton;
    private JButton multiPlayerButton;
    private JButton singlePlayerButton;

    private final JFrame MAIN_MENU_FRAME;

    public Dashboard(JFrame MainMenu) {

        this.MAIN_MENU_FRAME = MainMenu;
        setContentPane(mainpanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        pack();
        setLocationRelativeTo(null);
        initListeners();

    }


    private void createUIComponents() {
        // TODO: place custom component creation code here
    }

    private void initListeners() {
        initLogoutBottomListener();
        initSinglePlayerButtonListener();
        initSettingButtonListeners();
    }

    private void initLogoutBottomListener() {

        logOutButton.addActionListener(e -> {
            MainMenu mainMenu = new MainMenu();
            this.setVisible(false);
            mainMenu.setVisible(true);

        });
    }

    private void initSinglePlayerButtonListener() {
        singlePlayerButton.addActionListener(e -> {
            SinglePlayer singleplayer = new SinglePlayer();
            this.setVisible(false);
            singleplayer.setVisible(true);
        });
    }

    private void initSettingButtonListeners() {
        settingButton.addActionListener(e -> {
            Setting setting = new Setting();
            this.setVisible(false);
            setting.setVisible(true);
        });
    }
}


