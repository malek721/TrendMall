package View;

import Model.Satici;
import Model.Urun;

import javax.swing.*;
import java.awt.*;

public class SepetUnsuru extends JPanel{
    private JLabel saticiAdi,urunAdi,urunSayisi,fiyat;
    private JButton arti,eksi,remove;
    public SepetUnsuru(Urun urun) {
        this.setBackground(new Color(0xFAFAFA));
        this.setBorder(BorderFactory.createLineBorder(new Color(0xC3C3C3), 1));
        this.setLayout(null);
        String saticiIsim = urun.getSatici().getSb().getAd() +" "+ urun.getSatici().getSb().getSoyad();
        saticiAdi = new JLabel(saticiIsim);
        saticiAdi.setFont(new Font("Inter", Font.BOLD, 18));
        saticiAdi.setForeground(new Color(0x000000));
        saticiAdi.setBounds(20, 20, 180, 40);
        this.add(saticiAdi);

        urunAdi = new JLabel(urun.getAd());
        urunAdi.setFont(new Font("Inter", Font.BOLD, 18));
        urunAdi.setForeground(new Color(0x000000));
        urunAdi.setBounds(200, 20, 140, 40);
        this.add(urunAdi);

        eksi = new JButton("-");
        eksi.setFocusable(false);
        eksi.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        eksi.setBounds(400, 20, 20, 40);
        eksi.setFont(new Font("Inter", Font.BOLD, 26));
        eksi.setForeground(new Color(0x000000));
        eksi.setBackground(new Color(0xD0D0D0));
        eksi.setBorder(BorderFactory.createLineBorder(new Color(0x0D95927, true), 2));
        this.add(eksi);

        urunSayisi =new JLabel("1");
        urunSayisi.setFont(new Font("Inter", Font.BOLD, 18));
        urunSayisi.setForeground(new Color(0x000000));
        urunSayisi.setBounds(435, 20, 80, 40);
        urunSayisi.setBackground(new Color(0x9A1D1D));
        this.add(urunSayisi);

        arti = new JButton("+");
        arti.setFocusable(false);
        arti.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        arti.setBounds(460, 20, 20, 40);
        arti.setFont(new Font("Inter", Font.BOLD, 26));
        arti.setForeground(new Color(0xD95927));
        arti.setBackground(new Color(0xD9D9D9));
        arti.setBorder(BorderFactory.createLineBorder(new Color(0x0D95927, true), 2));
        this.add(arti);

        fiyat = new JLabel("23.99"+"tl");
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



}
