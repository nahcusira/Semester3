

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

    void add() {
        System.out.print("Enter Requirement Name : ");
        String requirementName = c.checkInputString();
        System.out.print("Enter Task Type(1.code 2.test 3.design 4.review) : ");
        String taskTypeId = c.checkInputTaskTypeId();
        System.out.print("Enter Date(dd/MM/yyyy) : ");
        String date = c.checkInputDate();
        System.out.print("Enter PlanFrom(8h -> 17h30 <=> 8.0, 8.5, 9.0, 9.5 … ->  17.5) : ");
        String planFrom = c.checkInputPlan();
        System.out.print("Enter PlanTo(8h -> 17h30 <=> 8.0, 8.5, 9.0, 9.5 … ->  17.5) : ");
        String planTo = c.checkInputPlanTo(planFrom);
        System.out.print("Enter Assignee : ");
        String assign = c.checkInputString();
        System.out.print("Enter Reviewer : ");
        String reviewer = c.checkInputString();
        if (c.checkExist(taskTypeId, requirementName, date, planFrom, planTo, assign, reviewer)) {
            System.err.println("Exist");
            return;
        }
        c.add(taskTypeId, requirementName, date, planFrom, planTo, assign, reviewer);
    }

//    int find() {
//        System.out.print("Enter ID you want to delete : ");
//        int id = c.CheckInputInt();
//        return c.find(id);
//    }

    void delete() {/*
        if (c.list.isEmpty()) {
            System.err.println("List Empty");
            return;
        }
        int FindId = find();
        if (FindId != -1) {
            c.list.remove(FindId);
            System.err.println("Successful");
            for (int i = FindId; i < c.list.size(); i++) {
                c.list.get(i).setId(c.list.get(i).getId() - 1);
            }
        }*/
        System.out.print("Enter ID you want to delete : ");
        int id = c.CheckInputInt();
        c.delete(id);
    }

    void display() {
        if (c.list.isEmpty()) {
            System.err.println("List Empty");
            return;
        }
        System.out.printf("%-5s%-15s%-15s%-15s%-15s%-15s%-15s\n", "ID", "Name", "Task Type", "Date", "Time", "Assign", "Reviewer");
        for (int i = 0; i < c.list.size(); i++) {
            System.out.printf("%-5d%-15s%-15s%-15s%-15.1f%-15s%-15s\n",
                    c.list.get(i).getId(),
                    c.list.get(i).getRequirementName(),
                    c.list.get(i).getTaskTypeId(),
                    c.list.get(i).getDate(),
                    Double.parseDouble(c.list.get(i).getPlanTo()) - Double.parseDouble(c.list.get(i).getPlanFrom()),
                    c.list.get(i).getAssign(),
                    c.list.get(i).getReviewer());
        }
    }

    void update() {
        System.out.print("Enter ID : ");
        int id = c.CheckInputInt();
        if (c.find(id) != -1) {
            System.out.print("Enter Requirement Name : ");
            String requirementName = c.checkInputString();
            System.out.print("Enter Task Type(1.code 2.test 3.design 4.review) : ");
            String taskTypeId = c.checkInputTaskTypeIdUpdate();
            System.out.print("Enter Date(dd/MM/yyyy) : ");
            String date = c.checkInputDate();
            System.out.print("Enter PlanFrom(8h -> 17h30 <=> 8.0, 8.5, 9.0, 9.5 … ->  17.5) : ");
            String planFrom = c.checkInputPlan();
            System.out.print("Enter PlanTo(8h -> 17h30 <=> 8.0, 8.5, 9.0, 9.5 … ->  17.5) : ");
            String planTo = c.checkInputPlan();
            for (int i = 0; i < c.list.size(); i++) {
                if (Double.parseDouble(planFrom) > Double.parseDouble(c.list.get(i).getPlanTo())) {
                    System.out.print("Re-enter PlanTo(8h -> 17h30 <=> 8.0, 8.5, 9.0, 9.5 … ->  17.5) : ");
                    planTo = c.checkInputPlan();
                    break;
                }
                if (planFrom.equalsIgnoreCase("nope") && planTo.equalsIgnoreCase("nope") || planTo.equalsIgnoreCase("nope")) {
                    break;
                }
                if (Double.parseDouble(planTo) <= Double.parseDouble(c.list.get(i).getPlanFrom())) {
                    System.out.print("Re-enter PlanFrom(8h -> 17h30 <=> 8.0, 8.5, 9.0, 9.5 … ->  17.5) : ");
                    planFrom = c.checkInputPlan();
                    break;
                }
            }
            System.out.print("Enter Assignee : ");
            String assign = c.checkInputString();
            System.out.print("Enter Reviewer : ");
            String reviewer = c.checkInputString();
            c.update(id, taskTypeId, requirementName, date, planFrom, planTo, assign, reviewer);
        } else {
            System.out.println("Not found");
            return;
        }
    }

    void menu() {
        while (true) {
            System.out.println("1. Add task");
            System.out.println("2. Delete task");
            System.out.println("3. Display task");
            System.out.println("4. Exit");
            System.out.println("5. Update");
            System.out.print("Enter your choice : ");
            int choice = c.CheckChoice(1, 5);
            switch (choice) {
                case 1:
                    add();
                    break;
                case 2:
                    delete();
                    break;
                case 3:
                    display();
                    break;
                case 4:
                    return;
                case 5:
                    update();
            }
        }
    }

    public static void main(String[] args) {
        View v = new View();
        v.menu();
    }
}
