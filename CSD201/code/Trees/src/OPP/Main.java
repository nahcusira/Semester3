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
public class Main {

    public static void main(String[] args) {
        Student t = new Student("F", "a4", 7.9);
        Student x = new Student("A", "a1", 5.5);
        Student y = new Student("C", "a2", 4.9);
        Student z = new Student("J", "a3", 7.9);
        Student u = new Student("Z", "a5", 7.9);
        Student a = new Student("U", "a6", 7.9);
        Student b = new Student("V", "a7", 7.9);
        Tree tree = new Tree();
        tree.insert(x);
        tree.insert(y);
        tree.insert(z);
        tree.insert(t);
        tree.insert(u);
        tree.insert(a);
        tree.insert(b);
        tree.preOrder(tree.root);
        System.out.println();
//        tree.deleteByCode(y);
//        tree.preOrder(tree.root);
        System.out.println(tree.search(tree.root, b).info.name);
    }
}
