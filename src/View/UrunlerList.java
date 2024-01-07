package View;

import Controller.UrunController;
import Model.Urun;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class UrunlerList {
    JPanel urunList;
    MainFrame main;
    ArrayList<Urun> urunler;
    JTextField urunArayin;
    JComboBox<String> kategori;

    public UrunlerList() {
        NavBar nav = new NavBar();
        JPanel mainContent = new JPanel();
        mainContent.setLayout(null);
        mainContent.setBackground(new Color(251, 251, 251));
        kategori = new JComboBox<>(new String[]{"Katogori Seç"});
        kategori.setBackground(new Color(0xF7F7F7));
        kategori.setFont(new Font("Inter", Font.PLAIN, 20));
        kategori.setBounds(1071, 52, 290, 60);
        urunArayin = new JTextField("  Ürün Arayın");
        urunArayin.setBackground(new Color(0xD9D9D9));
        urunArayin.setForeground(new Color(0x5A5959));
        urunArayin.setFont(new Font("Inter", Font.PLAIN, 24));
        urunArayin.setBorder(null);
        urunArayin.setBounds(130, 52, 430, 55);
        urunList  = new JPanel(new FlowLayout(FlowLayout.LEADING, 5, 30));
        urunList.setBackground(new Color(0xFBFBFB));
        urunList.setBounds(58, 188, 1450, 450);
        urunler = new ArrayList<>();
        for (Urun urun : urunler) {
            String saticiAd = urun.getSatici().getSb().getAd();
            String urunAd = urun.getAd();
            String fiyat = String.valueOf(urun.getFiyat());
            UrunDisplay urunDisplay = new UrunDisplay(saticiAd, urunAd, fiyat);
            urunList.add(urunDisplay);
        }
        mainContent.add(urunList);
        mainContent.add(kategori);
        mainContent.add(urunArayin);
        main = new MainFrame();
        main.add(nav, BorderLayout.NORTH);
        main.add(mainContent, BorderLayout.CENTER);

    }

    public void urunEkle(){
        urunList.removeAll();
        UrunController controller = new UrunController();
        controller.urunEkle();
        main.revalidate();
        main.repaint();
    }


    public JTextField getUrunArayin() {
        return urunArayin;
    }

    public void setUrunArayin(JTextField urunArayin) {
        this.urunArayin = urunArayin;
    }

    public JComboBox<String> getKategori() {
        return kategori;
    }

    public ArrayList<Urun> getUrunler() {
        return urunler;
    }
}
