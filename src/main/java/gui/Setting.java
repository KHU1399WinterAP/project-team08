package gui;

import javax.swing.*;

public class Setting extends JFrame {

    private JPanel mainpanel;
    private JButton changecolor;
    private JFrame PREVIOUS_FRAME;


    public Setting(JFrame previousFrame) {
        this.PREVIOUS_FRAME = previousFrame;
        setContentPane(mainpanel);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);

        pack();
        setLocationRelativeTo(null);

        initListener();
    }

    private void initListener(){
        initChangeColorButtonListener();
    }

    private void initChangeColorButtonListener(){
        changecolor.addActionListener(e -> {
            ChangeColor changeColor=new ChangeColor(this);
            this.setVisible(false);
            changeColor.setVisible(true);});
    }

    }
