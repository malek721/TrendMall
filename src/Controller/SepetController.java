package Controller;

import Connection.DBConnection;
import Model.KartOdeme;
import Model.Odeme;
import Model.Sepet;
import Model.Urun;
import View.OdemeSayfa;
import View.UrunDisplay;

import java.sql.Statement;

public class SepetController {
    private DBConnection conn;
    private Sepet model;
    private UrunDisplay view;

    public SepetController(Sepet model, UrunDisplay view) {
        this.model = model;
        this.view = view;
        this.view.getSepeteEkleBtn().addActionListener(e -> sepeteEkle(view.getUrun()));
        conn = DBConnection.getInstance();
    }

    public UrunDisplay getView() {
        return view;
    }

    private void sepeteEkle(Urun urun) {
        Statement statement;
        String query;
        try {
            if (model.getUrunler().isEmpty()) {
                query = "Insert into Sepet Values(" +
                        model.getMusteri().getId() +
                        ", ARRAY [" + urun.getId() + "], "
                        + urun.getFiyat() + ");";
                statement = conn.getConnection().createStatement();
                statement.executeUpdate(query);
                model.urunEkle(urun);
            } else if (!model.getUrunler().contains(urun)) {
                query = "Update Sepet set urun_id = array_append(urun_id, " + urun.getId() + ") " +
                        "Where musteri_id = " + model.getMusteri().getId() + ";\n";
                String query2 = "Update Sepet set toplam_ucret = toplam_ucret +" + urun.getFiyat() +
                        " Where musteri_id = " + model.getMusteri().getId() + " ";
                statement = conn.getConnection().createStatement();
                statement.executeUpdate(query + query2);
                model.urunEkle(urun);
            }
        } catch (Exception e) {
            System.out.println("Operation Failed");
        }

    }
}
