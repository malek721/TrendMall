package Controller;

import Model.DatabaseOperations.UrunDB;
import Model.Urun;
import View.UrunDuzeltmeSayfa;

public class UrunDuzeltmeController {
    private final UrunDuzeltmeSayfa view;
    private final Urun urun;

    public UrunDuzeltmeController(UrunDuzeltmeSayfa view, Urun urun) {
        this.view = view;
        this.urun = urun;
        urunBilgileriYazdir();
        view.getKayidetBtn().addActionListener(e -> urunBilgileriGuncelle());
    }

    private void urunBilgileriYazdir() {
        view.getUrunAdi().setText(urun.getAd());
        view.getKatogori().setText(urun.getKategori().getAd());
        view.getFiyat().setText(String.valueOf(urun.getFiyat()));
        view.getMiktar().setText(String.valueOf(urun.getMiktar()));
    }

    private void urunBilgileriGuncelle() {
        int newMiktar = Integer.parseInt(view.getMiktar().getText());
        float newFiyat = Float.parseFloat(view.getFiyat().getText());
        UrunDB.urunBilgileriKaydet(urun.getId(), newMiktar, newFiyat);
        urun.setMiktar(newMiktar);
        urun.setFiyat(newFiyat);
    }
}
