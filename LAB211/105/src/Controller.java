
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
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
public class Controller {

    private final Scanner sc = new Scanner(System.in);
    ArrayList<Product> list = new ArrayList<>();

    public Controller() {
    }

    public ArrayList<Product> getList() {
        return list;
    }

    public int CheckChoice(int min, int max) {
        while (true) {
            try {
                int result = Integer.parseInt(sc.nextLine().trim());
                if (result < min || result > max) {
                    throw new NumberFormatException();
                }
                return result;
            } catch (NumberFormatException e) {
                System.err.println("Re-input");
            }
        }
    }

    public String checkInputString() {
        while (true) {
            String result = sc.nextLine().trim();
            if (result.equalsIgnoreCase("")) {
                return result;
            }
            if (result.length() == 0) {
                System.err.println("Not empty.");
            } else {
                return result;
            }
        }
    }

    public int CheckInputInt() {
        while (true) {
            try {
                int result = Integer.parseInt(sc.nextLine().trim());
                return result;
            } catch (NumberFormatException e) {
                System.err.println("Re-input");
            }
        }
    }

    public double CheckInputDouble() {
        double n;
        while (true) {
            try {
                String result = sc.nextLine();
                if (result.equalsIgnoreCase("")) {
                    return -1;
                }
                n = Double.parseDouble(result);
                if (n < 0) {
                    System.err.println("Re-input");
                }
                return n;
            } catch (NumberFormatException e) {
                System.err.println("Re-input");
            }
        }
    }

    public String checkInputDate() {
        while (true) {
            try {
                String result = sc.nextLine().trim();
                if (result.equalsIgnoreCase("")) {
                    return result;
                }
                SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                format.setLenient(false);
                Date date = format.parse(result);
                if (result.equalsIgnoreCase(format.format(date))) {
                    return result;
                } else {
                    System.err.println("Re-input");
                }
            } catch (NumberFormatException | ParseException ex) {
                System.err.println("Re-input");
            }
        }
    }

    void add(int id, String name, String location, String expiryDate, String dateOfManufacture, String category, String storekeeper, String receiptDate, double price) {
        list.add(new Product(id, name, location, expiryDate, dateOfManufacture, category, storekeeper, receiptDate, price));
    }

    Product getProduct(int id) {
        for (Product product : list) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    void update(int id, String name, String location, String expiryDate, String dateOfManufacture, String category, String storekeeper, String receiptDate, double price) {
        Product product = getProduct(id);
        if (!name.equalsIgnoreCase("")) {
            product.setName(name);
        }
        if (!location.equalsIgnoreCase("")) {
            product.setLocation(location);
        }
        if (!expiryDate.equalsIgnoreCase("")) {
            product.setExpiryDate(expiryDate);
        }
        if (!dateOfManufacture.equalsIgnoreCase("")) {
            product.setDateOfManufacture(dateOfManufacture);
        }
        if (!category.equalsIgnoreCase("")) {
            product.setCategory(category);
        }
        if (!storekeeper.equalsIgnoreCase("")) {
            product.setStorekeeper(storekeeper);
        }
        if (!receiptDate.equalsIgnoreCase("")) {
            product.setReceiptDate(receiptDate);
        }
        if (price != -1) {
            product.setPrice(price);
        }
    }

    ArrayList<Product> search(String value) {
        ArrayList<Product> listSearch = new ArrayList<>();
        for (Product product : listSearch) {
            if (product.getName().toUpperCase().contains(value) || product.getCategory().toUpperCase().contains(value) || product.getStorekeeper().toUpperCase().contains(value) || product.getReceiptDate().toUpperCase().contains(value)) {
                listSearch.add(product);
            }
        }
        return listSearch;
    }

    public ArrayList<Product> sort() {
        list.sort(Comparator.comparing(Product::getExpiryDate));
        return list;
    }

}
