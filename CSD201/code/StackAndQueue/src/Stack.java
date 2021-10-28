
import java.util.EmptyStackException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author kami
 */
public class Stack {

    Node head;

    public Stack() {
        head = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void push(Person x) {
        Node p = new Node(x, head);
        if (isEmpty()) {
            head = p;
        } else {
            p.next = head;
            head = p;
        }
    }

    public Person pop() {
        if (isEmpty()) {
            return null;
        }
        Person x = head.info;
        head = head.next;
        return x;
    }

    public Person top() {
        if (isEmpty()) {
            return null;
        }
        Person x = head.info;
        return x;
    }

    public void clear() {
        head = null;
    }

//    protected Node head;
//
//    public Stack() {
//        head = null;
//    }
//
//    boolean isEmpty() {
//        return (head == null);
//    }
//
//    void push(Person x) {
//        head = new Node(x, head);
//    }
//
//    Person top() {
//        if (isEmpty()) {
//            throw new EmptyStackException();
//        }
//
//        return (head.info);
//    }
//
//    Person pop() {
//        if (isEmpty()) {
//            throw new EmptyStackException();
//        }
//
//        Person x = head.info;
//        head = head.next;
//        return (x);
//    }
//
//    void clear() {
//        head = null;
//    }
}
