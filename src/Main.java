import Controller.UyeOlController;
import Model.UyeOl;
import View.*;

public class Main {

    public static void main(String[] args) {
        new UyeOlController(new UyeOlSayfa(), new UyeOl());
    }
}