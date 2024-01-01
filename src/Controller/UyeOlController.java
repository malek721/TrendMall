package Controller;

import Model.GirisYapma;
import Model.UyeOl;
import View.GirisSayfa;
import View.UyeOlSayfa;

import javax.swing.*;
import java.awt.*;

public class UyeOlController {
    UyeOlSayfa view;
    UyeOl model;

    public UyeOlController(UyeOlSayfa view, UyeOl model) {
        this.view = view;
        this.model = model;
        view.getUyeOlButton().addActionListener(e -> getAddNewUserMessage());
    }

    private void getAddNewUserMessage() {
        String ad = view.getInputs().get("Ad").getText().trim();
        String soyad = view.getInputs().get("Soyad").getText().trim();
        String eposta = view.getInputs().get("E-posta").getText().trim();
        String sifre = view.getInputs().get("Şifre").getText().trim();
        String telNo = view.getInputs().get("Telefon Numarası").getText().trim();
        String adres = view.getInputs().get("Adres").getText().trim();
        AbstractButton selectedButton = view.getKullanicilar().getElements().nextElement();
        JRadioButton selectedRadioButton = (JRadioButton) selectedButton;
        String result = model.addNewUser(selectedRadioButton.getText(), ad, soyad, eposta, sifre, telNo, adres);
        view.getMessage().setText(result);
        view.getMessage().setForeground(Color.RED);

    }
}
