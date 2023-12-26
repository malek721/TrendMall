import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.sql.Statement;
import java.util.HashMap;

public class UyeOl implements ActionListener {
    TrendMallFrame uyeOlFrame;
    JPanel uyeOlForm;
    ImageIcon logo;
    JLabel imageContainer;
    JButton uyeOlSwitch;
    JButton girisYapSwitch;

    HashMap<String, JTextField> inputs = new HashMap<>();
    String[] inputsName = {"E-posta", "Ad", "Soyad", "Sifre", "Telefon Numarası", "Adres"};

    JButton uyeOlButton;

    public UyeOl() {
        JPanel inputPanel = new JPanel();
        inputPanel.setBounds(50, 131, 400,250);
        inputPanel.setLayout(new GridLayout(inputsName.length, 1, 89, 0));
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
        bottomPanel.setPreferredSize(new Dimension(0, 100));
        bottomPanel.setBackground(new Color(251, 251, 251));
        JPanel buttonContainer = new JPanel();
        buttonContainer.setBounds(114, 29, 270, 45);
        buttonContainer.setBackground(new Color(0XE7E7E7));
        buttonContainer.setBorder(BorderFactory.createLineBorder(new Color(0xCAC5C5), 1));
        girisYapSwitch = new JButton("Giriş Yap");
        girisYapSwitch.setFont(new Font("Poppins", Font.BOLD, 17));
        girisYapSwitch.setBounds(3, 3, 140, 40);
        girisYapSwitch.setBackground(new Color(0xE7E7E7));
        girisYapSwitch.setFocusable(false);
        girisYapSwitch.setBorder(null);
        girisYapSwitch.addActionListener(this);
        uyeOlSwitch = new JButton("Üye Ol");
        uyeOlSwitch.setBounds(148, 3, 119, 40);
        uyeOlSwitch.setBackground(new Color(0xD27550));
        uyeOlSwitch.setForeground(Color.WHITE);
        uyeOlSwitch.setFont(new Font("Poppins", Font.BOLD, 17));
        uyeOlSwitch.setFocusable(false);
        uyeOlSwitch.setBorder(null);
        uyeOlButton = new JButton("Üye Ol");
        uyeOlButton.setFont(new Font("Poppins", Font.BOLD, 24));
        uyeOlButton.setBounds(50, 400, 400, 50);
        uyeOlButton.setBackground(new Color(0xD27550));
        uyeOlButton.setForeground(Color.WHITE);
        uyeOlButton.setFocusable(false);
        uyeOlButton.setBorder(null);
        uyeOlButton.addActionListener(this);
        imageContainer = new JLabel(logo);
        imageContainer.setVerticalAlignment(JLabel.TOP);
        imageContainer.setHorizontalAlignment(JLabel.CENTER);
        imageContainer.setVerticalTextPosition(JLabel.TOP);
        imageContainer.setHorizontalTextPosition(JLabel.CENTER);
        imageContainer.setIconTextGap(15);
        uyeOlForm = new JPanel();
        uyeOlForm.setPreferredSize(new Dimension(500, 420));
        uyeOlForm.setBackground(new Color(0xF7F7F7));
        uyeOlForm.setBorder(BorderFactory.createLineBorder(new Color(0xB0B0B0), 1, true));
        uyeOlForm.setLayout(null);
        uyeOlForm.setAutoscrolls(true);
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
            inputPanel.add(input);
        }
        uyeOlForm.add(inputPanel);
        buttonContainer.setLayout(null);
        buttonContainer.add(girisYapSwitch);
        buttonContainer.add(uyeOlSwitch);
        uyeOlFrame = new TrendMallFrame();
        topPanel.add(imageContainer);
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
        if(e.getSource() == girisYapSwitch){
            uyeOlFrame.dispose();
            new GirisYap();
        }

        if(e.getSource() == uyeOlButton){
            Statement statement;
            DBConnection conn = DBConnection.getInstance();
            try{
                String query = "INSERT INTO Musteri VALUES (Default,'" +inputs.get("Ad").getText().trim()+
                        "','"+inputs.get("Soyad").getText().trim()+"','"+inputs.get("E-posta").getText().trim()+
                        "','"+inputs.get("Sifre").getText().trim()+ "','"+inputs.get("Adres").getText().trim()+
                        "','"+inputs.get("Telefon Numarası").getText().trim()+"')";
                statement = conn.getConnection().createStatement();
                statement.executeUpdate(query);
                System.out.println("jejrnej");

            }catch (Exception s){
                System.out.println(inputs.get("Telefon Numarası").getText().trim().length());
                System.out.println(s);

            }

        }
    }
}
