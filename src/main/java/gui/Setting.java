package gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Setting extends JFrame {

    private JPanel mainpanel;
    private JButton changecolor;
    private JButton dashboardButton;
    private JFrame PREVIOUS_FRAME;


    public Setting(JFrame previousFrame) {
        super("MainMenu|Dashboard|Setting");
        this.PREVIOUS_FRAME = previousFrame;
        setContentPane(mainpanel);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);

        pack();
        setLocationRelativeTo(null);

        initListener();


    }

    private void initListener() {
        initChangeColorButtonListener();
        initDashboardButtonListener();

    }

    private void initChangeColorButtonListener() {
        changecolor.addActionListener(e -> {
            ChangeColor changeColor = new ChangeColor(this);
            this.setVisible(false);
            changeColor.setVisible(true);
        });
    }

    private void initDashboardButtonListener() {
        dashboardButton.addActionListener(e -> {
            Dashboard dashboard = new Dashboard(this);
            this.setVisible(false);
            dashboard.setVisible(true);
        });
    }


}
