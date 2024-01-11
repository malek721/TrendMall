package Model.DatabaseOperations;

import Connection.DBConnection;
import Model.Musteri;

import java.sql.Array;
import java.sql.ResultSet;
import java.sql.Statement;

public class SepetDB {
    private static final  DBConnection conn = DBConnection.getInstance();
    static public void bosSepeteEkle(int musteriId, int urunId, float urunFiyat) {
        Statement statement;
        String query;
        try {
            query = "Insert into Sepet Values(" +
                    musteriId +
                    ", ARRAY [" + urunId + "], "
                    + urunFiyat + ");";
            statement = conn.getConnection().createStatement();
            statement.executeUpdate(query);


        } catch (Exception e) {
            System.out.println("Operation Failed");
        }
    }

    static public void sepeteEkle(int musteriId, int urunId, float urunFiyat) {
        Statement statement;
        String query;
        try {
            query = "Update Sepet set urun_id = array_append(urun_id, " + urunId + ") " +
                    "Where musteri_id = " + musteriId + ";\n";
            String query2 = "Update Sepet set toplam_ucret = toplam_ucret +" + urunFiyat +
                    " Where musteri_id = " + musteriId + " ";
            statement = conn.getConnection().createStatement();
            statement.executeUpdate(query + query2);
        } catch (Exception e) {
            System.out.println("Operation Failed");
        }
    }

    static public void sepettenKaldir(int musteriId, int urunId, float urunFiyat) {
        Statement statement;
        String query;
        try {
            query = "Update Sepet set urun_id = array_remove(urun_id, " + urunId + ") " +
                    "Where musteri_id = " + musteriId + ";\n";
            String query2 = "Update Sepet set toplam_ucret = toplam_ucret -" + urunFiyat +
                    " Where musteri_id = " + musteriId + " ";
            statement = conn.getConnection().createStatement();
            statement.executeUpdate(query + query2);
        } catch (Exception e) {
            System.out.println("Operation Failed");
        }
    }



    static public Array getUrulerId(Musteri m) {
        Statement statement;
        String query;
        ResultSet sonuc;
        try {
            query = "SELECT urun_id FROM sepet WHERE musteri_id =" + m.getId() + " ";
            statement = conn.getConnection().createStatement();
            sonuc = statement.executeQuery(query);
            sonuc.next();
                return sonuc.getArray("urun_id");
        } catch (Exception e) {
            System.out.println("Operation Failed");
        }
        return null;
    }
}
