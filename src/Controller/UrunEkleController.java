package Controller;

import Model.DatabaseOperations.KategoriDB;
import Model.DatabaseOperations.UrunDB;
import Model.Kategori;
import Model.Satici;
import Model.Urun;
import View.UrunEklemeSayfa;

import java.sql.ResultSet;

public class UrunEkleController {

    private final UrunEklemeSayfa view;
    private final Satici satici;

    public UrunEkleController(UrunEklemeSayfa view, Satici satici) {
        this.view = view;
        this.satici = satici;
        view.getKayidetBtn().addActionListener(e -> urunEkle());
    }

    public void urunEkle() {
        String urunAd = view.getUrunAdi().getText().trim();
        int katogoriId = KategoriDB.kategriIdGetir(view.getKatogori().getText().trim());
        int miktar = Integer.parseInt(view.getMiktar().getText().trim());
        float fiyat = Float.parseFloat(view.getFiyat().getText().trim());
        UrunDB.urunEkle(satici.getId(), urunAd, katogoriId, miktar, fiyat);
        try {
            ResultSet sonuc = UrunDB.sonUrunGetir();
            if (sonuc.next()) {
                int id = sonuc.getInt("id");
                String name = sonuc.getString("ad");
                int amount = sonuc.getInt("miktar");
                float price = sonuc.getFloat("fiyat");
                Kategori kategori = KategoriDB.kategriGetir(sonuc.getInt("katogori_id"));

                Urun urun = new Urun(id, satici, name, price, kategori, amount);
                satici.getSb().getUrunler().add(urun);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
