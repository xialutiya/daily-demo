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

//        int[] weight = {10, 20, 30};
//        int[] value = {60, 100, 150};
//
//        System.out.println(testNum(value, weight));
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int[] arr = new int[k];
//            int total = 0;
        for (int i = 0; i < k; i++) {
            arr[i] = sc.nextInt();
//                total += arr[i];
        }
//            int num = total / 2;
//            int[][] dp = new int[k + 1][num + 1];
//            for (int i = 1; i <= k; i++) {
//                for (int j = 1; j <= num; j++) {
//                    if (arr[i - 1] <= j) {
//                        dp[i][j] = Math.max(arr[i - 1] + dp[i - 1][j - arr[i - 1]], dp[i - 1][j]);
//                    } else {
//                        dp[i][j] = dp[i - 1][j];
//                    }
//                }
//            }
//            int result = dp[k][num];
//            System.out.println(total - result * 2);
        System.out.println(testNumTwo(arr));
    }

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
        return dp[n][w];
    }

    public static int testNumTwo(int[] arr) {

        int n = arr.length;
        int total = Arrays.stream(arr).sum();
        int w = total / 2;
        int[][] dp = new int[n + 1][w + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= w; j++) {
                if (arr[i - 1] <= j) {
                    dp[i][j] = Math.max(arr[i - 1] + dp[i - 1][j - arr[i - 1]], dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return total - dp[n][w] * 2;
    }
}
