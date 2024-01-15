package Controller;

import Model.DatabaseOperations.KategoriDB;
import Model.DatabaseOperations.SaticiDB;
import Model.DatabaseOperations.UrunDB;
import Model.*;
import View.OdemeSayfa;
import View.UrunDisplay;
import View.UrunlerList;

import java.sql.ResultSet;
import java.util.ArrayList;

public class UrunListController {
    private final Sepet sepet;

    private final UrunlerList view;

    public UrunListController(UrunlerList view, Sepet sepet) {
        this.view = view;
        this.sepet = sepet;
        addKategories();
        urunlerGoster();
        view.getKategori().addActionListener(e -> urunlerGoster());
    }

    private void addKategories() {
        String[] kategoriler = KategoriDB.kategorileriGetir();
        for (String s : kategoriler) {
            view.getKategori().addItem(s);
        }
    }

    private void urunlerGoster() {
        String kategori = view.getKategori().getSelectedItem().toString();
        view.getUrunList().removeAll();
        ArrayList<Urun> urunler = urunlerGetir(kategori);
        for (Urun urun : urunler) {
            UrunDisplay urunDisplay = new UrunDisplay(urun);
            new SepetController(sepet, urunDisplay);
            urunDisplay.getSimdiAl().addActionListener(e -> {
                ArrayList<Urun> urunList = new ArrayList<>();
                urunList.add(urun);
                new OdemeController(new Odeme(), new KartOdeme(), new OdemeSayfa(urunList));
                view.getMain().dispose();
            });
            view.getUrunList().add(urunDisplay);
        }
        view.getMain().revalidate();
        view.getMain().repaint();
    }

    private ArrayList<Urun> urunlerGetir(String kategoriAd) {
        ArrayList<Urun> urunler = new ArrayList<>();
        ResultSet sonuc;
        try {
            if (kategoriAd.equals("Katogori Seç"))
                sonuc = UrunDB.urunBilgileriGetir();
            else
                sonuc = UrunDB.urunBilgileriGetir(kategoriAd);
            while (sonuc.next()) {
                int id = sonuc.getInt("id");
                String ad = sonuc.getString("ad");
                int miktar = sonuc.getInt("miktar");
                float fiyat = sonuc.getFloat("fiyat");
                Satici satici = SaticiDB.saticiGetir(sonuc.getInt("satici_id"));
                Kategori kategori = KategoriDB.kategriGetir(sonuc.getInt("katogori_id"));
                urunler.add(new Urun(id, satici, ad, fiyat, kategori, miktar));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return urunler;
    }


}
