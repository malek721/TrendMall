package Model;

import Connection.DBConnection;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class KategoriDB {

    static public String[] kategorileriGetir(DBConnection conn) {
        Statement statement;
        ResultSet sonuc;
        String query;
        try {
            query = "SELECT ad FROM katogori";
            statement = conn.getConnection().createStatement();
            sonuc = statement.executeQuery(query);
            ArrayList<String> kategoriler = new ArrayList<>();
            while (sonuc.next()) {
                kategoriler.add(sonuc.getString("ad"));
            }
            return kategoriler.toArray(new String[0]);
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    static public int kategriIdGetir(DBConnection conn, String kategriAd) {
        Statement statement;
        ResultSet sonuc;
        String query;
        try {
            query = "SELECT id FROM katogori WHERE ad = '" + kategriAd + "'";
            statement = conn.getConnection().createStatement();
            sonuc = statement.executeQuery(query);
            if (sonuc.next()) {
                return sonuc.getInt("id");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return 0;
    }

    static public Kategori kategriGetir(DBConnection conn, int id) {
        Statement statement;
        ResultSet sonuc;
        String query;
        try {
            query = "SELECT * FROM katogori WHERE id = " + id + " ";
            statement = conn.getConnection().createStatement();
            sonuc = statement.executeQuery(query);
            if (sonuc.next()) {
                return new Kategori(sonuc.getInt("id"), sonuc.getString("ad"));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
}
