/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author kami
 */
public class Node {

    Music info;
    Node next;

    public Node() {
    }

    public Node(Music info, Node next) {
        this.info = info;
        this.next = next;
    }

    public Node(Music x) {
        info = x;
        next = null;
    }
}
