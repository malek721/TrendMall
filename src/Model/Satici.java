package Model;

public class Satici implements Kullanici {
    int id;
    SaticiBilgileri sb;

    public Satici (int id, String ad, String soyad, String eposta, String sifre, String adres, String telNo) {
        this.id = id;
        sb = new SaticiBilgileri(ad,soyad,eposta,sifre,adres,telNo);
    }
}
