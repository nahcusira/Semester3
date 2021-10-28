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

    Car info;
    Node left, right;

    public Node(Car x) {
        info = new Car(x.id, x.price);
        left = right = null;
    }

    public Node(Car info, Node left, Node right) {
        this.info = info;
        this.left = left;
        this.right = right;
    }

}
