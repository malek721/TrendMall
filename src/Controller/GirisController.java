package Controller;

import Model.GirisYapma;
import View.GirisSayfa;

import java.awt.*;

public class GirisController {
    GirisSayfa view;
    GirisYapma model;

    public GirisController(GirisSayfa view, GirisYapma model) {
        this.view = view;
        this.model = model;
        this.view.getGirisYapButton().addActionListener(e -> getSignInMessage());
    }

    private void getSignInMessage() {
        String eposta = view.getInputs().get("E-posta").getText().trim();
        String sifre = view.getInputs().get("Şifre").getText().trim();
        boolean status = model.loggingIn(eposta, sifre);
        if (status) {
            view.getMessage().setText("Log in successful");
            view.getMessage().setForeground(Color.GREEN);
        } else {
            view.getMessage().setText("There is no user with this email or password");
            view.getMessage().setForeground(Color.RED);
        }
    }
}
