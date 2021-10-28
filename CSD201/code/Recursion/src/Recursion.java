/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author kami
 */
public class Recursion {

    static int fractorial(int n) {
        if (n <= 1) {
            return 1;
        } else {
            return n * fractorial(n - 1);
        }
    }

    static void tail(int n) {
        if (n > 0) {
            System.out.print(n);
            tail(n - 1);
            System.out.print(n);
        }
    }

    static String ex237(int n) {
        if (n <= 0) {
            return "";
        }
        return (ex237(n - 3) + n + ex237(n - 2) + n);
    }

    static int sum(int n) {
        if (n <= 1) {
            return 1;
        } else {
            return n + sum(n - 1);
        }
    }

    static int min(int a[], int n) {
        if (n == 1) {
            return a[0];
        }
        if (a[0] > a[n - 1]) {
            a[0] = a[n - 1];
        }
        return min(a, n - 1);
    }

    static boolean isPlindrome(char c[], int n) {
        if (n == 1) {
            return true;
        }
        int m = c.length;
        if (c[m - n] != c[n - 1]) {
            return false;
        } else {
            return isPlindrome(c, n - 1);
        }
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.println(sum(n));
        System.out.println(fractorial(5));
        System.out.println(sum(7));//28
        int[] a = {7, 2, 10, 1, -9, 2};
        System.out.println(min(a, a.length));
        char[] c = "radar".toCharArray();
        System.out.println(isPlindrome(c, c.length));
    }
}
/*

1.
n       return
1       1
2       1
3       10
4       2
5       16
6       3
7       22
8       4
9       28

3.
n       show
123     3
12      2
1       1
0       0

 */
