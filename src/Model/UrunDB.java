package Model;

import Connection.DBConnection;

import java.sql.Array;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;

public class UrunDB {

    public UrunDB() {}

    static public ResultSet urunBilgileriGetir(DBConnection conn) {
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

    static public ArrayList<Urun> urunlerGetir(Array urun_id){
        DBConnection conn = DBConnection.getInstance();
        ArrayList<Urun> urunler = new ArrayList<>();
        String query;
        Statement statement;
        ResultSet sonuc;
        try {
            query = "SELECT * FROM Urun WHERE id  = ANY('" + urun_id + "'::int[])";
            statement = conn.getConnection().createStatement();
            sonuc = statement.executeQuery(query);
            while (sonuc.next()) {
                int id = sonuc.getInt("id");
                String ad = sonuc.getString("ad");
                int miktar = sonuc.getInt("miktar");
                float fiyat = sonuc.getFloat("fiyat");
                Satici satici = SaticiDB.saticiBilgileriGetir(conn, sonuc.getInt("satici_id"));
                Kategori kategori = KategoriDB.kategriGetir(conn, sonuc.getInt("katogori_id"));
                urunler.add(new Urun(id, satici, ad, fiyat, kategori, miktar));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return urunler;
    }
}
