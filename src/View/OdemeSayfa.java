package View;
import Model.Urun;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class OdemeSayfa implements ActionListener {
    private final ArrayList<Urun> urunler;
    private final MainFrame main;
    private final JTextField kartSahibiAdi;
    private final JTextField kartNo;
    private final JComboBox<Integer> sonAyTarihi;
    private final JComboBox<Integer> sonYilTarihi;
    private final JTextField cvv;
    private final ButtonGroup seceneklerGroupButton;
    private final JTextField kod;
    private final JButton kodUygulama;
    private final JButton odemeYap;
    private final SiparisOzeti siparisOzeti;

    public OdemeSayfa(ArrayList<Urun> urunler) {
        this.urunler = urunler;
        NavBar nav = new NavBar();
        JPanel mainContent = new JPanel();
        mainContent.setLayout(null);
        mainContent.setBackground(new Color(251, 251, 251));
        JLabel title = new JLabel("ÖDEME SEÇENEKLERİ");
        title.setFont(new Font("Inter", Font.BOLD, 26));
        title.setForeground(new Color(0, 0, 0));
        title.setBounds(75, 57, 300, 35);
        mainContent.add(title);
        seceneklerGroupButton = new ButtonGroup();
        String[] seceneklerAdi = {"Kredi Kart", "Nakit"};
        for (int i = 0; i < seceneklerAdi.length; i++) {
            JRadioButton secenek = new JRadioButton(seceneklerAdi[i]);
            secenek.setActionCommand(seceneklerAdi[i]);
            secenek.setFont(new Font("Inter", Font.BOLD, 24));
            secenek.setForeground(new Color(0, 0, 0));
            secenek.setBackground(new Color(251, 251, 251));
            secenek.setBounds(81 + (i * 619), 157, 170, 35);
            secenek.setFocusable(false);
            seceneklerGroupButton.add(secenek);
            mainContent.add(secenek);
        }
        JPanel kartBilgiler = new JPanel();
        kartBilgiler.setLayout(null);
        kartBilgiler.setBackground(new Color(251, 251, 251));
        kartBilgiler.setBorder(BorderFactory.createLineBorder(new Color(0xBEBCBC), 1));
        kartBilgiler.setBounds(75, 205, 570, 350);
        String[] kartBilgilerAd = {"Kart Sahibinin Adı", "Kart Numarası", "Son Kullanma Tarihi", "CVV"};
        for (int i = 0; i < kartBilgilerAd.length; i++) {
            JLabel label = new JLabel(kartBilgilerAd[i]);
            label.setFont(new Font("Poppins", Font.PLAIN, 15));
            if (kartBilgilerAd[i].equals("CVV"))
                label.setBounds(300, 215, 140, 30);
            else
                label.setBounds(35, 15 + (i * 100), 140, 30);
            label.setForeground(new Color(0, 0, 0));
            kartBilgiler.add(label);
        }

        kartSahibiAdi = new JTextField("  ");
        kartSahibiAdi.setFont(new Font("Poppins", Font.BOLD, 18));
        kartSahibiAdi.setBackground(new Color(0xE7E7E7));
        kartSahibiAdi.setBorder(BorderFactory.createLineBorder(new Color(0x919191), 1));
        kartSahibiAdi.setBounds(35, 45, 500, 62);
        kartBilgiler.add(kartSahibiAdi);

        kartNo = new JTextField("  ");
        kartNo.setFont(new Font("Poppins", Font.BOLD, 18));
        kartNo.setBackground(new Color(0xE7E7E7));
        kartNo.setBorder(BorderFactory.createLineBorder(new Color(0x919191), 1));
        kartNo.setBounds(35, 145, 500, 62);
        kartBilgiler.add(kartNo);

        sonAyTarihi = new JComboBox<>(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12});
        sonAyTarihi.setSelectedIndex(0);
        sonAyTarihi.setFont(new Font("Poppins", Font.BOLD, 18));
        sonAyTarihi.setBackground(new Color(0xE7E7E7));
        sonAyTarihi.setBorder(BorderFactory.createLineBorder(new Color(0x919191), 1));
        sonAyTarihi.setBounds(35, 245, 110, 62);
        kartBilgiler.add(sonAyTarihi);

        sonYilTarihi = new JComboBox<>(new Integer[]{2024, 2025, 2026, 2027, 2028, 2029, 2030, 2031});
        sonYilTarihi.setFont(new Font("Poppins", Font.BOLD, 18));
        sonYilTarihi.setBackground(new Color(0xE7E7E7));
        sonYilTarihi.setBorder(BorderFactory.createLineBorder(new Color(0x919191), 1));
        sonYilTarihi.setBounds(150, 245, 110, 62);
        kartBilgiler.add(sonYilTarihi);

        cvv = new JTextField("  ");
        cvv.setFont(new Font("Poppins", Font.BOLD, 18));
        cvv.setBackground(new Color(0xE7E7E7));
        cvv.setBorder(BorderFactory.createLineBorder(new Color(0x919191), 1));
        cvv.setBounds(280, 245, 110, 62);
        kartBilgiler.add(cvv);

        JPanel kuponContainer = new JPanel();
        kuponContainer.setLayout(null);
        kuponContainer.setBackground(new Color(251, 251, 251));
        kuponContainer.setBounds(1028, 366, 418, 115);
        kuponContainer.setBorder(BorderFactory.createLineBorder(new Color(0xC3C3C3), 1));
        mainContent.add(kuponContainer);

        JLabel kuponContainerTitle = new JLabel("KUPON KODU");
        kuponContainerTitle.setFont(new Font("Inter", Font.PLAIN, 18));
        kuponContainerTitle.setForeground(new Color(0, 0, 0));
        kuponContainerTitle.setBounds(35, 12, 125, 30);
        kuponContainer.add(kuponContainerTitle);

        kod = new JTextField("  ");
        kod.setFont(new Font("Inter", Font.BOLD, 18));
        kod.setBackground(new Color(0xD9D9D9));
        kod.setForeground(new Color(0x111111));
        kod.setBorder(null);
        kod.setBounds(35, 51, 230, 40);
        kuponContainer.add(kod);

        kodUygulama = new JButton("UYGULA");
        kodUygulama.setFont(new Font("Inter", Font.PLAIN, 16));
        kodUygulama.setForeground(new Color(0xFFFFFFF));
        kodUygulama.setBackground(new Color(0xD95927));
        kodUygulama.setBounds(292, 50, 85, 40);
        kodUygulama.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        kodUygulama.setFocusable(false);
        kodUygulama.setBorder(null);
        kodUygulama.addActionListener(this);
        kuponContainer.add(kodUygulama);

        odemeYap = new JButton("Ödeme Yap");
        odemeYap.setFocusable(false);
        odemeYap.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        odemeYap.setBounds(1139, 505, 166, 51);
        odemeYap.setFont(new Font("Inter", Font.BOLD, 26));
        odemeYap.setForeground(new Color(0xD95927));
        odemeYap.setBackground(new Color(251, 251, 251));
        odemeYap.setBorder(BorderFactory.createLineBorder(new Color(0xD95927), 2));
        odemeYap.addActionListener(this);
        mainContent.add(odemeYap);

        siparisOzeti = new SiparisOzeti(toplamFiyat(urunler));
        mainContent.add(siparisOzeti);
        mainContent.add(kartBilgiler);
        main = new MainFrame();
        main.add(nav, BorderLayout.NORTH);
        main.add(mainContent, BorderLayout.CENTER);
    }

    public float toplamFiyat(ArrayList<Urun> urunler){
        float toplam = 0;
        for(Urun urun: urunler){
            toplam+= urun.getFiyat();
        }
        return toplam;
    }

    public JTextField getKartSahibiAdi() {
        return kartSahibiAdi;
    }

    public JTextField getKartNo() {
        return kartNo;
    }

    public JComboBox<Integer> getSonAyTarihi() {
        return sonAyTarihi;
    }

    public JComboBox<Integer> getSonYilTarihi() {
        return sonYilTarihi;
    }

    public JTextField getCvv() {
        return cvv;
    }

    public JButton getOdemeYap() {
        return odemeYap;
    }

    public JButton getKodUygulama() {
        return kodUygulama;
    }

    public JTextField getKod() {
        return kod;
    }

    public ButtonGroup getSeceneklerGroupButton() {
        return seceneklerGroupButton;
    }

    public SiparisOzeti getSiparisOzeti() {
        return siparisOzeti;
    }

    public ArrayList<Urun> getUrunler() {
        return urunler;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == odemeYap) {
            new BasariliSiparis();
            main.dispose();
        }
    }
}
