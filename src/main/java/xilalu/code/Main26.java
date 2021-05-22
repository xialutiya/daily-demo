package xilalu.code;

import java.util.Scanner;

/**
 * 输入一个整形数组（可能有正数和负数），求数组中连续子数组（最少有一个元素）的最大和。要求时间复杂度为O(n)。
 *
 * @author lds
 * @date 2021/5/9 20:35
 */
public class Main26 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = sc.nextInt();
        }
        sumChildArrOne(arr);
        sumChildArrTwo(arr);
        int num = sumChildArrThree(arr, 0, len - 1);
        System.out.println(num);
    }

    /**
     * 1.暴力穷举法.
     * <p>
     * 求最大子数组之和.
     *
     * @param arr 数组.
     */
    public static void sumChildArrOne(int[] arr) {
        int maxNum = 0;
        for (int i = 0; i < arr.length; i++) {
            int num = 0;
            for (int j = i; j < arr.length; j++) {
                num += arr[j];
                if (maxNum < num) {
                    maxNum = num;
                }
            }
        }
        System.out.println(maxNum);
    }

    /**
     * 动态规划法.
     * 状态置换方程:sum = Math.max(sum + arr[i], arr[i])
     *
     * @param arr
     */
    public static void sumChildArrTwo(int[] arr) {
        int maxNum = 0;
        int sum = 0;
        for (int num : arr) {
            sum = Math.max((sum + num), num);
            if (sum > maxNum) {
                maxNum = sum;
            }
        }
        System.out.println(maxNum);
    }

    /**
     * 分治法.
     *
     * @param arr
     */
    public static int sumChildArrThree(int[] arr, int start, int end) {
        if (start == end) {
            return arr[start];
        }
        int middle = (start + end) / 2;
        int maxLeft = sumChildArrThree(arr, start, middle);
        int maxRight = sumChildArrThree(arr, middle + 1, end);
        int maxMiddle = sumChildArrMiddle(arr, start, middle, end);
        if (maxLeft >= maxRight && maxLeft >= maxMiddle) {
            return maxLeft;
        } else if (maxRight > maxLeft && maxRight > maxMiddle) {
            return maxRight;
        } else {
            return maxMiddle;
        }
    }

    public static int sumChildArrMiddle(int[] arr, int start, int middle, int end) {
        int maxLeftNum = 0;
        int maxRightNum = 0;
        // 求左边子数组右边界最大之和.
        int sum = 0;
        for (int i = middle; i >= start; i--) {
            sum += arr[i];
            if (maxLeftNum < sum) {
                maxLeftNum = sum;
            }
        }
        // 求右子数组左边界最大值和.
        sum = 0;
        for (int i = (middle + 1); i <= end; i++) {
            sum += arr[i];
            if (maxRightNum < sum) {
                maxRightNum = sum;
            }
        }
        // 中间子数组最大之和.
        return maxLeftNum + maxRightNum;
    }
}
