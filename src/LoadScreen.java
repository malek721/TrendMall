import javax.swing.*;
import java.awt.*;

public class LoadScreen{
    public  LoadScreen(){
        TrendMallFrame main = new TrendMallFrame();
        ImageIcon logo = new ImageIcon("img.png");
        JLabel imageContainer = new JLabel(logo);
        main.add(imageContainer, BorderLayout.CENTER);
        Timer timer = new Timer(3000, e -> {
            // Code to be executed after the delay
            new GirisYap();
            main.dispose();
        });

        // Start the timer
        timer.setRepeats(false); // Set to execute only once
        timer.start();
    }

}
