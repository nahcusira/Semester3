/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author hn919
 */
public class Validation {

    static Scanner sc = new Scanner(System.in);

    public static int checkIntLimit(int min, int max) {
        while (true) {
            try {
                int n = Integer.parseInt(sc.nextLine());
                if (n < min || n > max) {
                    throw new NumberFormatException();
                }
                return n;
            } catch (NumberFormatException ex) {
                System.out.println("Please try again! In range 1-4");
            }
        }
    }

    //check input is integer number
    public static int inputNumber() {
        Scanner sc = new Scanner(System.in);
        boolean check = true;
        int n = 0;
        while (check) {
            try {
                n = Integer.parseInt(sc.nextLine());
                check = false;
            } catch (NumberFormatException e) {
                System.out.println("Enter again, Please enter integer number");
            }
        }
        return n;
    }

    //check input time for from time and to time
    public static double inputTime() {
        boolean check = true;
        double time = 0;

        while (check) {
            try {
                time = Double.parseDouble(sc.nextLine());
                if (time >= 8 && time <= 17.5 && time % 0.5 == 0) {
                    break;
                } else {
                    System.out.println("Enter again! Task from 8h to 17h30 [8-17.5]");
                }
            } catch (NumberFormatException e) {
                System.err.println("Invalid choice, please input again!");
            }
        }
        return time;

    }
    
    //check input time to must be > time 
    public static double inputTimeTo(double time) {
        boolean check = true;
        double timeTo = 0;

        while (check) {
            try {
                timeTo = Double.parseDouble(sc.nextLine());
                if (timeTo >= 8 && timeTo <= 17.5 && timeTo % 0.5 == 0 && timeTo > time) {
                    break;
                } else {
                    System.out.println("Enter again[8-17.5] and must more than from time");
                }
            } catch (NumberFormatException e) {
                System.err.println("Invalid choice, please input again!");
            }
        }
        return timeTo;

    }

    //check validate input Date
    public static String inputDate() {
        boolean bcheck = true;
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        sdf.setLenient(false);
        Date date = null;

        while (bcheck) {

            try {
                System.out.print("Date: ");
                date = sdf.parse(sc.nextLine());
                bcheck = false;
            } catch (Exception e) {
                System.err.println("Invalid Date (Date format dd-MM-yyyy): ");
            }
        }
        return sdf.format(date);
    }

    //check validate String 
    public static String inputString() {
        Scanner sc = new Scanner(System.in);
        String s = null;
        boolean check = true;

        while (check) {
            s = sc.nextLine().trim();
            if (s.length() == 0) {
                System.out.println("Enter again: ");
            } else {
                check = false;
            }
        }
        return s;
    }

    public static int inputTaskType() {
        boolean check = true;
        int Type = 0;

        while (check) {
            try {
                Type = Integer.parseInt(sc.nextLine());
                if (Type >= 1 && Type <= 4) {
                    break;
                } else {
                    System.out.println("Enter again: ");
                }
            } catch (NumberFormatException e) {
                System.err.println("Invalid choice, please input again!:");
            }
        }
        return Type;
    }

}
