/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import entities.Student;
import entities.Report;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Mr D
 */
public class InputValidation {

    Scanner sc = new Scanner(System.in);

    public int checkInputInteger(String mess) {
        while (true) {
            try {
                System.out.print(mess);
                int intNumber = Integer.parseInt(sc.nextLine().trim());
                if (intNumber < 0) {
                    throw new NumberFormatException();
                } else {
                    return intNumber;
                }
            } catch (NumberFormatException e) {
                System.err.println("Must be Integer and larger than 0");
                System.out.print(mess);
            }
        }
    }

    // check input option menu
    public int validateOption(String mess, int firstOption, int lastOption) {
        // declare
        int option;
        while (true) {
            try {
                System.out.print(mess);
                option = Integer.parseInt(sc.nextLine().trim());
                if (option < firstOption || option > lastOption) {
                    System.err.println("Option must between " + firstOption + " and " + lastOption);
                } else {
                    return option;
                }

            } catch (NumberFormatException e) {
                System.err.println("Option must be number between " + firstOption + " and " + lastOption);

            }
        }
    }

    public String checkEmptyString() {
        // declare
        String content;

        while (true) {
            content = sc.nextLine().trim();
            if (content.isEmpty()) {
                System.err.println("Must not be empty");
                System.out.print("Enter again: ");
            } else {
                return content;
            }
        }
    }

    public String checkName(String mess) {
        // declare
        while (true) {
            System.out.print(mess);
            String name = sc.nextLine().trim();
            if (name.isEmpty()) {
                System.err.println("Must not be empty");

            } else {
                return name;
            }
        }
    }

    public String checkNameFind(String mess) {

        System.out.print(mess);
        String name = sc.nextLine().trim();
        //System.err.println("Must not be empty");
        return name;

    }

    public String checkID(String mess) {
        while (true) {
            System.out.print(mess);
            String studentID = checkEmptyString();
            if (!studentID.matches("^[ST,st]{2}[0-9]{3}$")) {
                System.err.println("Student ID format is ST001");

            } else {
                return studentID.toUpperCase();
            }
        }
    }

    public int validateSemester(String mess, int firstOption, int lastOption) {
        // declare
        int semester;
        while (true) {
            try {
                System.out.print(mess);
                semester = Integer.parseInt(checkEmptyString());
                if (semester < firstOption || semester > lastOption) {
                    System.err.println("Semester choice must between " + firstOption + " and " + lastOption);
                } else {
                    return semester;
                }

            } catch (NumberFormatException e) {
                System.err.println("Semester choice is number between " + firstOption + " and " + lastOption);
            }
        }
    }

    //check id  exist
    public boolean checkIdExist(List<Student> list, String id) {
        for (Student s : list) {
            if (s.getId().equalsIgnoreCase(id)) {
                return true;
            }
        }
        return false;
    }
    //check user input course

    public String checkInputCourse(String mess) {
        //loop until user input correct
        while (true) {
            System.out.print(mess);
            String result = checkEmptyString();
            //check input course in java/ .net/ c/c++
            if (result.equalsIgnoreCase("java")
                    || result.equalsIgnoreCase(".net")
                    || result.equalsIgnoreCase("c/c++")) {
                return result;
            }
            System.err.println("There are only three courses: Java, .Net, C/C++");
        }
    }
// check input Continue Option (Y/N)

    public boolean checkContinue(String mess) {
        System.out.print(mess);
        while (true) {
            // check empty input
            String cont = checkEmptyString();
            // continue
            if (cont.equalsIgnoreCase("y")) {
                return true;
            }
            // stop
            if (cont.equalsIgnoreCase("n")) {
                return false;
            }
            // else
            System.err.println("Y/y to continue or N/n to stop");
        }
    }

    //check student exist
//    public  boolean checkStudentExist(ArrayList<Student> list, String id,
//            String studentName, String semester, String courseName) {
//        int size = list.size();
//        for (Student student : list) {
//            if (id.equalsIgnoreCase(student.getId())
//                    && studentName.equalsIgnoreCase(student.getStudentName())
//                    && semester.equalsIgnoreCase(student.getSemester())
//                    && courseName.equalsIgnoreCase(student.getCourseName())) {
//                return false;
//            }
//        }
//        return true;
//    }
    //check user input u / d
    public boolean checkInputUD(String mess) {
        System.out.print(mess);
        //loop until user input correct
        while (true) {

            String result = checkEmptyString();
            //return true if user input u/U
            if (result.equalsIgnoreCase("U")) {
                return true;
            }
            //return false if user input d/D
            if (result.equalsIgnoreCase("D")) {
                return false;
            }
            System.err.print(mess);

        }

    }

    //check report exist
    public boolean checkReportExist(List<Report> lr, String id, String name,
            String course) {
        for (Report report : lr) {
            if (id.equalsIgnoreCase(report.getId())
                    && name.equalsIgnoreCase(report.getStudentName())
                    && course.equalsIgnoreCase(report.getCourseName())) {
                return false;
            }
        }
        return true;
    }

    public String checkNameExist(List<Student> list, String id) {
        for (Student student : list) {
            if (student.getId().equals(id)) {
                return student.getStudentName();
            }
        }

        return "";
    }

    public boolean checkCourseExist(List<Student> list, String course, int semester,
            String id, String name) {
        for (Student student : list) {
            if (student.getSemester() == semester
                    && student.getCourseName().equals(course)
                    && student.getId().equals(id)
                    && student.getStudentName().equals(name)) {
                return true;
            }
        }
        return false;
    }

}
