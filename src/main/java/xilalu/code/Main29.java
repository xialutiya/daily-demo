package xilalu.code;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author lds
 * @date 2021/5/19 20:55
 */
public class Main29 {

    private static String[] arr =
            {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    private static List<String> list = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String digits = sc.nextLine();
        bfs(digits, 0, new StringBuffer());
        for (String s : list) {
            System.out.print(s + " ");
        }
    }
    public static void bfs(String digits, int index, StringBuffer sb) {
        if (digits.length() == index) {
            list.add(sb.toString());
            return;
        }
        char c = digits.charAt(index);
        String str = arr[c - '2'];
        for (int i = 0; i < str.length(); i++) {
            sb.append(str.charAt(i));
            bfs(digits, index + 1, sb);
            sb.deleteCharAt(index);
        }
    }

}
