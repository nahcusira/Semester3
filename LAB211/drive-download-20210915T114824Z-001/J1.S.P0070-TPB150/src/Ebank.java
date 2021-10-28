
import java.util.Locale;
import java.util.Random;
import java.util.ResourceBundle;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author admin
 */
public class Ebank {

    ResourceBundle bundle;

    public ResourceBundle getBundle() {
        return bundle;
    }

    public void setBundle(ResourceBundle bundle) {
        this.bundle = bundle;
    }

    public void setLocale(Locale locale) {
        bundle = ResourceBundle.getBundle("language", locale);
    }

    public String checkAccountNumber(String accountNumber) {

        String str = "";
        if (!accountNumber.matches("^[0-9]{10}$")) {
            str = bundle.getString("account.error");
        }
        return str;

    }

    public String checkPassword(String password) {
        String str = "";
        if (password.length() < 8 || password.length() > 31) {
            str += bundle.getString("password.error.length");
        }
        if (!password.matches("[a-zA-Z0-9]*[a-zA-Z]+[a-zA-Z0-9]*")) {
            str += bundle.getString("password.error.letter");
        }
        if (!password.matches("[a-zA-Z0-9]*[0-9]+[a-zA-Z0-9]*")) {
            str += bundle.getString("password.error.digit");
        }
        return str;
    }

    public String generateCaptcha() {
        StringBuilder captcha = new StringBuilder();

        Random random = new Random();
        String str = "123456789qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM";
        for (int i = 0; i < 6; i++) {
            int idxChar = random.nextInt(str.length());
            // capcha.append(capcha);
            captcha.append(str.charAt(idxChar));
        }
        return captcha.toString();
    }

    public String checkCaptcha(String captcha, String recaptcha) {
        String str = "";
        if (!recaptcha.matches("^[a-zA-Z0-9]{6}$")) {
            str += bundle.getString("captcha.error");
        }
        else if (!recaptcha.contains(captcha)) {
            str += bundle.getString("captcha.incorrect");
        }
        return str;

    }

}
