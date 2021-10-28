
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
public class Main {

    private static final Scanner sc = new Scanner(System.in);

    public static void bubbleSort(int arr[]) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    private static int checkInputInt() {
        while (true) {
            try {
                int result = Integer.parseInt(sc.nextLine());
                return result;
            } catch (NumberFormatException e) {
                System.err.println("Please input number");
                System.out.print("Enter again: ");
            }
        }
    }

    private static int inputSize() {
        System.out.print("Enter size of array : ");
        int n = checkInputInt();
        return n;
    }

    public static int[] input(int n) {
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = checkInputInt();
        }
        return arr;
    }

    public static void show(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

    }

    public static void main(String[] args) {
        int n = inputSize();
        System.out.println("Number of array : ");
        int arr[] = input(n);
        System.out.println("Array before : ");
        show(arr);
        System.out.println("Sorted array");
        bubbleSort(arr);
        show(arr);
    }
}
