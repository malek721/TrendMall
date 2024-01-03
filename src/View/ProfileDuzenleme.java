package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProfileDuzenleme implements ActionListener {
        JButton cikisBtn,donBtn,kayidetBtn;
        JTextField ad,soyad,Tel_no,sifre;
        TextArea adres;
        String[] bilgiler = {"Ad","Soyad","Telefon No","Adres","Şifre"};


    public ProfileDuzenleme(){
        NavBar nav = new NavBar();
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(null);
        mainPanel.setBackground(new Color(251, 251, 251));

        JPanel musteriB = new JPanel();
        musteriB.setLayout(null);
        musteriB.setBackground(new Color(251, 251, 251));
        musteriB.setBorder(BorderFactory.createLineBorder(new Color(0xBEBCBC), 1));
        musteriB.setBounds(500, 50, 600, 540);

        for (int i = 0; i < bilgiler.length; i++) {
            JLabel label = new JLabel(bilgiler[i]+":");
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

        Tel_no = new JTextField("  ");
        Tel_no.setFont(new Font("Poppins", Font.BOLD, 16));
        Tel_no.setBackground(new Color(0xE7E7E7));
        Tel_no.setBorder(BorderFactory.createLineBorder(new Color(0x919191), 1));
        Tel_no.setBounds(140, 190, 380, 50);
        musteriB.add(Tel_no);

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

        mainPanel.add(musteriB);
        MainFrame main = new MainFrame();
        main.add(nav, BorderLayout.NORTH);
        main.add(mainPanel, BorderLayout.CENTER);
        }





    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
