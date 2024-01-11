package Model.DatabaseOperations;

import Connection.DBConnection;

import java.sql.Statement;
import java.time.LocalDate;

public class SiparisDB {
    static final DBConnection conn = DBConnection.getInstance();

    static public void siparisBilgileriKaydet(int musteriId, int urunId, int saticiId, LocalDate date) {
        Statement statement;
        String query;
        try {
            query = "Insert INTO Siparis VALUES (DEFAULT," + musteriId + "," +
                    urunId + "," + saticiId + ",'" + date.toString() + "')";
            statement = conn.getConnection().createStatement();
            statement.executeUpdate(query);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
