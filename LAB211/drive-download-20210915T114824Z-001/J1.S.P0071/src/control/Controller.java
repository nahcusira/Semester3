/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
int IDx = 1;if (!listTask.isEmpty()) {
IDx = listTask.get(listTask.size() - 1).getId() + 1;}
objTask.setId(IDx);
 */
package control;

import java.util.ArrayList;
import model.Task;

/**
 *
 * @author hn919
 */
public class Controller {

    ArrayList<Task> listTask = new ArrayList<>();

    int IDx = 0;

    public ArrayList<Task> getDataTask() {
        return listTask;
    }

    //add task
    public boolean addTask(Task objTask) {
        if (objTask == null) {
            return false;
        } else {
            IDx++;
            objTask.setId(IDx);
            listTask.add(objTask);
            return true;

        }
    }

    //delete task
    public boolean deleteTask(int taskID) {
        for (int i = 0; i < listTask.size(); i++) {
            if (listTask.get(i).getId() == taskID) {
                listTask.remove(i);
                return true;
            }
        }
        return false;
    }
}
