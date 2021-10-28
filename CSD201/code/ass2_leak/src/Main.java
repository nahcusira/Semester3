
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
public class Main {

    public static void main(String[] args) throws IOException {
        BSTree t = new BSTree();
        String f = "person.txt";
        String fout = "q2_out.txt";
        String fout1 = "q3_out.txt";
        System.out.println("Q1 : ");
        t.readFile(f);
        System.out.println();
        System.out.println("Q2 : ");
        t.postOrder1(t.root);
        t.save(fout);
        System.out.println("Successful");
        System.out.println("Q3 : ");
        t.deleteByCopy();
        t.save1(fout1);
        System.out.println("Successful");
    }
}
