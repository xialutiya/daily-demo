package xilalu.test;

import java.util.Scanner;

/**
 * @author lds
 * @date 2021/1/20 16:36
 */
public class TestFour {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] strArr = str.split(" ");
        String numStr = strArr[0];
        String kStr = strArr[1];
        int[] arr = new int[numStr.length()];
        int k = Integer.valueOf(kStr);
        for (int i = 0; i < numStr.length(); i++) {
            arr[i] = Integer.valueOf(numStr.charAt(i) + "");
        }
    }

}
