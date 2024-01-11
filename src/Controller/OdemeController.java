package Controller;

import Connection.DBConnection;
import Model.DatabaseOperations.IndirimKodDB;
import Model.DatabaseOperations.MusteriDB;
import Model.DatabaseOperations.OdemeDB;
import Model.DatabaseOperations.SiparisDB;
import Model.KartOdeme;
import Model.Musteri;
import Model.Odeme;
import Model.Urun;
import View.OdemeSayfa;

import java.sql.ResultSet;
import java.time.LocalDate;

public class OdemeController {
    static DBConnection conn;
    private Odeme modelOdeme;
    private KartOdeme modelKartOdeme;
    private final OdemeSayfa view;

    public OdemeController(Odeme modelOdeme, KartOdeme modelKartOdeme, OdemeSayfa view) {
        this.modelOdeme = modelOdeme;
        this.modelKartOdeme = modelKartOdeme;
        this.view = view;
        conn = DBConnection.getInstance();
        view.getOdemeYap().addActionListener(e -> odemeBilgileriKaydet());
        view.getKodUygulama().addActionListener(e -> indrimYap());
    }

    private void odemeBilgileriKaydet() {
        ResultSet sonuc;
        try {
            LocalDate date = LocalDate.now();
            float toplamUcret = Float.parseFloat(view.getSiparisOzeti().getToplamUcret().getText().substring(0, view.getSiparisOzeti().getToplamUcret().getText().length() - 2));
            OdemeDB.odemeBilgileriKaydet(3, toplamUcret, date);
            if (view.getSeceneklerGroupButton().getSelection().getActionCommand().equals("Kredi Kart")) {
                int id = OdemeDB.getSonOdemeID();
                String kartSahibiAdi = view.getKartSahibiAdi().getText().trim();
                String kartNo = view.getKartNo().getText().trim();
                String sonKullanmaTarihi = view.getSonYilTarihi().getSelectedItem() + "-" + view.getSonAyTarihi().getSelectedItem() + "-01";
                int cvv = Integer.parseInt(view.getCvv().getText().trim());
                OdemeDB.kartBilgileriKaydet(kartNo, kartSahibiAdi, sonKullanmaTarihi, cvv);
                modelKartOdeme = new KartOdeme(id, toplamUcret, date.toString(), kartNo, kartSahibiAdi, sonKullanmaTarihi, cvv);

            } else {
                sonuc = OdemeDB.getSonOdeme();
                if (sonuc.next()) {
                    int id = sonuc.getInt("id");
                    Musteri musteri = MusteriDB.musteriGetir(sonuc.getInt("musteri_id"));
                    float odemeTutari = sonuc.getFloat("odeme_tutari");
                    String odemeTarihi = sonuc.getString("odeme_tarihi");
                    modelOdeme = new Odeme(id, musteri, odemeTutari, odemeTarihi);
                }
            }
            siparisVer();
        } catch (Exception e) {
            System.out.println("Operation Failed");
        }
    }

    private void indrimYap() {
        String kod = view.getKod().getText().trim();
        ResultSet sonuc = IndirimKodDB.getIndirimKod(kod);
        try {
            if (sonuc.next()) {
                LocalDate date = LocalDate.now();
                if (sonuc.getDate("gecerlilik_tarihi").toLocalDate().isAfter(date)) {
                    int indirimMiktar = sonuc.getInt("indirim_miktari");
                    int uzunluk = view.getSiparisOzeti().getToplamUcret().getText().length();
                    float orjinalFiyat = Float.parseFloat(view.getSiparisOzeti().getToplamUcret().getText().substring(0, uzunluk - 2));
                    view.getSiparisOzeti().getToplamUcret().setText(orjinalFiyat - indirimMiktar + " tl");
                    IndirimKodDB.kuponKullanimiKaydet(sonuc.getString("kod"), Musteri.getInstance().getId(), date);
                } else {
                    System.out.println("Bu indirm kod gecersiz");
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private void siparisVer() {
        try {
            LocalDate date = LocalDate.now();
            for (Urun urun : view.getUrunler()) {
                SiparisDB.siparisBilgileriKaydet(Musteri.getInstance().getId(), urun.getId(), urun.getSatici().getId(), date);
            }
        } catch (Exception e) {
            System.out.println("Operation Failed");
        }
    }
}
