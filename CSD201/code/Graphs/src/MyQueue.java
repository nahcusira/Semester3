
import java.util.LinkedList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author kami
 */
public class MyQueue {

    LinkedList<Object> head;

    public MyQueue() {
        head = new LinkedList<>();
    }

    public void enqueue(Object obj) {
        head.addLast(obj);
    }

    public Object dequeue() {
        if (head.isEmpty()) {
            return null;
        }
        return head.removeFirst();
    }

    public boolean isEmpty() {
        return head.isEmpty();
    }

    public void clear() {
        head = null;
    }

    public Object front() {
        return head.getFirst();
    }
}
