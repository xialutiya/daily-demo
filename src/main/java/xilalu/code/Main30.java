package xilalu.code;

/**
 * 给定一个整数数组，编写一个函数，找出索引m和n，只要将索引区间[m,n]的元素排好序，
 * 整个数组就是有序的。注意：n-m尽量最小，也就是说，找出符合条件的最短序列。
 * 函数返回值为[m,n]，若不存在这样的m和n（例如整个数组是有序的），请返回[-1,-1]。
 *
 * @author lds
 * @date 2021/5/19 22:52
 */
public class Main30 {
    public static void main(String[] args) {

        int[] arr = {1, 2, 4, 7, 10, 11, 7, 12, 6, 7, 16, 18, 19};
        int[] result = subSort(arr);
        for (int i : result) {
            System.out.print(i + " ");
        }
    }

    public static int[] subSort(int[] array) {
        int a = -1, b = -1;
        int minNum = Integer.MAX_VALUE;
        int maxNum = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            if (array[i] >= maxNum) {
                maxNum = array[i];
            } else {
                a = i;
            }
        }
        for (int i = array.length - 1; i >= 0; i--) {
            if (array[i] <= minNum) {
                minNum = array[i];
            } else {
                b = i;
            }
        }
        int[] result = new int[2];
        result[0] = b;
        result[1] = a;
        return result;
    }
}
