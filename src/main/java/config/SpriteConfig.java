package config;

import javax.swing.*;
import java.net.URL;

public class SpriteConfig {
private static final URL BALL_URL  = SpriteConfig.class.getResource("/resourses/k.ico");
public static final Icon BALL = createicon(BALL_URL,"ball");

    private static Icon createicon(URL url, String name) {
        if (url != null)
            return new ImageIcon(url);

        System.out.printf("Cannot find %s sprite.\n", name);
        return null;
    }
}