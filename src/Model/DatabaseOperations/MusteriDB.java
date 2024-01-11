package Model.DatabaseOperations;

import Connection.DBConnection;
import Model.Musteri;

import java.sql.ResultSet;
import java.sql.Statement;

public class MusteriDB {
    private static final DBConnection conn = DBConnection.getInstance();

    static public Musteri musteriGetir(int id) {
        Statement statement;
        ResultSet sonuc;
        String query;
        try {
            query = "SELECT * FROM Musteri WHERE id =" + id + " ";
            statement = conn.getConnection().createStatement();
            sonuc = statement.executeQuery(query);
            if (sonuc.next()) {
                String ad = sonuc.getString("ad");
                String soyad = sonuc.getString("soyad");
                String eposta = sonuc.getString("eposta");
                String sifre = sonuc.getString("sifre");
                String adres = sonuc.getString("adres");
                String telNo = sonuc.getString("tel_no");
                return Musteri.getInstance(id, ad, soyad, eposta, sifre,adres, telNo);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
}
