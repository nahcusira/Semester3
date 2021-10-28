
import java.util.ArrayList;
import java.util.Comparator;
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
public class Controller {
    
    private final Scanner sc = new Scanner(System.in);
    
    ArrayList<EastAsiaCountries> list = new ArrayList<>();
    
    public Controller() {
    }
    
//    public ArrayList<EastAsiaCountries> getList() {
//        return list;
//    }
    
    public int inputChoice(String mess, int min, int max) {
        while (true) {
            try {
                System.out.println(mess);
                int result = Integer.parseInt(sc.nextLine().trim());
                if (result < min || result > max) {
                    throw new NumberFormatException();
                }
                return result;
            } catch (Exception e) {
            }
        }
    }
    
    public float inputFloat(String mess, String err) {
        while (true) {
            try {
                System.out.println(mess);
                float result = Float.parseFloat(sc.nextLine().trim());
                if (result > 0) {
                    return result;
                }
            } catch (Exception e) {
            }
        }
    }
    
    public String inputString(String mess, String err) {
        while (true) {
            try {
                System.out.println(mess);
                String result = sc.nextLine().trim();
                if (result.isEmpty()) {
                    System.out.println(err);
                } else {
                    return result;
                }
            } catch (Exception e) {
            }
        }
    }
    
    public void addCountry(String countryCode, String countryName, float totalArea, String countryTerrain) {
        list.add(new EastAsiaCountries(countryCode, countryName, totalArea, countryTerrain));
    }
    
    public EastAsiaCountries getCode(String countryCode) {
        for (EastAsiaCountries eastAsiaCountries : list) {
            if (eastAsiaCountries.getCountryCode().equals(countryCode)) {
                return eastAsiaCountries;
            }
        }
        return null;
    }
    
    public boolean checkExist(String countryCode) {
        for (EastAsiaCountries eastAsiaCountries : list) {
            if (eastAsiaCountries.getCountryCode().equalsIgnoreCase(countryCode)) {
                return true;
            }
        }
        return false;
    }
    
    public ArrayList<EastAsiaCountries> sortCountry() {
        list.sort(Comparator.comparing(EastAsiaCountries::getCountryCode));
        return list;
    }
    
    public ArrayList<EastAsiaCountries> searchCountry(String searchValue) {
        ArrayList<EastAsiaCountries> listSearch = new ArrayList<>();
        for (EastAsiaCountries eastAsiaCountries : list) {
            if (eastAsiaCountries.getCountryName().toLowerCase().contains(searchValue)) {
                listSearch.add(eastAsiaCountries);
            }
        }
        return listSearch;
    }
}
