package xilalu.code;

import java.util.Scanner;

/**
 * 给定N（可选作为埋伏点的建筑物数）、D（相距最远的两名特工间的距离的最大值）以及可选建筑的坐标，
 * 计算在这次行动中，大锤的小队有多少种埋伏选择。
 * 注意：
 * 1. 两个特工不能埋伏在同一地点
 * 2. 三个特工是等价的：即同样的位置组合(A, B, C) 只算一种埋伏方法，不能因“特工之间互换位置”而重复使用
 * <p>
 * 第一行包含空格分隔的两个数字 N和D(1 ≤ N ≤ 1000000; 1 ≤ D ≤ 1000000)
 * 第二行包含N个建筑物的的位置，每个位置用一个整数（取值区间为[0, 1000000]）表示，从小到大排列（将大街看做一条数轴）
 */
public class MainEeight {

    private static int mod = 99997867;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int N = in.nextInt();
            int D = in.nextInt();
            int[] location = new int[N];
            for (int i = 0; i < N; i++) {
                location[i] = in.nextInt();
            }
            long count = 0L;

            int right = 2;
            for (int i = 0; i < N - 2; i++) {
                long temp = 0L;
                for (int j = right; j < N; j++) {

                    if (location[j] - location[i] > D) {
                        break;
                    } else {
                        temp = (long) (j - i);
                        right = j;
                    }

                }
                if (temp >= 2)
                    count += temp * (temp - 1) / 2 % mod;
            }
            System.out.println(count % mod);
        }
        sln();
    }

    public static void sln() {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(), D = sc.nextInt();
        long cnt = 0L;
        if (N <= 2) {
            System.out.println(-1);
            return;
        }
        int[] locs = new int[N];
        for (int i = 0; i < N; i++) {
            locs[i] = sc.nextInt();
        }
        sc.close();
        int left = 0, right = 2;
        while (right < N) {
            if (locs[right] - locs[left] > D) left++;
            else if (right - left < 2) right++;
            else {
                cnt += calC(right - left);
                right++;
            }
        }
        cnt %= mod;
        System.out.println(cnt);
    }

    public static long calC(long num) {
        return num * (num - 1) / 2;
    }
}
