package View;

import Controller.ProfileDuzeltmeController;
import Model.Musteri;
import Model.Sepet;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NavBar extends JPanel implements ActionListener {
    private final JLabel kullaniciAdi;
    private final JButton sepet;
    private final JButton profil;

    public NavBar() {
        this.setBackground(new Color(0xFAF8F8));
        this.setPreferredSize(new Dimension(1512, 130));
        this.setBorder(BorderFactory.createLineBorder(new Color(0xCCCCCC), 1));
        this.setLayout(null);
        ImageIcon logo = new ImageIcon("img-small.png");
        JLabel logoContainer = new JLabel(logo);
        logoContainer.setBounds(58, 19, 130, 100);
        this.add(logoContainer);
        kullaniciAdi = new JLabel(Musteri.getInstance().getMb().getAd() + " " + Musteri.getInstance().getMb().getSoyad());
        kullaniciAdi.setFont(new Font("Inter", Font.BOLD, 24));
        kullaniciAdi.setForeground(new Color(0x000000));
        kullaniciAdi.setBounds(900, 47, 200, 29);
        this.add(kullaniciAdi);
        sepet = new JButton("Sepetim");
        sepet.setFont(new Font("Inter", Font.PLAIN, 24));
        sepet.setForeground(new Color(0xF4F4F4));
        sepet.setBackground(new Color(0xFA6930));
        sepet.setBounds(1184, 37, 125, 50);
        sepet.setBorder(null);
        sepet.setFocusable(false);
        sepet.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        sepet.addActionListener(this);
        profil = new JButton("Profil Düzenleme");
        profil.setBounds(1333, 37, 154, 50);
        profil.setBackground(new Color(0xD3D3D3));
        profil.setForeground(new Color(0x000000));
        profil.setFont(new Font("Inter", Font.PLAIN, 17));
        profil.setBorder(null);
        profil.setFocusable(false);
        profil.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        profil.addActionListener(this);
        this.add(profil);
        this.add(sepet);
    }

    public JLabel getKullaniciAdi() {
        return kullaniciAdi;
    }

    public JButton getSepet() {
        return sepet;
    }

    public JButton getProfil() {
        return profil;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == profil) {
            new ProfileDuzeltmeController(new ProfileDuzenleme(), Musteri.getInstance());
        }
        if (e.getSource() == sepet) {
            new SepetSayfa(Sepet.getInstance());
        }
    }
}
