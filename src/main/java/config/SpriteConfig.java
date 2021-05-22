package config;

import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.awt.*;
import java.net.URL;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class SpriteConfig {


    private static final URL BALL_URL  = SpriteConfig.class.getResource("resources/colorCircle.png");
    //private static final URL circle_URL  = SpriteConfig.class.getResource("java/resources/colorCircle.png");
    public  static final Icon BALL = createIcon(BALL_URL,"ball");
    //public static final Icon circle = createIcon(circle_URL,"circle");
    private static @Nullable
    BufferedImage createImage(URL url, String name) {
        try {
            if (url != null)
                return ImageIO.read(url);

            printError(name);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }


    private static Icon createIcon(URL url, String name ) {
        try {
            if (url != null) {
                var image = ImageIO.read(url);
                var width = image.getWidth() ;
                var height = image.getHeight() ;

                return new ImageIcon(image.getScaledInstance(width, height, Image.SCALE_SMOOTH));
            }

            printError(name);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    private static void printError(String name) {
        System.out.printf("Cannot find %s sprite.\n", name);
    }
}