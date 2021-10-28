
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
public class Main {

    public static void main(String[] args) throws IOException {
        BSTree t = new BSTree();
        String f = "car.txt";
        String fout2 = "q2_out.txt";
        String fout3 = "q3_out.txt";
        System.out.println("Q1:");
        t.readFile(f);
        System.err.println("Done");
        System.out.println();
        System.out.println("Q3:");
        t.deleteByCopy();
        t.save1(fout3);
        System.err.println("Done");
        System.out.println("Q4: ");
        t.balance();
        t.preOrder(t.root);
    }
}
