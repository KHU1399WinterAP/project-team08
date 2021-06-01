package config;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

public class SpriteConfig {


    private static final URL BALL_URL = SpriteConfig.class.getResource("/resources/ball.png");

    public static Icon createIcon(int x, int y) {
        BufferedImage img=null;
        try {
            img = ImageIO.read(SpriteConfig.BALL_URL);
        } catch (IOException e) {
            e.printStackTrace();
        }
        ImageIcon imageIcon = new ImageIcon(img.getScaledInstance(x,y, Image.SCALE_SMOOTH));
        return imageIcon;
    }}







