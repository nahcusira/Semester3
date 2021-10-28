package Management;

import entities.Student;
import utils.InputValidation;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author admin
 */
public class ManagerStudent {

    List<Student> studentList = new ArrayList<>();

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    public void initialList() {

        studentList.add(new Student("ST001", "HienA", 1, "Java"));
        studentList.add(new Student("ST002", "HienB", 5, "C/C++"));
        studentList.add(new Student("ST003", "HienC", 4, ".Net"));
        studentList.add(new Student("ST001", "HienA", 2, "Java"));
        studentList.add(new Student("ST001", "HienA", 3, "Java"));
        studentList.add(new Student("ST001", "HienA", 3, ".Net"));
    }

    // create new student
    public void createStudent() {
        InputValidation v = new InputValidation();

        String id = v.checkID("Enter id:");
        if (v.checkIdExist(studentList, id)) {
            String name = v.checkNameExist(studentList, id);
            System.out.println("Name Student : " + name);
            int semester = v.validateSemester("Enter semester: ", 1, 9);
            String course;
            while (true) {
                course = v.checkInputCourse("Enter name course: ");
                if (v.checkCourseExist(studentList, course, semester, id, name)) {
                    System.err.println("Course is Exit ,Please Enter aligan");
                } else {
                    break;
                }
            }
            studentList.add(new Student(id, name, semester, course));
            System.out.println("Add student success.");
        } else {
            String name = v.checkName("Enter name student: ");
            int semester = v.validateSemester("Enter semester: ", 1, 9);
            String course = v.checkInputCourse("Enter name course: ");
            studentList.add(new Student(id, name, semester, course));
            System.out.println("Add student success.");
        }
    }

    public List<Student> findAndSort() {
      
        InputValidation v = new InputValidation();

        String keySearch = v.checkNameFind("Enter name to search: ");
        
//        if(keySearch.equals("")){
//            
//        }
        
        List<Student> listStudentFAS = listStudentFindByName(keySearch);
        Collections.sort(listStudentFAS);
        return listStudentFAS;
    }
    //find list

    public List<Student> listStudentFindByName(String keySearh) {
        ArrayList<Student> listStudentFindByName = new ArrayList<>();
        for (Student student : studentList) {
            //check student have name contains input
            if (student.getStudentName().toLowerCase().contains(keySearh.toLowerCase())) {
                listStudentFindByName.add(student);
            }
        }
        if (listStudentFindByName.isEmpty()) {
            System.err.println("Not exist.");
        }
        return listStudentFindByName;
    }

    public void update(List<Student> studentChange) {
        InputValidation v = new InputValidation();
        int semester = 0;
        String course = "";
        String name = "";
        String idStudent = v.checkID("Enter id:");
        if (v.checkIdExist(studentList, idStudent)) {
            name = v.checkNameExist(studentList, idStudent);
            System.out.println("Name Student : " + name);
        } else {
            name = v.checkName("Enter name student: ");
        }

        int index = v.checkInputInteger("Enter index in list: ");
        while (true) {
            semester = v.validateSemester("Enter semester: ", 1, 9);
            course = v.checkInputCourse("Enter name course: ");
            if (v.checkCourseExist(studentList, course, semester, idStudent, name)) {
                System.err.println("Course is Exist ,Please Enter again");
            } else {
                break;
            }
        }

        for (Student student : studentChange) {
            student.setId(idStudent);
            student.setStudentName(name);
            if (student.getIdEdit() == index) {
                student.setSemester(semester);
                student.setCourseName(course);
            }
        }
    }

    public boolean delete(String id, int index) {
        int current = -1;

        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getId().equals(id)) {
                current++;
                if (current == index) {
                    studentList.remove(studentList.get(i));
                    return true;
                }
            }
        }
        return false;
    }

    //update and delete   
    public void updateOrDelete() {
        InputValidation v = new InputValidation();
        ViewStudent viewStudent = new ViewStudent();
        String id = v.checkID("Enter id: ");
        if (v.checkIdExist(studentList, id)) {
            List<Student> studentChange = getStudentbyId(id);
            viewStudent.displayListChange(studentChange);
            if (v.checkInputUD("Press U/u to update or D/d to delete student: ")) {
                update(studentChange);
                System.err.println("Update success.");
            } else {
                int index = v.checkInputInteger("Enter index in list: ");
                if (delete(id, index)) {
                    System.err.println("Delete success.");
                } else {
                    System.err.println("Delete fail");

                }
            }
        } else {
            System.err.println("Not found student");
            return;
        }

    }

    //Get list student find by id
    public ArrayList<Student> getStudentbyId(String id) {
        ArrayList<Student> listS = new ArrayList<>();
        for (Student s : studentList) {
            if (id.equalsIgnoreCase(s.getId())) {
                listS.add(s);
            }
        }
        return listS;
    }

}
