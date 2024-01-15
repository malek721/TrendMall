package View;

import Model.Satici;

import javax.swing.*;
import java.awt.*;

public class UrunDuzeltmeSayfa {

    SaticiNavBar nav;
    JButton kayidetBtn;

    JTextField urunAdi, katogori, miktar, fiyat;

    String[] bilgiler = {"ürün adı", "katogori", "miktar", "fiyat"};


    public UrunDuzeltmeSayfa(Satici satici) {
        nav = new SaticiNavBar(satici);
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(null);
        mainPanel.setBackground(new Color(251, 251, 251));

        JPanel urunB = new JPanel();
        urunB.setLayout(null);
        urunB.setBackground(new Color(251, 251, 251));
        urunB.setBorder(BorderFactory.createLineBorder(new Color(0xBEBCBC), 1));
        urunB.setBounds(500, 30, 600, 540);

        JLabel title = new JLabel("Ürün Bilgileri");
        title.setFont(new Font("Inter", Font.BOLD, 26));
        title.setForeground(new Color(0, 0, 0));
        title.setBounds(200, 20, 300, 35);
        urunB.add(title);

        for (int i = 0; i < bilgiler.length; i++) {
            JLabel label = new JLabel(bilgiler[i] + ":");
            label.setFont(new Font("Arial", Font.PLAIN, 20));
            label.setBounds(20, 100 + (i * 80), 110, 25);
            label.setForeground(new Color(0, 0, 0));
            urunB.add(label);
        }

        urunAdi = new JTextField("  ");
        urunAdi.setFont(new Font("Poppins", Font.BOLD, 18));
        urunAdi.setBackground(new Color(0xE7E7E7));
        urunAdi.setBorder(BorderFactory.createLineBorder(new Color(0x919191), 1));
        urunAdi.setBounds(130, 85, 380, 50);
        urunAdi.setEditable(false);
        urunB.add(urunAdi);
        katogori = new JTextField("  ");
        katogori.setFont(new Font("Poppins", Font.BOLD, 18));
        katogori.setBackground(new Color(0xE7E7E7));
        katogori.setBorder(BorderFactory.createLineBorder(new Color(0x919191), 1));
        katogori.setBounds(130, 165, 380, 50);
        katogori.setEditable(false);
        urunB.add(katogori);
        miktar = new JTextField("  ");
        miktar.setFont(new Font("Poppins", Font.BOLD, 18));
        miktar.setBackground(new Color(0xE7E7E7));
        miktar.setBorder(BorderFactory.createLineBorder(new Color(0x919191), 1));
        miktar.setBounds(130, 245, 380, 50);
        urunB.add(miktar);
        fiyat = new JTextField("  ");
        fiyat.setFont(new Font("Poppins", Font.BOLD, 18));
        fiyat.setBackground(new Color(0xE7E7E7));
        fiyat.setBorder(BorderFactory.createLineBorder(new Color(0x919191), 1));
        fiyat.setBounds(130, 325, 380, 50);
        urunB.add(fiyat);

        kayidetBtn = new JButton("Kaydet");
        kayidetBtn.setBounds(180, 440, 220, 40);
        kayidetBtn.setForeground(new Color(0xF4F4F4));
        kayidetBtn.setBackground(new Color(0xFA6930));
        kayidetBtn.setFont(new Font("Poppins", Font.BOLD, 16));
        urunB.add(kayidetBtn);


        mainPanel.add(urunB);
        MainFrame main = new MainFrame();
        main.add(nav, BorderLayout.NORTH);
        main.add(mainPanel, BorderLayout.CENTER);
    }

    public JButton getKayidetBtn() {
        return kayidetBtn;
    }

    public JTextField getUrunAdi() {
        return urunAdi;
    }

    public JTextField getKatogori() {
        return katogori;
    }

    public JTextField getMiktar() {
        return miktar;
    }

    public JTextField getFiyat() {
        return fiyat;
    }

}
