package gui;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Dashboard extends javax.swing.JFrame {

    private JPanel mainpanel;
    private JButton logOutButton;
    private JButton settingButton;
    private JButton singlePlayerButton;

    private final JFrame MAIN_MENU_FRAME;

    public Dashboard(JFrame MainMenu) {
        super("MainMenu|Dashboard");
        this.MAIN_MENU_FRAME = MainMenu;
        setContentPane(mainpanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        initListeners();

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
            SinglePlayer singleplayer = new SinglePlayer(this);
            this.setVisible(false);
            singleplayer.setVisible(true);
            });
    }

    private void initSettingButtonListeners() {
        settingButton.addActionListener(e -> {
            Setting setting = new Setting(this);
            this.setVisible(false);
            setting.setVisible(true);
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


