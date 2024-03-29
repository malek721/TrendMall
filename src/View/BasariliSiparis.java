package View;

import Controller.UrunListController;
import Model.Sepet;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BasariliSiparis implements ActionListener {
    private final JButton anasayfa;
    private final MainFrame mainFrame;

    public BasariliSiparis() {
        NavBar nav = new NavBar();
        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(new Color(0xFBFBFB));
        mainPanel.setLayout(null);
        JLabel mesaj1 = new JLabel("Siparişiniz Başarılı Alındı");
        mesaj1.setFont(new Font("Inter", Font.BOLD, 41));
        mesaj1.setForeground(new Color(0xD95927));
        mesaj1.setBounds(518, 270, 490, 50);
        JLabel mesaj2 = new JLabel("Siparişiniz En Kısa Zamanda Kapında olacak");
        mesaj2.setFont(new Font("Inter", Font.BOLD, 41));
        mesaj2.setForeground(new Color(0xD95927));
        mesaj2.setBounds(335, 340, 859, 50);
        ImageIcon icon = new ImageIcon("img_1.png");
        JLabel imageContainer = new JLabel(icon);
        imageContainer.setBounds(670, 50, 200, 205);
        anasayfa = new JButton("Ana Sayfa");
        anasayfa.setForeground(new Color(0xD95927));
        anasayfa.setBackground(new Color(0xFBFBFB));
        anasayfa.addActionListener(this);
        anasayfa.setBorder(BorderFactory.createEmptyBorder());
        anasayfa.setBounds(690, 450, 160, 55);
        anasayfa.setBorder(new LineBorder(new Color(0xD95927), 3));
        anasayfa.setFont(new Font("Inter", Font.BOLD, 29));
        anasayfa.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        anasayfa.setFocusable(false);
        mainPanel.add(mesaj1);
        mainPanel.add(mesaj2);
        mainPanel.add(imageContainer);
        mainPanel.add(anasayfa);
        mainFrame = new MainFrame();
        mainFrame.add(nav, BorderLayout.NORTH);
        mainFrame.add(mainPanel, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == anasayfa) {
            new UrunListController(new UrunlerList(), Sepet.getInstance());
            mainFrame.dispose();
        }
    }
}
