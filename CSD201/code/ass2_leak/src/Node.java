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

    Person info;
    Node left, right;

    public Node(Person x) {
        info = new Person(x.name, x.age);
        left = right = null;
    }

    public Node(Person info, Node left, Node right) {
        this.info = info;
        this.left = left;
        this.right = right;
    }

}
