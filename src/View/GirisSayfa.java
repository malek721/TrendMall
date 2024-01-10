package View;

import Controller.UrunListController;
import Controller.UyeOlController;
import Model.Kullanici;
import Model.KullaniciFactory;
import Model.Musteri;
import Model.UyeOl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;

public class GirisSayfa implements ActionListener {
    HashMap<String, JTextField> inputs = new HashMap<>();
    HashMap<String, JButton> buttons = new HashMap<>();
    String[] inputsName = {"E-posta", "Şifre"};
    String[] buttonSwitchName = {"Giriş Yap", "Üye Ol"};
    JButton girisYapButton;
    MainFrame girisFrame;
    JLabel message;

    public GirisSayfa() {
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
        ImageIcon logo = new ImageIcon("img.png");
        JLabel imageContainer = new JLabel(logo);
        imageContainer.setVerticalAlignment(JLabel.TOP);
        imageContainer.setHorizontalAlignment(JLabel.CENTER);
        imageContainer.setVerticalTextPosition(JLabel.TOP);
        imageContainer.setHorizontalTextPosition(JLabel.CENTER);
        imageContainer.setIconTextGap(15);
        JPanel buttonContainer = new JPanel();
        buttonContainer.setBounds(114, 29, 270, 45);
        buttonContainer.setBackground(new Color(0XE7E7E7));
        buttonContainer.setBorder(BorderFactory.createLineBorder(new Color(0xCAC5C5), 1));
        buttonContainer.setLayout(null);
        JPanel girisForm = new JPanel();
        girisForm.setPreferredSize(new Dimension(500, 420));
        girisForm.setBackground(new Color(0xF7F7F7));
        girisForm.setBorder(BorderFactory.createLineBorder(new Color(0xB0B0B0), 1, true));
        girisForm.setLayout(null);
        for (int i = 0; i < buttonSwitchName.length; i++) {
            JButton button = new JButton(buttonSwitchName[i]);
            button.setFont(new Font("Poppins", Font.BOLD, 17));
            button.setBounds(3 + (145 * i), 3, 140 - (21 * i), 40);
            button.setFocusable(false);
            button.setBorder(null);
            if (buttonSwitchName[i].equals("Giriş Yap")) {
                button.setBackground(new Color(0xD27550));
                button.setForeground(Color.WHITE);
            } else {
                button.setBackground(new Color(0xE7E7E7));
                button.addActionListener(this);
            }
            buttons.put(buttonSwitchName[i], button);
            buttonContainer.add(button);
        }
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
        girisYapButton = new JButton("Giriş Yap");
        girisYapButton.setFont(new Font("Poppins", Font.BOLD, 24));
        girisYapButton.setBounds(50, 316, 400, 50);
        girisYapButton.setBackground(new Color(0xD27550));
        girisYapButton.setForeground(Color.WHITE);
        girisYapButton.setFocusable(false);
        girisYapButton.setBorder(null);
        girisYapButton.addActionListener(this);
        message = new JLabel("");
        message.setBounds(130, 280, 350, 20);
        message.setFont(new Font("Poppins", Font.BOLD, 12));
        topPanel.add(imageContainer);
        girisForm.add(buttonContainer, BorderLayout.NORTH);
        girisForm.add(girisYapButton);
        girisForm.add(message);
        girisFrame = new MainFrame();
        girisFrame.add(topPanel, BorderLayout.NORTH);
        girisFrame.add(leftSidePanel, BorderLayout.WEST);
        girisFrame.add(rightSidePanel, BorderLayout.EAST);
        girisFrame.add(bottomPanel, BorderLayout.SOUTH);
        girisFrame.add(girisForm, BorderLayout.CENTER);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == buttons.get("Üye Ol")) {
            new UyeOlController(new UyeOlSayfa(), new UyeOl());
            girisFrame.dispose();
        }
        if (e.getSource() == buttons.get("Giriş Yap")) {
            KullaniciFactory factory  = new KullaniciFactory();
            Kullanici kullanici  = factory.getKullanici(inputs.get("E-posta").getText());
            if (kullanici instanceof Musteri)
                new UrunListController(new UrunlerList((Musteri) kullanici));

        }

        }

    public JButton getGirisYapButton() {
        return girisYapButton;
    }

    public JLabel getMessage() {
        return message;
    }

    public HashMap<String, JTextField> getInputs() {
        return inputs;
    }
}
