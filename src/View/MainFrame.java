package View;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    public MainFrame(){
        this.setTitle("TrendMall");
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        ImageIcon logo = new ImageIcon("img.png");
        this.setIconImage(logo.getImage());
        this.getContentPane().setBackground(new Color(251, 251, 251));
    }
}
