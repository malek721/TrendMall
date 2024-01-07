package Model;

import Connection.DBConnection;

import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class UrunDB {

    static public ResultSet urunBilgileriGetir(DBConnection conn) {
        ArrayList<Urun> urunler = null;
        Statement statement;
        ResultSet sonuc;
        String query;
        try {
            query = "SELECT * FROM Urun";
            statement = conn.getConnection().createStatement();
            sonuc = statement.executeQuery(query);
            return sonuc;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    static public ResultSet urunBilgileriGetir(DBConnection conn, String kategori) {
        Statement statement;
        ResultSet sonuc;
        String query;
        try {
            query = "SELECT * FROM Urun WHERE katogori_id =" + KategoriDB.kategriIdGetir(conn, kategori) + " ";
            statement = conn.getConnection().createStatement();
            sonuc = statement.executeQuery(query);
            return sonuc;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
}
