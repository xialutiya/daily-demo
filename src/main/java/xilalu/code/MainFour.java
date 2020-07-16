package xilalu.code;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * 给定一个32位int型正整数，我们定义如下操作，取其十进制各位数字的平方和，
 * 并不断重复这个操作。如果某次操作完成后得到的结果是1，则返回true；
 * 否则继续执行，直到证明永远不会得到结果为1，返回false
 */
public class MainFour {
    public static void main(String [] args) {
        //建立一个二维数组,提高后面平方的运算速度
        int[][] lib = new int[10][2];
        for (int i = 0; i < 10; i++) {
            lib[i][0] = i;
            lib[i][1] = i*i;
        }
        //读取数据
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int[] arr = new int[m];
        for (int i = 0; i < m; i++) {
            arr[i] = scanner.nextInt();
        }
        for (int i = 0; i < m; i++) {
            List<Integer> list = new ArrayList<>();
            System.out.println(isOne(arr[i],lib,list));
        }
    }

    private static boolean isOne(int num, int[][] lib, List<Integer> list) {
        if (num == 1) return true;
        //这里最重要的就是判断什么时候是false,其实就是循环了
        //每次判断list中是否已经含有当前数字,如果有,那就不可能为1了;
        if (list.contains(num))  return false;
        //并且插入num
        list.add(num);
        int n = 0;
        while(num > 0){
            int tmp = num % 10;
            n += lib[tmp][1];
            num /= 10;
        }
        return isOne(n,lib, list);
    }
}
