package View;

import Controller.OdemeController;
import Controller.SepetController;
import Model.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SepetSayfa implements ActionListener {
    Sepet sepet;

    MainFrame main;

    SiparisOzeti siparisOzeti;

    JLabel urunSayisi;
    JButton sepetOnayla;

    public SepetSayfa(Sepet sepet) {
        NavBar nav = new NavBar();
        this.sepet = sepet;
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(null);
        mainPanel.setBackground(new Color(251, 251, 251));

        urunSayisi = new JLabel("Sepetim(" + sepet.getUrunler().size() + " ürün)");
        urunSayisi.setFont(new Font("Arial", Font.PLAIN, 28));
        urunSayisi.setBounds(60, 50, 240, 25);
        urunSayisi.setForeground(new Color(0, 0, 0));
        mainPanel.add(urunSayisi);
        siparisOzeti = new SiparisOzeti(sepet.getToplamUcret());
        mainPanel.add(siparisOzeti);
        for (int i = 0; i < sepet.getUrunler().size(); i++) {
            SepetUnsuru unsuru = new SepetUnsuru(sepet.getUrunler().get(i));
            Urun urun = sepet.getUrunler().get(i);
            unsuru.getRemove().addActionListener(e -> {
                unsuru.setVisible(false);
                SepetController.sepettenKaldir(urun);
                siparisOzeti.getUrunUcret().setText(sepet.getToplamUcret() + " tl");
                siparisOzeti.getToplamUcret().setText(sepet.getToplamUcret() + 45 + " tl");
                urunSayisi.setText("Sepetim(" + sepet.getUrunler().size() + " ürün)");
            });
            unsuru.setBounds(60, 100 + (i * 100), 880, 80);
            mainPanel.add(unsuru);
        }
        sepetOnayla = new JButton("Sepet Onayla");
        sepetOnayla.setFocusable(false);
        sepetOnayla.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        sepetOnayla.setBounds(1128, 400, 200, 50);
        sepetOnayla.setFont(new Font("Inter", Font.BOLD, 26));
        sepetOnayla.setForeground(new Color(0xD95927));
        sepetOnayla.setBackground(new Color(251, 251, 251));
        sepetOnayla.setBorder(BorderFactory.createLineBorder(new Color(0xD95927), 2));
        sepetOnayla.addActionListener(this);
        mainPanel.add(sepetOnayla);


        main = new MainFrame();
        main.add(nav, BorderLayout.NORTH);
        main.add(mainPanel, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == sepetOnayla) {
            new OdemeController(new Odeme(), new KartOdeme(), new OdemeSayfa(sepet.getUrunler()));
            main.dispose();
        }
    }
}
