package xilalu.code;

import xilalu.stack.MyArrayStack;
import xilalu.stack.MyStack;

import java.util.Scanner;

/**
 * 四则运算.
 */
public class Main15 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str = sc.next();
            MyStack<Integer> numStack = new MyArrayStack<>(10);
            MyStack<String> operatorStack = new MyArrayStack<>(10);
            for (int i = 0; i < str.length(); i++) {
                String data = str.charAt(i) + "";
                if (isOperator(data)) {
                    if (operatorStack.isEmpty()) {
                        operatorStack.push(data);
                    } else {

                    }
                } else {
                    numStack.push(Integer.valueOf(data));
                }
            }
        }
    }

    public static boolean isOperator(String data) {
        switch (data) {
            case "+":
            case "-":
            case "*":
            case "/":
            return true;
        }
        return false;
    }

}
