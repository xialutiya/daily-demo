package xilalu.code;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 给定一个数组，每个元素范围是0~K（K < 整数最大值2^32），
 * 将该数组分成两部分，使得 |S1- S2|最小，
 * 其中S1和S2分别是数组两部分的元素之和
 */
public class MainFive {

    public static void main(String[] args) {

        int[] weight = {10, 20, 30};
        int[] value = {60, 100, 150};

        System.out.println(testNum(value, weight));
//        Scanner sc = new Scanner(System.in);
//        int k = sc.nextInt();
//        int[] arr = new int[k];
//        for (int i = 0; i < k; i++) {
//            arr[i] = sc.nextInt();
//        }
//        System.out.println(testNumTwo(arr));
    }

    /**
     * 0,1背包问题.
      */
    public static int testNum(int[] value, int[] weight) {
        int n = 3;
        int w = 50;
        int[][] dp = new int[n + 1][w + 1];
        for (int i = 1; i <= n; i++) {
            for (int cw = 1; cw <= w; cw++) {
                if (weight[i - 1] <= cw) {
                    dp[i][cw] = Math.max(value[i - 1] + dp[i - 1][cw - weight[i - 1]], dp[i - 1][cw]);
                } else {
                    dp[i][cw] = dp[i - 1][cw];
                }
            }
        }
        for (int i = n; i >= 1; i--) {
            for (int j = w; j >= 1; j--) {
                if (dp[i][j] == dp[i - 1][w]) {

                } else if (dp[i][j] == dp[i][j - 1]) {

                } else if (dp[i][j] == dp[i - 1][j - 1]) {

                } else {
                    
                }
            }
        }
        return dp[n][w];
    }

//    public static int testNumTwo(int[] arr) {
//
//        int n = arr.length;
//        int total = Arrays.stream(arr).sum();
//        int w = total / 2;
//        int[][] dp = new int[n + 1][w + 1];
//        for (int i = 1; i <= n; i++) {
//            for (int j = 1; j <= w; j++) {
//                if (arr[i - 1] <= j) {
//                    dp[i][j] = Math.max(arr[i - 1] + dp[i - 1][j - arr[i - 1]], dp[i - 1][j]);
//                } else {
//                    dp[i][j] = dp[i - 1][j];
//                }
//            }
//        }
//        return total - dp[n][w] * 2;
//    }

    /**
     * 购物车问题.
     * @param arr
     * @return
     */
    public static int shoppingCart(int[] arr) {

        return 0;
    }
}
