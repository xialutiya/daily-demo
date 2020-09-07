package xilalu.linked;

import java.util.Scanner;

/**
 * 找到链表的倒数第n个节点.
 */
public class Main3 {
    private static int n;
    private static int m;
    private static MySingleLinked<Integer> mySLinked;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            mySLinked = new MySingleLinked<>();
            n = sc.nextInt();
            m = sc.nextInt();
            for (int i = 0; i < n; i++) {
                mySLinked.insertHead(i);
            }
        }

    }

    public int testBoolOne(int m) {
        if (n < m) {
            return -1;
        }
        int size = mySLinked.size;
        return mySLinked.get(size - m);
    }
}
