
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author kami
 */
public class List {

    Node head, tail;

    public List() {
        head = tail = null;
    }

    public boolean isEmpty() {
        if (head == null) {
            return true;
        } else {
            return false;
        }
    }

    public void clear() {
        head = tail = null;
    }

    public void addLast(Music x) {
        Node p = new Node(x);
        if (isEmpty()) {
            head = tail = p;
            return;
        }
        tail.next = p;
        tail = p;
    }

    public void readFile(String f) throws IOException {
        FileReader fr = new FileReader(f);
        BufferedReader br = new BufferedReader(fr);
        String s;
        while (true) {
            s = br.readLine();
            if (s == null || s.trim().equals("")) {
                break;
            }
            String[] dataF = s.split("[|]");
            addLast(new Music(dataF[0].trim(), dataF[1].trim(), Integer.parseInt(dataF[2].trim())));
        }
        fr.close();
        br.close();
    }

    public void saveFile(String f) throws IOException {
        FileWriter fw = new FileWriter(f);
        PrintWriter pw = new PrintWriter(fw);
        Node p = head;
        while (p != null) {
            pw.printf("%10s|%20s|%4d\r\n", p.info.name, p.info.artist, p.info.Rated);
            p = p.next;
        }
        pw.close();
        fw.close();
    }

    public void visit(Node p) {
        if (p != null) {
            System.out.println(p.info + " ");
        }
    }

    public void traverse() {
        Node p = head;
        while (p != null) {
            visit(p);
            p = p.next;
        }
        System.out.println();
    }

    public Node search(String x) {
        sort();
        Node p = head;
        while (p != null) {
            if (p.info.name.equals(x)) {
                visit(p);
            }
            p = p.next;
        }
        return p;
    }

    public void sort() {
        Node pi = head, pj;
        Music tmp;
        while (pi != null) {
            pj = pi.next;
            while (pj != null) {
                if (pi.info.Rated < pj.info.Rated) {
                    tmp = pi.info;
                    pi.info = pj.info;
                    pj.info = tmp;
                }
                pj = pj.next;
            }
            pi = pi.next;
        }
    }

    public void deleteHead() {
        if (isEmpty()) {
            return;
        }
        head = head.next;
        if (head == null) {
            tail = null;
        }
    }

    public void delete(Node p) {
        if (isEmpty()) {
            return;
        }
        if (p == head) {
            deleteHead();
            return;
        }
        Node pNext = p.next;
        Node q = head;
        while (q != null && q.next != p) {
            q = q.next;
        }
        if (q == null) {
            return;
        }
        q.next = pNext;
        if (q.next == null) {
            tail = q;
        }
    }

    public Node min() {
        Node p = head;
        Node min = p;
        while (p!=null) {            
            if(p.info.Rated<p.next.info.Rated){
                min=p.next;
            }
        }
        visit(p);
        return null;
    }
}
