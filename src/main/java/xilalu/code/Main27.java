package xilalu.code;

import java.util.Scanner;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * @author lds
 * @date 2021/5/18 0:31
 */
public class Main27 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int len = getLongChildStr(s);
        System.out.println(len);
    }

    public static int getLongChildStr(String s) {
        int maxSize = 0;
        int[] dict = new int[256]; //记录ASCII 码字符出现的位置，以字符作为下标
        int base = 0;
        int key = 0;
        int i = 0;
        while (key < s.length()) {
            i = s.charAt(key);
            if (dict[i] > base)
                base = dict[i];
            dict[i] = key + 1; //以1作为起始位置，下标加1
            maxSize = (maxSize > key - base + 1) ? maxSize : key - base + 1;
            key++;
        }
        return maxSize;
    }
}
