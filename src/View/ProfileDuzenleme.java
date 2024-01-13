package View;

import javax.swing.*;
import java.awt.*;

public class ProfileDuzenleme {
    NavBar nav;
    JButton kayidetBtn;
    JTextField ad, soyad, telNo, sifre;
    TextArea adres;
    String[] bilgiler = {"Ad", "Soyad", "Telefon No", "Adres", "Şifre"};


    public ProfileDuzenleme() {
        nav = new NavBar();
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(null);
        mainPanel.setBackground(new Color(251, 251, 251));

        JPanel musteriB = new JPanel();
        musteriB.setLayout(null);
        musteriB.setBackground(new Color(251, 251, 251));
        musteriB.setBorder(BorderFactory.createLineBorder(new Color(0xBEBCBC), 1));
        musteriB.setBounds(500, 50, 600, 540);

        for (int i = 0; i < bilgiler.length; i++) {
            JLabel label = new JLabel(bilgiler[i] + ":");
            label.setFont(new Font("Arial", Font.PLAIN, 20));
            if (bilgiler[i].equals("Şifre"))
                label.setBounds(20, 100 + (i * 80), 110, 25);
            else
                label.setBounds(20, 50 + (i * 80), 110, 25);
            label.setForeground(new Color(0, 0, 0));
            musteriB.add(label);
        }

        ad = new JTextField(" M.Malik");
        ad.setFont(new Font("Poppins", Font.BOLD, 16));
        ad.setBackground(new Color(0xE7E7E7));
        ad.setBorder(BorderFactory.createLineBorder(new Color(0x919191), 1));
        ad.setBounds(140, 30, 380, 50);
        ad.setEditable(false);
        musteriB.add(ad);

        soyad = new JTextField(" ELHIDIR");
        soyad.setFont(new Font("Poppins", Font.BOLD, 16));
        soyad.setBackground(new Color(0xE7E7E7));
        soyad.setBorder(BorderFactory.createLineBorder(new Color(0x919191), 1));
        soyad.setBounds(140, 110, 380, 50);
        soyad.setEditable(false);
        musteriB.add(soyad);

        telNo = new JTextField("  ");
        telNo.setFont(new Font("Poppins", Font.BOLD, 16));
        telNo.setBackground(new Color(0xE7E7E7));
        telNo.setBorder(BorderFactory.createLineBorder(new Color(0x919191), 1));
        telNo.setBounds(140, 190, 380, 50);
        musteriB.add(telNo);

        adres = new TextArea(" ");
        adres.setFont(new Font("Poppins", Font.BOLD, 16));
        adres.setBackground(new Color(0xE7E7E7));
        adres.setBounds(140, 270, 380, 100);
        musteriB.add(adres);

        sifre = new JTextField("  ");
        sifre.setFont(new Font("Poppins", Font.BOLD, 16));
        sifre.setBackground(new Color(0xE7E7E7));
        sifre.setBorder(BorderFactory.createLineBorder(new Color(0x919191), 1));
        sifre.setBounds(140, 400, 380, 50);
        musteriB.add(sifre);

        kayidetBtn = new JButton("Kaydet");
        kayidetBtn.setBounds(380, 480, 140, 40);
        kayidetBtn.setForeground(new Color(0xF4F4F4));
        kayidetBtn.setBackground(new Color(0xFA6930));
        kayidetBtn.setFont(new Font("Poppins", Font.BOLD, 16));
        musteriB.add(kayidetBtn);

        mainPanel.add(musteriB);
        MainFrame main = new MainFrame();
        main.add(nav, BorderLayout.NORTH);
        main.add(mainPanel, BorderLayout.CENTER);
    }

    public JButton getKayidetBtn() {
        return kayidetBtn;
    }

    public NavBar getNav() {
        return nav;
    }

    public JTextField getAd() {
        return ad;
    }

    public JTextField getSoyad() {
        return soyad;
    }

    public JTextField getTelNo() {
        return telNo;
    }

    public JTextField getSifre() {
        return sifre;
    }

    public TextArea getAdres() {
        return adres;
    }
}
