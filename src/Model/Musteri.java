package Model;

import Model.DatabaseOperations.MusteriDB;

public class Musteri implements Kullanici {
    int id;
    MusteriBilgileri mb;

    private static Musteri musteri;

    private Musteri() {
    }

    private Musteri(int id, String ad, String soyad, String eposta, String sifre, String adres, String telNo) {
        this.id = id;
        mb = new MusteriBilgileri(ad, soyad, eposta, sifre, adres, telNo);
    }

    static public Musteri getInstance(int id, String ad, String soyad, String eposta, String sifre, String adres, String telNo) {
        if (musteri == null) {
            musteri = new Musteri(id, ad, soyad, eposta, sifre, adres, telNo);
        }
        return musteri;
    }

    static public Musteri getInstance() {
        if (musteri == null) {
            musteri = new Musteri();
        }
        return musteri;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public MusteriBilgileri getMb() {
        return mb;
    }

    @Override
    public void telefonNoDegistir(String telNo) {
        if (telNo.charAt(0) == '5' && telNo.length() == 10 && telNo.matches("\\d+")) {
            MusteriDB.telNoDegistir(id, telNo);
            mb.setTelNo(telNo);
        }
    }

    @Override
    public void sifreDegistir(String yeniSifre) {
        if (yeniSifre.length() > 6 && yeniSifre.length() < 16) {
            MusteriDB.sifreDegistir(id, yeniSifre);
            mb.setTelNo(yeniSifre);
        }
    }

    @Override
    public void adresDegister(String telNo) {
        MusteriDB.adresDegistir(id, telNo);
        mb.setTelNo(telNo);
    }
}
