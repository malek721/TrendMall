package View;

import Controller.GirisController;
import Model.DatabaseOperations.GirisYapma;

import javax.swing.*;
import java.awt.*;

public class TrendMall {
    public TrendMall() {
        MainFrame main = new MainFrame();
        ImageIcon logo = new ImageIcon("img.png");
        JLabel imageContainer = new JLabel(logo);
        main.add(imageContainer, BorderLayout.CENTER);
        Timer timer = new Timer(3000, e -> {
            new GirisController(new GirisSayfa(), new GirisYapma());
            main.dispose();
        });

        timer.setRepeats(false);
        timer.start();
    }

}
