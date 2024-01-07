package View;
import javax.swing.*;
import java.awt.*;

public class UrunDisplay extends JPanel{
    JLabel saticiAd;
    JLabel urunAd;
    JLabel urunFiyat;
    JButton simdiAl;
    JButton sepeteEkle;

    public UrunDisplay(String saticiAd, String urunAd, String urunFiyat){
        this.setLayout(null);
        this.setPreferredSize(new Dimension(350, 160));
        this.setBackground(new Color(251, 251, 251));
        this.saticiAd = new JLabel(saticiAd);
        this.saticiAd.setFont(new Font("Inter", Font.BOLD, 20));
        this.saticiAd.setForeground(Color.BLACK);
        this.saticiAd.setBounds(0, 0, 180,30);
        this.urunAd = new JLabel(urunAd);
        this.urunAd.setFont(new Font("Inter", Font.PLAIN, 20));
        this.urunAd.setForeground(Color.BLACK);
        this.urunAd.setBounds(170, 0, 150,30);
        this.urunFiyat = new JLabel(urunFiyat+" tl");
        this.urunFiyat.setFont(new Font("Inter", Font.BOLD, 20));
        this.urunFiyat.setForeground(new Color(0xD95927));
        this.urunFiyat.setBounds(0, 50, 100,30);
        simdiAl = new JButton("Şimdi Al");
        simdiAl.setFont(new Font("Inter", Font.BOLD, 14));
        simdiAl.setForeground(new Color(0xD95927));
        simdiAl.setBackground(new Color(0xF4F4F4));
        simdiAl.setBounds(0, 100, 100,40);
        simdiAl.setBorder(BorderFactory.createLineBorder(new Color(0xD95927),1));
        simdiAl.setFocusable(false);
        simdiAl.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        sepeteEkle = new JButton("Sepete Ekle");
        sepeteEkle.setBorder(null);
        sepeteEkle.setFont(new Font("Inter", Font.BOLD, 14));
        sepeteEkle.setForeground(new Color(0xFFFFFF));
        sepeteEkle.setBackground(new Color(0xD95927));
        sepeteEkle.setBounds(120, 100, 100,40);
        sepeteEkle.setFocusable(false);
        sepeteEkle.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        this.add(this.urunAd);
        this.add(this.saticiAd);
        this.add(this.urunFiyat);
        this.add(simdiAl);
        this.add(sepeteEkle);
    }
}
