package Model;

public class Odeme {
    private int id;
    private float odemTutar;
    private String odemTarihi;

    public Odeme(int id, float odemeTutar, String odemeTarihi) {
        this.id = id;
        this.odemTutar = odemeTutar;
        this.odemTarihi = odemeTarihi;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
