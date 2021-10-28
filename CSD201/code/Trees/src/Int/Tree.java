/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Int;

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
        System.out.print(p.info + " ");
    }

    Node search(Node p, int x) {
        if (p == null) {
            return null;
        }
        if (p.info == x) {
            return p;
        }
        if (x < p.info) {
            return search(p.left, x);
        } else {
            return search(p.right, x);
        }
    }

    void insert(int x) {
        if (isEmpty()) {
            root = new Node(x);
            return;
        }
        Node f = null, p = root;
        while (p != null) {
            if (p.info == x) {
                System.out.println(x + " is exist");
                return;
            }
            f = p;//luu gia tri cua p
            if (x > p.info) {
                p = p.right;
            } else {
                p = p.left;
            }
        }//-> tim ra dc f la cha cua p=null
        if (x < f.info) {
            f.left = new Node(x);
        } else {
            f.right = new Node(x);
        }
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
            f = (Node) q.dequeue();
            visit(f);
            if (f.left != null) {
                q.enqueue(f.left);
            }
            if (f.right != null) {
                q.enqueue(f.right);
            }
        }
    }

    public void deleteByCopy(int x) {
        Node p = search(root, x);
        if (p == null) {
            System.out.println("Key " + x + " does not exists, deletion failed");
            return;
        }
        //find f is father of p
        Node f = null, q = root;
        while (q != p) {
            f = q;
            if (q.info > p.info) {
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

    public void deleteByMerging(int x) {
        Node p = search(root, x);
        if (p == null) {
            System.out.println("Key " + x + " does not exists, deletion failed");
            return;
        }
        //find f is father of p
        Node f = null, q = root;
        while (q != p) {
            f = q;
            if (q.info > p.info) {
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

    void inOrder(int data[], Node p) {//sap xep theo thu tu tang dan
        if (p == null) {
            return;
        }
        inOrder(data, p.left);
        for (int i = 0; i < data.length - 1; i++) {
            insert(data[i]);
        }
        inOrder(data, p.right);
        //--> dc 1 list theo thu tu tang dan
    }

    void balance(int data[], int first, int last) {
        if (first <= last) {
            int middle = (first + last) / 2;
            insert(data[middle]);
            balance(data, first, middle - 1);
            balance(data, middle + 1, last);
        }
    }

    void balance(int data[]) {
        inOrder(data, root);
        clear();
        balance(data, 0, data.length - 1);
    }

    //inorder a BST and save all items to an array
    public void buildArray(ArrayList a, Node p) {
        if (p == null) {
            return;
        }
        buildArray(a, p.left);
        a.add(p);
        buildArray(a, p.right);
    }

    //insert all items from an array to a new BST
//    public void balance1(ArrayList a, int f, int l) {
//        if (f > l) {
//            return;
//        }
//        int m = (f + l) / 2;
//        Node p = (Node) a.get(m);
//        insert(p.info);
//        balance(a, f, m - 1);
//        balance(a, m + 1, l);
//    }
//
//    public void balance1(Node p) {
//        ArrayList a = new ArrayList();
//        buildArray(a, p);
//        int l = a.size(), f = 0;
//        //create a new tree and insert all items from a to the BST
//        Tree t = new Tree();
//        t.balance1(a, f, l - 1);
//        root = t.root;
//    }
}
