package View;

import Controller.OdemeController;
import Model.KartOdeme;
import Model.Odeme;
import Model.Urun;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class UrunDisplay extends JPanel{
    Urun urun;
    JLabel saticiAd;
    JLabel urunAd;
    JLabel urunFiyat;
    ArrayList<Urun> urunler = new ArrayList<>();
    JButton simdiAl;
    JButton sepeteEkleBtn;

    public UrunDisplay(Urun urun) {
        this.urun = urun;
        this.setLayout(null);
        this.setPreferredSize(new Dimension(350, 160));
        this.setBackground(new Color(251, 251, 251));
        String saticiIsimi = urun.getSatici().getSb().getAd() + " " + urun.getSatici().getSb().getSoyad();
        this.saticiAd = new JLabel(saticiIsimi);
        this.saticiAd.setFont(new Font("Inter", Font.BOLD, 20));
        this.saticiAd.setForeground(Color.BLACK);
        this.saticiAd.setBounds(0, 0, 180, 30);
        this.urunAd = new JLabel(urun.getAd());
        this.urunAd.setFont(new Font("Inter", Font.PLAIN, 20));
        this.urunAd.setForeground(Color.BLACK);
        this.urunAd.setBounds(170, 0, 150, 30);
        this.urunFiyat = new JLabel(urun.getFiyat() + " tl");
        this.urunFiyat.setFont(new Font("Inter", Font.BOLD, 20));
        this.urunFiyat.setForeground(new Color(0xD95927));
        this.urunFiyat.setBounds(0, 50, 100, 30);
        simdiAl = new JButton("Şimdi Al");
        simdiAl.setFont(new Font("Inter", Font.BOLD, 14));
        simdiAl.setForeground(new Color(0xD95927));
        simdiAl.setBackground(new Color(0xF4F4F4));
        simdiAl.setBounds(0, 100, 100, 40);
        simdiAl.setBorder(BorderFactory.createLineBorder(new Color(0xD95927), 1));
        simdiAl.setFocusable(false);
        simdiAl.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        sepeteEkleBtn = new JButton("Sepete Ekle");
        sepeteEkleBtn.setBorder(null);
        sepeteEkleBtn.setFont(new Font("Inter", Font.BOLD, 14));
        sepeteEkleBtn.setForeground(new Color(0xFFFFFF));
        sepeteEkleBtn.setBackground(new Color(0xD95927));
        sepeteEkleBtn.setBounds(120, 100, 100, 40);
        sepeteEkleBtn.setFocusable(false);
        sepeteEkleBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        this.add(this.urunAd);
        this.add(this.saticiAd);
        this.add(this.urunFiyat);
        this.add(simdiAl);
        this.add(sepeteEkleBtn);
    }

    public Urun getUrun() {
        return urun;
    }

    public JButton getSimdiAl() {
        return simdiAl;
    }

    public JButton getSepeteEkleBtn() {
        return sepeteEkleBtn;
    }

}
