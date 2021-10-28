
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author kami
 */
public class View {

    Controller c = new Controller();

    public void input() {
        String countryCode = c.inputString("Enter Code of Country : ", "Must String");
        if (c.checkExist(countryCode)) {
            System.err.println("Country Exist");
            return;
        }
        String countryName = c.inputString("Enter Name of Country : ", "Must String");
        float totalArea = c.inputFloat("Enter Area of Country : ", "Must Float");
        String countryTerrain = c.inputString("Enter Terrain of Country : ", "Must String");
        c.addCountry(countryCode, countryName, totalArea, countryTerrain);
    }

    public void display(ArrayList<EastAsiaCountries> list) {
        if (list.isEmpty()) {
            System.err.println("List is empty");
            return;
        }
        System.out.printf("%-20s%-25s%-20s%-25s\n", "ID", "Name", "Total Area", "Terrain");
        for (EastAsiaCountries e : list) {
            e.display();
        }
    }

    public void search() {
        String seachValue = c.inputString("Enter the code you want to search : ", "Please input correct!");
        ArrayList<EastAsiaCountries> list = c.searchCountry(seachValue);
        if (list.isEmpty()) {
            System.err.println("Country not exist");
            return;
        }
        display(list);
    }

    public void sort() {
        ArrayList<EastAsiaCountries> list = c.sortCountry();
        display(list);
    }

    public void show() {
        ArrayList<EastAsiaCountries> list = c.list;
        display(list);
    }

    public void menu() {
        while (true) {
            System.out.println("1. Input the information of 11 countries in East Asia");
            System.out.println("2. Display the information of country you've just input");
            System.out.println("3. Search the information of country by user-entered name");
            System.out.println("4. Display the information of countries sorted name in ascending order");
            System.out.println("5. Exit");
            int choice = c.inputChoice("Enter your choice : ", 1, 5);
            switch (choice) {
                case 1:
                    input();
                    break;
                case 2:
                    show();
                    break;
                case 3:
                    search();
                    break;
                case 4:
                    sort();
                    break;
                case 5:
                    return;
            }
        }
    }

    public static void main(String[] args) {
        View v = new View();
        v.menu();
    }
}
