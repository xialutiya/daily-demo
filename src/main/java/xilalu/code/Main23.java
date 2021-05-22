package xilalu.code;

import java.util.Scanner;

/**
 * 给定两字符串A和B，如果能将A从中间某个位置分割为左右两部分字符串（都不为空串），
 * 并将左边的字符串移动到右边字符串后面组成新的字符串可以变为字符串B时返回true。
 * 例如：如果A=‘youzan’，B=‘zanyou’，A按‘you’‘zan’切割换位后得到‘zanyou’和B相同返回true。
 *
 * @author lds
 * @date 2021/5/8 22:32
 */
public class Main23 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 字符串A.
        String strA = sc.nextLine();
        // 字符串B.
        String strB = sc.nextLine();

        compareStr(strA, strB);
    }

    public static void compareStr(String strA, String strB) {
        if (strA.length() < strB.length()) {
            System.out.println(false);
            return;
        }
        String compareStrA = strA + strA;
        if (compareStrA.contains(strB)) {
            System.out.println(true);
            return;
        }
        System.out.println(false);
    }
}
