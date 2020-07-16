package xilalu.code;

import java.util.Scanner;

/**
 *  你需要爬上一个N层的楼梯，在爬楼梯过程中， 每阶楼梯需花费非负代价，
 *  第i阶楼梯花费代价表示为cost[i]， 一旦你付出了代价，
 *  你可以在该阶基础上往上爬一阶或两阶。
 * 你可以从第 0 阶或者 第 1 阶开始，请找到到达顶层的最小的代价是多少。
 * N和cost[i]皆为整数，且N∈[2,1000]，cost[i]∈ [0, 999]。
 */
public class MainThree {

    public static void main(String[] args) {

        // 获取输入
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        String[] cosStr = input.split(",");
        int N = cosStr.length;
        int[] cos = new int[N];
        for (int i = 0; i < N; ++i) {
            cos[i] = Integer.parseInt(cosStr[i]);
        }

        System.out.println(testNum(cos));

//        int[] dp = new int[N];
//        dp[0] = cos[0];
//        dp[1] = cos[1];
//        for (int i = 2; i < N; ++i) {
//            dp[i] = cos[i] + (dp[i-1] < dp[i-2] ? dp[i-1] : dp[i-2]);
//        }
//
//        System.out.println(dp[N-1] < dp[N-2] ? dp[N-1] : dp[N-2]);
    }

    public static int testNum(int[] arr) {
        int len = arr.length;
        int[] dp = new int[len];
        dp[0] = arr[0];
        dp[1] = arr[1];
        for (int  i = 2; i < len; i++) {
            dp[i] = arr[i] + Math.min(dp[i - 1], dp[i - 2]);
        }
        return Math.min(dp[len - 1], dp[len - 2]);
    }
}
