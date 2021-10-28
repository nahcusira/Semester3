/* This program contains 2 parts: (1) and (2)
   YOUR TASK IS TO COMPLETE THE PART  (2)  ONLY
 */
//(1)==============================================================
import java.util.*;
import java.io.*;

public class MyList {
  Node head,tail;
  MyList() {head=tail=null;}
  boolean isEmpty() {
    return(head==null);
   }
  void clear() {head=tail=null;}

  void fvisit(Node p, RandomAccessFile f) throws Exception {
    if(p != null) f.writeBytes(p.info + " ");
   }

  void ftraverse(RandomAccessFile f) throws Exception {
    Node p = head;
    while(p!=null) {
       fvisit(p,f); // You will use this statement to write information of the node p to the file
       p=p.next;
      }
    f.writeBytes("\r\n");
   }

  void loadData(int k) { //do not edit this function
    String [] a = Lib.readLineToStrArray("data.txt", k);
    int [] b = Lib.readLineToIntArray("data.txt", k+1);
    int [] c = Lib.readLineToIntArray("data.txt", k+2);
    int n = a.length;
    for(int i=0;i<n;i++) addLast(a[i],b[i],c[i]);
   }

//===========================================================================
//(2)===YOU CAN EDIT OR EVEN ADD NEW FUNCTIONS IN THE FOLLOWING PART========
//===========================================================================
/* 
   Khong su dung tieng Viet co dau de viet ghi chu.
   Neu dung khi chay truc tiep se bao loi va nhan 0 diem
*/
 

   
  void addLast(String xOwner, int xColor, int xSize)
   { 
       if(xOwner.charAt(0)=='A'){
           
       }
       else{
           Balloon balloon = new Balloon(xOwner, xColor, xSize);
           addLast(balloon);
           
       }
    
   }
  void addLast(Balloon x){
      Node q = new Node(x);
      if(isEmpty())
          head=tail=q;
      else{
          tail.next=q;
          tail=q;
      }
  }
  

  //You do not need to edit this function. Your task is to complete the addLast function above only.
  void f1() throws Exception {
     clear();
     loadData(1);
     String fname = "f1.txt";
     File g123 = new File(fname);
     if(g123.exists()) g123.delete();
     RandomAccessFile  f = new RandomAccessFile(fname, "rw"); 
     ftraverse(f);
     f.close();
    }  

//==================================================================
  public void insertPosition(Balloon x, int position) {
		if (isEmpty()) head = tail = new Node(x);
		int count = 1;
		Node p = head;
		while (p!= null && count < position) {
			p = p.next;
			count ++;
		}
		Node temp = p.next;
		p.next = new Node(x, temp);
	} 
  void f2() throws Exception {
     clear();
     loadData(5);
     String fname = "f2.txt";
     File g123 = new File(fname);
     if(g123.exists()) g123.delete();
     RandomAccessFile  f = new RandomAccessFile(fname, "rw"); 
     ftraverse(f);
     Balloon x, y;
     x = new Balloon("X",1,2);
     y = new Balloon("Y",3,4);
     //------------------------------------------------------------------------------------
     /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/

      insertPosition(x, 2);
      insertPosition(y, 0);

    //------------------------------------------------------------------------------------
     ftraverse(f);
     f.close();
    }  

//==================================================================
  void f3() throws Exception {
    clear();
    loadData(9);
    String fname = "f3.txt";
    File g123 = new File(fname);
    if(g123.exists()) g123.delete();
    RandomAccessFile  f = new RandomAccessFile(fname, "rw"); 
    ftraverse(f);
    //------------------------------------------------------------------------------------
     /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/



    //------------------------------------------------------------------------------------
    ftraverse(f);
    f.close();
   }

//==================================================================
  public void sortFourth() {
        Node pi, pj; pi = head; int count = 0; 
        while(pi != null) {
            count++; pj = pi.next; int count1 = 0;
            while(pj != null) {
                count1++;
                if(pj.info.size<pi.info.size) {
                    Balloon t = pi.info; pi.info = pj.info;pj.info = t;
                }
                pj = pj.next; if(count1 == count+4) break;
            }
            pi = pi.next; if(count == 3) break;
        }
    }
	
  void f4() throws Exception {
    clear();
    loadData(13);
    String fname = "f4.txt";
    File g123 = new File(fname);
    if(g123.exists()) g123.delete();
    RandomAccessFile  f = new RandomAccessFile(fname, "rw"); 
    ftraverse(f);
    //------------------------------------------------------------------------------------
     /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/

     sortFourth();

    //------------------------------------------------------------------------------------
    ftraverse(f);
    f.close();
   }

 }
