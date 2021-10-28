
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

    public void create() {
        String id, studentName, semester, courseName;
        for (int i = 0; i < 2; i++) {
            do {
                id = c.inputString("Enter ID : ", "Please input correct");
                studentName = c.inputString("Enter name of student : ", "Please input correct");
                semester = c.inputString("Enter semester : ", "Please input correct");
                courseName = c.inputString("Enter course name : ", "Please input correct");
            } while (c.checkExistID(id) && c.checkExistSName(studentName) && c.checkExistSemester(semester) && c.checkExistCName(courseName));
            c.addStudent(id, studentName, semester, courseName);
        }
        String choose;
        do {
            choose = c.inputString("Do you want to continue(Y/N)?", "Please input correct");
        } while (!choose.equalsIgnoreCase("Y") && !choose.equalsIgnoreCase("N"));
        if (choose.equalsIgnoreCase("Y")) {
            do {
                id = c.inputString("Enter ID : ", "Please input correct");
                studentName = c.inputString("Enter name of student : ", "Please input correct");
                semester = c.inputString("Enter semester : ", "Please input correct");
                courseName = c.inputString("Enter course name : ", "Please input correct");
            } while (c.checkExistID(id) && c.checkExistSName(studentName) && c.checkExistSemester(semester) && c.checkExistCName(courseName));
            c.addStudent(id, studentName, semester, courseName);
        }
        if (choose.equalsIgnoreCase("N")) {
            return;
        }
    }

    public void find() {
        String findValue = c.inputString("Enter the name of student you want to find : ", "Please input correct");
        ArrayList<Student> list = c.findStudent(findValue);
        if (list.isEmpty()) {
            System.out.println("Student not exist");
            return;
        }
        display(list);
    }

    public void display(ArrayList<Student> list) {
        if (list.isEmpty()) {
            System.err.println("Empty");
            return;
        }
        System.out.printf("%-25s%-25s%-25s%-25s", "id", "studentName", "semester", "courseName");
        for (Student student : list) {
            student.display();
        }
    }

    public void sort() {
        ArrayList<Student> list = c.sortStudent();
        display(list);
    }

    public void update() {

    }

    public void menu() {
        while (true) {
            System.out.println("1. Create");
            System.out.println("2. Find and sort");
            System.out.println("3. Update/Delete");
            System.out.println("4. Report");
            System.out.println("5. Exit");
            int choice = c.choice("Enter your choice : ", "Please input corrct", 1, 5);
            switch (choice) {
                case 1:
                    create();
                    break;
                case 2:
                    String choose;
                    do {
                        choose = c.inputString("Do you want to continue(Y/N)?", "Please input correct");
                    } while (!choose.equalsIgnoreCase("Y") && !choose.equalsIgnoreCase("N"));
                    break;
                case 3:
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
