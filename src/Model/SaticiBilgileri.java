package Model;

import java.util.ArrayList;

public class SaticiBilgileri extends KullaniciBilgileri {
    ArrayList<Urun> urunler;
    public SaticiBilgileri(String ad, String soyad, String eposta, String sifre, String adres, String telNo, ArrayList<Urun> urunler) {
        super(ad, soyad, eposta, sifre, adres, telNo);
        this.urunler = urunler;
    }

    public ArrayList<Urun> getUrunler() {
        return urunler;
    }

    public void setUrunler(ArrayList<Urun> urunler) {
        this.urunler = urunler;
    }
}
