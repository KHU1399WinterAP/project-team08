package gui;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;


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


    private void createUIComponents() {
        mainpanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                try {
                    var image = ImageIO.read(this.getClass().getResource("/resources/background.png"));
                    g.drawImage(image, 0, 0, this);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };
    }
}
