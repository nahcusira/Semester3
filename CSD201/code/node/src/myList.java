
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author kami
 */
public class myList {

    public MyList() {
        head = tail = null;
    }

    //return true if Mylist is empty otherwise return false
    public boolean isEmpty() {
        return head == null;
    }

    //append a new node to the end of list
    public void addLast(int x) {
        Node p = new Node(x);
        if (isEmpty()) {
            head = tail = p;
        } else {
            tail.next = p;
            tail = p;
        }
    }

    //insert a new node to the beginning of list
    public void addFirst(int x) {
        Node p = new Node(x);
        if (isEmpty()) {
            head = tail = p;
        } else {
            p.next = head;
            head = p;
        }
    }

    //output list
    public void traversal() {
        Node p = head;
        while (p != null) {
            System.out.print(p.info + "  ");
            p = p.next;
        }
        System.out.println("");
    }

    //return number of nodes in the list
    public int size() {
        Node p = head;
        int c = 0;
        while (p != null) {
            c++;
            p = p.next;
        }
        return c;
    }

    //return a Node at position k
    public Node get(int k) {
        Node p = head;
        int c = 0;
        while (p != null && c < k) {
            c++;
            p = p.next;
        }
        return p;
    }

    //sort the list ascending 
    public void sort() {
        int n = size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                Node pi = get(i), pj = get(j);
                if (pi.info > pj.info) {
                    int t = pi.info;
                    pi.info = pj.info;
                    pj.info = t;
                }
            }
        }
    }

    //return the first Node which infor = given x otherwise return null
    public Node search(int x) {
        Node p = head;
        while (p != null && p.info != x) {
            p = p.next;
        }
        return p;
    }
