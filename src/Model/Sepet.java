package Model;

import Model.DatabaseOperations.SepetDB;
import Model.DatabaseOperations.UrunDB;

import java.util.ArrayList;

public class Sepet {
    private Musteri musteri;
    private ArrayList<Urun> urunler;
    private float toplamUcret;

    static private Sepet sepet;

    private Sepet() {}

    private Sepet(Musteri musteri) {
        this.musteri = musteri;
        this.urunler = UrunDB.urunlerGetir(SepetDB.getUrulerId(musteri));
        toplamUcretHsaaplama();
    }

    static public Sepet getInstance(Musteri m) {
        if (sepet == null) {
            sepet = new Sepet(m);
        }
        return sepet;
    }

    static public Sepet getInstance() {
        if (sepet == null) {
            sepet = new Sepet();
        }
        return sepet;
    }

    public void urunEkle(Urun urun) {
        urunler.add(urun);
        toplamUcretHsaaplama();
    }

    public void urunKaldir(Urun urun) {
        urunler.remove(urun);
        toplamUcretHsaaplama();
    }

    private void toplamUcretHsaaplama() {
        float toplamUcret = 0;
        for (Urun urun : urunler) {
            toplamUcret += urun.getFiyat();
        }
        this.toplamUcret = toplamUcret;
    }



    public Musteri getMusteri() {
        return musteri;
    }

    public void setMusteri(Musteri musteri) {
        this.musteri = musteri;
    }

    public ArrayList<Urun> getUrunler() {
        return urunler;
    }

    public void setUrunler(ArrayList<Urun> urunler) {
        this.urunler = urunler;
    }

    public float getToplamUcret() {
        return toplamUcret;
    }

    public void setToplamUcret(float toplamUcret) {
        this.toplamUcret = toplamUcret;
    }
}
