package xilalu.dumptree;

import java.util.Arrays;
import java.util.Scanner;

public class MyDumpTree {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = sc.nextInt();
        }
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    // int data[] = {8, 4, 20, 7, 3, 1, 25, 14, 17};
    public static void heapSort(int[] arr) {
        int len = arr.length;
        // 构建堆.
        for (int i = len / 2 - 1; i >= 0; i--) {
            maxHeap(arr, i, len);
        }
        // 删除节点.
        for (int i = len - 1; i > 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            maxHeap(arr, 0, i);
        }
    }

    /**
     * 堆化.
     *
     * @param arr   数组.
     * @param start 开始元素.
     * @param end   结束元素.
     */
    public static void maxHeap(int[] arr, int start, int end) {
      int parent = start;
      int son = 2 * start + 1;
        while (son < end) {
            int temp = son;
            if (temp + 1 < end && arr[temp] < arr[temp + 1]) {
                temp++;
            }
            if (arr[parent] > arr[temp]) {
                return;
            } else {
                int num = arr[parent];
                arr[parent] = arr[temp];
                arr[temp] = num;
                parent = temp;
                son = 2 * parent + 1;
            }
        }
    }

}
