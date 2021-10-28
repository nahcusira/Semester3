/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import control.Controller;
//import static control.Controller.inputId;
import control.Validation;
import model.Task;

/**
 *
 * @author hn919
 */
public class Main {

    public static void main(String[] args) {
        Controller ctl = new Controller();
        while (true) {
            System.out.println("===== Task Program =====");
            System.out.println("1.Add task");
            System.out.println("2.Delete task");
            System.out.println("3.Display task");
            System.out.println("4. Exit");
            System.out.print("Enter Your Choice: ");
            int choice = Validation.checkIntLimit(1, 4);
            switch (choice) {
                case 1: {
                    if (ctl.addTask(inputTask())) {
                        System.out.println("Add successfull");
                    } else {
                        System.out.println("Add false");
                    }
                    break;
                }
                case 2: {

                    if (ctl.deleteTask(inputId())) {
                        System.out.println("Delete successfull");
                        

                    } else {
                        System.out.println("Delete false, ID not exist");
                    }
                    break;
                }
                case 3: {
                    System.out.println("-----Task-----");
                    System.out.printf("%-5s%-15s%-15s%-15s%-15s%-15s\n", "ID", "Name", "Task Type", "Date", "Time", "Assignee", "Reviewer");
                    for (Task objTask : ctl.getDataTask()) {
                        System.out.println(objTask);
                    }
                    break;
                }

                case 4: {
                    System.out.println("Exit Program!");
                    return;
                }

            }
        }

    }

    //input id to delete
    public static int inputId() {
        System.out.print("Input Id:");
        int id = Validation.inputNumber(); //input in need delete
        return id;
    }

    //input value
    public static Task inputTask() {
        Task objTask = new Task();
        System.out.print("Requirement Name: ");
        objTask.setName(Validation.inputString()); //input name
        System.out.print("Task Type: ");
        objTask.setTypeId(Validation.inputTaskType());
        objTask.setDate(Validation.inputDate()); // input date
        System.out.print("From: ");
        objTask.setFrom(Validation.inputTime());//input timefrom
        System.out.print("To: ");
        objTask.setTo(Validation.inputTimeTo(objTask.getFrom())); //input time to , time to > time from
        System.out.print("Assignee: ");
        objTask.setAssignee(Validation.inputString());//input Assign
        System.out.print("Reviewer: ");
        objTask.setReviewer(Validation.inputString());// input reviewer
        return objTask;
    }

}
