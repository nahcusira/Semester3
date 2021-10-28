package view;

import controller.Management;
import controller.Validate;
import java.util.ArrayList;
import model.Employee;

public class Main {

    String fName, lName, phone, Email, Address, dob, egency;
    int boo;
    double salary;
    Boolean sex = null;
    Management m = new Management();
    Validate validate = new Validate();

    public void inputInfor() {
        fName = validate.inputString("First Name: ",
                "First name is required!", "[a-zA-Z ]+");
        lName = validate.inputString("Last Name: ",
                "Last name is required!", "[a-zA-Z ]+");
        phone = validate.inputString("Phone: ",
                "Phone is required and is ditgits!", "[0-9]{10,11}");
        Email = validate.inputString("Email: ",
                "Invalid is Email!", "^[0-9A-Za-z+_.%]+@[0-9A-Za-z.-]+\\.[A-Za-z]{2,4}$");
        Address = validate.inputString("Adrress: ",
                "Adress is required!", "[a-zA-Z ]+");
        dob = validate.inputDate("DOB: ", "Invalid format!", "dd/MM/yyyy");
        boo = validate.inputIntLimit("Sex(1.Male/2.Female): ", "Invalid sex!", 1, 2);

        if (boo == 1) {
            sex = true;
        } else if (boo == 2) {
            sex = false;
        }
        salary = validate.inputDoubleLimit("Salary: ", "Invalid salary!",
                1, Double.MAX_VALUE);
        egency = validate.inputString("Egency: ", "invalid!", "[a-zA-Z ]+");
    }

    public void addEmployeeView() {
        System.out.println("\n-------- Add Employees --------");

        int id = 0;
        while (true) {
            id = validate.inputIntLimit("Id: ", "Invalid Id!", 1, Integer.MAX_VALUE);
            if (validate.checkDuplicateId(id, m.getListEmployees())) {
                System.out.println("Duplicate!");
            } else {
                break;
            }
        }
        inputInfor();
        boolean checkadd = m.addEmployee(id, fName, lName, phone, Email, Address, dob, sex, salary, egency);
        if (checkadd == true) {
            System.out.println("Add successful!");
        } else {
            System.err.println("Add fail!");
        }
    }

    public void UpdateEmployeeView() {
        System.out.println("\n-------- Update Employee --------");

        int id = 0;
        id = validate.inputIntLimit("Id: ", "Invalid Id!", 0, Integer.MAX_VALUE);
        Employee em = null;
        em = m.getEployeeById(id);
        if (em == null) {
            System.out.println("Id not exist!");
            return;
        }
        inputInfor();
        m.updateEmployee(id, fName, lName, phone, Email, Address, dob, sex, salary, egency);
        System.out.println("Update succesfull!");
    }

    public void searchEmployeeView() {

        System.out.println("-------- Search Employee --------");
        System.out.println("");
        String searchValue = validate.inputSearchValue("Enter name: ");
        ArrayList<Employee> listEmployee = m.searchEmployeeByName(searchValue);
        if (listEmployee.isEmpty()) {
            System.out.println("List is empty");
            return;
        }
        showEmployees(listEmployee);
    }

    public void RemoveEmployeeView() {

        System.out.println("-------- Remove Employee --------");
        int id = validate.inputIntLimit("Id: ", "Invalid id!", 0, Integer.MAX_VALUE);
        if (m.removeEmployee(id)) {
            System.out.println("Remove successful!");
        } else {
            System.out.println("Not found employee");
        }
    }

    public void sortEmployeeView() {
        ArrayList<Employee> listEmployee = m.sortEmployeeBySalary();
        showEmployees(listEmployee);
    }

    public void showEmployees(ArrayList<Employee> listEmployee) {
        if (listEmployee.isEmpty()) {
            System.err.println("List empty.");
            return;
        }
        System.out.printf("\n%-5s%-15s%-15s%-15s%-26s%-10s%-12s%-10s%-10s%-10s\n",
                "ID", "First Name", "Last Name", "Phone", "Email", "Adress", "DOB",
                "Sex", "Salary", "Egency");
        for (int i = 0; i < listEmployee.size(); i++) {
            Employee employee = listEmployee.get(i);
            System.out.printf("%-5s%-15s%-15s%-15s%-26s%-10s%-12s%-10s%-10.1f%-10s\n",
                    employee.getId(),
                    employee.getFirstName(),
                    employee.getLastName(),
                    employee.getPhone(),
                    employee.getEmail(),
                    employee.getAddress(),
                    employee.getDob(),
                    employee.isSex() ? "Male" : "Female",
                    employee.getSalary(),
                    employee.getAgency()
            );
        }
    }

    public void display() {

        while (true) {
            System.out.println("1. Add employees");
            System.out.println("2. Update employees");
            System.out.println("3. Remove employees");
            System.out.println("4. Search employees");
            System.out.println("5. Sort employees by salary");
            System.out.println("6. Exit");
            int choice = validate.inputIntLimit("Your choice: ",
                    "Input must in range[1-6]!", 1, 6);
            switch (choice) {
                case 1:
                    addEmployeeView();
                    break;
                case 2:
                    UpdateEmployeeView();
                    break;
                case 3:
                    RemoveEmployeeView();
                    break;
                case 4:
                    searchEmployeeView();
                    break;
                case 5:
                    sortEmployeeView();
                    break;
                case 6:
                    System.exit(0);
                    break;
            }
        }
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.display();
    }
}
