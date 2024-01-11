package Model.DatabaseOperations;

import Connection.DBConnection;
import Model.Kategori;
import Model.Satici;
import Model.Urun;

import java.sql.Array;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class UrunDB {
    private static final DBConnection conn = DBConnection.getInstance();

    public UrunDB() {}

    static public ResultSet urunBilgileriGetir() {
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

    static public ResultSet urunBilgileriGetir(String kategori) {
        Statement statement;
        ResultSet sonuc;
        String query;
        try {
            query = "SELECT * FROM Urun WHERE katogori_id =" + KategoriDB.kategriIdGetir(kategori) + " ";
            statement = conn.getConnection().createStatement();
            sonuc = statement.executeQuery(query);
            return sonuc;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    static public ArrayList<Urun> urunlerGetir(Array urun_id){
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
                Satici satici = SaticiDB.saticiGetir(sonuc.getInt("satici_id"));
                Kategori kategori = KategoriDB.kategriGetir(sonuc.getInt("katogori_id"));
                urunler.add(new Urun(id, satici, ad, fiyat, kategori, miktar));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return urunler;
    }
}
