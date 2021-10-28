/* This program contains 2 parts: (1) and (2)
   YOUR TASK IS TO COMPLETE THE PART  (2)  ONLY
 */
//(1)==============================================================
import java.io.*;
import java.util.*;

public class BSTree {
   Node root;
   BSTree() {root=null;}
   boolean isEmpty() {
       return(root==null);
      }
   void clear() {
       root=null;
      }
   void visit(Node p) {
      System.out.print("p.info: ");
      if(p != null) System.out.println(p.info + " ");
     }
   void fvisit(Node p, RandomAccessFile f) throws Exception {
      if(p != null) f.writeBytes(p.info + " ");
     }
   void breadth(Node p, RandomAccessFile f) throws Exception {
     if(p==null) return;
     Queue q = new Queue();
     q.enqueue(p);Node r;
     while(!q.isEmpty()) {
        r = q.dequeue();
        fvisit(r,f);
        if(r.left!=null) q.enqueue(r.left);
        if(r.right!=null) q.enqueue(r.right);
       }
    }
   void preOrder(Node p, RandomAccessFile f) throws Exception {
      if(p==null) return;
      fvisit(p,f);
      preOrder(p.left,f);
      preOrder(p.right,f);
     }
   void inOrder(Node p, RandomAccessFile f) throws Exception {
      if(p==null) return;
      inOrder(p.left,f);
      fvisit(p,f);
      inOrder(p.right,f);
     }
   void postOrder(Node p, RandomAccessFile f) throws Exception {
      if(p==null) return;
      postOrder(p.left,f);
      postOrder(p.right,f);
      fvisit(p,f);
     }

   void loadData(int k) { //do not edit this function
      String [] a = Lib.readLineToStrArray("data.txt", k);
      int [] b = Lib.readLineToIntArray("data.txt", k+1);
      int [] c = Lib.readLineToIntArray("data.txt", k+2);
      int n = a.length;
      for(int i=0;i<n;i++) insert(a[i],b[i],c[i]);
     }

//===========================================================================
//(2)===YOU CAN EDIT OR EVEN ADD NEW FUNCTIONS IN THE FOLLOWING PART========
//===========================================================================
  void insert(Balloon x)
    {Node q = new Node(x);
     if(root==null)
        {root = q;
         return; 
        }
     Node f,p;
     p=root;f=null;
     while(p!=null)
       {if(p.info.size == x.size) return;
        if(x.size < p.info.size)
          {f=p;p=p.left;}
           else
            {f=p;p=p.right;}
       }
     if(x.size < f.info.size)
        f.left=q;
         else
           f.right=q;
     }
  void insert(String xOwner, int xColor, int xSize)
     {//You should insert here statements to complete this function
      if(xOwner.charAt(0) == 'A' ) return;
       Balloon x = new Balloon(xOwner,xColor,xSize);
       insert(x);
     }

//Do not edit this function. Your task is to complete insert function above only.
  void f1() throws Exception {
    clear();
    loadData(1);
    String fname = "f1.txt";
    File g123 = new File(fname);
    if(g123.exists()) g123.delete();
    RandomAccessFile  f = new RandomAccessFile(fname, "rw"); 
    breadth(root,f);
    f.writeBytes("\r\n");
    inOrder(root,f);
    f.writeBytes("\r\n");
    f.close();
   }  
  
//=============================================================
 
  void postOrder2(Node p, RandomAccessFile f) throws Exception {
      if(p==null) return;
      if(p.info.color<7){
      fvisit(p,f);
     }
      postOrder2(p.left,f);
      postOrder2(p.right,f);
  }
  void f2() throws Exception {
    clear();
    loadData(5);
    String fname = "f2.txt";
    File g123 = new File(fname);
    if(g123.exists()) g123.delete();
    RandomAccessFile  f = new RandomAccessFile(fname, "rw"); 
    preOrder(root,f);
    f.writeBytes("\r\n");
    //------------------------------------------------------------------------------------
    /*You must keep statements pre-given in this function.
      Your task is to insert statements here, just after this comment,
      to complete the question in the exam paper.*/

      postOrder2(root, f);

      
    //------------------------------------------------------------------------------------
    f.writeBytes("\r\n");
    f.close();
   }  

//=============================================================
  public void bfs(Node p){ //input root
        if(p == null) return;
        Queue m = new Queue();
        m.enqueue(p);
        while(!m.isEmpty()){
            Node q = (Node)m.dequeue();// get node
            if(q.left != null){ // if lever still hava node left
                m.enqueue(q.left);
            }
            if(q.right != null){ //if lever still hava node right
                m.enqueue(q.right);
            }
            visit(q);// traversal them
        }        
    }
  void f3() throws Exception {
    clear();
    loadData(9);
    String fname = "f3.txt";
    File g123 = new File(fname);
    if(g123.exists()) g123.delete();
    RandomAccessFile  f = new RandomAccessFile(fname, "rw"); 
    breadth(root,f);
    f.writeBytes("\r\n");
    //------------------------------------------------------------------------------------
    /*You must keep statements pre-given in this function.
      Your task is to insert statements here, just after this comment,
      to complete the question in the exam paper.*/
      bfs(root);

    //------------------------------------------------------------------------------------
    breadth(root,f);
    f.writeBytes("\r\n");
    f.close();
   }  

//=============================================================

  void f4() throws Exception {
    clear();
    loadData(13);;
    String fname = "f4.txt";
    File g123 = new File(fname);
    if(g123.exists()) g123.delete();
    RandomAccessFile  f = new RandomAccessFile(fname, "rw"); 
    breadth(root,f);
    f.writeBytes("\r\n");
    //------------------------------------------------------------------------------------
    /*You must keep statements pre-given in this function.
      Your task is to insert statements here, just after this comment,
      to complete the question in the exam paper.*/
 

     
    //------------------------------------------------------------------------------------
    breadth(root,f);
    f.writeBytes("\r\n");
    f.close();
   }  

 }
