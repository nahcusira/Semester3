
import java.util.Stack;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author kami
 */
public class MyList {

    Node head, tail;

    MyList() {
        head = tail = null;
    }

    boolean isEmpty() {
        return (head == null);
    }

    void clear() {
        head = tail = null;
    }

    public void visit(Node p) {
        if (p != null) {
            System.out.println(p.info + " ");
        }
    }

    void traverse() {
        Node p = head;
        while (p != null) {
            visit(p);
            p = p.next;
        }
        System.out.println();
    }

    //1 - addLast xName start != 'B' || xAge >17
    void addLast(Person x) {
        Node p = new Node(x);
        if (isEmpty()) {
            head = tail = p;
            return;
        }
        tail.next = p;
        tail = p;
    }

    void addLast(String xName, int xAge) {
        if (xName.charAt(0) == 'B' || xAge < 17) {
            return;
        } else {
            Person p = new Person(xName, xAge);
            addLast(p);
        }
    }

    //2--delete first node have age = 20
    Node search2() {
        Node p = head;
        while (p != null) {
            if (p.info.age == 20) {
                return p;
            }
            p = p.next;
        }
        return null;
    }

    void delete2(Node p) {

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

    //3 -- display first 5 person have age > 22
    public void trarverse3() {
        int count = 0;
        Node p = head;
        while (p != null && count < 5) {
            if (p.info.age > 22) {
                visit(p);
                count++;
            }
            p = p.next;
        }
    }

    //4 -- display person have the second max age
    public int max() {
        int max = head.info.age;
        if (isEmpty()) {
            return max = head.info.age;
        }
        Node p = head;
        while (p != null) {
            if (max < p.info.age) {
                max = p.info.age;
            }
            p = p.next;
        }
        return max;
    }

    int max2nd(int upper) {
        Node p = head;
        int value = -99;
        while (p != null) {
            if ((p.info.age > value) && (p.info.age < upper)) {
                value = p.info.age;
            }
            p = p.next;
        }
        return value;
    }

    public Node search4() {
        Node p = head;
        while (p != null) {
            if (p.info.age == max2nd(max())) {
                return p;
            }
            p = p.next;
        }
        return null;
    }

    void display4(Node p) {
        if (p == search4()) {
            System.out.println(p.info + " ");
        }
    }

    //5 -- sort by age
    void sort() {
        Node pi = head, pj;
        Person temp;
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

    //6 -- delete last node have age = 20 
    Node search6() {
        Node p = head;
        Stack s = new Stack();
        while (p != null) {
            if (p.info.age == 20) {
                s.push(p);
            }
            p = p.next;
        }
        return (Node) s.pop();
    }

    void delete6(Node p) {
        Node pNext = p.next;
        Node q = head;
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

    // remove the 5 last person have age > 22
    public Node getNode(int k) {
        int c = 0;
        Node p = head;
        while (p != null && c < k) {
            p = p.next;
            c++;
        }
        return p;
    }

    public int size() {
        Node p = head;
        int c = 0;
        while (p != null) {
            c++;
            p = p.next;
        }
        return c;
    }

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

    public void removeFiveLastNodeCondition() {
        int c = 0;
        int sz = size();
        for (int i = sz - 1; i >= 0; i--) {
            Node p = getNode(i);
            if (p.info.age > 22) {
                c++;
                remove(p);
                if (c >= 5) {
                    break;
                }
            }
        }
    }

    //7 -- display last 5 person have age > 22
    public void display7() {
        int c = 0;
        int sz = size();
        for (int i = sz - 1; i >= 0; i--) {
            Node p = getNode(i);
            if (p.info.age > 22) {
                c++;
                System.out.println(p.info + " ");
                if (c >= 5) {
                    break;
                }
            }
        }
    }

    //8 -- display the third max age
    public Node search8() {
        Node p = head;
        while (p != null) {
            if (p.info.age == max2nd(max2nd(max()))) {
                return p;
            }
            p = p.next;
        }
        return null;
    }

    void display8(Node p) {
        if (p == search8()) {
            System.out.println(p.info + " ");
        }
    }

}
