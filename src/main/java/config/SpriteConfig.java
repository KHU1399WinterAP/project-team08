package config;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

public class SpriteConfig {


    public static final URL BALL_URL = SpriteConfig.class.getResource("/resources/ball.png");
    public static final URL CIRCLE_URL = SpriteConfig.class.getResource("/resources/colorCircle.png");

    public static Icon createIcon(int x, int y,URL url) {
        BufferedImage img = null;
        try {
            img = ImageIO.read(url);
        } catch (IOException e) {
            e.printStackTrace();
        }
        ImageIcon imageIcon = new ImageIcon(img.getScaledInstance(x, y, Image.SCALE_SMOOTH));
        return imageIcon;
    }
}







