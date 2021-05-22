package xilalu.code;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author lds
 * @date 2021/5/21 23:18
 */
public class Main31 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<String> list = new ArrayList();
        dfs("", n, n, list);
        for (String s : list) {
            System.out.print(s + " ");
        }
    }

    public static void dfs(String str, int left, int right, List<String> list) {
        if (left == 0 && right == 0) {
            list.add(str);
            return;
        }
        if (left > right) {
            return;
        }
        if (left > 0) {
            dfs(str + "(", left - 1, right, list);
        }
        if (right > 0) {
            dfs(str + ")", left, right - 1, list);
        }
    }
}
