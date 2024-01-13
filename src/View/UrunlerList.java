package View;

import Controller.OdemeController;
import Controller.SepetController;
import Controller.UrunListController;
import Model.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class UrunlerList{
    private MainFrame main;
    private NavBar nav;
    private JPanel urunList;
    private JComboBox<String> kategori;

    public UrunlerList() {
        main = new MainFrame();
        nav = new NavBar();
        JPanel mainContent = new JPanel();
        mainContent.setLayout(null);
        mainContent.setBackground(new Color(251, 251, 251));
        kategori = new JComboBox<>(new String[]{"Katogori Seç"});
        kategori.setBackground(new Color(0xF7F7F7));
        kategori.setFont(new Font("Inter", Font.PLAIN, 20));
        kategori.setBounds(1071, 52, 290, 60);
        urunList = new JPanel(new FlowLayout(FlowLayout.LEADING, 5, 30));
        urunList.setBackground(new Color(0xFBFBFB));
        JScrollPane scroll = new JScrollPane(urunList);
        scroll.setBounds(58, 300, 1450, 300);
        mainContent.add(scroll);
        mainContent.add(kategori);
        main.add(nav, BorderLayout.NORTH);
        main.add(mainContent, BorderLayout.CENTER);
    }

    public MainFrame getMain() {
        return main;
    }

    public NavBar getNav() {
        return nav;
    }

    public JPanel getUrunList() {
        return urunList;
    }

    public JComboBox<String> getKategori() {
        return kategori;
    }
}
