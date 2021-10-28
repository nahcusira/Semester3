
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
        String code = c.inputString("Enter Code : ", "Please input correct!");
        if (c.checkExist(code)) {
            System.err.println("Doctor Exist!");
            return;
        }
        String name = c.inputString("Enter Name : ", "Please input correct!");
        String Specialization = c.inputString("Enter Specialization : ", "Please input correct!");
        int availablity = c.inputInt("Enter Availablity : ", "Please input correct!");
        c.addDoctor(code, name, Specialization, availablity);
    }

    public void update() {
        String code = c.inputString("Enter Code : ", "Please input correct!");
        if (c.checkExist(code)) {
            String name = c.inputStringUpdate("Enter Name : ", "Please input correct!", "[a-zA-Z ]+");
            String Specialization = c.inputStringUpdate("Enter Specialization : ", "Please input correct!", "[a-zA-Z ]+");
            int availablity = c.inputIntUpdate("Enter Availablity : ", "Please input correct!");
            c.updateDoctor(code, name, Specialization, availablity);
        } else {
            System.err.println("Not found doctor");
            return;
        }
    }

    public void delete() {
        String code = c.inputString("Enter the code you want to delete : ", "Please input correct!");
        if (c.checkExist(code)) {
            c.removeDocter(code);
            System.err.println("Successful");
        } else {
            System.err.println("Not found doctor");
        }
    }

    public void display(ArrayList<Doctor> list) {
        if (list.isEmpty()) {
            System.err.println("List is empty!");
            return;
        }
        System.out.printf("%-20s%-25s%-20s%-25s\n", "Code", "Name", "Specialization", "Availablity");
        for (Doctor doctor : list) {
            doctor.display();
        }
    }

    public void search() {
        String searchValue = c.inputString("Enter the code you want to search : ", "Please input correct!");
        ArrayList<Doctor> list = c.searchDoctor(searchValue);
        if (list.isEmpty()) {
            System.err.println("Doctor not exist");
            return;
        }
        display(list);
    }

    public void menu() {
        while (true) {
            System.out.println("1. Add Doctor");
            System.out.println("2. Update Doctor");
            System.out.println("3. Delete Doctor");
            System.out.println("4. Search Doctor");
            System.out.println("5. Exit");
            int choice = c.choice("Enter your choice : ", "Please choice correct", 1, 5);
            switch (choice) {
                case 1:
                    input();
                    break;
                case 2:
                    update();
                    break;
                case 3:
                    delete();
                    break;
                case 4:
                    search();
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
