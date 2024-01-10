package Controller;

import Connection.DBConnection;
import Model.*;
import View.UrunDisplay;
import View.UrunlerList;

import java.sql.ResultSet;
import java.util.ArrayList;

public class UrunListController {

    private static DBConnection conn = DBConnection.getInstance();
    private static UrunlerList view;

    public UrunListController(UrunlerList view) {
        UrunListController.view = view;
        addKategories();
    }

    private void addKategories() {
        String[] kategoriler = KategoriDB.kategorileriGetir(DBConnection.getInstance());
        for (String s : kategoriler) {
            view.getKategori().addItem(s);
        }
    }

    static public ArrayList<Urun> urunEkle(String kategoriAd) {
        ArrayList<Urun> urunler = new ArrayList<>();
        ResultSet sonuc;
        try {
            if(kategoriAd.equals("Katogori Seç"))
                sonuc = UrunDB.urunBilgileriGetir(conn);
            else
                sonuc = UrunDB.urunBilgileriGetir(conn, kategoriAd);
            while (sonuc.next()) {
                int id = sonuc.getInt("id");
                String ad = sonuc.getString("ad");
                int miktar = sonuc.getInt("miktar");
                float fiyat = sonuc.getFloat("fiyat");
                Satici satici = SaticiDB.saticiBilgileriGetir(conn, sonuc.getInt("satici_id"));
                Kategori kategori = KategoriDB.kategriGetir(conn, sonuc.getInt("katogori_id"));
                urunler.add(new Urun(id, satici, ad, fiyat, kategori, miktar));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return urunler;
    }


}
