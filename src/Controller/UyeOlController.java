package Controller;

import Model.GirisYapma;
import Model.UyeOl;
import View.GirisSayfa;
import View.UyeOlSayfa;

import javax.swing.*;
import java.awt.*;

public class UyeOlController {
    private UyeOlSayfa view;
    private UyeOl model;

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
        String result;
        if(view.getKullanicilarButtonGroup().getSelection().getActionCommand().equals("Müşteri"))
            result = model.addNewUser("Musteri" , ad, soyad, eposta, sifre, telNo, adres);
        else
            result = model.addNewUser("Satici", ad, soyad, eposta, sifre, telNo, adres);
        view.getMessage().setText(result);
        view.getMessage().setForeground(Color.RED);

    }
}
