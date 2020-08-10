package xilalu.code;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 小明是一名算法工程师，同时也是一名铲屎官。某天，他突发奇想，想从猫咪的视频里挖掘一些猫咪的运动信息。
 * 为了提取运动信息，他需要从视频的每一帧提取“猫咪特征”。
 * 一个猫咪特征是一个两维的vector<x, y>。如果x_1=x_2 and y_1=y_2，那么这俩是同一个特征。
 * 因此，如果喵咪特征连续一致，可以认为喵咪在运动。也就是说，如果特征<a, b>在持续帧里出现，
 * 那么它将构成特征运动。比如，特征<a, b>在第2/3/4/7/8帧出现，那么该特征将形成两个特征运动2-3-4 和7-8。
 * 现在，给定每一帧的特征，特征的数量可能不一样。小明期望能找到最长的特征运动。
 * <p>
 * <p>
 * 第一行包含一个正整数N，代表测试用例的个数。
 * 每个测试用例的第一行包含一个正整数M，代表视频的帧数。
 * 接下来的M行，每行代表一帧。其中，第一个数字是该帧的特征个数，接下来的数字是在特征的取值；
 * 比如样例输入第三行里，2代表该帧有两个猫咪特征，<1，1>和<2，2>
 * 所有用例的输入特征总数和<100000
 * N满足1≤N≤100000，M满足1≤M≤10000，一帧的特征个数满足 ≤ 10000。
 * 特征取值均为非负整数。
 * <p>
 * 对每一个测试用例，输出特征运动的长度作为一行
 */
public class Main10 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        while (n > 0) {
            n--;
            int cnt;
            Map<String, Integer> map1 = new HashMap<>();
            int m = scanner.nextInt();
            if (m > 0) {
                cnt = 1;
            } else {
                cnt = 0;
            }
            for (int i = 0; i < m; i++) {
                int t = scanner.nextInt();
                int[][] temp = new int[t][2];
                Map<String, Integer> mapNow = new HashMap<>();
                for (int j = 0; j < t; j++) { //对1行处理
                    temp[j][0] = scanner.nextInt();
                    temp[j][1] = scanner.nextInt();
                    if (map1.containsKey(temp[j][0] + "," + temp[j][1])) {
                        int cntTemp = map1.get(temp[j][0] + "," + temp[j][1]) + 1;
                        mapNow.put(temp[j][0] + "," + temp[j][1], cntTemp);
                        cnt = Math.max(cntTemp, cnt);
                    } else {
                        mapNow.put((temp[j][0] + "," + temp[j][1]), 1);
                    }
                }
                map1 = mapNow;
            }
            System.out.println(cnt);
        }
    }

    public static void testNum() {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int m = sc.nextInt();
            int max;
            Map<String, Integer> mapOne = new HashMap<>();
            if (m > 0) {
                max = 1;
            } else {
                max = 0;
            }
            for (int j = 0; j < m; j++) {
                int t = sc.nextInt();
                int[][] temp = new int[t][2];
                Map<String, Integer> mapTwo = new HashMap<>();
                for (int k = 0; k < t; k++) {
                    temp[k][0] = sc.nextInt();
                    temp[k][1] = sc.nextInt();
                    String key = temp[k][0] + "," + temp[k][1];
                    if (mapOne.containsKey(key)) {
                        int num = mapOne.get(key) + 1;
                        mapTwo.put(key, num);
                        max = Math.max(num, max);
                    } else {
                        mapTwo.put(key, 1);
                    }
                }
                mapOne = mapTwo;
            }
            System.out.println(max);
        }
    }

}
