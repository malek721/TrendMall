package View;

import Model.Urun;

import javax.swing.*;
import java.awt.*;

public class SepetUnsuru extends JPanel {
    private final JButton remove;

    public SepetUnsuru(Urun urun) {
        this.setBackground(new Color(0xFAFAFA));
        this.setBorder(BorderFactory.createLineBorder(new Color(0xC3C3C3), 1));
        this.setLayout(null);
        String saticiIsim = urun.getSatici().getSb().getAd() + " " + urun.getSatici().getSb().getSoyad();
        JLabel saticiAdi = new JLabel(saticiIsim);
        saticiAdi.setFont(new Font("Inter", Font.BOLD, 18));
        saticiAdi.setForeground(new Color(0x000000));
        saticiAdi.setBounds(20, 20, 180, 40);
        this.add(saticiAdi);

        JLabel urunAdi = new JLabel(urun.getAd());
        urunAdi.setFont(new Font("Inter", Font.BOLD, 18));
        urunAdi.setForeground(new Color(0x000000));
        urunAdi.setBounds(200, 20, 140, 40);
        this.add(urunAdi);

        JLabel fiyat = new JLabel(urun.getFiyat() + " tl");
        fiyat.setFont(new Font("Inter", Font.BOLD, 20));
        fiyat.setForeground(new Color(0xD95927));
        fiyat.setBounds(570, 20, 120, 40);
        this.add(fiyat);


        remove = new JButton("remove");
        remove.setFocusable(false);
        remove.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        remove.setBounds(720, 20, 120, 40);
        remove.setFont(new Font("Inter", Font.BOLD, 18));
        remove.setForeground(new Color(0xFFFFFF));
        remove.setBackground(new Color(0x4D4D4D));
        remove.setBorder(BorderFactory.createLineBorder(new Color(0x0D95927, true), 2));
        this.add(remove);
    }

    public JButton getRemove() {
        return remove;
    }
}
