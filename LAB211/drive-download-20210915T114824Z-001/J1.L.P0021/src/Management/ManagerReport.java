package Management;

import entities.Report;
import entities.Student;
import utils.InputValidation;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/**
 *
 * @author admin
 */
public class ManagerReport {
    //Print report
    public List<Report> makeReport(List<Student> list) {
        InputValidation v = new InputValidation();
        ArrayList<Report> lr = new ArrayList<>();
        for (Student student : list) {
            int total = 0;
            String id = student.getId();
            String courseName = student.getCourseName();
            String studentName = student.getStudentName();
            for (Student studentCountTotal : list) {
                if (id.equalsIgnoreCase(studentCountTotal.getId())
                        && courseName.equalsIgnoreCase(studentCountTotal.getCourseName())) {
                    total++;
                }
            }
            if (v.checkReportExist(lr, id, studentName, courseName)) {
                lr.add(new Report(id, studentName, courseName, total));
            }
        }
        Collections.sort(lr);
        //print report
        return lr;
    }

}
