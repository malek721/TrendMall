package View;

import Controller.GirisController;
import Model.DatabaseOperations.GirisYapma;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;

public class UyeOlSayfa implements ActionListener {
    MainFrame uyeOlFrame;

    HashMap<String, JButton> buttons = new HashMap<>();
    String[] buttonSwitchName = {"Giriş Yap", "Üye Ol"};

    HashMap<String, JTextField> inputs = new HashMap<>();
    String[] inputsName = {"Ad", "Soyad", "E-posta", "Şifre", "Telefon Numarası", "Adres"};
    ButtonGroup kullanicilarButtonGroup;
    String[] kullanicilarNames = {"Müşteri", "Satıcı"};

    JButton uyeOlButton;
    JLabel message;

    public UyeOlSayfa() {
        JPanel topPanel = new JPanel();
        topPanel.setBackground(new Color(251, 251, 251));
        JPanel leftSidePanel = new JPanel();
        leftSidePanel.setPreferredSize(new Dimension(500, 0));
        leftSidePanel.setBackground(new Color(251, 251, 251));
        JPanel rightSidePanel = new JPanel();
        rightSidePanel.setPreferredSize(new Dimension(500, 0));
        rightSidePanel.setBackground(new Color(251, 251, 251));
        JPanel bottomPanel = new JPanel();
        bottomPanel.setPreferredSize(new Dimension(0, 50));
        bottomPanel.setBackground(new Color(251, 251, 251));
        ImageIcon logo = new ImageIcon("img.png");
        JLabel imageContainer = new JLabel(logo);
        imageContainer.setIconTextGap(15);
        imageContainer.setVerticalAlignment(JLabel.TOP);
        imageContainer.setHorizontalAlignment(JLabel.CENTER);
        imageContainer.setVerticalTextPosition(JLabel.TOP);
        imageContainer.setHorizontalTextPosition(JLabel.CENTER);
        JPanel buttonContainer = new JPanel();
        buttonContainer.setBounds(114, 29, 270, 45);
        buttonContainer.setBackground(new Color(0XE7E7E7));
        buttonContainer.setBorder(BorderFactory.createLineBorder(new Color(0xCAC5C5), 1));
        buttonContainer.setLayout(null);
        for (int i = 0; i < buttonSwitchName.length; i++) {
            JButton button = new JButton(buttonSwitchName[i]);
            button.setFont(new Font("Poppins", Font.BOLD, 17));
            button.setBounds(3 + (145 * i), 3, 140 - (21 * i), 40);
            button.setFocusable(false);
            button.setBorder(null);
            if (buttonSwitchName[i].equals("Üye Ol")) {
                button.setBackground(new Color(0xD27550));
                button.setForeground(Color.WHITE);
            } else {
                button.setBackground(new Color(0xE7E7E7));
                button.addActionListener(this);
            }
            buttons.put(buttonSwitchName[i], button);
            buttonContainer.add(button);
        }
        JPanel uyeOlForm = new JPanel();
        uyeOlForm.setPreferredSize(new Dimension(500, 500));
        uyeOlForm.setBackground(new Color(0xF7F7F7));
        uyeOlForm.setBorder(BorderFactory.createLineBorder(new Color(0xB0B0B0), 1, true));
        uyeOlForm.setLayout(null);
        uyeOlForm.setAutoscrolls(true);
        JPanel inputList = new JPanel();
        inputList.setBounds(50, 131, 400, 250);
        inputList.setLayout(new GridLayout(inputsName.length, 1, 89, 0));
        for (int i = 0; i < inputsName.length; i++) {
            JTextField input = new JTextField("   " + inputsName[i]);
            input.setSize(400, 40);
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
            inputList.add(input);
        }
        kullanicilarButtonGroup = new ButtonGroup();
        for (int i = 0; i < kullanicilarNames.length; i++) {
            JRadioButton kullanici = new JRadioButton(kullanicilarNames[i]);
            kullanici.setActionCommand(kullanicilarNames[i]);
            kullanici.setBounds(50 + (i * 110), 390, 100, 30);
            kullanici.setFocusable(false);
            kullanici.setBackground(new Color(0xF7F7F7));
            kullanici.addActionListener(this);
            kullanicilarButtonGroup.add(kullanici);
            uyeOlForm.add(kullanici);
        }
        uyeOlForm.add(inputList);
        message = new JLabel("");
        message.setBounds(80, 430, 350, 20);
        message.setFont(new Font("Poppins", Font.BOLD, 12));
        uyeOlButton = new JButton("Üye Ol");
        uyeOlButton.setFont(new Font("Poppins", Font.BOLD, 24));
        uyeOlButton.setBounds(50, 470, 400, 50);
        uyeOlButton.setBackground(new Color(0xD27550));
        uyeOlButton.setForeground(Color.WHITE);
        uyeOlButton.setFocusable(false);
        uyeOlButton.setBorder(null);
        uyeOlButton.addActionListener(this);
        uyeOlFrame = new MainFrame();
        topPanel.add(imageContainer);
        uyeOlForm.add(message);
        uyeOlForm.add(buttonContainer, BorderLayout.NORTH);
        uyeOlForm.add(uyeOlButton);
        uyeOlFrame.add(uyeOlForm, BorderLayout.CENTER);
        uyeOlFrame.add(topPanel, BorderLayout.NORTH);
        uyeOlFrame.add(leftSidePanel, BorderLayout.WEST);
        uyeOlFrame.add(rightSidePanel, BorderLayout.EAST);
        uyeOlFrame.add(bottomPanel, BorderLayout.SOUTH);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == buttons.get("Giriş Yap")) {
            uyeOlFrame.dispose();
            new GirisController(new GirisSayfa(), new GirisYapma());
        }
    }

    public HashMap<String, JTextField> getInputs() {
        return inputs;
    }

    public ButtonGroup getKullanicilarButtonGroup() {
        return kullanicilarButtonGroup;
    }

    public JButton getUyeOlButton() {
        return uyeOlButton;
    }

    public JLabel getMessage() {
        return message;
    }
}