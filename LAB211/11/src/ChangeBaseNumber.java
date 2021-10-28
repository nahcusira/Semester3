
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
public class ChangeBaseNumber {

    private final Scanner sc = new Scanner(System.in);

    String HEX = "0123456789ABCDEF";//luu gia tri va vi tri de phuc vu cho viec chuyen doi sau nay

    int checkInput(String mess, String err, int min, int max) {
        int n = 0;
        System.out.println(mess);
        while (true) {
            try {
                n = Integer.parseInt(sc.nextLine());
                if (n < min || n > max) {
                    System.err.println(err);
                } else {
                    break;
                }
            } catch (Exception e) {
                System.err.println(err);
            }
        }
        return n;
    }

    String checkValue(String mess, String err, String regex) {
        String n = "";
        System.out.println(mess);
        while (true) {
            n = sc.nextLine();
            if (n.matches(regex)) {
                break;
            } else {
                System.err.println(err);
            }
        }
        return n;
    }

    String DecToOther(int dec, int base) {
        String result = "";
        while (dec > 0) {
            result = HEX.charAt(dec % base) + result;//chia lay du va doc ket qua tu tail -> head
            dec /= base;
        }
        return result;
    }

    int OtherToDec(String other, int base) {//string de nhap cho he co so 16 (hex)
        int dec = 0;
        for (int i = 0; i < other.length(); i++) {
            dec += HEX.indexOf(other.toUpperCase().charAt(i)) * Math.pow(base, other.length() - 1 - i);//lay gia tri .. o vi tri thu i trong HEX
        }
        return dec;
    }

    int base(int choice) {
        int[] base = {2, 8, 10, 16};
        return base[choice - 1];
    }

    public static void main(String[] args) {
        String BIN = "[01]+";
        String OCT = "[0-7]+";
        String DEC = "[0-9]+";
        String HEX = "[0-9A-Fa-f]+";
        ChangeBaseNumber m = new ChangeBaseNumber();
        String regex[] = {BIN, OCT, DEC, HEX};//check regex cua tung he co so khi input
        int inputBase = m.checkInput("Choose the base number input (1. BIN 2. OCT 3. DEC 4. HEX)", "Error", 1, 4);
        int outputBase = m.checkInput("Choose the base number output (1. BIN 2. OCT 3. DEC 4. HEX)", "Error", 1, 4);
        String value = m.checkValue("Enter the input value : ", "Error", regex[inputBase - 1]);
        System.out.println("Result is : ");
        if (m.base(inputBase) == 10) {
            System.out.println(m.DecToOther(Integer.parseInt(value), m.base(outputBase)));//10->output
        } else {
            System.out.println(m.DecToOther(m.OtherToDec(value, m.base(inputBase)), m.base(outputBase)));//input->10->output
        }
    }
}
