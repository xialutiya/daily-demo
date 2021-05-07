package xilalu.code;

import java.util.Scanner;
import java.util.Stack;

/**
 * 有一十进制正整数，移除其中的 K 个数，使剩下的数字是所有可能中最大的。
 * 假设：
 * 字符串的长度一定大于等于 K
 * 字符串不会以 0 开头.
 *
 * @author lds
 * @date 2021/3/24 23:15
 */
public class Main21 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int num = sc.nextInt();
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(maxNum(arr, num));
    }

    // 7 3 1 4 3 2 2 1 9
    public static int maxNum(int[] arr, int k) {

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && k > 0 && stack.peek() < arr[i]) {
                stack.pop();
                k--;
            }
            stack.push(arr[i]);

        }
        while (k > 0) {
            stack.pop();
            k--;
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.peek());
            stack.pop();
        }
        System.out.println(sb.reverse());

        return 0;
    }
}
