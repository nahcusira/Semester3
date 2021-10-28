/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author kami
 */
public class Doctor {

    String code;
    String name;
    String Specialization;
    int availablity;

    public Doctor() {
    }

    public Doctor(String code, String name, String Specialization, int availablity) {
        this.code = code;
        this.name = name;
        this.Specialization = Specialization;
        this.availablity = availablity;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getSpecialization() {
        return Specialization;
    }

    public int getAvailablity() {
        return availablity;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSpecialization(String Specialization) {
        this.Specialization = Specialization;
    }

    public void setAvailablity(int availablity) {
        this.availablity = availablity;
    }

    public void display() {
        System.out.printf("%-20s%-25s%-20s%-25s\n", this.code, this.name, this.Specialization, this.availablity);
    }

}
