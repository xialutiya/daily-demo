package xilalu.sort;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 冒泡排序.
 * 时间复杂度O(n^2)
 * 是否稳定:是.
 */
public class BubbleSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    // 11 3 5 17 7 9 -> 3 11 5 17 7 9 -> 3 5 11 17 7 9 -> 3 5 11 7 17 9 -> 3 5 11 7 9 17
    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    arr[j] = arr[j] + arr[j + 1];
                    arr[j + 1] = arr[j] - arr[j + 1];
                    arr[j] = arr[j] - arr[j + 1];
                }
            }
        }
    }
}
