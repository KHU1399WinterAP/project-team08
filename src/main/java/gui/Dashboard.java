package gui;

import javax.swing.*;

public class Dashboard extends javax.swing.JFrame {

    private JPanel mainpanel;

    private final JFrame MAIN_MENU_FRAME;

    public Dashboard(JFrame MainMenu) {

        this.MAIN_MENU_FRAME = MainMenu;
        setContentPane(mainpanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        pack();
        setLocationRelativeTo(null);

    }
}


