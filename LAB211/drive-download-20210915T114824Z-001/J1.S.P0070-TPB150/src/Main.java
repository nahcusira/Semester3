
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author admin
 */
public class Main {

    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

    public void login(Ebank e) throws IOException {
        while (true) {
            String str;
            System.out.print(e.getBundle().getString("account"));
            str = input.readLine();
            if (e.checkAccountNumber(str).equals("")) {
                break;
            } else {
                System.out.println(e.getBundle().getString("account.error"));
            }
        }
        
        while (true) {

            System.out.print(e.getBundle().getString("password"));
            String password = input.readLine();

            if (e.checkPassword(password).equals("")) {
                break;
            } else {
                System.out.println(e.checkPassword(password));
            }
        }
        while (true) {

            String captcha = e.generateCaptcha();
            System.out.println("Captcha: " + captcha);
            System.out.println(e.getBundle().getString("captcha"));
            String recaptcha = input.readLine();
            if (e.checkCaptcha(captcha, recaptcha).equals("")) {
                System.out.println(e.getBundle().getString("success"));
                break;
            } else {
                System.out.println(e.checkCaptcha(captcha, recaptcha));
            }

        }
    }

    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        int choice;
        Ebank e = new Ebank();
        Validate v = new Validate();
        Locale locale;
        Main m = new Main();

        while (true) {
            System.out.println("-------Login Program-------");
            System.out.println("1. Vietnamese");
            System.out.println("2. English");
            System.out.println("3. Exit");
            System.out.print("Please choose language to start: ");
            choice = v.validateOption(1, 3);
            switch (choice) {
                case 1:
                    locale = new Locale("vn");
                    e.setLocale(locale);
                    m.login(e);

                    break;
                case 2:
                    locale = new Locale("en");
                    e.setLocale(locale);
                    m.login(e);

                    break;
                case 3:
                    return;
            }
        }

    }
}
