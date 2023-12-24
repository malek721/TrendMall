import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class GirisYap{
    JPanel girisForm;
    ImageIcon logo;
    JLabel imageContainer;
    JButton uyeOlSwitch;
    JTextField eposta;
    JTextField sifre;

    JButton girisYapButton;

    public GirisYap() {

        logo = new ImageIcon("img.png");
        JPanel topPanel = new JPanel();
        topPanel.setBackground(new Color(251, 251, 251));
        JPanel leftSidePanel = new JPanel();
        leftSidePanel.setPreferredSize(new Dimension(500, 0));
        leftSidePanel.setBackground(new Color(251, 251, 251));
        JPanel rightSidePanel = new JPanel();
        rightSidePanel.setPreferredSize(new Dimension(500, 0));
        rightSidePanel.setBackground(new Color(251, 251, 251));
        JPanel bottomPanel = new JPanel();
        bottomPanel.setPreferredSize(new Dimension(0, 200));
        bottomPanel.setBackground(new Color(251, 251, 251));
        JPanel buttonContainer = new JPanel();
        buttonContainer.setBounds(114, 29, 270, 45);
        buttonContainer.setBackground(new Color(0XE7E7E7));
        buttonContainer.setBorder(BorderFactory.createLineBorder(new Color(0xCAC5C5), 1));
        JButton girisYapSwitch = new JButton("Giriş Yap");
        girisYapSwitch.setFont(new Font("Poppins", Font.BOLD, 17));
        girisYapSwitch.setBounds(3, 3, 140, 40);
        girisYapSwitch.setBackground(new Color(0xD27550));
        girisYapSwitch.setForeground(Color.WHITE);
        girisYapSwitch.setFocusable(false);
        girisYapSwitch.setBorder(null);
        uyeOlSwitch = new JButton("Üye Ol");
        uyeOlSwitch.setBounds(148, 3, 119, 40);
        uyeOlSwitch.setBackground(new Color(0xE7E7E7));
        uyeOlSwitch.setFont(new Font("Poppins", Font.PLAIN, 17));
        uyeOlSwitch.setFocusable(false);
        uyeOlSwitch.setBorder(null);
        eposta = new JTextField("   E-posta");
        eposta.setBounds(50, 131, 400, 40);
        eposta.setBackground(new Color(0xE7E7E7));
        eposta.setForeground(new Color(0xBFBFBF));
        eposta.setFont(new Font("Poppins", Font.PLAIN, 18));
        eposta.setBorder(null);
        eposta.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (eposta.getText().equals("   E-posta")) {
                    eposta.setText("  ");
                    eposta.setForeground(new Color(30,30,30)); // Set text color on focus
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (eposta.getText().equals("  ")) {
                    eposta.setText("   E-posta");
                    eposta.setForeground(new Color(0xBFBFBF)); // Set placeholder color on focus lost
                }
            }
        });

        sifre = new JTextField("   Şifre");
        sifre.setBounds(50, 220, 400, 40);
        sifre.setBackground(new Color(0xE7E7E7));
        sifre.setFont(new Font("Poppins", Font.PLAIN, 18));
        sifre.setForeground(new Color(0xBFBFBF));
        sifre.setBorder(null);
        sifre.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (sifre.getText().equals("   Şifre")) {
                    sifre.setText("  ");
                    sifre.setForeground(new Color(30,30,30)); // Set text color on focus
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (sifre.getText().equals("  ")) {
                    sifre.setText("   Şifre");
                    sifre.setForeground(new Color(0xBFBFBF)); // Set placeholder color on focus lost
                }
            }
        });
        girisYapButton = new JButton("Giriş Yap");
        girisYapButton.setFont(new Font("Poppins", Font.BOLD, 24));
        girisYapButton.setBounds(50, 316, 400, 50);
        girisYapButton.setBackground(new Color(0xD27550));
        girisYapButton.setForeground(Color.WHITE);
        girisYapButton.setFocusable(false);
        girisYapButton.setBorder(null);
        imageContainer = new JLabel(logo);
        imageContainer.setVerticalAlignment(JLabel.TOP);
        imageContainer.setHorizontalAlignment(JLabel.CENTER);
        imageContainer.setVerticalTextPosition(JLabel.TOP);
        imageContainer.setHorizontalTextPosition(JLabel.CENTER);
        imageContainer.setIconTextGap(15);
        girisForm = new JPanel();
        girisForm.setPreferredSize(new Dimension(500, 420));
        girisForm.setBackground(new Color(0xF7F7F7));
        girisForm.setBorder(BorderFactory.createLineBorder(new Color(0xB0B0B0), 1, true));
        girisForm.setLayout(null);
        buttonContainer.setLayout(null);
        buttonContainer.add(girisYapSwitch);
        buttonContainer.add(uyeOlSwitch);
        TrendMallFrame girisFrame = new TrendMallFrame();
        topPanel.add(imageContainer);
        girisForm.add(buttonContainer, BorderLayout.NORTH);
        girisForm.add(eposta);
        girisForm.add(sifre);
        girisForm.add(girisYapButton);
        girisFrame.add(topPanel, BorderLayout.NORTH);
        girisFrame.add(leftSidePanel, BorderLayout.WEST);
        girisFrame.add(rightSidePanel, BorderLayout.EAST);
        girisFrame.add(bottomPanel, BorderLayout.SOUTH);
        girisFrame.add(girisForm, BorderLayout.CENTER);

    }




}
