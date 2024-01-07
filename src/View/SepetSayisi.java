package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class SepetSayisi implements ActionListener{

    JLabel urunSayisi;
    JButton sepetOnayla;

    public SepetSayisi(){
        NavBar nav = new NavBar();
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(null);
        mainPanel.setBackground(new Color(251, 251, 251));

        urunSayisi =new JLabel("Sepetim(8 ürün)");
        urunSayisi.setFont(new Font("Arial", Font.PLAIN, 28));
        urunSayisi.setBounds(60, 50 , 240, 25);
        urunSayisi.setForeground(new Color(0, 0, 0));
        mainPanel.add(urunSayisi);

        //SiparisOzeti siparisOzeti = new SiparisOzeti();
        //mainPanel.add(siparisOzeti.getOzet());

        SepetUnsuru  unsuru = new SepetUnsuru();
        mainPanel.add(unsuru);

        sepetOnayla = new JButton("Sepet Onayla");
        sepetOnayla.setFocusable(false);
        sepetOnayla.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        sepetOnayla.setBounds(1128, 400, 200, 50);
        sepetOnayla.setFont(new Font("Inter", Font.BOLD, 26));
        sepetOnayla.setForeground(new Color(0xD95927));
        sepetOnayla.setBackground(new Color(251,251,251));
        sepetOnayla.setBorder(BorderFactory.createLineBorder(new Color(0xD95927), 2));
        mainPanel.add(sepetOnayla);


        MainFrame main = new MainFrame();
        main.add(nav, BorderLayout.NORTH);
        main.add(mainPanel, BorderLayout.CENTER);
    }




    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
