package xilalu.code;

import java.util.Scanner;

/**
 * 11.某天猿辅导 HR 组织大家去漂流，
 * 早上，参加团建的同学都到齐了，并且按到达公司的先后顺序排好队了。
 * 由于员工太多，一个大巴车坐不下，需要分多个车，车是足够的，但所有人需要按一定顺序上车，按如下规则安排上车的顺序：
 * 假设大巴车容量为 m，从队首开始，每 m 个人分成一个小组，每个小组坐一辆车。同时只有一个车打开车门供员工上车。
 * 小组之间按从队尾到队首顺序依次上车，同一小组内先到的同学先上，求所有人上车的顺序。
 *
 * @author lds
 * @date 2021/2/20 23:02
 */
public class Main16 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt(); // 车容量.
        int n = sc.nextInt(); // 员工数.
        int[] arr = new int[n];
        for (int i = 1; i <= n; i++) {
            arr[i - 1] = i;
        }
        test001(m, arr);
    }

    public static void test001(int m, int[] arr) {
       int len = arr.length;
       int num = len / m;
        if (len % m != 0) {
            num++;
        }

        while (num > 0) {
            for (int i = (num - 1) * m; i < len && i < num * m; i++) {
                System.out.print(arr[i] + " ");
            }
            num--;
        }
    }
}
