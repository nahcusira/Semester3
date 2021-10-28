
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
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
public class BSTree {

    Node root;

    public BSTree() {
        root = null;
    }

    void clear() {
        root = null;
    }

    boolean isEmpty() {
        return root == null;
    }

    void visit(Node p) {
        if (p == null) {
            return;
        }
        System.out.print("(" + p.info + ")");
    }

    void insert(Car x) {
        if (isEmpty()) {
            root = new Node(x);
            return;
        }
        Node f = null, p = root;
        while (p != null) {
            f = p;
            if (p.info.id.compareToIgnoreCase(x.id) > 0) {
                p = p.left;
            } else {
                p = p.right;
            }
        }
        if (f.info.id.compareToIgnoreCase(x.id) > 0) {
            f.left = new Node(x);
        } else {
            f.right = new Node(x);
        }
    }

    void postOrder(Node p) {
        if (p == null) {
            return;
        }
        postOrder(p.left);
        postOrder(p.right);
        visit(p);
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
            if (!s.substring(0, 1).toUpperCase().equalsIgnoreCase("B") && Integer.parseInt(dataF[1].trim()) <= 20) {
                insert(new Car(dataF[0].trim(), Integer.parseInt(dataF[1].trim())));
            }
        }
//        postOrder(root);
        fr.close();
        br.close();
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
            if (f.left != null && f.right != null && height(f) < 5) {
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

    int height(Node p) {
        if (p == null) {
            return 0;
        } else {
            int lDepth = height(p.left);
            int rDepth = height(p.right);
            if (lDepth > rDepth) {
                return lDepth + 1;
            } else {
                return rDepth + 1;
            }
        }
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
                if (q.info.id.compareToIgnoreCase(p.info.id) > 0) {
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

    void preOrder(Node p) {
        if (p == null) {
            return;
        }
        visit(p);
        preOrder(p.left);
        preOrder(p.right);
    }

    void inOrder(ArrayList<Car> data, Node p) {//sap xep theo thu tu tang dan
        if (p == null) {
            return;
        }
        inOrder(data, p.left);
        data.add(p.info);
        inOrder(data, p.right);
        //--> dc 1 list theo thu tu tang dan
    }

    void balance(ArrayList<Car> data, int first, int last) {
        if (first <= last) {
            int middle = (first + last) / 2;
            insert(data.get(middle));//lay phan tu o giua r chen vao
            balance(data, first, middle - 1);//goi de quy nua trai
            balance(data, middle + 1, last);//goi de quy nua phai
        }
    }

    void balance() {
        ArrayList<Car> data = new ArrayList<>();
        inOrder(data, root);//sap xep tree tang dan va add vao list data
        clear();//clear old tree
        balance(data, 0, data.size() - 1);
    }
}
