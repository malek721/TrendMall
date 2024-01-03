package Model;

public class KartOdeme extends Odeme{
    private String kartNo;
    private String kartSahibiAdi;
    private String sonKullanmaTarihi;
    private int cvv;

    public KartOdeme(int id, float odemTutar, String odemTarihi, String kartNo, String kartSahibiAdi, String sonKullanmaTarihi, int cvv) {
        super(id, odemTutar, odemTarihi);
        this.kartNo = kartNo;
        this.kartSahibiAdi = kartSahibiAdi;
        this.sonKullanmaTarihi = sonKullanmaTarihi;
        this.cvv = cvv;
    }

    public String getKartNo() {
        return kartNo;
    }

    public void setKartNo(String kartNo) {
        this.kartNo = kartNo;
    }

    public String getKartSahibiAdi() {
        return kartSahibiAdi;
    }

    public void setKartSahibiAdi(String kartSahibiAdi) {
        this.kartSahibiAdi = kartSahibiAdi;
    }

    public String getSonKullanmaTarihi() {
        return sonKullanmaTarihi;
    }

    public void setSonKullanmaTarihi(String sonKullanmaTarihi) {
        this.sonKullanmaTarihi = sonKullanmaTarihi;
    }

    public int getCvv() {
        return cvv;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
    }
}
