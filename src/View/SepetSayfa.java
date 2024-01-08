package View;

import Model.Musteri;
import Model.Sepet;
import Model.Urun;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SepetSayfa{
    Sepet sepet;

    JLabel urunSayisi;
    JButton sepetOnayla;

    public SepetSayfa(Sepet sepet) {
        NavBar nav = new NavBar();
        Musteri m = new Musteri(2, "Amr", "Walidi", "amr.nawaf128@gmail.com", "Amr_Nawaf128", "İstanbul/Türkiye", "5369922950");
        this.sepet = sepet;
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(null);
        mainPanel.setBackground(new Color(251, 251, 251));

        urunSayisi = new JLabel("Sepetim(" + sepet.getUrunler().size() + " ürün)");
        urunSayisi.setFont(new Font("Arial", Font.PLAIN, 28));
        urunSayisi.setBounds(60, 50, 240, 25);
        urunSayisi.setForeground(new Color(0, 0, 0));
        mainPanel.add(urunSayisi);
        SiparisOzeti siparisOzeti = new SiparisOzeti(sepet.getToplamUcret());
        mainPanel.add(siparisOzeti.getOzet());
        for (int i = 0; i < sepet.getUrunler().size(); i++) {
            SepetUnsuru unsuru = new SepetUnsuru(sepet.getUrunler().get(i));
            unsuru.setBounds(60, 100 + (i*100), 880, 80);
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
        mainPanel.add(sepetOnayla);


        MainFrame main = new MainFrame();
        main.add(nav, BorderLayout.NORTH);
        main.add(mainPanel, BorderLayout.CENTER);
    }
}
