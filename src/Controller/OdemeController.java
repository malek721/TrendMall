package Controller;

import Connection.DBConnection;
import Model.KartOdeme;
import Model.Odeme;
import View.OdemeSayfa;
import View.SiparisOzeti;

import javax.swing.*;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;

public class OdemeController {
    private Odeme modelOdeme;
    private KartOdeme modelKartOdeme;
    private SiparisOzeti siparisOzetiView;
    private OdemeSayfa odemeSayfaView;

    public OdemeController(Odeme modelOdeme, KartOdeme modelKartOdeme, OdemeSayfa odemeSayfaView, SiparisOzeti siparisOzetiView) {
        this.modelOdeme = modelOdeme;
        this.modelKartOdeme = modelKartOdeme;
        this.siparisOzetiView = siparisOzetiView;
        this.odemeSayfaView = odemeSayfaView;
        this.odemeSayfaView.getOdemeYap().addActionListener(e -> odemeBilgileriKaydet());
    }

    public void odemeBilgileriKaydet() {
        DBConnection conn = DBConnection.getInstance();
        String query;
        Statement statement;
        ResultSet sonuc;
        LocalDate date = LocalDate.now();
        try {
            query = "INSERT INTO Odeme VALUES (DEFAULT, " + Integer.parseInt(siparisOzetiView.getToplamUcret().getText()) +
                    ", '" + date.getYear() + "-" + date.getMonth() + "-" + date.getDayOfMonth() + "')";
            statement = conn.getConnection().createStatement();
            statement.executeUpdate(query);
            AbstractButton selectedButton = odemeSayfaView.getSecenekler().getElements().nextElement();
            JRadioButton selectedRadioButton = (JRadioButton) selectedButton;
            if (selectedRadioButton.getText().equals("Kredi Kart")) {
                query = "SELECT max(id) FROM Odeme";
                sonuc = statement.executeQuery(query);
                if (sonuc.next()) {
                    query = "INSERT INTO kart_odeme VALUES (" + sonuc.getString("id") +
                            ",'" + odemeSayfaView.getKartSahibiAdi().getText().trim() +
                            "','" + odemeSayfaView.getKartNo().getText().trim() + "','"
                            + odemeSayfaView.getSonYilTarihi().getSelectedItem() + "-" + odemeSayfaView.getSonAyTarihi().getSelectedItem() + "- 01'"
                            + Integer.parseInt(odemeSayfaView.getCvv().getText()) + " )";
                    statement.executeUpdate(query);
                    modelKartOdeme = new KartOdeme(Integer.parseInt(sonuc.getString("id")),
                            Float.parseFloat(siparisOzetiView.getToplamUcret().getText()),
                            date.getYear() + "-" + date.getMonth() + "-" + date.getDayOfMonth()
                            , odemeSayfaView.getKartNo().getText().trim(), odemeSayfaView.getKartSahibiAdi().getText().trim(),
                            odemeSayfaView.getSonYilTarihi().getSelectedItem() + "-" + odemeSayfaView.getSonAyTarihi().getSelectedItem() + "- 01'",
                            Integer.parseInt(odemeSayfaView.getCvv().getText()));
                }
            }
            else {
                query = "SELECT * FROM Odeme WHERE id = (SELECT max(id) FROM Odeme)";
                sonuc = statement.executeQuery(query);
                if (sonuc.next()) {
                    modelOdeme = new Odeme(Integer.parseInt(sonuc.getString("id")),
                            Float.parseFloat(sonuc.getString("odeme_tutari")),
                            sonuc.getString("odeme_tarihi"));
                }
            }

        } catch (Exception e) {
            System.out.println("Operation Failed");
        }
    }
}
