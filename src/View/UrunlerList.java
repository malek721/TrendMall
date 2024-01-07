package View;

import Controller.UrunController;
import Model.Kategori;
import Model.Urun;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class UrunlerList implements ActionListener {
    JPanel urunList;
    MainFrame main = new MainFrame();;
    ArrayList<Urun> urunler;
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
        kategori.addActionListener(this);
        urunList  = new JPanel(new FlowLayout(FlowLayout.LEADING, 5, 30));
        urunList.setBackground(new Color(0xFBFBFB));
        urunlerGoster(kategori.getSelectedItem().toString());
        JScrollPane scroll = new JScrollPane(urunList);
        scroll.setBounds(58, 300, 1450, 300);
        mainContent.add(scroll);
        mainContent.add(kategori);
        main.add(nav, BorderLayout.NORTH);
        main.add(mainContent, BorderLayout.CENTER);

    }
    public void urunlerGoster(String kategori){
        urunList.removeAll();
        urunler = UrunController.urunEkle(kategori);
        for (Urun urun : urunler) {
            String saticiAd = urun.getSatici().getSb().getAd()+ " " + urun.getSatici().getSb().getSoyad();
            String urunAd = urun.getAd();
            String fiyat = String.valueOf(urun.getFiyat());
            UrunDisplay urunDisplay = new UrunDisplay(saticiAd, urunAd, fiyat);
            urunList.add(urunDisplay);
        }
        main.revalidate();
        main.repaint();
    }

    public JComboBox<String> getKategori() {
        return kategori;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == kategori){
            String selectedKategori = kategori.getSelectedItem().toString();
            urunlerGoster(selectedKategori);
        }
    }
}
