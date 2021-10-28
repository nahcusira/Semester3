
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

    ArrayList<Student> list = new ArrayList<>();

    public Controller() {
    }

    public void addStudent(String id, String studentName, String semester, String courseName) {
        list.add(new Student(id, studentName, semester, courseName));
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
            } catch (Exception e) {
                System.err.println(err);
            }
        }
    }

    public String inputString(String mess, String err) {
        while (true) {
            try {
                System.out.println(mess);
                String result = sc.nextLine().trim();
                if (result.isEmpty()) {
                    System.err.println(err);
                } else {
                    return result;
                }
            } catch (Exception e) {
                System.err.println(err);
            }
        }
    }

     public Student getStudent(String get) {
        for (Student student : list) {
            if (student.getId().equalsIgnoreCase(get)) {
                return student;
            }
        }
        return null;
    }

    public void updateStudent(String id, String studentName, String semester, String courseName) {
        Student student = getStudent(id);
        student.setStudentName(studentName);
        student.setSemester(semester);
        student.setCourseName(courseName); 
    }

    public void delete(String id) {
        Student student = getStudent(id);
        if (student == null) {
            return;
        } else {
            list.remove(student);
        }
    }

    public ArrayList<Student> findStudent(String findValue) {
        ArrayList<Student> listFind = new ArrayList<>();
        for (Student student : list) {
            if (student.getStudentName().toLowerCase().contains(findValue)) {
                listFind.add(student);
            }
        }
        return listFind;
    }

    public ArrayList<Student> sortStudent() {
        list.sort(Comparator.comparing(Student::getStudentName));
        return list;
    }

}
