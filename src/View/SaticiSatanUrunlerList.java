package View;

import Model.Satici;
import Model.Sepet;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SaticiSatanUrunlerList{
    private Satici satici;
    private MainFrame main;
    private SaticiNavBar nav;
    private JPanel urunList;
    public SaticiSatanUrunlerList(Satici satici){
        this.satici = satici;
        main = new MainFrame();
        nav = new SaticiNavBar(satici);
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

    public SaticiNavBar getSaticiNavBar() {
        return nav;
    }

    public JPanel getUrunList() {
        return urunList;
    }
}
