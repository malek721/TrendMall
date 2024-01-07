package Controller;

import Connection.DBConnection;
import Model.KartOdeme;
import Model.Odeme;
import View.OdemeSayfa;

import javax.swing.*;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.Enumeration;

public class OdemeController {
    static DBConnection conn;
    private Odeme modelOdeme;
    private KartOdeme modelKartOdeme;
    static private OdemeSayfa view;

    public OdemeController(Odeme modelOdeme, KartOdeme modelKartOdeme, OdemeSayfa view) {
        this.modelOdeme = modelOdeme;
        this.modelKartOdeme = modelKartOdeme;
        this.view = view;
        conn = DBConnection.getInstance();
        this.view.getOdemeYap().addActionListener(e -> odemeBilgileriKaydet());

    }

    private void odemeBilgileriKaydet() {
        String query;
        Statement statement;
        ResultSet sonuc;
        try {
            LocalDate date = LocalDate.now();
            float toplamUcret = Float.parseFloat(view.getSiparisOzeti().getToplamUcret().getText().substring(0, view.getSiparisOzeti().getToplamUcret().getText().length() - 2));
            query = "INSERT INTO Odeme VALUES (DEFAULT, " + toplamUcret + ", '" + date + "')";
            statement = conn.getConnection().createStatement();
            statement.executeUpdate(query);
            Enumeration<AbstractButton> buttons = view.getSeceneklerGroupButton().getElements();
            buttons.hasMoreElements();
            AbstractButton button = buttons.nextElement();
            if (button.getText().equals("Kredi Kart")) {
                query = "SELECT max(id) as id FROM Odeme";
                sonuc = statement.executeQuery(query);
                if (sonuc.next()) {
                    int id = sonuc.getInt("id");
                    String kartSahibiAdi = view.getKartSahibiAdi().getText().trim();
                    String kartNo = view.getKartNo().getText().trim();
                    String sonKullanmaTarihi = view.getSonYilTarihi().getSelectedItem() + "-" + view.getSonAyTarihi().getSelectedItem() + "-01";
                    int cvv = Integer.parseInt(view.getCvv().getText().trim());
                    query = "INSERT INTO kart_odeme VALUES (" + id + ",'" + kartNo + "','"
                            + kartSahibiAdi + "','" + sonKullanmaTarihi + "'," + cvv + " )";
                    statement.executeUpdate(query);
                    modelKartOdeme = new KartOdeme(id, toplamUcret, date.toString(), kartNo, kartSahibiAdi, sonKullanmaTarihi, cvv);
                }
            } else {
                query = "SELECT max(id) as id FROM Odeme";
                sonuc = statement.executeQuery(query);
                if (sonuc.next()) {
                    modelOdeme = new Odeme(sonuc.getInt("id"), toplamUcret, date.toString());
                }
            }

        } catch (Exception e) {
            System.out.println("Operation Failed");
        }
    }

    public static void indrimYap(String kod) {
        String query;
        Statement statement;
        ResultSet sonuc;
        try {
            query = "SELECT *  FROM kupon";
            statement = conn.getConnection().createStatement();
            sonuc = statement.executeQuery(query);
            if (sonuc.next()) {
                LocalDate date = LocalDate.now();
                if (sonuc.getDate("gecerlilik_tarihi").toLocalDate().isAfter(date)) {
                    int indirimMiktar = sonuc.getInt("indirim_miktari");
                    int uzunluk = view.getSiparisOzeti().getToplamUcret().getText().length();
                    float orjinalFiyat = Float.parseFloat(view.getSiparisOzeti().getToplamUcret().getText().substring(0, uzunluk - 2));
                    view.getSiparisOzeti().getToplamUcret().setText(orjinalFiyat - indirimMiktar + " tl");
                }
                else {
                    System.out.println("Bu indirm kod gecersiz");
                }
            }
        } catch (Exception e) {
            System.out.println("Operation Failed");
        }
    }
}
