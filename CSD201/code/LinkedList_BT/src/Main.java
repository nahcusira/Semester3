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
        MyList m = new MyList();
        //1.
        System.out.println("1 :");
        m.addLast("Thang", 18);
        m.addLast("Bang", 10);
        m.addLast("Toan", 20);
        m.addLast("Tham", 16);
        m.addLast("Mai", 26);
        m.addLast("Duc", 18);
        m.addLast("Loc", 15);
        m.addLast("Nam", 36);
        m.addLast("Luyen", 53);
        m.addLast("Mai", 41);
        m.addLast("Ngoc", 54);
        m.addLast("Kaka", 55);
        m.addLast("Obama", 25);
        m.traverse();
        System.out.println("2 : ");
        m.delete2(m.search2());
        m.traverse();
        System.out.println("3 : ");
        m.trarverse3();
        System.out.println("4 : ");
        m.display4(m.search4());
        System.out.println("5 : ");
        m.sort();
        m.traverse();
        System.out.println("6 : ");
        m.delete6(m.search6());
        m.traverse();
        System.out.println("7 : ");
        m.display7();
        System.out.println("8 : ");
        m.display8(m.search8());
    }
}
