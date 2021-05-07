package xilalu.sort;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 选择排序.
 * 时间复杂度O(n^2)
 * 是否稳定:否.
 */
public class SelectSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        selectSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    // 5 6 1 9 3 -> 1 6 5 9 3 -> 1 3 5 9 6 -> 1 3 5 9 6 -> 1 3 5 6 9
    public static void selectSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int index = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[index] > arr[j]) {
                    index = j;
                }
            }
            if (index != i) {
                int temp = arr[i];
                arr[i] = arr[index];
                arr[index] = temp;
            }
        }

    }
}
