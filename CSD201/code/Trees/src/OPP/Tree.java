/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OPP;

import java.util.ArrayList;

/**
 *
 * @author kami
 */
public class Tree {

    Node root;

    Tree() {
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
        System.out.print(p.info.id + " ");
    }

    void preOrder(Node p) {
        if (p == null) {
            return;
        }
        visit(p);
        preOrder(p.left);
        preOrder(p.right);
    }

    void postOrder(Node p) {
        if (p == null) {
            return;
        }
        postOrder(p.left);
        postOrder(p.right);
        visit(p);
    }

    void inOrder(Node p) {
        if (p == null) {
            return;
        }
        inOrder(p.left);
        visit(p);
        inOrder(p.right);
    }

    void breadth(Node p) {
        if (p == null) {
            return;
        }
        Queue q = new Queue();
        q.enqueue(p);
        Node f;
        while (!q.isEmpty()) {
            f = q.dequeue();
            visit(f);
            if (f.left != null) {
                q.enqueue(f.left);
            }
            if (f.right != null) {
                q.enqueue(f.right);
            }
        }
    }

    void insert(Student x) {
        if (isEmpty()) {
            root = new Node(x);
            return;
        }
        Node f = null, p = root;
        while (p != null) {
            if (p.info.id.equalsIgnoreCase(x.id)) {
                System.out.println(x + " is exist");
                return;
            }
            f = p;//luu lai gia tri cua p
            if (p.info.id.compareToIgnoreCase(x.id) > 0) {//p>x->p sang ben phai
                p = p.left;
            } else {
                p = p.right;
            }
        }
        //f la node leaf, p=null, x la con cua f
        if (f.info.id.compareToIgnoreCase(x.id) > 0) {//xac dinh x la con trai hay phai cua f
            f.left = new Node(x);
        } else {
            f.right = new Node(x);
        }
    }

    Node search(Node p, Student x) {
        if (p == null) {
            return null;
        }
        if (p.info.id.equalsIgnoreCase(x.id)) {
            return p;
        }
        if (p.info.id.compareToIgnoreCase(x.id) > 0) {
            return search(p.left, x);
        } else {
            return search(p.right, x);
        }
    }

    public void deleteByCopy(Student x) {
        Node p = search(root, x);
        if (p == null) {
            System.out.println("Key " + x + " does not exists, deletion failed");
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

    public void deleteByMerging(Student x) {
        Node p = search(root, x);
        if (p == null) {
            System.out.println("Key " + x + " does not exists, deletion failed");
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
            Node t = null;
            while (q.right != null) {
                t = q;
                q = q.right;
            }
            Node rp = p.right;
            q.right = rp;
            if (f == null) {
                root = p.left;
            } else if (f.left == p) {
                f.left = p.left;
            } else {
                f.right = p.left;
            }
        }
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

    Node rotateRight(Node p) {
        if (p == null || p.left == null) {
            return p;
        }
        Node pl = p.left;
        p.left = pl.right;
        pl.right = p;
        return pl;
    }

    Node rotateLeft(Node p) {
        if (p == null || p.right == null) {
            return p;
        }
        Node pr = p.right;
        p.right = pr.left;
        pr.left = p;
        return pr;
    }

    void inOrder(ArrayList<Student> data, Node p) {//sap xep theo thu tu tang dan
        if (p == null) {
            return;
        }
        inOrder(data, p.left);
        data.add(p.info);
        inOrder(data, p.right);
        //--> dc 1 list theo thu tu tang dan
    }

    void balance(ArrayList<Student> data, int first, int last) {
        if (first <= last) {
            int middle = (first + last) / 2;
            insert(data.get(middle));//lay phan tu o giua r chen vao
            balance(data, first, middle - 1);//goi de quy nua trai
            balance(data, middle + 1, last);//goi de quy nua phai
        }
    }

    void balance() {
        ArrayList<Student> data = new ArrayList<>();
        inOrder(data, root);//sap xep tree tang dan va add vao list data
        clear();//clear old tree
        balance(data, 0, data.size() - 1);
    }

}
