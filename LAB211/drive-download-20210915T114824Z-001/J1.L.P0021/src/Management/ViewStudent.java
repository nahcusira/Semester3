/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Management;

import java.util.List;
import entities.Student;

/**
 *
 * @author Admin
 */
public class ViewStudent {

    public void displayList(List<Student> list) {
        if (!list.isEmpty()) {
            System.out.printf("%-15s%-20s%-10s%-10s\n", "id", "studentName", "semester", "courseName");
            for (Student student : list) {
                student.print();
            }
        }
    }
    
    public void displayListChange(List<Student> list){
        
        int idEdit = 0;
            System.out.printf("%-10s%-10s%-12s%-15s%-18s\n", "STT", "ID", "Name", "  Semester", "course name ");
            for (Student student : list) {
                student.setIdEdit(idEdit++);
                System.out.printf("%-10d%-10s%-15s%-15s%-15s\n", student.getIdEdit(), student.getId(),
                        student.getStudentName(), student.getSemester(),
                        student.getCourseName());
            }

    }
        
    
}
