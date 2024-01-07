package Model;

public class Urun {
    int id;
    Satici satici;
    String ad;
    float fiyat;
    Kategori kategori;
    int miktar;

    public Urun (){

    }

    public Urun(int id, Satici satici, String ad, float fiyat, Kategori kategori, int miktar) {
        this.id = id;
        this.satici = satici;
        this.ad = ad;
        this.fiyat = fiyat;
        this.kategori = kategori;
        this.miktar = miktar;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Satici getSatici() {
        return satici;
    }

    public void setSatici(Satici satici) {
        this.satici = satici;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public float getFiyat() {
        return fiyat;
    }

    public void setFiyat(float fiyat) {
        this.fiyat = fiyat;
    }

    public Kategori getKategori() {
        return kategori;
    }

    public void setKategori(Kategori kategori) {
        this.kategori = kategori;
    }

    public int getMiktar() {
        return miktar;
    }

    public void setMiktar(int miktar) {
        this.miktar = miktar;
    }
}
