package Controller;

import Model.Musteri;
import Model.Sepet;
import Model.DatabaseOperations.SepetDB;
import Model.Urun;
import View.UrunDisplay;

public class SepetController {
    static private Sepet model;
    private UrunDisplay view;

    public SepetController(Sepet model, UrunDisplay view) {
        SepetController.model = model;
        this.view = view;
        view.getSepeteEkleBtn().addActionListener(e -> sepeteEkle(view.getUrun()));
    }

    private void sepeteEkle(Urun urun) {
        if (model.getUrunler().isEmpty()) {
            SepetDB.bosSepeteEkle(Musteri.getInstance().getId(), urun.getId(), urun.getFiyat());
            model.urunEkle(urun);
        } else if (!model.getUrunler().contains(urun)) {
            SepetDB.sepeteEkle(Musteri.getInstance().getId(), urun.getId(), urun.getFiyat());
            model.urunEkle(urun);
        }
    }

    static public void sepettenKaldir(Urun urun) {
        SepetDB.sepettenKaldir(Musteri.getInstance().getId(), urun.getId(), urun.getFiyat());
        model.urunKaldir(urun);
    }
}
