package View;

import Controller.OdemeController;
import Controller.SepetController;
import Controller.UrunListController;
import Model.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class UrunlerList implements ActionListener {
    NavBar nav;
    JPanel urunList;
    MainFrame main = new MainFrame();
    ;
    ArrayList<Urun> urunler;
    JComboBox<String> kategori;

    public UrunlerList() {
        nav = new NavBar();
        nav.getSepet().addActionListener(this);
        JPanel mainContent = new JPanel();
        mainContent.setLayout(null);
        mainContent.setBackground(new Color(251, 251, 251));
        kategori = new JComboBox<>(new String[]{"Katogori Seç"});
        kategori.setBackground(new Color(0xF7F7F7));
        kategori.setFont(new Font("Inter", Font.PLAIN, 20));
        kategori.setBounds(1071, 52, 290, 60);
        kategori.addActionListener(this);
        urunList = new JPanel(new FlowLayout(FlowLayout.LEADING, 5, 30));
        urunList.setBackground(new Color(0xFBFBFB));
        urunlerGoster(kategori.getSelectedItem().toString());
        JScrollPane scroll = new JScrollPane(urunList);
        scroll.setBounds(58, 300, 1450, 300);
        mainContent.add(scroll);
        mainContent.add(kategori);
        main.add(nav, BorderLayout.NORTH);
        main.add(mainContent, BorderLayout.CENTER);

    }

    public MainFrame getMain() {
        return main;
    }

    public JComboBox<String> getKategori() {
        return kategori;
    }

    public void urunlerGoster(String kategori) {
        urunList.removeAll();
        urunler = UrunListController.urunEkle(kategori);
        Musteri m = new Musteri(2, "Amr", "Walidi","amr.nawaf128@gmail.com","Amr_Nawaf128","İstanbul/Türkiye", "5369922950");
        for (Urun urun : urunler) {
            Sepet sepet = Sepet.getInstance(m);
            SepetController controller = new SepetController(sepet, new UrunDisplay(urun));
            controller.getView().getSimdiAl().addActionListener(e -> main.dispose());
            controller.getView().getSimdiAl().addActionListener(e ->
                    new OdemeController(new Odeme(), new KartOdeme(),
                            new OdemeSayfa(urun.getFiyat())
                    )
            );
            urunList.add(controller.getView());
        }
        main.revalidate();
        main.repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == kategori) {
            String selectedKategori = kategori.getSelectedItem().toString();
            urunlerGoster(selectedKategori);
        }
        if(e.getSource() == nav.getSepet()) {
            new SepetSayfa(Sepet.getInstance());
            main.dispose();
        }
    }

}
