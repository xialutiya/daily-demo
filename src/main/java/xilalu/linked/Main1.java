package xilalu.linked;

import java.util.Scanner;

/**
 * 约瑟夫问题.
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        testNum(n, m);
    }

    public static void testNum(int n, int m) {
        MyRoundLinked<Integer> myRLinked = new MyRoundLinked<>();
        for (int i = n; i > 0; i--) {
            myRLinked.insertHead(i);
        }
        myRLinked.josephus(m);
    }
}
