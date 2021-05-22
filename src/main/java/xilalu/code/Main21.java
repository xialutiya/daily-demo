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
        int num = sc.nextInt();
        int k = sc.nextInt();
        String str = String.valueOf(num);
        int[] arr = new int[str.length()];
        for (int i = 0; i < str.length(); i++) {
            arr[i] = Integer.valueOf(str.charAt(i) + "");
        }
        getMaxNum(arr, k);
    }

    public static void getMaxNum(int[] arr, int k) {
        Stack<Integer> stack = new Stack();
        for (int num : arr) {
            while (!stack.isEmpty() && stack.peek() < num && k > 0) {
                stack.pop();
                k--;
            }
            stack.push(num);
        }
        while (k > 0) {
            stack.pop();
            k--;
        }
        StringBuffer sb = new StringBuffer();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        System.out.println(sb.reverse());
    }

}
