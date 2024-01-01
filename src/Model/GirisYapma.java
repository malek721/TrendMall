package Model;

import Connection.DBConnection;

import java.sql.ResultSet;
import java.sql.Statement;

public class GirisYapma {
    private String eposta;

    public GirisYapma() {
        this.eposta = "";
    }

    public boolean loggingIn(String eposta, String sifre) {
        DBConnection conn = DBConnection.getInstance();
        Statement statement;
        ResultSet sonuc;
        String query;
        try {
            query = "SELECT * FROM Musteri WHERE eposta = '"
                    + eposta + "' and sifre = '"
                    + sifre + "'";
            statement = conn.getConnection().createStatement();
            sonuc = statement.executeQuery(query);
            if (sonuc.next()) {
                this.eposta = eposta;
                return true;
            }
            query = "SELECT * FROM Satici WHERE eposta = '"
                    + eposta + "' and sifre = '"
                    + sifre + "'";
            statement = conn.getConnection().createStatement();
            sonuc = statement.executeQuery(query);
            if (sonuc.next()) {
                this.eposta = eposta;
                return true;
            }
        } catch (Exception ex) {
            System.out.println("Operation Failed");
        }

        return false;
    }

    public String getEposta() {
        return eposta;
    }
}
