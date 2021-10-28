
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

        List l = new List();
        System.out.println("1.");
        String f = "songs.txt";
        String fout = "songs_out.txt";
        l.clear();
        l.readFile(f);
        l.saveFile(fout);
        System.out.println("Successful");
        System.out.println("2.");
        l.traverse();
        System.out.println("3.");
        l.search("Fields of gold");
        System.out.println("6.");
        l.sort();
        l.traverse();
        System.out.println();
        l.min();
    }
}
