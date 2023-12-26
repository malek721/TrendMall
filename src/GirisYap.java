import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;

public class GirisYap implements ActionListener {
    JPanel girisForm;
    ImageIcon logo;
    JLabel imageContainer;
    JButton uyeOlSwitch;
    HashMap<String, JTextField> inputs = new HashMap<>();
    String[] inputsName = {"E-posta", "Sifre"};
    JButton girisYapButton;

    TrendMallFrame girisFrame;

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
        uyeOlSwitch.setFont(new Font("Poppins", Font.BOLD, 17));
        uyeOlSwitch.setFocusable(false);
        uyeOlSwitch.setBorder(null);
        uyeOlSwitch.addActionListener(this);
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
        for (int i = 0; i < inputsName.length; i++) {
            JTextField input = new JTextField("   " + inputsName[i]);
            input.setBounds(50, 131 + (i * 89), 400, 40);
            input.setBackground(new Color(0xE7E7E7));
            input.setForeground(new Color(0xBFBFBF));
            input.setFont(new Font("Poppins", Font.PLAIN, 18));
            input.setBorder(null);
            int tmp = i;
            input.addFocusListener(new FocusListener() {
                @Override
                public void focusGained(FocusEvent e) {
                    if (input.getText().trim().equals(inputsName[tmp])) {
                        input.setText("  ");
                        input.setForeground(new Color(30, 30, 30)); // Set text color on focus
                    }
                }

                @Override
                public void focusLost(FocusEvent e) {
                    if (input.getText().equals("  ")) {
                        input.setText("   " + inputsName[tmp]);
                        input.setForeground(new Color(0xBFBFBF)); // Set placeholder color on focus lost
                    }
                }
            });
            inputs.put(inputsName[i], input);
            girisForm.add(input);
        }
        buttonContainer.setLayout(null);
        buttonContainer.add(girisYapSwitch);
        buttonContainer.add(uyeOlSwitch);
        girisFrame = new TrendMallFrame();
        topPanel.add(imageContainer);
        girisForm.add(buttonContainer, BorderLayout.NORTH);
        girisForm.add(girisYapButton);
        girisFrame.add(topPanel, BorderLayout.NORTH);
        girisFrame.add(leftSidePanel, BorderLayout.WEST);
        girisFrame.add(rightSidePanel, BorderLayout.EAST);
        girisFrame.add(bottomPanel, BorderLayout.SOUTH);
        girisFrame.add(girisForm, BorderLayout.CENTER);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == uyeOlSwitch) {
            girisFrame.dispose();
            new UyeOl();
        }

        if (e.getSource() == girisYapButton) {
            DBConnection conn = DBConnection.getInstance();
            Statement statement;
            ResultSet sonuc;
            try {
                String query = "SELECT * FROM Musteri WHERE eposta = '"
                        + inputs.get("E-posta").getText().trim() + "' and sifre = '" + inputs.get("sifre").getText().trim() + "'";
                statement = conn.getConnection().createStatement();
                sonuc = statement.executeQuery(query);
                if (sonuc == null) {
                    System.out.println("There is no user with this email or pass word");
                } else {
                    System.out.println("Log in successful");
                }
            } catch (Exception ex) {
                System.out.println(ex);
            }
        }
    }
}
