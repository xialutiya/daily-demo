package xilalu.sort;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 快速排序.
 * 时间复杂度O(nlogn)
 * 是否稳定:否.
 */
public class QuickSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
    public static void quickSort(int[] arr, int left, int right) {
        int base = arr[left];
        int point1 = left;
        int point2 = right;
        while (point1 < point2) {
            while (point1 < point2 && base < arr[point2]) {
                point2--;
            }
            if (point1 < point2) {
                int temp = arr[point1];
                arr[point1] = arr[point2];
                arr[point2] = temp;
                point1++;
            }
            while (point1 < point2 && base >= arr[point1]) {
                point1++;
            }
            if (point1 < point2) {
                int temp = arr[point1];
                arr[point1] = arr[point2];
                arr[point2] = temp;
                point2--;
            }
        }
        if (left < point1) {
            quickSort(arr, left, point1 - 1);
        }
        if (point1 < right) {
            quickSort(arr, point1 + 1, right);
        }
    }

}
