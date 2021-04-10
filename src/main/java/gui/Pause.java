package gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Pause extends JFrame {

    private JPanel mainpanel;
    private JButton dashboardButton;
    private JButton menuButton;
    private JButton playButton;


    public Pause() {

        setContentPane(mainpanel);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);


        pack();
        setLocationRelativeTo(null);
        initListener();

    }

    private void initListener() {
        initDashboardButtonListener();
        initMenuButtonListener();
        initPlayButtonListener();
    }

    private void initDashboardButtonListener() {
        dashboardButton.addActionListener(e -> {
            Dashboard dashboard = new Dashboard(this);
            this.setVisible(false);
            dashboard.setVisible(true);
        });
    }

    private void initMenuButtonListener() {
        menuButton.addActionListener(
                e -> {
                    MainMenu mainMenu = new MainMenu();
                    this.dispose();
                    mainMenu.setVisible(true);
                });
    }


    private void initPlayButtonListener() {
        playButton.addActionListener(e -> {
            SinglePlayer singlePlayer = new SinglePlayer(this);
            this.setVisible(false);
            singlePlayer.setVisible(true);
        });
    }

}
