/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author kami
 */
public class node {

    person info;
    node next;

    public node() {
    }

    public node(person info, node next) {
        this.info = info;
        this.next = next;
    }

    public node(person x) {
        info = x;
        next = null;
    }
}
