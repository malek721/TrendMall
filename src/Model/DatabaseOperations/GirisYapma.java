package Model.DatabaseOperations;

import Connection.DBConnection;

import java.sql.ResultSet;
import java.sql.Statement;

public class GirisYapma {

    public boolean loggingIn(String eposta, String sifre) {
        DBConnection conn = DBConnection.getInstance();
        Statement statement;
        ResultSet sonuc;
        String query;
        try {
            query = "SELECT * FROM Musteri WHERE eposta = '" + eposta + "' AND sifre = '" + sifre +
                    "' UNION SELECT * FROM Satici WHERE eposta = '" + eposta + "' AND sifre = '" + sifre + "';";
            statement = conn.getConnection().createStatement();
            sonuc = statement.executeQuery(query);
            return sonuc.next();
        } catch (Exception ex) {
            System.out.println("Operation Failed");
        }

        return false;
    }
}
