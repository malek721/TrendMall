package View;

import Model.Satici;

import javax.swing.*;
import java.awt.*;

public class SaticiSatanUrunlerList{
    private final MainFrame main;
    private final JPanel urunList;
    public SaticiSatanUrunlerList(Satici satici){
        main = new MainFrame();
        SaticiNavBar nav = new SaticiNavBar(satici);
        JPanel mainContent = new JPanel();
        mainContent.setLayout(null);
        mainContent.setBackground(new Color(251, 251, 251));
        urunList = new JPanel(new FlowLayout(FlowLayout.LEADING, 5, 30));
        urunList.setBackground(new Color(0xFBFBFB));
        urunList.setBounds(58, 100, 1450, 500);
        mainContent.add(urunList);
        main.add(nav, BorderLayout.NORTH);
        main.add(mainContent, BorderLayout.CENTER);
    }

    public MainFrame getMain() {
        return main;
    }

    public JPanel getUrunList() {
        return urunList;
    }
}
