package View;

import javax.swing.*;
import java.awt.*;
import java.text.DateFormatSymbols;
import java.util.HashMap;

public class OdemeSayfa {
    JTextField kartSahibiAdi;
    JTextField kartNo;
    JComboBox<Integer> sonAyTarihi;
    JComboBox<Integer> sonYilTarihi;
    JTextField cvv;
    JComboBox<JLabel> kartTuru;
    String[] seceneklerAdi = {"Kredi Kart", "Nakit"};
    String[] kartBilgilerAd = {"Kart Sahibinin Adı", "Kart Numarası", "Son Kullanma Tarihi", "CVV"};
    ButtonGroup secenekler;

    public OdemeSayfa() {
        NavBar nav = new NavBar();
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(null);
        mainPanel.setBackground(new Color(251, 251, 251));
        JLabel title = new JLabel("ÖDEME SEÇENEKLERİ");
        title.setFont(new Font("Inter", Font.BOLD, 26));
        title.setForeground(new Color(0, 0, 0));
        title.setBounds(75, 57, 300, 35);
        mainPanel.add(title);
        secenekler = new ButtonGroup();
        for (int i = 0; i < seceneklerAdi.length; i++) {
            JRadioButton secenek = new JRadioButton(seceneklerAdi[i]);
            secenek.setFont(new Font("Inter", Font.BOLD, 24));
            secenek.setForeground(new Color(0, 0, 0));
            secenek.setBackground(new Color(251, 251, 251));
            secenek.setBounds(81 + (i * 619), 157, 170, 35);
            secenek.setFocusable(false);
            secenekler.add(secenek);
            mainPanel.add(secenek);
        }
        JPanel kartBilgiler = new JPanel();
        kartBilgiler.setLayout(null);
        kartBilgiler.setBackground(new Color(251, 251, 251));
        kartBilgiler.setBorder(BorderFactory.createLineBorder(new Color(0xBEBCBC), 1));
        kartBilgiler.setBounds(75, 205, 570, 350);
        for (int i = 0; i < kartBilgilerAd.length; i++) {
            JLabel label = new JLabel(kartBilgilerAd[i]);
            label.setFont(new Font("Poppins", Font.PLAIN, 15));
            if (kartBilgilerAd[i].equals("CVV"))
                label.setBounds(300, 215, 140, 30);
            else
                label.setBounds(35, 15 + (i * 100), 140, 30);
            label.setForeground(new Color(0, 0, 0));
            kartBilgiler.add(label);
        }
        kartSahibiAdi = new JTextField("  ");
        kartSahibiAdi.setFont(new Font("Poppins", Font.BOLD, 18));
        kartSahibiAdi.setBackground(new Color(0xE7E7E7));
        kartSahibiAdi.setBorder(BorderFactory.createLineBorder(new Color(0x919191), 1));
        kartSahibiAdi.setBounds(35, 45, 500, 62);
        kartBilgiler.add(kartSahibiAdi);
        kartNo = new JTextField("  ");
        kartNo.setFont(new Font("Poppins", Font.BOLD, 18));
        kartNo.setBackground(new Color(0xE7E7E7));
        kartNo.setBorder(BorderFactory.createLineBorder(new Color(0x919191), 1));
        kartNo.setBounds(35, 145, 500, 62);
        kartBilgiler.add(kartNo);
        sonAyTarihi = new JComboBox<>(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12});
        sonAyTarihi.setSelectedIndex(0);
        sonAyTarihi.setFont(new Font("Poppins", Font.BOLD, 18));
        sonAyTarihi.setBackground(new Color(0xE7E7E7));
        sonAyTarihi.setBorder(BorderFactory.createLineBorder(new Color(0x919191), 1));
        sonAyTarihi.setBounds(35, 245, 110, 62);
        kartBilgiler.add(sonAyTarihi);
        sonYilTarihi = new JComboBox<>(new Integer[]{2024, 2025, 2026, 2027, 2028, 2029, 2030, 2031});
        sonYilTarihi.setFont(new Font("Poppins", Font.BOLD, 18));
        sonYilTarihi.setBackground(new Color(0xE7E7E7));
        sonYilTarihi.setBorder(BorderFactory.createLineBorder(new Color(0x919191), 1));
        sonYilTarihi.setBounds(150, 245, 110, 62);
        kartBilgiler.add(sonYilTarihi);
        cvv = new JTextField("  ");
        cvv.setFont(new Font("Poppins", Font.BOLD, 18));
        cvv.setBackground(new Color(0xE7E7E7));
        cvv.setBorder(BorderFactory.createLineBorder(new Color(0x919191), 1));
        cvv.setBounds(280, 245, 110, 62);
        kartBilgiler.add(cvv);
        mainPanel.add(kartBilgiler);
        MainFrame main = new MainFrame();
        main.add(nav.navBar, BorderLayout.NORTH);
        main.add(mainPanel, BorderLayout.CENTER);
    }
}
