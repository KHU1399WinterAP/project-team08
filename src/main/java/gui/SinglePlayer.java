package gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SinglePlayer extends JFrame {
    private JButton menuButton;
    private JButton dashboardButton;
    private JPanel mainpanel;
    private JButton pauseButton2;
    private JFrame PREVIOUS_FRAME;


    public SinglePlayer(JFrame previousFrame) {
        super("MainMenu|Dashboard|SinglePlayer");
        this.PREVIOUS_FRAME = previousFrame;
        setContentPane(mainpanel);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);

        pack();
        setLocationRelativeTo(null);

        initlisteners();

    }

    private void initlisteners() {
        initPauseButtonListener();
    }


    private void initPauseButtonListener() {
        pauseButton2.addActionListener(e -> {
            Pause pause = new Pause();
            this.setVisible(false);
            pause.setVisible(true);
        });
    }

    private void createUIComponents() {
    }

}
