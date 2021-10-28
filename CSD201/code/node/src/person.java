/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author kami
 */
public class person {

    String id;
    String name;
    int age;

    public person() {
    }

    public person(String id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "person{" + "id=" + id + ", name=" + name + ", age=" + age + '}';
    }
}
