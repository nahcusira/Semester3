
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
public class main {

    public static void main(String[] args) throws IOException {
        myList m = new myList();
//        m.addFirst(new person("HE123", "nam", 12));
//        m.addFirst(new person("HS456", "hung", 229));
//        m.addLast(new person("HC789", "long", 25));
//        m.traverse();
        String f = "person.txt";
        String fout = "person_out.txt";
        System.out.println();
        m.clear();
        m.readFile(f);
        m.traverse();
        System.out.println();
        m.saveFile(fout);
        System.out.println();
    }
}
