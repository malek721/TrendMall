package Model;

import java.util.ArrayList;

public class Satici implements Kullanici {
    private int id;
    private SaticiBilgileri sb;

    public Satici(){}

    public Satici (int id, String ad, String soyad, String eposta, String sifre, String adres, String telNo, ArrayList<Urun> urunler) {
        this.id = id;
        sb = new SaticiBilgileri(ad,soyad,eposta,sifre,adres,telNo, urunler);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public SaticiBilgileri getSb() {
        return sb;
    }

    public void setSb(SaticiBilgileri sb) {
        this.sb = sb;
    }
}
