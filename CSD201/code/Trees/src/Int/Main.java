/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Int;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author kami
 */
public class Main {
    
    public static void main(String[] args) {
        
        int[] x = {3,4,5,6,7,8,9,10};
        Tree t = new Tree();
        for (int i = 0; i < x.length; i++) {
            t.insert(x[i]);
        }
//        t.deleteByCopy(52);
//        System.out.println(t.search(t.root, 50).info);

//        t.preOrder(t.root);
//        System.out.println();
//        t.inOrder(t.root);
//        System.out.println();
//        t.postOrder(t.root);
//        t.balance(x);
//        t.inOrder(t.root);
//        t.preOrder(t.root);
//        t.deleteByMerging(30);
        
    }
}
