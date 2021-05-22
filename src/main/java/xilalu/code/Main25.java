package xilalu.code;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。
 * 请写程序找出这两个只出现一次的数字。要求时间复杂度为O(n)，空间复杂度为O(1)。
 *
 * @author lds
 * @date 2021/5/9 9:51
 */
public class Main25 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int[] input = new int[len];
        for (int i = 0; i < len; i++) {
            input[i] = sc.nextInt();
        }
        findNumsAppearOnce(input);
    }

    /**
     * @param input 输入数组.
     */
    public static void findNumsAppearOnce(int[] input) {
        // 结果数组.
        int[] arr = new int[2];
        int result = 0, index = 0;
        // 设只出现过一次的数字为A,B. result=A^B;
        for (int i = 0; i < input.length; i++) {
            result ^= input[i];
        }
        // 从右往左遍历查找A,B第一个不同的二进制位.
        while ((result & 1) == 0) {
            result = result >>> 1;
            index++;
        }
        // 将数组分为包含A与包含B的两部分.
        for (int num : input) {
            if (((num >>> index) & 1) == 0) {
                arr[0] ^= num;
            } else {
                arr[1] ^= num;
            }
        }
        // 输出结果.
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
