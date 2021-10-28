
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
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

    ArrayList<Employee> list = new ArrayList<>();

    public Controller() {
    }

    public ArrayList<Employee> getList() {
        return list;
    }

    public void addEmployee(String id, String fName, String lName, String phone, String email, String address, String dob, String sex, double salary, String egency) {
        list.add(new Employee(id, fName, lName, phone, email, address, dob, sex, salary, egency));
    }

    public boolean checkExist(String id) {
        for (Employee employee : list) {
            if (employee.getId().equalsIgnoreCase(id)) {
                return true;
            }
        }
        return false;
    }

    public int choice(String mess, String err, int min, int max) {
        while (true) {
            try {
                System.out.println(mess);
                int result = Integer.parseInt(sc.nextLine().trim());
                if (result < min || result > max) {
                    throw new NumberFormatException();
                }
                return result;
            } catch (NumberFormatException e) {
                System.err.println(err);
            }
        }
    }

    public String inputString(String msg, String err, String regex) {
        String result = null;
        while (true) {
            System.out.print(msg);
            result = sc.nextLine().trim();
            if (!result.matches(regex)) {
                System.err.println(err);
            } else {
                return result;
            }

        }
    }

    public String inputStringUpdate(String msg, String err, String regex) {
        String result = null;
        while (true) {
            System.out.print(msg);
            result = sc.nextLine();
            if (result.isEmpty()) {
                return result;
            }
            if (!result.matches(regex)) {
                System.err.println(err);
            } else {
                return result;
            }

        }
    }

    public double inputDouble(String mess, String err) {
        while (true) {
            try {
                System.out.print(mess);
                double result = Double.parseDouble(sc.nextLine().trim());
                if (result < 0) {
                    System.err.println(err);
                } else {
                    return result;
                }
            } catch (NumberFormatException e) {
                System.err.println(err);
            }
        }
    }

    public double inputDoubleUpdate(String mess, String err) {
        double n;
        System.out.print(mess);
        while (true) {
            try {
                String result = sc.nextLine();
                if (result.equals("")) {
                    return -1;
                }
                n = Double.parseDouble(result);
                if (n < 0) {
                    System.out.println(err);
                }
                return n;
            } catch (NumberFormatException e) {
            }
        }
    }

    public String inputDate(String mess, String err, String format) {
        SimpleDateFormat sdfin = new SimpleDateFormat(format);
        Date date;
        sdfin.setLenient(false);
        SimpleDateFormat sdfout = new SimpleDateFormat(format);
        System.out.print(mess);
        while (true) {
            try {
                mess = sc.nextLine().trim();
                date = sdfin.parse(mess);
                Date now = new Date();
                String txt[] = mess.split("/");
                int year = Integer.parseInt(txt[2]);
                int age = 2021 - year;
                if (date.after(now) || age < 18) {
                    System.err.println(err);
                    continue;
                }
                break;
            } catch (NumberFormatException | ParseException e) {
                System.err.println(err);
            }
            try {
                date = sdfout.parse(mess);
                break;
            } catch (ParseException e) {
                System.err.println(err);
            }
        }
        return sdfout.format(date);
    }

    public Employee getIdEmployee(String id) {
        for (Employee employee : list) {
            if (employee.getId().equalsIgnoreCase(id)) {
                return employee;
            }
        }
        return null;
    }

    public void updateEmployee(String id, String fName, String lName, String phone, String email, String address, String dob, String sex, double salary, String egency) {
        Employee employee = getIdEmployee(id);
        if (!"".equals(fName)) {
            employee.setfName(fName);
        }
        if (!"".equals(lName)) {
            employee.setlName(lName);
        }
        if (!"".equals(phone)) {
            employee.setPhone(phone);
        }
        if (!"".equals(email)) {
            employee.setEmail(email);
        }
        if (!"".equals(address)) {
            employee.setAddress(address);
        }
        if (!"".equals(dob)) {
            employee.setDob(dob);
        }
        if (!"".equals(sex)) {
            employee.setSex(sex);
        }
        if (salary != -1) {
            employee.setSalary(salary);
        }
        if (!"".equals(egency)) {
            employee.setEgency(egency);
        }
    }

    public void remove(String id) {
        Employee employee = getIdEmployee(id);
        if (employee == null) {
            return;
        } else {
            list.remove(employee);
        }
    }

    public ArrayList<Employee> searchEmployee(String searchValue) {
        ArrayList<Employee> listSearch = new ArrayList<>();
        for (Employee employee : list) {
            if (employee.getfName().toLowerCase().contains(searchValue) || employee.getlName().toLowerCase().contains(searchValue)) {
                listSearch.add(employee);
            }
        }
        return listSearch;
    }

    public ArrayList<Employee> sortEmployee() {
        list.sort(Comparator.comparing(Employee::getSalary));
        return list;
    }

}
