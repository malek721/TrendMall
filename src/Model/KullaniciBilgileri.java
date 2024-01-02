package Model;

public class KullaniciBilgileri {
    private String ad;
    private String soyad;
    private String eposta;
    private String sifre;
    private String adres;
    private String telNo;

    public KullaniciBilgileri(String ad, String soyad, String eposta, String sifre, String adres, String telNo) {
        this.ad = ad;
        this.soyad = soyad;
        this.eposta = eposta;
        this.sifre = sifre;
        this.adres = adres;
        this.telNo = telNo;
    }public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getSoyad() {
        return soyad;
    }

    public void setSoyad(String soyad) {
        this.soyad = soyad;
    }

    public String getEposta() {
        return eposta;
    }

    public void setEposta(String eposta) {
        this.eposta = eposta;
    }

    public String getSifre() {
        return sifre;
    }

    public void setSifre(String sifre) {
        this.sifre = sifre;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public String getTelNo() {
        return telNo;
    }

    public void setTelNo(String telNo) {
        this.telNo = telNo;
    }
    void telefonNoDegistir(String telNo){}
    void sifreDegistir(String eskiSifre, String yeniSifre){}
    void adresDegister(String telNo){}
}
