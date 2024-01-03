package Controller;

import Connection.DBConnection;
import Model.KartOdeme;
import Model.Odeme;
import View.OdemeSayfa;

import javax.swing.*;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;

public class OdemeController {
    private Odeme modelOdeme;
    private KartOdeme modelKartOdeme;
    private OdemeSayfa view;

    public OdemeController(Odeme modelOdeme, KartOdeme modelKartOdeme, OdemeSayfa view) {
        this.modelOdeme = modelOdeme;
        this.modelKartOdeme = modelKartOdeme;
        this.view = view;
        this.view.getOdemeYap().addActionListener(e -> odemeBilgileriKaydet());
    }

    public void odemeBilgileriKaydet() {
        DBConnection conn = DBConnection.getInstance();
        String query;
        Statement statement;
        ResultSet sonuc;
        try {
            LocalDate date = LocalDate.now();
            float toplamUcret = Float.parseFloat(view.getSiparisOzeti().getToplamUcret().getText());
            query = "INSERT INTO Odeme VALUES (DEFAULT, " + toplamUcret + ", '" + date + "')";
            statement = conn.getConnection().createStatement();
            statement.executeUpdate(query);
            AbstractButton selectedButton = view.getSecenekler().getElements().nextElement();
            JRadioButton selectedRadioButton = (JRadioButton) selectedButton;
            if (selectedRadioButton.getText().equals("Kredi Kart")) {
                query = "SELECT max(id) as id FROM Odeme";
                sonuc = statement.executeQuery(query);
                if (sonuc.next()) {
                    int id = Integer.parseInt(sonuc.getString("id"));
                    String kartSahibiAdi = view.getKartSahibiAdi().getText().trim();
                    String kartNo = view.getKartNo().getText().trim();
                    String sonKullanmaTarihi = view.getSonYilTarihi().getSelectedItem() + "-" + view.getSonAyTarihi().getSelectedItem() + "-01";
                    int cvv = Integer.parseInt(view.getCvv().getText().trim());
                    query = "INSERT INTO kart_odeme VALUES (" + id + ",'" + kartSahibiAdi + "','"
                            + kartNo + "','" + sonKullanmaTarihi + "'," + cvv + " )";
                    statement.executeUpdate(query);
                    modelKartOdeme = new KartOdeme(id, toplamUcret, date.toString(), kartNo, kartSahibiAdi, sonKullanmaTarihi, cvv);
                }
            } else {
                query = "SELECT max(id) as id FROM Odeme";
                sonuc = statement.executeQuery(query);
                if (sonuc.next()) {
                    modelOdeme = new Odeme(Integer.parseInt(sonuc.getString("id")), toplamUcret, date.toString());
                }
            }

        } catch (Exception e) {
            System.out.println("Operation Failed");
        }
    }
}
