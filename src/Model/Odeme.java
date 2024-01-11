package Model;

import Model.DatabaseOperations.MusteriDB;

public class Odeme {
    private int id;

    private Musteri musteri;
    private float odemTutar;
    private String odemTarihi;

    public Odeme() {
    }
    public Odeme(int id,Musteri musteri, float odemeTutar, String odemeTarihi) {
        this.id = id;
        this.musteri = musteri;
        this.odemTutar = odemeTutar;
        this.odemTarihi = odemeTarihi;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Musteri getMusteri() {
        return musteri;
    }

    public void setMusteri(Musteri musteri) {
        this.musteri = musteri;
    }

    public float getOdemTutar() {
        return odemTutar;
    }

    public void setOdemTutar(float odemTutar) {
        this.odemTutar = odemTutar;
    }

    public String getOdemTarihi() {
        return odemTarihi;
    }

    public void setOdemTarihi(String odemTarihi) {
        this.odemTarihi = odemTarihi;
    }

    public void faturaYazdir(){
        System.out.println(this.odemTarihi + " " + this.odemTutar);
    }
}
