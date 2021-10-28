
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
public class Queue {

    Node head, tail;

    public Queue() {
        head = tail = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    //addLast
    public void enqueue(Person x) {
        Node p = new Node(x);
        if (isEmpty()) {
            head = tail = p;
        } else {
            tail.next = p;
            tail = p;
        }
    }

    public Person dequeue() {
        if (isEmpty()) {
            return null;
        }
        Person x = head.info;
        head = head.next;
        return x;
    }

    public Person front() {
        if (isEmpty()) {
            return null;
        }
        Person x = head.info;
        return x;
    }

    public void clear() {
        head = tail = null;
    }

    /*
    protected Node head, tail;

    public Queue() {
        head = tail = null;
    }

    boolean isEmpty() {
        return (head == null);
    }

    Person front() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }

        return (head.info);
    }

    Person dequeue() throws Exception {
        if (isEmpty()) {
            throw new Exception();
        }
        Person x = head.info;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        return (x);

    }
    
    void enqueue(Person x) {
        if (isEmpty()) {
            head = tail = new Node(x);
        } else {
            tail.next = new Node(x);
            tail = tail.next;
        }
    }

    void clear() {
        head = null;
    }

    void display() {
        Node cur = head;
        while (cur != null) {
            if (cur == tail) {
                System.out.println(cur.info + "\n");
            } else {
                System.out.println(cur.info + " <- ");
            }
            cur = cur.next;
        }
    }

     */
}
