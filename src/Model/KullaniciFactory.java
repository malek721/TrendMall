package Model;

import Connection.DBConnection;

import java.sql.ResultSet;
import java.sql.Statement;

public class KullaniciFactory implements KullaniciFactoryI {

    static DBConnection conn = DBConnection.getInstance();
    @Override
    public Kullanici getKullanici(String eposta) {
        Statement statement;
        String query;
        ResultSet sonuc;
        try {
            query = "SELECT * FROM Musteri WHERE eposta = '" + eposta + "'";
            statement = conn.getConnection().createStatement();
            sonuc = statement.executeQuery(query);
            if (sonuc.next()) {
                int id = sonuc.getInt("id");
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
            return SaticiDB.saticiBilgileriGetir(conn, sonuc.getInt("id"));
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
}
