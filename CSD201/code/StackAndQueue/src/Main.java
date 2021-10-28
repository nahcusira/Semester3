/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author kami
 */
public class Main {

    public static void main(String[] args) {
        Stack s = new Stack();
        Queue q = new Queue();
        Person a = new Person("hung", 25);
        Person b = new Person("long", 12);
        Person c = new Person("ngoc", 35);
        s.push(a);
        s.push(c);
        s.push(b);
        System.out.println(s.top());
        // System.out.println(s.pop());
        System.out.println(s.pop());

    }
}
