/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author kami
 */
public class Car {

    String id;
    int price;

    public Car() {
    }

    public Car(String id, int price) {
        this.id = id;
        this.price = price;
    }

    @Override
    public String toString() {
        return "(" + id + "," + price + ")";
    }

}
