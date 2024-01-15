package Controller;

import Model.DatabaseOperations.SaticiDB;
import Model.Satici;
import Model.Urun;
import View.SaticiSatanUrunlerList;
import View.SaticiUrunDisplay;
import View.UrunDuzeltmeSayfa;

import java.util.ArrayList;

public class SaticiUrunController {
    private Satici satici;
    private final SaticiSatanUrunlerList view;

    public SaticiUrunController(SaticiSatanUrunlerList view, Satici satici) {
        this.view = view;
        this.satici = satici;
        urunlerGoster();
    }

    private void urunlerGoster() {
        ArrayList<Urun> urunler = SaticiDB.saticiUrunleriGetir(satici);
        for (Urun urun : urunler) {
            SaticiUrunDisplay urunDisplay = new SaticiUrunDisplay(urun);
            urunDisplay.getUrunDuzeltleme().addActionListener(e -> {
                new UrunDuzeltmeController(new UrunDuzeltmeSayfa(satici), urun);
                view.getMain().dispose();
            });
            view.getUrunList().add(urunDisplay);
        }
    }
}
