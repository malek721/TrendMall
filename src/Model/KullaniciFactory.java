package Model;

import Connection.DBConnection;
import Model.DatabaseOperations.MusteriDB;
import Model.DatabaseOperations.SaticiDB;

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
                return MusteriDB.musteriGetir(sonuc.getInt("id"));
            } else {
                query = "SELECT * FROM Satici WHERE eposta = '" + eposta + "'";
                statement = conn.getConnection().createStatement();
                sonuc = statement.executeQuery(query);
                sonuc.next();
                return SaticiDB.saticiGetir(sonuc.getInt("id"));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
}
