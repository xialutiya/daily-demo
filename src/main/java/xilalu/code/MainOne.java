package xilalu.code;

import java.util.Scanner;

/**
 * 小明最近在做病毒自动检测，他发现，在某些library 的代码段的二进制表示中，
 * 如果包含子串并且恰好有k个1，就有可能有潜在的病毒。library的二进制表示可能很大，
 * 并且子串可能很多，人工分析不可能，于是他想写个程序来先算算到底有多少个子串满足条件。
 * 如果子串内容相同，但是开始或者结束位置不一样，则被认为是不同的子串。
 * 注：子串一定是连续的。例如"010"有6个子串，分别是 "0, "1", "0", "01", "10", "010"
 */
public class MainOne {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        sc.nextLine();
        String str = sc.next();
        System.out.println(num(k, str));
    }

    public static int num(int k, String str) {
        char[] chars = str.toCharArray();
        int res = 0;
        int len = chars.length;
        for (int i = 0; i < len; i++) {
            if (chars[i] == '1') {
                res++;
            }
        }
        if (res < k) {
            return 0;
        }
        res = 0;
        for (int i = 0; i < len; i++) {
            int index = i;
            int count = 0;
            while (count < k && index < len) {
                if (chars[index] == '1' && ++count == k) {
                    res++;
                    index++;
                    break;
                }
                index++;
            }
            while (index < len && chars[index] != '1') {
                res++;
                index++;
            }
        }
        return res;
    }
}
