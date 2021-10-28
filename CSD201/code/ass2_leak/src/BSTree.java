
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author kami
 */
public class BSTree {

    Node root;

    public BSTree() {
        root = null;
    }

    void clear() {
        root = null;
    }

    void visit(Node p) {
        if (p == null) {
            return;
        }
        System.out.print("(" + p.info + ")");
    }

    void preOrder(Node p) {
        if (p == null) {
            return;
        }
        visit(p);
        preOrder(p.left);
        preOrder(p.right);
    }

    boolean isEmpty() {
        return root == null;
    }

    void insert(Person x) {
        if (isEmpty()) {
            root = new Node(x);
            return;
        }
        Node f = null, p = root;
        while (p != null) {
//            if (p.info.age == x.age) {
//                System.out.println(x + " is exist");
//                return;
//            }
            f = p;//luu lai gia tri cua p
            if (p.info.name.compareToIgnoreCase(x.name) > 0) {//p>x->p sang ben phai
                p = p.left;
            } else {
                p = p.right;
            }
        }
        //f la node leaf, p=null, x la con cua f
        if (f.info.name.compareToIgnoreCase(x.name) > 0) {//xac dinh x la con trai hay phai cua f
            f.left = new Node(x);
        } else {
            f.right = new Node(x);
        }
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
            if (!s.substring(0, 1).toUpperCase().equalsIgnoreCase("B")) {
                insert(new Person(dataF[0].trim(), Integer.parseInt(dataF[1].trim())));
            }
        }
        postOrder(root);
        fr.close();
        br.close();
    }

    void postOrder(Node p) {
        if (p == null) {
            return;
        }
        postOrder(p.left);
        postOrder(p.right);
        visit(p);
    }

    String s = "";

    void postOrder1(Node p) {
        if (p == null) {
            return;
        }
        postOrder1(p.left);
        postOrder1(p.right);
        s += "(" + p.info.name + "," + p.info.age + ")";
    }

    public void save(String f) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(f));
        writer.write(s);
        writer.close();
    }

    Node breadth(Node p) {
        if (p == null) {
            return null;
        }
        Queue q = new Queue();
        q.enqueue(p);
        Node f;
        while (!q.isEmpty()) {
            f = (Node) q.dequeue();
            if (f.left != null && f.right != null && f.info.age >= 4) {
                return f;
            }
            if (f.left != null) {
                q.enqueue(f.left);
            }
            if (f.right != null) {
                q.enqueue(f.right);
            }
        }
        return null;
    }

    void deleteByCopy() {
        {
            Node p = breadth(root);
            if (p == null) {
                System.out.println("Key " + p + " does not exists, deletion failed");
                return;
            }
            //find f is father of p
            Node f = null, q = root;
            while (q != p) {
                f = q;
                if (q.info.name.compareToIgnoreCase(p.info.name) > 0) {
                    q = q.left;
                } else {
                    q = q.right;
                }
            }
            //1.p has no child
            if (p.left == null && p.right == null) {
                if (f == null) {
                    root = null;
                } else if (f.left == p) {
                    f.left = null;
                } else {
                    f.right = null;
                }
            } //2.p has left child only
            else if (p.left != null && p.right == null) {
                if (f == null) {
                    root = p.left;
                } else if (f.left == p) {
                    f.left = p.left;
                } else {
                    f.right = p.left;
                }
            } //3.p has right child only
            else if (p.left == null && p.right != null) {
                if (f == null) {
                    root = p.right;
                } else if (f.left == p) {
                    f.left = p.right;
                } else {
                    f.right = p.right;
                }
            } //4.p has both child
            else if (p.left != null && p.right != null) {
                //tim q la node lon nhat ben con trai cua p -> q la con phai nhat
                //cua con trai cua p
                q = p.left;
                f = null;
                while (q.right != null) {
                    f = q;
                    q = q.right;
                }
                p.info = q.info;
                //delete q
                if (f == null) {
                    p.left = q.left;
                } else {
                    f.right = q.left;
                }
            }
        }
    }

    void save1(String f) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(f));
        Node p = root;
        if (p == null) {
            return;
        }
        Queue m = new Queue();
        m.enqueue(p);
        while (!m.isEmpty()) {
            Node q = (Node) m.dequeue();
            writer.write(q.info.toString());
            if (q.left != null) {
                m.enqueue(q.left);
            }
            if (q.right != null) {
                m.enqueue(q.right);
            }
        }
        writer.close();

    }

}
