package Model;

import Model.DatabaseOperations.SaticiDB;

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

    @Override
    public void telefonNoDegistir(String telNo) {
        if (telNo.charAt(0) == '5' && telNo.length() == 10 && telNo.matches("\\d+")) {
            SaticiDB.telNoDegistir(id, telNo);
            sb.setTelNo(telNo);
        }
    }

    @Override
    public void sifreDegistir(String yeniSifre) {
        if (yeniSifre.length() > 6 && yeniSifre.length() < 16) {
            SaticiDB.sifreDegistir(id, yeniSifre);
            sb.setTelNo(yeniSifre);
        }
    }

    @Override
    public void adresDegister(String telNo) {
        SaticiDB.adresDegistir(id, telNo);
        sb.setTelNo(telNo);
    }
}
