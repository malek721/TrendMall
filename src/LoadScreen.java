import javax.swing.*;
import java.awt.*;

public class LoadScreen {
    public LoadScreen() {
        TrendMallFrame main = new TrendMallFrame();
        ImageIcon logo = new ImageIcon("img.png");
        JLabel imageContainer = new JLabel(logo);
        main.add(imageContainer, BorderLayout.CENTER);
        Timer timer = new Timer(3000, e -> {
            new GirisSayfa();
            main.dispose();
        });

        timer.setRepeats(false);
        timer.start();
    }

}
