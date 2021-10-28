
import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author kami
 */
public class Employee {

    String id;
    String fName;
    String lName;
    String phone;
    String email;
    String address;
    String dob;
    String sex;
    double salary;
    String egency;

    public Employee() {
    }

    public Employee(String id, String fName, String lName, String phone, String email, String address, String dob, String sex, double salary, String egency) {
        this.id = id;
        this.fName = fName;
        this.lName = lName;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.dob = dob;
        this.sex = sex;
        this.salary = salary;
        this.egency = egency;
    }

    public String getId() {
        return id;
    }

    public String getfName() {
        return fName;
    }

    public String getlName() {
        return lName;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public String getDob() {
        return dob;
    }

    public String getSex() {
        return sex;
    }

    public double getSalary() {
        return salary;
    }

    public String getEgency() {
        return egency;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setEgency(String egency) {
        this.egency = egency;
    }

    public void display() {
        System.out.printf("%-25s%-25s%-25s%-25s%-25s%-25s%-25s%-25s%-25s%-25s\n", this.id, this.fName, this.lName, this.phone, this.email, this.address, this.dob, this.sex, this.salary, this.egency);
    }

}
