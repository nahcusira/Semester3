/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OPP;

/**
 *
 * @author kami
 */
public class Node {

    Student info;
    Node left, right;

    public Node(Student x) {
        info = new Student(x.id, x.name, x.gpa);
        left = right = null;
    }
}
