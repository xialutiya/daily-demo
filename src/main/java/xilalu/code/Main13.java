package xilalu.code;

import xilalu.stack.MyArrayStack;
import xilalu.stack.MyStack;

import java.util.Scanner;

/**
 * 校验括号的合法性:[{()}]
 */
public class Main13 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        char[] chars = str.toCharArray();
        MyStack<Character> myStack = new MyArrayStack<>(16);
        for (int i = 0; i < chars.length; i++) {
            if (myStack.isEmpty()) {
                myStack.push(chars[i]);
            } else {
                Character peek = myStack.peek();
                String s = peek + "";
                String s1 = chars[i] + "";
                if (isOk(s + s1)) {
                    myStack.pop();
                } else {
                    myStack.push(chars[i]);
                }
            }
        }
        System.out.println(myStack.isEmpty());
    }

    public static boolean isOk(String str) {
        return str.equals("[]") || str.equals("{}") || str.equals("()");
    }
}
