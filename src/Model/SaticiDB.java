package Model;

import Connection.DBConnection;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class SaticiDB {
    static public Satici saticiBilgileriGetir(DBConnection conn, int id) {
        Satici satici = new Satici();
        satici.setId(id);
        Statement statement;
        ResultSet sonuc;
        String query;
        try {
            query = "SELECT * FROM Satici WHERE id =" + id + " ";
            statement = conn.getConnection().createStatement();
            sonuc = statement.executeQuery(query);
            if (sonuc.next()) {
                String ad = sonuc.getString("ad");
                String soyad = sonuc.getString("soyad");
                String eposta = sonuc.getString("eposta");
                String sifre = sonuc.getString("sifre");
                String adres = sonuc.getString("adres");
                String telNo = sonuc.getString("tel_no");
                ArrayList<Urun> urunler = saticiUrunleriGetir(conn, satici);
                satici = new Satici(id, ad, soyad, eposta, sifre, adres, telNo, urunler);
            }
            return satici;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    static public ResultSet saticiBilgileriGetir(DBConnection conn, String mail) {
        Statement statement;
        ResultSet sonuc;
        String query;
        try {
            query = "SELECT * FROM Satici WHERE eposta =" + mail + " ";
            statement = conn.getConnection().createStatement();
            sonuc = statement.executeQuery(query);
            return sonuc;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    static private ArrayList<Urun> saticiUrunleriGetir(DBConnection conn, Satici satici) {
        ArrayList<Urun> urunler = new ArrayList<>();
        Statement statement;
        ResultSet sonuc;
        String query;
        try {
            query = "SELECT * FROM Urun WHERE satici_id = " + satici.getId() + " ";
            statement = conn.getConnection().createStatement();
            sonuc = statement.executeQuery(query);
            while (sonuc.next()) {
                int id = sonuc.getInt("id");
                String ad = sonuc.getString("ad");
                int miktar = sonuc.getInt("miktar");
                float fiyat = sonuc.getFloat("fiyat");
                Kategori kategori = KategoriDB.kategriGetir(conn, sonuc.getInt("katogori_id"));
                Urun urun = new Urun(id, satici, ad, fiyat, kategori, miktar);
                urunler.add(urun);
            }
            return urunler;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
}
