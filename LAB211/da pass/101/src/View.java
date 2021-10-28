
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

    public void add() {
        String id = c.inputString("Enter ID : ", "Please input correct", "[a-zA-Z0-9 ]+");
        if (c.checkExist(id)) {
            System.err.println("Employee is exist");
            return;
        }
        String fName = c.inputString("Enter first name : ", "Please input correct", "[a-zA-Z ]+");
        String lName = c.inputString("Enter last name : ", "Please input correct", "[a-zA-Z ]+");
        String phone = c.inputString("Enter phone : ", "Please input correct", "[0-9]+");
        String email = c.inputString("Enter mail : ", "Please input correct", "^[0-9A-Za-z+_.%]+@[0-9A-Za-z.-]+\\.[A-Za-z]{2,4}$");
        String address = c.inputString("Enter address : ", "Please input correct", "[a-zA-Z ]+");
        String dob = c.inputDate("Enter DOB (dd/MM/yyyy) : ", "Please input correct", "dd/MM/yyyy");
        String sex;
        do {
            sex = c.inputString("Enter gender (Male/Female) : ", "Please input correct", "[a-zA-Z ]+");
        } while (!sex.equalsIgnoreCase("Female") && !sex.equalsIgnoreCase("Male"));
        double salary = c.inputDouble("Enter salary : ", "Please input correct");
        String egency = c.inputString("Enter egency : ", "Please input correct", "[a-zA-Z ]+");
        c.addEmployee(id, fName, lName, phone, email, address, dob, sex, salary, egency);
    }

    public void update() {
        String id = c.inputString("Enter ID : ", "Please input correct", "[a-zA-Z0-9 ]+");
        if (c.checkExist(id)) {
            String fName = c.inputStringUpdate("Enter first name : ", "Please input correct", "[a-zA-Z ]+");
            String lName = c.inputStringUpdate("Enter last name : ", "Please input correct", "[a-zA-Z ]+");
            String phone = c.inputStringUpdate("Enter phone : ", "Please input correct", "[0-9]+");
            String email = c.inputStringUpdate("Enter mail : ", "Please input correct", "^[0-9A-Za-z+_.%]+@[0-9A-Za-z.-]+\\.[A-Za-z]{2,4}$");
            String address = c.inputStringUpdate("Enter address : ", "Please input correct", "[a-zA-Z ]+");
            String dob = c.inputDate("Enter DOB (dd/MM/yyyy) : ", "Please input correct", "dd/MM/yyyy");
            String sex;
            do {
                sex = c.inputStringUpdate("Enter gender (Male/Female) : ", "Please input correct", "[a-zA-Z ]+");
            } while (!sex.equalsIgnoreCase("Female") && !sex.equalsIgnoreCase("Male") && !sex.isEmpty());
            double salary = c.inputDoubleUpdate("Enter salary : ", "Please input correct");
            String egency = c.inputStringUpdate("Enter egency : ", "Please input correct", "[a-zA-Z ]+");
            c.updateEmployee(id, fName, lName, phone, email, address, dob, sex, salary, egency);
        } else {
            System.err.println("Not found employee");
            return;
        }
    }

    public void remove() {
        String id = c.inputString("Enter ID : ", "Please input correct", "[a-zA-Z0-9 ]+");
        if (c.checkExist(id)) {
            c.remove(id);
            System.err.println("Successfull");
        } else {
            System.err.println("Not found employee");
        }
    }

    public void display(ArrayList<Employee> list) {
        if (list.isEmpty()) {
            System.err.println("Empty");
            return;
        }
        System.out.printf("%-25s%-25s%-25s%-25s%-25s%-25s%-25s%-25s%-25s%-25s\n", "ID", "First Name", "Last Name", "Phone", "Email", "Address", "DOB", "Sex", "Salary", "Egency");
        for (Employee employee : list) {
            employee.display();
        }
    }

    public void search() {
        String searchValue = c.inputString("Enter the Name you want to search : ", "Please input correct", "[a-zA-Z ]+");
        ArrayList<Employee> list = c.searchEmployee(searchValue);
        if (list.isEmpty()) {
            System.err.println("Employee not exist");
            return;
        }
        display(list);
    }

    public void sort() {
        ArrayList<Employee> list = c.sortEmployee();
        display(list);
    }

    public void menu() {
        while (true) {
            System.out.println("1. Add employee");
            System.out.println("2. Update employee");
            System.out.println("3. Remove employee");
            System.out.println("4. Search employee");
            System.out.println("5. Sort employee by salary");
            System.out.println("6. Exit");
            int choice = c.choice("Enter your choice : ", "Please input correct", 1, 6);
            switch (choice) {
                case 1:
                    add();
                    break;
                case 2:
                    update();
                    break;
                case 3:
                    remove();
                    break;
                case 4:
                    search();
                    break;
                case 5:
                    sort();
                    break;
                case 6:
                    return;
            }
        }
    }

    public static void main(String[] args) {
        View v = new View();
        v.menu();
    }

}
