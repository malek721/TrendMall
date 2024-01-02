package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NavBar implements ActionListener {
    JPanel navBar;

    JButton sepet;
    JButton profil;

    public NavBar() {
        navBar = new JPanel();
        navBar.setBackground(new Color(0xFAF8F8));
        navBar.setPreferredSize(new Dimension(1512, 164));
        navBar.setBorder(BorderFactory.createLineBorder(new Color(0xCCCCCC), 1));
        navBar.setLayout(null);
        ImageIcon logo = new ImageIcon("img-small.png");
        JLabel logoContainer = new JLabel(logo);
        logoContainer.setBounds(58, 19, 130, 100);
        navBar.add(logoContainer);
        JLabel kullaniciAdi = new JLabel();
        kullaniciAdi.setFont(new Font("Inter", Font.BOLD, 24));
        kullaniciAdi.setForeground(new Color(0x000000));
        kullaniciAdi.setBounds(900, 67, 200, 29);
        navBar.add(kullaniciAdi);
        sepet = new JButton("Sepetim");
        sepet.setFont(new Font("Inter", Font.PLAIN, 24));
        sepet.setForeground(new Color(0xF4F4F4));
        sepet.setBackground(new Color(0xFA6930));
        sepet.setBounds(1184, 57, 125, 50);
        sepet.setBorder(null);
        sepet.addActionListener(this);
        sepet.setFocusable(false);
        sepet.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        profil = new JButton("Profil Düzenleme");
        profil.setBounds(1333, 57, 154, 50);
        profil.setBackground(new Color(0xD3D3D3));
        profil.setForeground(new Color(0x000000));
        profil.setFont(new Font("Inter", Font.PLAIN, 17));
        profil.setBorder(null);
        profil.setFocusable(false);
        profil.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        profil.addActionListener(this);
        navBar.add(profil);
        navBar.add(sepet);
    }

        @Override
        public void actionPerformed(ActionEvent e) {

        }
}
