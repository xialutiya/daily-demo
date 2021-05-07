package xilalu.code;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 求a/b的小数表现形式。如果a可以整除b则不需要小数点。
 * 如果是有限小数，则可以直接输出。如果是无限循环小数，
 * 则需要把小数循环的部分用"()"括起来。
 */
public class MainTwo {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        System.out.println(testNum(a, b));
        System.out.println(testNumTwo(a, b));
    }

    public static String testNum(int a, int b) {

        StringBuffer sb = new StringBuffer();
        sb.append(a / b);
        if (a % b != 0) {
            a = a % b;
            sb.append(".");
            Map<Integer, Integer> map = new HashMap<>();
            while (a != 0) {
                a *= 10;
                if (map.get(a) != null) {
                    sb.insert(map.get(a), "(").append(")");
                    break;
                }
                map.put(a, sb.length());
                sb.append(a / b);
                a = a % b;
            }
        }
        return sb.toString();
    }

    public static String testNumTwo(int a, int b) {
        StringBuilder sb = new StringBuilder();
        sb.append(a / b);
        if (a % b != 0) {
            sb.append(".");
            a = a % b;
            Map<Integer, Integer> maps = new HashMap<>();
            while (a != 0) {
                a *= 10;
                if (maps.get(a) != null) {
                    sb.insert(maps.get(a), "(").append(")");
                    break;
                }
                maps.put(a, sb.length());
                sb.append(a/b);
                a = a % b;
            }
        }

        return sb.toString();
    }
}
