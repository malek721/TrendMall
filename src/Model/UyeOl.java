package Model;

import Connection.DBConnection;

import java.sql.ResultSet;
import java.sql.Statement;

public class UyeOl {
    static DBConnection conn = DBConnection.getInstance();

    public String addNewUser(String kullanici, String ad, String soyad, String eposta, String sifre, String telNo, String adres) {
        Statement statement;
        String query;
        try {
            if (kullanici.equals("Müşteri")) {
                if (checkInfo("Müşteri", ad, soyad, eposta, sifre, telNo).isEmpty()) {
                    query = "INSERT INTO Musteri VALUES (Default,'" + ad +
                            "','" + soyad + "','" + eposta +
                            "','" + sifre + "','" + adres +
                            "','" + telNo + "')";
                    statement = conn.getConnection().createStatement();
                    statement.executeUpdate(query);
                } else {
                    return checkInfo("Musteri", ad, soyad, eposta, sifre, telNo);
                }
            } else {
                if (checkInfo("Satici", ad, soyad, eposta, sifre, telNo).isEmpty()) {
                    query = "INSERT INTO Satici VALUES (Default,'" + ad +
                            "','" + soyad + "','" + eposta +
                            "','" + sifre + "','" + adres +
                            "','" + telNo + "')";
                    statement = conn.getConnection().createStatement();
                    statement.executeUpdate(query);
                } else {
                    return checkInfo("Satici", ad, soyad, eposta, sifre, telNo);
                }
            }
        } catch (Exception ex) {
            System.out.println("Operation Failed");
        }
        return "";
    }

    static private String checkInfo(String kullanici, String ad, String soyad, String eposta, String sifre, String telNo) {
        String error = "";

        if (ad.length() > 20 || ad.matches(".*\\d+.*")) {
            return "Kullanici adı 20 karekterden az oluşur ve rakamlarden oluşmaz";
        }
        if (soyad.length() > 20 || soyad.matches(".*\\d+.*")) {
            return "Kullanıcı soyadı 20 karekterden az oluşur ve rakamlarden oluşmaz";
        }
        try {
            Statement statement;
            ResultSet sonuc;
            String query;
            query = "SELECT * FROM " + kullanici + " WHERE eposta = '"
                    + eposta + "'";
            statement = conn.getConnection().createStatement();
            sonuc = statement.executeQuery(query);
            if (!sonuc.next()) {
                if (eposta.length() > 50 || !(eposta.indexOf('@') >= 0))
                    return "E-posta 50 karekterden az oluşur ve @ sembol içerir";
            }
            else {
                return "E-posta zaten alındı";
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        if (sifre.length() < 6 || sifre.length() > 16) {
            return "Şifre 6 ve 16 arasında karekterden oluşur";
        }
        if (telNo.charAt(0) != '5' || telNo.length() != 10 || !telNo.matches("\\d+")) {
            return "telefon numarasi 5 ile başlar ve 10 rakamlardan oluşur";
        }
        return error;

    }
}
