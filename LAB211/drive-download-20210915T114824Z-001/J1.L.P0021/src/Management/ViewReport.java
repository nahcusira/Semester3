/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Management;

import java.util.List;
import entities.Report;

/**
 *
 * @author Admin
 */
public class ViewReport {

    public void displayReport(List<Report> lr) {
        if (!lr.isEmpty()) {
            System.out.printf("%-15s|%-10s|%-5s\n", "Name", "Course Name", "Total");
            for (Report report : lr) {
                System.out.printf("%-15s|%-11s|%-5d\n", report.getStudentName(), report.getCourseName(), report.getTotalCourse());
            }
        }
    }
}
