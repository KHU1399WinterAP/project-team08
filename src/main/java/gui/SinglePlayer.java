package gui;

import javax.swing.*;

public class SinglePlayer extends JFrame{
    private JButton menuButton;
    private JButton dashboardButton;
    private JButton pauseButton;

    public SinglePlayer(){

        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setResizable(false);
        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initlisteners();


    }
    private void initlisteners(){
        initpauseButtonListener();
        initmenuButtonListener();
        initdashboardButtonListener();
    }



    private void  initpauseButtonListener() {


    }
    private void  initmenuButtonListener() {
        menuButton.addActionListener(
                e -> {
                    MainMenu mainMenu = new MainMenu();
                    this.dispose();
                    mainMenu.setVisible(true);
                }
        );
    }
    private void initdashboardButtonListener () {
        dashboardButton.addActionListener(e -> {
            Dashboard dashboard= new Dashboard(this);
            this.setVisible(false);
            dashboard.setVisible(true);

        });
    }

    private void createUIComponents(){
    }

}
