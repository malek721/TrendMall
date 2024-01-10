package Controller;

import Connection.DBConnection;
import Model.Musteri;
import Model.Sepet;
import Model.Urun;
import View.UrunDisplay;

import java.sql.Array;
import java.sql.ResultSet;
import java.sql.Statement;

public class SepetController {
    static private DBConnection conn = DBConnection.getInstance();
    static private Sepet model;
    static private UrunDisplay view;

    public SepetController(Sepet model, UrunDisplay view) {
        SepetController.model = model;
        SepetController.view = view;
        SepetController.view.getSepeteEkleBtn().addActionListener(e -> sepeteEkle(view.getUrun()));
        conn = DBConnection.getInstance();
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

    static public void sepettenKaldir(Urun urun) {
        Statement statement;
        String query;
        try {
            query = "Update Sepet set urun_id = array_remove(urun_id, " + urun.getId() + ") " +
                    "Where musteri_id = " + model.getMusteri().getId() + ";\n";
            String query2 = "Update Sepet set toplam_ucret = toplam_ucret -" + urun.getFiyat() +
                    " Where musteri_id = " + model.getMusteri().getId() + " ";
            statement = conn.getConnection().createStatement();
            statement.executeUpdate(query+ query2);
            model.urunKaldir(urun);
        } catch (Exception e) {
            System.out.println("Operation Failed");
        }
    }
    static public Array getUrulerId(Musteri m){
        Statement statement;
        String query;
        ResultSet sonuc;
        try {
            query = "SELECT urun_id FROM sepet WHERE musteri_id ="+ m.getId()+" ";
            statement = conn.getConnection().createStatement();
            sonuc = statement.executeQuery(query);
            if(sonuc.next()){
                return sonuc.getArray("urun_id");
            }
        } catch (Exception e) {
            System.out.println("Operation Failed");
        }
        return null;
    }
}
