package Controller;

import Model.*;
import Model.DatabaseOperations.SaticiDB;
import View.*;

import java.util.ArrayList;

public class SaticiUrunController {
    private Satici satici;
    private final SaticiSatanUrunlerList view;

    public SaticiUrunController(SaticiSatanUrunlerList view, Satici satici) {
        this.view = view;
        this.satici = satici;
        urunlerGoster();
        view.getSaticiNavBar().getKullaniciAdi().setText(satici.getSb().getAd() + " " + satici.getSb().getSoyad());
    }

    private void urunlerGoster() {
        ArrayList<Urun> urunler = SaticiDB.saticiUrunleriGetir(satici);
        for (Urun urun : urunler) {
            SaticiUrunDisplay urunDisplay = new SaticiUrunDisplay(urun);
            urunDisplay.getUrunDuzeltleme().addActionListener(e -> {

                view.getMain().dispose();
            });
            view.getUrunList().add(urunDisplay);
        }
    }
}
