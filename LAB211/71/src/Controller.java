
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
    ArrayList<Task> list = new ArrayList<>();

    public Controller() {
    }

    public ArrayList<Task> getList() {
        return list;
    }

    public void add(String taskTypeId, String requirementName, String date, String planFrom, String planTo, String assign, String reviewer) {
        int id = input_ID();
        list.add(new Task(id, taskTypeId, requirementName, date, planFrom, planTo, assign, reviewer));
    }

    private int input_ID() {
        int id;
        if (list.isEmpty()) {
            id = 1;
        } else {
            id = list.get(list.size() - 1).getId() + 1;
        }
        return id;
    }

    public boolean checkExist(String taskTypeId, String requirementName, String date, String planFrom, String planTo, String assign, String reviewer) {
        for (Task task : list) {
            if (task.getRequirementName().equalsIgnoreCase(requirementName) && task.getTaskTypeId().equalsIgnoreCase(taskTypeId) && task.getPlanFrom().equalsIgnoreCase(planFrom) && task.getPlanTo().equalsIgnoreCase(planTo) && task.getDate().equalsIgnoreCase(date) && task.getAssign().equalsIgnoreCase(assign) && task.getReviewer().equalsIgnoreCase(reviewer)) {
                return true;
            }
        }
        return false;
    }

    public int CheckChoice(int min, int max) {
        while (true) {
            try {
                int result = Integer.parseInt(sc.nextLine().trim());
                if (result < min || result > max) {
                    throw new NumberFormatException();
                }
                return result;
            } catch (NumberFormatException e) {
                System.err.println("Re-input");
            }
        }
    }

    //tim task muon delete theo id
    int find(int id) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == id) {
                return i;
            }
        }
        System.err.println("Not found");
        return -1;
    }

    void delete(int id) {
        if (list.isEmpty()) {
            System.err.println("List Empty");
            return;
        }
        int FindId = find(id);
        if (FindId != -1) {
            list.remove(FindId);
            System.err.println("Successful");
            for (int i = FindId; i < list.size(); i++) {
                list.get(i).setId(list.get(i).getId() - 1);
            }
        }
    }

    /*
     int find() {
        System.out.print("Enter ID you want to delete : ");
        int id = c.CheckInputInt();
        return c.find(id);
    }

    void delete() {
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
        }
    }
    
     */
    public String checkInputString() {
        while (true) {
            String result = sc.nextLine().trim();
            if (result.length() == 0) {
                System.err.println("Not empty.");
            } else {
                return result;
            }
        }
    }

    public int CheckInputInt() {
        while (true) {
            try {
                int result = Integer.parseInt(sc.nextLine().trim());
                return result;
            } catch (NumberFormatException e) {
                System.err.println("Re-input");
            }
        }
    }

    public String checkInputDate() {
        while (true) {
            try {
                String result = sc.nextLine().trim();
                if (result.equalsIgnoreCase("nope")) {
                    return result;
                }
                SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                format.setLenient(false);
                Date date = format.parse(result);
                if (result.equalsIgnoreCase(format.format(date))) {
                    return result;
                } else {
                    System.err.println("Re-input");
                }
            } catch (NumberFormatException | ParseException ex) {
                System.err.println("Re-input");
            }
        }
    }

    public String checkInputTaskTypeId() {
        while (true) {
            int n = CheckChoice(1, 4);
            String result = null;
            switch (n) {
                case 1:
                    result = "code";
                    break;
                case 2:
                    result = "test";
                    break;
                case 3:
                    result = "design";
                    break;
                case 4:
                    result = "review";
            }
            return result;
        }
    }

    public String checkInputTaskTypeIdUpdate() {
        while (true) {
            String result = null;
            String s = checkInputString();
            if (s.equalsIgnoreCase("nope")) {
                return result = "nope";
            }
            int n = Integer.parseInt(s);
            n = CheckChoice(1, 4);
            switch (n) {
                case 1:
                    result = "code";
                    break;
                case 2:
                    result = "test";
                    break;
                case 3:
                    result = "design";
                    break;
                case 4:
                    result = "review";

            }
            return result;
        }
    }

    public String checkInputPlan() {
        while (true) {
            String result = checkInputString();
            if (result.equalsIgnoreCase("nope")) {
                return result;
            }
            if (result.matches("^[0-9]{1,2}\\.5|[0-9]{1,2}\\.0$") && Double.parseDouble(result) >= 8.0 && Double.parseDouble(result) < 17.5) {
                return result;
            } else {
                System.err.println("Re-input ");
            }
        }
    }

    public String checkInputPlanTo(String planFrom) {
        while (true) {
            String result = checkInputString();
            if (result.equalsIgnoreCase("nope")) {
                return result;
            }
            if (result.matches("^[0-9]{1,2}\\.5|[0-9]{1,2}\\.0$") && Double.parseDouble(result) >= 8.0 && Double.parseDouble(result) <= 17.5) {
                if (Double.parseDouble(planFrom) < Double.parseDouble(result)) {
                    return result;
                } else {
                    System.err.println("Re-input ");
                }
            } else {
                System.err.println("Re-input ");
            }
        }
    }

    Task getTask(int id) {
        for (Task task : list) {
            if (task.getId() == id) {
                return task;
            }
        }
        return null;
    }

    public void update(int id, String taskTypeId, String requirementName, String date, String planFrom, String planTo, String assign, String reviewer) {
        Task task = getTask(id);
        if (!taskTypeId.equalsIgnoreCase("nope")) {
            task.setTaskTypeId(taskTypeId);
        }
        if (!requirementName.equalsIgnoreCase("nope")) {
            task.setRequirementName(requirementName);
        }
        if (!date.equalsIgnoreCase("nope")) {
            task.setDate(date);
        }
        if (!planFrom.equalsIgnoreCase("nope")) {
            task.setPlanFrom(planFrom);
        }
        if (!planTo.equalsIgnoreCase("nope")) {
            task.setPlanTo(planTo);
//            if (Double.parseDouble(task.getPlanFrom()) <= Double.parseDouble(task.getPlanTo())) {
//                task.setPlanFrom(planFrom);
//            }
        }
        if (!assign.equalsIgnoreCase("nope")) {
            task.setAssign(assign);
        }
        if (!reviewer.equalsIgnoreCase("nope")) {
            task.setReviewer(reviewer);
        }
    }

}
