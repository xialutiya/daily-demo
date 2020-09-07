package xilalu.sort;

import java.util.Scanner;

/**
 * 希尔排序.
 * 时间复杂度O(n2)
 * 是否稳定:否.
 */
public class ShellSort {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        shellSort(arr);
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void shellSort(int arr[]) {
        for (int i = arr.length / 2; i >= 1; i /= 2) {
            for (int j = i; j < arr.length; j++) {
                int data = arr[j];
                int k = j - i;
                for (; k >= 0; k -= i) {
                    if (data < arr[k]) {
                        arr[k + i] = arr[k];
                    } else {
                        break;
                    }
                }
                arr[k + i] = data;
            }
        }
    }
}
