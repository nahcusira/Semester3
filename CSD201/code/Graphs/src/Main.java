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

        int[][] b = {
            //A  B  C  D  E f g h i
            {0, 1, 1, 1, 0, 0, 2, 0, 0},//A
            {1, 0, 1, 1, 0, 0, 0, 0, 0},//B
            {1, 1, 0, 1, 2, 0, 0, 3, 0}, //c
            {1, 1, 1, 0, 0, 1, 0, 0, 0},//d
            {0, 0, 0, 0, 0, 1, 0, 0, 0},//e
            {0, 0, 0, 1, 1, 0, 0, 0, 0},//f
            {0, 3, 0, 0, 0, 0, 0, 1, 1},//g
            {0, 0, 2, 0, 0, 0, 1, 0, 0},//h
            {0, 0, 0, 0, 2, 0, 1, 0, 0}//i
        };

        int[][] a = {
            {0, 2, 0, 0},
            {2, 0, 1, 1},
            {0, 1, 0, 1},
            {0, 1, 1, 0},};
        Graph g = new Graph();
        g.setData(b);
        g.displayAdj();
//        g.visit(3);
//        g.breadth(1);
//        g.depth(1);
//        Dijkstra d = new Dijkstra();
//        d.ijk(0, 1);
//        System.out.println();
//        Euler e = new Euler();
//        e.euler();
        g.eulerCycle(0);
        
//        g.dijikstra(0, 3);
    }
}
