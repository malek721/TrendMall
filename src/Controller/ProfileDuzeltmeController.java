package Controller;

import Model.Kullanici;
import Model.Musteri;
import Model.Satici;
import View.ProfileDuzenleme;

public class ProfileDuzeltmeController {
    private final ProfileDuzenleme view;
    private final Kullanici kullanici;

    public ProfileDuzeltmeController(ProfileDuzenleme view, Kullanici kullanici) {
        this.view = view;
        this.kullanici = kullanici;
        bilgileriGetir();
        view.getKayidetBtn().addActionListener(e -> bilgileriKaydet());
        if (kullanici instanceof Satici)
            view.getNav().getSepet().setVisible(false);
    }

    private void bilgileriGetir() {

        if (kullanici instanceof Musteri) {
            view.getAd().setText(((Musteri) kullanici).getMb().getAd());
            view.getSoyad().setText(((Musteri) kullanici).getMb().getSoyad());
            view.getAdres().setText(((Musteri) kullanici).getMb().getAdres());
            view.getTelNo().setText(((Musteri) kullanici).getMb().getTelNo());
            view.getSifre().setText(((Musteri) kullanici).getMb().getSifre());
        } else {
            view.getAd().setText(((Satici) kullanici).getSb().getAd());
            view.getSoyad().setText(((Satici) kullanici).getSb().getSoyad());
            view.getAdres().setText(((Satici) kullanici).getSb().getAdres());
            view.getTelNo().setText(((Satici) kullanici).getSb().getTelNo());
            view.getSifre().setText(((Satici) kullanici).getSb().getSifre());
        }
    }

    private void bilgileriKaydet() {
        String adres = view.getAdres().getText();
        String telNo = view.getTelNo().getText();
        String sifre = view.getSifre().getText();

        kullanici.adresDegister(adres);
        kullanici.telefonNoDegistir(telNo);
        kullanici.sifreDegistir(sifre);
    }
}
