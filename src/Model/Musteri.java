package Model;

public class Musteri implements Kullanici {
    int id;
    MusteriBilgileri mb;

    public Musteri(int id, String ad, String soyad, String eposta, String sifre, String adres, String telNo) {
        this.id = id;
        mb = new MusteriBilgileri(ad,soyad,eposta,sifre,adres,telNo);
    }

    public int getId() {
        return id;
    }

    public MusteriBilgileri getMb() {
        return mb;
    }
}
