/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import model.Employee;

/**
 *
 * @author Vanngo
 */
public class Validate {

    private final Scanner in = new Scanner(System.in);

    public int inputIntLimit(String msg, String err, int min, int max) {
        while (true) {
            try {
                System.out.print(msg);
                String temp = null;
                temp = in.nextLine().trim();
                int result = Integer.parseInt(temp);
                if (result < min || result > max) {
                    throw new NumberFormatException();
                }
                return result;
            } catch (NumberFormatException e) {
                System.out.println(err);
            }
        }
    }

    public double inputDoubleLimit(String msg, String err, double min, double max) {
        while (true) {
            try {
                System.out.print(msg);
                String temp = null;
                temp = in.nextLine().trim();
                double result = Double.parseDouble(temp);
                if (result < min || result > max) {
                    throw new NumberFormatException();
                }
                return result;
            } catch (NumberFormatException e) {
                System.out.println(err);
            }
        }
    }

    public String inputString(String msg, String err, String regex) {
        String result = null;
        while (true) {
            System.out.print(msg);
            result = in.nextLine().trim();
            if (!result.matches(regex)) {
                System.err.println(err);
            } else {
                return result;
            }

        }
    }

    public String inputSearchValue(String msg) {
        String result = null;
        System.out.print(msg);
        result = in.nextLine();
        return result;
    }

    public String inputDate(String msg, String err, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        sdf.setLenient(false);
        while (true) {
            try {
                System.out.print(msg);
                String result = in.nextLine().trim();
                Date date = sdf.parse(result);
                return sdf.format(date);
            } catch (ParseException e) {
                System.err.println(err);
            }
        }
    }

    public boolean checkDuplicateId(int id, ArrayList<Employee> list) {
        for (Employee em : list) {
            if (em.getId() == id) {
                return true;
            }
        }
        return false;
    }
}
