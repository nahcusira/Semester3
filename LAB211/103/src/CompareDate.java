
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author kami
 */
public class CompareDate {

    private static final Scanner sc = new Scanner(System.in);

    public Date inputDate(String mess, String format) {
        Date d = null;
        SimpleDateFormat df = new SimpleDateFormat(format);
        df.setLenient(false);
        System.out.print(mess);
        while (true) {
            try {
                d = df.parse(sc.nextLine());
                break;
            } catch (Exception e) {
                System.out.print("Invalid date, please input again: ");
            }
        }
        return d;
    }

    public static void main(String[] args) {
        Date f, s;
        CompareDate cd = new CompareDate();
        f = cd.inputDate("Please enter the first date: ", "dd/MM/yyyy");
        s = cd.inputDate("Please enter the second date: ", "dd/MM/yyyy");
        if (f.before(s)) {
            System.out.println("Date1 is before Date2");
        } else if (s.before(f)) {
            System.out.println("Date2 is before Date1");
        } else {
            System.out.println("Date2 is equal Date1");
        }
    }
}
