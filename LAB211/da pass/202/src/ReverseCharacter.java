/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author kami
 */
public class ReverseCharacter {

    static void reveser(String str) {
        if (str.isEmpty()) {
            return;
        }
        StringBuilder s = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) {
            s.append(str.charAt(i));
        }
        System.out.println(s);
    }

    public static void main(String[] args) {
        reveser("hello there!");
    }
}
