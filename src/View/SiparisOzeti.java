package View;
import javax.swing.*;
import java.awt.*;

public class SiparisOzeti {
    private JPanel ozet;
    private JLabel urunUcret;
    private JLabel kargoUcret;
    private JLabel toplamUcret;
    public SiparisOzeti(){
        ozet = new JPanel(){
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(Color.BLACK);
                int x1 = 25;
                int y1 = 190;
                int x2 = 385;
                int y2 = 190;
                g.drawLine(x1, y1, x2, y2);
            }
        };
        ozet.setBounds(1028, 71, 418, 274);
        ozet.setBackground(new Color(0xFAFAFA));
        ozet.setBorder(BorderFactory.createLineBorder(new Color(0xC3C3C3), 1));
        ozet.setLayout(null);
        JLabel title = new JLabel("Sipariş Özeti");
        title.setFont(new Font("Inter", Font.BOLD, 32));
        title.setForeground(new Color(0x000000));
        title.setBounds(35, 15, 200, 40);
        ozet.add(title);
        JLabel urunUcretiTitle = new JLabel("Ürünün ücreti");
        urunUcretiTitle.setFont(new Font("Inter", Font.PLAIN, 22));
        urunUcretiTitle.setForeground(new Color(0x000000));
        urunUcretiTitle.setBounds(30, 93, 150, 30);
        ozet.add(urunUcretiTitle);
        urunUcret = new JLabel("734 tl");
        urunUcret.setFont(new Font("Inter", Font.BOLD, 22));
        urunUcret.setForeground(new Color(0x000000));
        urunUcret.setBounds(324, 93, 150, 30);
        ozet.add(urunUcret);
        JLabel kargoUcretiTitle = new JLabel("Kargo ücreti");
        kargoUcretiTitle.setFont(new Font("Inter", Font.PLAIN, 22));
        kargoUcretiTitle.setForeground(new Color(0x000000));
        kargoUcretiTitle.setBounds(30, 131, 150, 30);
        ozet.add(kargoUcretiTitle);
        kargoUcret = new JLabel("45 tl");
        kargoUcret.setFont(new Font("Inter", Font.BOLD, 22));
        kargoUcret.setForeground(new Color(0x000000));
        kargoUcret.setBounds(324, 131, 150, 30);
        ozet.add(kargoUcret);
        JLabel toplamUcretiTitle = new JLabel("Toplam");
        toplamUcretiTitle.setFont(new Font("Inter", Font.BOLD, 22));
        toplamUcretiTitle.setForeground(new Color(0x000000));
        toplamUcretiTitle.setBounds(36, 211, 85, 30);
        ozet.add(toplamUcretiTitle);
        toplamUcret = new JLabel("779 tl");
        toplamUcret.setFont(new Font("Inter", Font.BOLD, 22));
        toplamUcret.setForeground(new Color(0xD95927));
        toplamUcret.setBounds(324, 211, 150, 30);
        ozet.add(toplamUcret);
    }

    public JPanel getOzet() {
        return ozet;
    }

    public void setUrunUcret(JLabel urunUcret) {
        this.urunUcret = urunUcret;
    }

    public void setKargoUcret(JLabel kargoUcret) {
        this.kargoUcret = kargoUcret;
    }

    public JLabel getToplamUcret() {
        return toplamUcret;
    }

    public void setToplamUcret(JLabel toplamUcret) {
        this.toplamUcret = toplamUcret;
    }
}
