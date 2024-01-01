package Model;

import Connection.DBConnection;

import java.sql.ResultSet;
import java.sql.Statement;

public class KullaniciFactory implements KullaniciFactoryI {
    @Override
    public Kullanici getKullanici(String eposta) {
        DBConnection conn = DBConnection.getInstance();
        Statement statement;
        String query;
        ResultSet sonuc;
        try {
            query = "SELECT * FROM Musteri WHERE eposta = '" + eposta + "'";
            statement = conn.getConnection().createStatement();
            sonuc = statement.executeQuery(query);
            if (sonuc.next()) {
                int id = Integer.parseInt(sonuc.getString("id"));
                String ad = sonuc.getString("ad");
                String soyad = sonuc.getString("soyad");
                String sifre = sonuc.getString("sifre");
                String adres = sonuc.getString("adres");
                String telNo = sonuc.getString("tel_no");
                return new Musteri(id, ad, soyad, eposta, sifre, adres, telNo);
            }
            query = "SELECT * FROM Satici WHERE eposta = '" + eposta + "'";
            statement = conn.getConnection().createStatement();
            sonuc = statement.executeQuery(query);
            int id = Integer.parseInt(sonuc.getString("id"));
            String ad = sonuc.getString("ad");
            String soyad = sonuc.getString("soyad");
            String sifre = sonuc.getString("sifre");
            String adres = sonuc.getString("adres");
            String telNo = sonuc.getString("tel_no");
            return new Satici(id, ad, soyad, eposta, sifre, adres, telNo);
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
}
