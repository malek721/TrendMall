package View;

import Controller.ProfileDuzeltmeController;
import Controller.UrunEkleController;
import Model.Satici;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SaticiNavBar extends JPanel implements ActionListener {
    private final Satici satici;
    private final JButton urunEkle;
    private final JButton profil;

    public SaticiNavBar(Satici satici) {
        this.satici = satici;
        this.setBackground(new Color(0xFAF8F8));
        this.setPreferredSize(new Dimension(1512, 130));
        this.setBorder(BorderFactory.createLineBorder(new Color(0xCCCCCC), 1));
        this.setLayout(null);
        ImageIcon logo = new ImageIcon("img-small.png");
        JLabel logoContainer = new JLabel(logo);
        logoContainer.setBounds(58, 19, 130, 100);
        this.add(logoContainer);
        JLabel kullaniciAdi = new JLabel(satici.getSb().getAd() + " " + satici.getSb().getSoyad());
        kullaniciAdi.setFont(new Font("Inter", Font.BOLD, 24));
        kullaniciAdi.setForeground(new Color(0x000000));
        kullaniciAdi.setBounds(900, 47, 200, 29);
        this.add(kullaniciAdi);
        urunEkle = new JButton("Ürün Ekle");
        urunEkle.setFont(new Font("Inter", Font.PLAIN, 24));
        urunEkle.setForeground(new Color(0xF4F4F4));
        urunEkle.setBackground(new Color(0xFA6930));
        urunEkle.setBounds(1184, 37, 125, 50);
        urunEkle.setBorder(null);
        urunEkle.setFocusable(false);
        urunEkle.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        urunEkle.addActionListener(this);
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
        this.add(urunEkle);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == profil) {
            new ProfileDuzeltmeController(new ProfileDuzenleme(), satici);
        }
        if (e.getSource() == urunEkle) {
            new UrunEkleController(new UrunEklemeSayfa(satici), satici);
        }
    }
}
