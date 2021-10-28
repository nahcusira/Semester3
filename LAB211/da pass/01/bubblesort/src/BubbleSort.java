
import java.util.Random;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author kami
 */
public class BubbleSort {

    private static final Scanner sc = new Scanner(System.in);

    private static void bubbleSort(int arr[]) {
        int temp;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    private static int input() {
        int n;
        while (true) {
            try {
                System.out.println("Enter size of array : ");
                n = Integer.parseInt(sc.nextLine());
                if (n > 0) {
                    break;
                } else {
                    System.err.println("Must be positive number");
                }
            } catch (Exception e) {
                System.err.println("Must be positive number");
            }
        }
        return n;
    }

    private static void show(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int n = input();
        int arr[] = new int[n];
        Random r = new Random();
        for (int i = 0; i < n; i++) {
            arr[i] = r.nextInt(n);
        }
        System.out.print("Array : ");
        show(arr);
        System.out.print("Sorted array : ");
        bubbleSort(arr);
        show(arr);
    }

}
