/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OPP;

import java.util.LinkedList;

/**
 *
 * @author kami
 */
public class Queue {

    LinkedList<Node> t;

    public Queue() {
        t = new LinkedList<Node>();
    }

    boolean isEmpty() {
        return t.isEmpty();
    }

    void clear() {
        t.clear();
    }

    void enqueue(Node p) {
        t.addLast(p);
    }

    Node dequeue() {
        if (isEmpty()) {
            return null;
        }
        return t.removeFirst();
    }

    Node front() {
        if (isEmpty()) {
            return null;
        }
        return t.getFirst();
    }
}
