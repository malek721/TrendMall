package Model.DatabaseOperations;

import Connection.DBConnection;

import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;

public class IndirimKodDB {
    static final DBConnection conn = DBConnection.getInstance();

    static public ResultSet getIndirimKod(String kod) {
        String query;
        Statement statement;
        ResultSet sonuc;
        try {
            query = "SELECT *  FROM kupon WHERE kod = '" + kod + "'";
            statement = conn.getConnection().createStatement();
            sonuc = statement.executeQuery(query);
            return sonuc;

        } catch (Exception e) {
            System.out.println("Operation Failed");
        }
        return null;
    }

    static public void kuponKullanimiKaydet(String kuponId, int musteriId, LocalDate date){
        String query;
        Statement statement;
        try {
            query = "INSERT INTO kupon_kullanim VALUES("+musteriId+",'"+kuponId+"','"+date+",')";
            statement = conn.getConnection().createStatement();
            statement.executeUpdate(query);
        } catch (Exception e) {
            System.out.println("Operation Failed");
        }
    }
}
