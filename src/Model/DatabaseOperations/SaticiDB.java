package Model.DatabaseOperations;

import Connection.DBConnection;
import Model.DatabaseOperations.KategoriDB;
import Model.Kategori;
import Model.Satici;
import Model.Urun;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class SaticiDB {
    private static final DBConnection conn = DBConnection.getInstance();

    static public Satici saticiGetir(int id) {
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
                ArrayList<Urun> urunler = saticiUrunleriGetir(satici);
                satici = new Satici(id, ad, soyad, eposta, sifre, adres, telNo, urunler);
            }
            return satici;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    static public ArrayList<Urun> saticiUrunleriGetir(Satici satici) {
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
                Kategori kategori = KategoriDB.kategriGetir(sonuc.getInt("katogori_id"));
                Urun urun = new Urun(id, satici, ad, fiyat, kategori, miktar);
                urunler.add(urun);
            }
            return urunler;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    static public void adresDegistir(int id, String newAdres) {
        Statement statement;
        String query;
        try {
            query = "Update Satici set adres = '" + newAdres + "' WHERE id = " + id + " ";
            statement = conn.getConnection().createStatement();
            statement.executeUpdate(query);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    static public void telNoDegistir(int id, String newTelNo) {
        Statement statement;
        String query;
        try {
            query = "Update Satici set tel_no = '" + newTelNo + "' WHERE id = " + id + " ";
            statement = conn.getConnection().createStatement();
            statement.executeUpdate(query);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    static public void sifreDegistir(int id, String newSifre) {
        Statement statement;
        String query;
        try {
            query = "Update Satici set sifre = '" + newSifre + "' WHERE id = " + id + " ";
            statement = conn.getConnection().createStatement();
            statement.executeUpdate(query);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
