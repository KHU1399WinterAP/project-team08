package gui;

import javax.swing.*;

public class SinglePlayer extends JFrame{
    private JButton menuButton;
    private JButton dashboardButton;
    private JButton pauseButton;
    private JPanel mainpanel;
    private JFrame PREVIOUS_FRAME;
public SinglePlayer(JPanel mainpanel){this.mainpanel=mainpanel;}

    public SinglePlayer(JFrame previousFrame){

        this.PREVIOUS_FRAME = previousFrame;
        setContentPane(mainpanel);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);

        pack();
        setLocationRelativeTo(null);

        initlisteners();
    }

    private void initlisteners(){
        initPauseButtonListener();
        initMenuButtonListener();
        initDashboardButtonListener();
    }

    private void  initPauseButtonListener() {

    }

    private void  initMenuButtonListener() {
        menuButton.addActionListener(
                e -> {
                    MainMenu mainMenu = new MainMenu();
                    this.dispose();
                    mainMenu.setVisible(true);
                });
    }
    private void initDashboardButtonListener () {
        dashboardButton.addActionListener(e -> {
            Dashboard dashboard= new Dashboard(this);
            this.setVisible(false);
            dashboard.setVisible(true);
        });
    }

    private void createUIComponents(){
    }

}
