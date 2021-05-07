package xilalu.code;

import java.util.Scanner;

/**
 * .猿辅导公司的 N位（N>=4）研发同学组织了一次秋游活动，某同学带了个无人机在高空拍照，活动结束时，
 * 先拍了一张所有同学排成公司猴头Logo的照片， 接着有人提议再排成“猿”的首字母Y字形来拍一张合照。
 * 用字符串中的每一个字符（不是换行符或结束符'\0'）代表一位老师，输出排好后的队形。
 * 要求 Y字除去中心点外，上下半部分等高，按照从左到右，从上到下进行排序。队形中没人的部分用空格占位。
 * 输入数据保证可以排出一个完整的Y字，即长度为 3k+1 （k>=1）
 *
 * @author lds
 * @date 2021/2/20 23:25
 */
public class Main17 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        test001(num);
    }

    public static void test001(int num) {
        int k = (num - 1) / 3;
        for (int i = 0; i < k; i++) {
            int start = i;
            while (start-- > 0) {
                System.out.print(" ");
            }
            System.out.print("Y");
            int middle = (k - i) * 2 - 1;
            while (middle-- > 0) {
                System.out.print(" ");
            }
            System.out.println("Y");
        }
        for (int i = 0; i <= k; i++) {
            int start = k;
            while (start-- > 0) {
                System.out.print(" ");
            }
            System.out.println("Y");
        }
    }

}
