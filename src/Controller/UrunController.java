package Controller;

import Connection.DBConnection;
import Model.*;
import View.UrunlerList;

import javax.swing.*;
import java.sql.ResultSet;
import java.util.ArrayList;

public class UrunController {
    UrunlerList view;

    public UrunController() {}

    public UrunController(UrunlerList view) {
        this.view = view;
        addKategories();
    }

    private void addKategories() {
        String[] kategoriler = KategoriDB.kategorileriGetir(DBConnection.getInstance());
        for (String s : kategoriler) {
            view.getKategori().addItem(s);
        }
    }

    public void urunEkle() {
        DBConnection conn = DBConnection.getInstance();
        try {
            ResultSet sonuc = UrunDB.urunBilgileriGetir(conn);
            while (sonuc.next()) {
                int id = sonuc.getInt("id");
                String ad = sonuc.getString("ad");
                int miktar = sonuc.getInt("miktar");
                float fiyat = sonuc.getFloat("fiyat");
                Satici satici = SaticiDB.saticiBilgileriGetir(conn, sonuc.getInt("satici_id"));
                Kategori kategori = KategoriDB.kategriGetir(conn, sonuc.getInt("katogori_id"));
                view.getUrunler().add(new Urun(id, satici, ad, fiyat, kategori, miktar));
            }
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}
