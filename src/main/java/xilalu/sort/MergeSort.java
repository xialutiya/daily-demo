package xilalu.sort;

import java.util.Scanner;

/**
 * 归并排序.
 * 时间复杂度:O(nlogn)
 * 是否稳定:是.
 */
public class MergeSort {

    private static int[] temp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        temp = new int[arr.length];
        mergeSort(arr, 0, n - 1);
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }
    public static void merge(int[] arr, int left, int mid, int right) {
//        int[] temp = new int[arr.length]; 临时数组开在这里如果数据很大例如arr.lenght=200w.会导致频繁gc.
        int point1 = left;
        int point2 = mid + 1;
        int loc = left;
        while (point1 <= mid && point2 <= right) {
            if (arr[point1] < arr[point2]) {
                temp[loc++] = arr[point1++];
            } else {
                temp[loc++] = arr[point2++];
            }
        }
        while (point1 <= mid) {
            temp[loc++] = arr[point1++];
        }
        while (point2 <= right) {
            temp[loc++] = arr[point2++];
        }
        for (int i = left; i <= right; i++) {
            arr[i] = temp[i];
        }
    }

}
