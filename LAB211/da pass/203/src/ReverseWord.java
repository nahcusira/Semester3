/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author kami
 */
import java.util.Scanner;

public class ReverseWord {

    private final static Scanner sc = new Scanner(System.in);

    static void reverse(String str) {
        while (str.trim().isEmpty()) {
            System.out.println("Re-enter : ");
            str = sc.nextLine().trim();
        }
        StringBuilder s = new StringBuilder();
        String txt[] = str.split("\\s+");
        for (int i = txt.length - 1; i >= 0; i--) {
            s.append(txt[i] + " ");
        }
        System.out.println(s.substring(0, 1).toUpperCase() + s.substring(1).trim());
    }

    public static void main(String[] args) {
        reverse("hello there!");
    }
}
