package xilalu.code;

import java.util.Scanner;

/**
 * 给定一个无序的整型数组A[n],数组大小大于等于3,
 * 允许有值相同的元素;请设计算法找到该数组排序后第三大的元素值并输出.
 *
 * @author lds
 * @date 2021/3/18 22:38
 */
public class Main20 {

    private static int k = 3;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = sc.nextInt();
        }
        quickSort(arr, 0, len - 1);

    }

    public static void quickSort(int[] arr, int start, int end) {

        int pivot = arr[start];
        int left = start;
        int right = end;
        while (left < right) {
            while (left < right && pivot > arr[right]) {
                right--;
            }
            while (left < right && pivot <= arr[left]) {
                left++;
            }
            if (left < right) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
            }
        }
        arr[start] = arr[left];
        arr[left] = pivot;
        if (left == (k - 1)) {
            System.out.println(arr[left]);
        }
        if (left > (k - 1)) {
            quickSort(arr, start, left - 1);
        }
        if (left < (k - 1)) {
            quickSort(arr, left + 1, end);
        }
    }

}
