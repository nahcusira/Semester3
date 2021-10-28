/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;

/**
 *
 * @author hn919
 */
public class Task {

    int Id, typeId;
    String name;
    String date;
    double from, to;
    String assignee;
    String reviewer;

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getFrom() {
        return from;
    }

    public void setFrom(double from) {
        this.from = from;
    }

    public double getTo() {
        return to;
    }

    public void setTo(double to) {
        this.to = to;
    }

    public String getAssignee() {
        return assignee;
    }

    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }

    public String getReviewer() {
        return reviewer;
    }

    public void setReviewer(String reviewer) {
        this.reviewer = reviewer;
    }

    public String getTypeName() {
        switch (typeId) {
            case 1:
                return "Code";
            case 2:
                return "Test";
            case 3:
                return "BA";
            case 4:
                return "Other";

        }
        return null;
    }

    @Override
    public String toString() {
        return String.format("%-5s%-15s%-15s%-15s%-15s%-15s\n", Id, name, getTypeName(), date, (to - from), assignee, reviewer);

    }

}
