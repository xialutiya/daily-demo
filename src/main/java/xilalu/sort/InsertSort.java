package xilalu.sort;

import java.util.Scanner;

/**
 * 插入排序.
 * 时间复杂度O(n^2)
 * 是否稳定:是.
 */
public class InsertSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        insertSort(arr);
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
    public static void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int data = arr[i];
            int j = i - 1;
            for (;j >= 0; j--) {
                if (data < arr[j]) {
                    arr[j + 1] = arr[j];
                } else {
                    break;
                }
            }
            arr[j + 1] = data;
        }
    }
}
