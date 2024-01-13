package View;

import Model.Urun;

import javax.swing.*;
import java.awt.*;

public class SaticiUrunDisplay extends JPanel{
    private final Urun urun;
    private final JButton urunDuzeltleme;

    public SaticiUrunDisplay(Urun urun) {
        this.urun = urun;
        this.setLayout(null);
        this.setPreferredSize(new Dimension(350, 160));
        this.setBackground(new Color(251, 251, 251));
        String saticiIsimi = urun.getSatici().getSb().getAd() + " " + urun.getSatici().getSb().getSoyad();
        JLabel saticiAd = new JLabel(saticiIsimi);
        saticiAd.setFont(new Font("Inter", Font.BOLD, 20));
        saticiAd.setForeground(Color.BLACK);
        saticiAd.setBounds(0, 0, 180, 30);
        JLabel urunAd = new JLabel(urun.getAd());
        urunAd.setFont(new Font("Inter", Font.PLAIN, 20));
        urunAd.setForeground(Color.BLACK);
        urunAd.setBounds(170, 0, 150, 30);
        JLabel urunFiyat = new JLabel(urun.getFiyat() + " tl");
        urunFiyat.setFont(new Font("Inter", Font.BOLD, 20));
        urunFiyat.setForeground(new Color(0xD95927));
        urunFiyat.setBounds(0, 50, 100, 30);
        urunDuzeltleme = new JButton("Ürün Düzelt");
        urunDuzeltleme.setBorder(null);
        urunDuzeltleme.setFont(new Font("Inter", Font.BOLD, 14));
        urunDuzeltleme.setForeground(new Color(0xFFFFFF));
        urunDuzeltleme.setBackground(new Color(0xD95927));
        urunDuzeltleme.setBounds(120, 50, 100, 40);
        urunDuzeltleme.setFocusable(false);
        urunDuzeltleme.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        this.add(urunAd);
        this.add(saticiAd);
        this.add(urunFiyat);
        this.add(urunDuzeltleme);
    }

    public Urun getUrun() {
        return urun;
    }

    public JButton getUrunDuzeltleme() {
        return urunDuzeltleme;
    }
}
