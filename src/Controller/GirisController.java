package Controller;

import Model.*;
import View.GirisSayfa;
import View.SaticiSatanUrunlerList;
import View.UrunlerList;

import java.awt.*;

public class GirisController {
    GirisSayfa view;
    GirisYapma model;

    public GirisController(GirisSayfa view, GirisYapma model) {
        this.view = view;
        this.model = model;
        this.view.getGirisYapButton().addActionListener(e -> getSignInMessage());
    }

    private void getSignInMessage() {
        String eposta = view.getInputs().get("E-posta").getText().trim();
        String sifre = view.getInputs().get("Şifre").getText().trim();
        boolean status = model.loggingIn(eposta, sifre);
        if (status) {
            KullaniciFactory factory = new KullaniciFactory();
            Kullanici kullanici = factory.getKullanici(eposta);
            view.getGirisFrame().dispose();
            if (kullanici instanceof Musteri)
                new UrunListController(new UrunlerList(), Sepet.getInstance((Musteri) kullanici));
            else
                new SaticiUrunController(new SaticiSatanUrunlerList((Satici) kullanici), (Satici) kullanici);

        } else {
            view.getMessage().setText("There is no user with this email or password");
            view.getMessage().setForeground(Color.RED);
        }
    }
}
