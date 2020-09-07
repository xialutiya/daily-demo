package xilalu.linked;

import java.util.Scanner;

/**
 * LRU.
 */
public class Main2 {

    private static final int capacity = 5;
    private static MySingleLinked<String> mySLinked;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        mySLinked = new MySingleLinked<>();
        while (sc.hasNext()) {
            String scr = sc.nextLine();
            testStr(scr);
        }
    }

    public static void testStr(String str) {
        mySLinked.removeData(str);
        mySLinked.insertHead(str);
        while (mySLinked.size > capacity) {
            mySLinked.removeIndex(mySLinked.size - 1);
        }
        mySLinked.print();
    }

}
