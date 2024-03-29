package Controller;

import Model.Musteri;
import Model.Sepet;
import Model.DatabaseOperations.SepetDB;
import Model.Urun;
import View.UrunDisplay;

public class SepetController {
    static private Sepet model;
    private final UrunDisplay view;

    public SepetController(Sepet model, UrunDisplay view) {
        SepetController.model = model;
        this.view = view;
        view.getSepeteEkleBtn().addActionListener(e -> sepeteEkle());
    }

    private void sepeteEkle() {
        Urun urun = view.getUrun();
        if (model.getUrunler().isEmpty()) {
            SepetDB.bosSepeteEkle(Musteri.getInstance().getId(), urun.getId(), urun.getFiyat());
            model.urunEkle(urun);
        } else {
            boolean isContains = false;
            for (Urun u : model.getUrunler()) {
                if (u.getId() == urun.getId()) {
                    isContains = true;
                    break;
                }
            }
            if (!isContains) {
                SepetDB.sepeteEkle(Musteri.getInstance().getId(), urun.getId(), urun.getFiyat());
                model.urunEkle(urun);
            }
        }
    }

    static public void sepettenKaldir(Urun urun) {
        SepetDB.sepettenKaldir(Musteri.getInstance().getId(), urun.getId(), urun.getFiyat());
        model.urunKaldir(urun);
    }
}
