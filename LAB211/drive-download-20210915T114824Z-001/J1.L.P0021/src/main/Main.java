package main;

import Management.ViewStudent;
import Management.ViewReport;
import Management.ManagerReport;
import Management.ManagerStudent;
import java.io.IOException;
import java.util.List;
import entities.Report;
import entities.Student;
import utils.InputValidation;

/**
 *
 * @author admin
 */
public class Main {

    public static void main(String[] args) throws IOException {
        ManagerStudent ms = new ManagerStudent();
        ManagerReport mr = new ManagerReport();
        InputValidation v = new InputValidation();
        ViewReport viewReport = new ViewReport();
        ViewStudent viewStudent = new ViewStudent();
        ms.initialList();
        while (true) {
            System.out.println("--- WELLCOME TO STUDENT MANAGEMENT ---");
            System.out.println("1. Create");
            System.out.println("2. Find and Sort");
            System.out.println("3. Update/Delete");
            System.out.println("4. Report");
            System.out.println("5. Exit");
            int choice = v.validateOption("Your choice: ", 1, 5);

            switch (choice) {
                case 1:
                    if (ms.getStudentList().size() > 10) {
                        if (!v.checkContinue("Do you want to continue (y/n)? ")) {
                            return;
                        }
                    }
                    ms.createStudent();
                    viewStudent.displayList(ms.getStudentList());
                    break;
                case 2:
                    List<Student> findAndSortResults = ms.findAndSort();
                    viewStudent.displayList(findAndSortResults);
                    break;
                case 3:
                    if (ms.getStudentList().isEmpty()) {
                        System.err.println("List empty.");
                    } else {
                        ms.updateOrDelete();
                    }

                    break;
                case 4:
                    if (ms.getStudentList().isEmpty()) {
                        System.err.println("List empty.");
                    } else {
                        List<Report> reports = mr.makeReport(ms.getStudentList());
                        viewReport.displayReport(reports);
                    }

                    break;
                case 5:
                    return;
            }

        }
    }
}
