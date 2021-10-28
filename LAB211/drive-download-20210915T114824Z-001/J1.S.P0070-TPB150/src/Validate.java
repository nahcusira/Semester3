/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 *
 * @author admin
 */
public class Validate {

    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    Scanner sc = new Scanner(System.in);

    public int validateOption(int firstOption, int lastOption) {
        // declare
        int option;
        while (true) {
            try {
                option = Integer.parseInt(sc.nextLine().trim());
                if (option < firstOption || option > lastOption) {
                    throw new NumberFormatException();
                }
                return option;
            } catch (NumberFormatException e) {
                System.err.println("Choose 1 If you want to use Vietnamese");
                System.err.println("Choose 2 If you want to use English");
                System.err.println("Choose 3 to exit");
                System.out.print("Your choice: ");
            }
        }
    }

   
    
   
    
  
}
