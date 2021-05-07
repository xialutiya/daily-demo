package xilalu.linked;

import java.util.Scanner;

/**
 * @author lds
 * @date 2020/10/12 23:11
 */
public class Main2Two {

    private static MySingleLinkedTwo<String> mySLink;
    private static int capacity = 5;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        mySLink = new MySingleLinkedTwo<>();
        while (sc.hasNext()) {
            String str = sc.nextLine();
            testStr(str);
        }
    }

    public static void testStr(String str) {
        mySLink.removeData(str);
        mySLink.insertHead(str);
        if (mySLink.size > capacity) {
            mySLink.removeIndex(mySLink.size - 1);
        }
        mySLink.print();
    }
}
