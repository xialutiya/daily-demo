package xilalu.code;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * 求任一正整数的阶乘（注意：是任意正整数）.
 *
 * @author lds
 * @date 2021/3/25 22:48
 */
public class Main22 {

    private static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
//        arr = new int[num + 1];
//        System.out.println(testNum(num));
        factorial(num);
    }

//    public static BigInteger testNum(int num) {
//        if (num <= 1) {
//            return new BigInteger("1");
//        }
//        if (arr[num] != 0) {
//            return BigInteger.valueOf(arr[num]);
//        }
//        arr[num] = num;
//        return BigInteger.valueOf(num).multiply(testNum(num - 1));
//    }

    static void factorial(int n) {
        int[] res = new int[36000]; // 10000! 位数不超过36000

        // 初始化
        res[0] = 1;
        int res_size = 1; // 表示有多少位

        // 计算 n!
        for (int x=2; x<=n; x++) {
            res_size = multiply(x, res, res_size);
        }

        for (int i=res_size-1; i>=0; i--) {
            System.out.print(res[i]);
        }
        System.out.println();
    }

    static int multiply(int x, int res[], int res_size) {
        int carry = 0; // 进位.
        for (int i = 0; i < res_size; i++) {
            int prod = res[i] * x + carry;
            res[i] = prod % 10;
            carry = prod / 10;
        }
        while (carry != 0) {
            res[res_size] = carry % 10;
            carry = carry / 10;
            res_size++;
        }
//        int carry = 0;  // 进位

//        for (int i=0; i<res_size; i++) {
//            int prod = res[i] * x + carry;
//            res[i] = prod % 10;
//            carry  = prod/10;
//        }
//
//        while (carry!=0) {
//            res[res_size] = carry%10;
//            carry = carry/10;
//            res_size++;
//        }
        return res_size;
    }
}