//delete the first node

    void dele(Node q) {
        Node f, p;
        f = null;
        p = head;
        while (p != null) {
            if (p == q) {
                break;
            }
            f = p;
            p = p.next;
        }
        if (p == null) {
            return;
        }
        if (f == null) {
            head = head.next;
            if (head == null) {
                tail = null;
            }
            return;
        }
        f.next = p.next;
        if (f.next == null) {
            tail = f;
        }
    }

    //remove a node from the list
    public void remove(Node p) {
        if (p == null) {
            return;
        }
        //find q where q.next = p
        Node f = head, q = null;
        while (f != null && f != p) {
            q = f;
            f = f.next;
        }
        //remove head
        if (q == null) {
            head = head.next;
            if (head == null) {
                tail = null;
            }
        } else {
            q.next = p.next;
            if (p == tail) {
                tail = q;
            }
        }
        p.next = null;
    }

    //reverse a list
    public void reverse() {
        int n = size();
        for (int i = 0, j = n - 1; i < j; i++, j--) {
            Node pi = get(i), pj = get(j);
            int t = pi.info;
            pi.info = pj.info;
            pj.info = t;
        }
    }

    //remove second node which have info < x
    public void removeAfter(int x) {
        int c = 0;
        Node p = head;
        while (p != null) {
            if (p.info < x) {
                c++;
            }
            if (c >= 2) {
                break;
            }
            p = p.next;
        }
        remove(p);
    }

    /*
    node head, tail;

    public myList() {
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

    public void read(node p) {
        if (p != null) {
            System.out.println(p.info + " ");
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

    public void delete(node p) {
        if (isEmpty()) {
            return;
        }
        if (p == head) {
            deleteHead();
            return;
        }
        node pNext = p.next;
        node q = head;
        while (q != null && q.next != p) {
            q = q.next;
        }
        if (q == null) {
            return; // p khong nam trong danh sach
        }
        q.next = pNext;
        if (q.next == null) {
            tail = q;
        }
    }

    public void deleteTail() {
        if (isEmpty()) {
            return;
        }
        node p = head;
        while (p.next != tail) {
            p = p.next;
            p.next = null;
            tail = p;
        }
    }

    public void deleteAfter(node p) {
        if (p == tail) {
            return;
        }
        if (isEmpty()) {
            return;
        }
        p.next = p.next.next;
    }

    public void addFirst(person x) {
        node p = new node(x);
        if (isEmpty()) {
            head = tail = p;
            return;
        }
        p.next = head;
        head = p;
    }

    public void addLast(person x) {
        node p = new node(x);
        if (isEmpty()) {
            head = tail = p;
            return;
        }
        tail.next = p;
        tail = p;
    }

    public void addAfter(node p, person x) {
        if (p == null) {
            return;
        }
        if (p == tail) {
            addLast(x);
            return;
        }
        node pNext = p.next;
        node q = new node(x, pNext);
        p.next = q;

    }

    public void addBefore(node p, person x) {
        if (p == null) {
            return;
        }
        if (p == head) {
            addFirst(x);
            return;
        }
        node q = head;
        while (q != null && q.next != p) {
            q = q.next;
        }
        if (q == null) {
            return;
        }
        addAfter(q, x);
    }

    public node search(String x) {
        node p = head;
        while (p != null) {
            if (p.info.name.equals(x)) {
                read(p);
                return p;
            }
            p = p.next;
        }
        return null;
    }

    public void traverse() {
        node p = head;
        while (p != null) {
            read(p);
            p = p.next;
        }
        System.out.println();
    }

    public int count() {
        int c = 0;
        if (isEmpty()) {
            return c = 0;
        }
        if (head == tail) {
            return c = 1;
        }
        node p = head;
        while (p != null) {
            c++;
            p = p.next;
        }
        return c;
    }

    public void sort() {
        node pi = head, pj;
        person temp;
        while (pi != null) {
            pj = pi.next;
            while (pj != null) {
                if (pi.info.age > pj.info.age) {
                    temp = pi.info;
                    pi.info = pj.info;
                    pj.info = temp;
                }
                pj = pj.next;
            }
            pi = pi.next;
        }
    }

    //bai 18 
    public int max() {
        int max = head.info.age;
        if (isEmpty()) {
            return max = head.info.age;
        }
        node p = head;
        while (p != null) {
            if (max < p.info.age) {
                max = p.info.age;
            }
            p = p.next;
        }
        return max;
    }

    //Bai19    
    public int min() {
        int min = head.info.age;
        if (isEmpty()) {
            return min = head.info.age;
        }
        node p = head;
        while (p != null) {
            if (min > p.info.age) {
                min = p.info.age;
            }
            p = p.next;
        }
        return min;
    }

    //bai20
    public int sum() {
        int sum = 0;
        if (isEmpty()) {
            return 0;
        }
        node p = head;
        while (p != null) {
            sum += p.info.age;
            p = p.next;
        }
        return sum;
    }

    //bai 21
    public double avg() {
        int count = 0;
        double sum = 0;
        node p = head;
        while (p != null) {
            sum += p.info.age;
            count++;
            p = p.next;
        }
        double avg = sum / count;
        return avg;
    }

    public void addMany(String[] a, String[] b, int[] c) {
        for (int i = 0; i < a.length; i++) {
            addLast(new person(a[i], b[i], c[i]));
        }
    }

//    public void max() {
//        sort();
//        node p = tail;
//        read(p);
//    }
//
//    public node min() {
//        if (isEmpty()) {
//            return null;
//        }
//        node p, q;
//        q = p = head;
//        int min;
//        min = p.info.age;
//        p = p.next;
//        while (p != null) {
//            if (p.info.age < min) {
//                q = p;
//                min = p.info.age;
//            }
//            p = p.next;
//        }
//        return (q);
//    }
//
//    public int sum() {
//        node p = head;
//        int sum = 0;
//        while (p != null) {
//            sum = sum + p.info.age;
//            p = p.next;
//        }
//        return sum;
//    }
//
//    public double avg() {
//        double avg = sum() / count();
//        return avg;
//    }
    public boolean sorted() {
        node pi = head, pj;
        while (pi != null) {
            pj = pi.next;
            if (pi.info.age < pj.info.age) {
                pi = pi.next;
                return true;
            } else {
                return false;
            }
        }
        return false;
    }
     */
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
            addLast(new person(dataF[0].trim(), dataF[1].trim(), Integer.parseInt(dataF[2].trim())));
        }
        fr.close();
        br.close();
    }

    void saveFile(String f) throws IOException {
        FileWriter fw = new FileWriter(f);
        PrintWriter pw = new PrintWriter(fw);
        node p = head;
        while (p != null) {
            pw.printf("%10s | %20s | %4d\r\n", p.info.id, p.info.name, p.info.age);
            p = p.next;
        }
        pw.close();
        fw.close();
    }
}
