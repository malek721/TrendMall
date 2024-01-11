package Model.DatabaseOperations;

import Connection.DBConnection;

import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;

public class OdemeDB {

    static final DBConnection conn = DBConnection.getInstance();

    static public void odemeBilgileriKaydet(int musteriId, float toplamUcret, LocalDate date) {
        String query;
        Statement statement;
        try {
            query = "INSERT INTO Odeme VALUES (DEFAULT," + musteriId + ", " + toplamUcret + ", '" + date + "')";
            statement = conn.getConnection().createStatement();
            statement.executeUpdate(query);
        } catch (Exception e) {
            System.out.println("Operation Failed");
        }
    }

    static public int getSonOdemeID() {
        String query;
        Statement statement;
        ResultSet sonuc;
        try {
            query = "SELECT max(id) as id FROM Odeme";
            statement = conn.getConnection().createStatement();
            sonuc = statement.executeQuery(query);
            return sonuc.getInt("id");
        } catch (Exception e) {
            System.out.println("Operation Failed");
        }
        return 0;
    }

    static public ResultSet getSonOdeme() {
        String query;
        Statement statement;
        ResultSet sonuc;
        try {
            query = "SELECT * FROM Odeme WHERE id = (SELECT max(id) FROM Odeme)";
            statement = conn.getConnection().createStatement();
            sonuc = statement.executeQuery(query);
            return sonuc;
        } catch (Exception e) {
            System.out.println("Operation Failed");
        }
        return null;
    }

    static public void kartBilgileriKaydet(String kartNo, String kartSahibininAdi, String sonKullanmaTarihi, int cvv) {
        String query;
        Statement statement;
        try {
            query = "INSERT INTO kart_odeme VALUES (" + getSonOdemeID() + ",'" + kartNo + "','"
                    + kartSahibininAdi + "','" + sonKullanmaTarihi + "'," + cvv + " )";
            statement = conn.getConnection().createStatement();
            statement.executeUpdate(query);
        } catch (Exception e) {
            System.out.println("Operation Failed");
        }
    }
}
