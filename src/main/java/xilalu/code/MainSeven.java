package xilalu.code;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 1. 三个同样的字母连在一起，一定是拼写错误，去掉一个的就好啦：比如 helllo -> hello
 * 2. 两对一样的字母（AABB型）连在一起，一定是拼写错误，去掉第二对的一个字母就好啦：比如 helloo -> hello
 * 3. 上面的规则优先“从左到右”匹配，即如果是AABBCC，虽然AABB和BBCC都是错误拼写，应该优先考虑修复AABB，结果为AABCC
 * <p>
 * 第一行包括一个数字N，表示本次用例包括多少个待校验的字符串。
 * 后面跟随N行，每行为一个待校验的字符串。
 * N行，每行包括一个被修复后的字符串。
 */
public class MainSeven {

    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int n = Integer.parseInt(scanner.nextLine());
//        while (n > 0) {
//            n--;
//            String res = scanner.nextLine();
//            System.out.println(testStr(res));
//        }
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        for (int i = 0; i < len; i++) {
            String next = sc.next();
            System.out.println(testStr(next));
        }
    }

    public static String testStr(String str) {

        Queue<Character> queue = new LinkedList<>();
        String res = "", temp = "";
        int pre = 0;
        for (int i = 0; i < str.length(); i++) {
            queue.offer(str.charAt(i));
        }
        while (!queue.isEmpty()) {
            int len = temp.length() - 1;
            Character c = queue.poll();
            if (len < 0) {
                temp += c;
                pre++;
            } else {
                if (c.equals(temp.charAt(len))) {
                    if (pre < 2) {
                        temp += c;
                        pre++;
                    } else if (pre == 2) {
                        continue;
                    }
                } else {
                    if (pre < 2) {
                        res += temp;
                        temp = String.valueOf(c);
                        pre = 1;
                    } else {
                        if (temp.length() < 3) {
                            temp += c;
                        } else {
                            res += temp;
                            temp = String.valueOf(c);
                            pre = 1;
                        }
                    }
                }
            }
        }
        return res + temp;
    }

    public String testStrTwo(String str) {
        Queue<Character> queue = new LinkedList<>();
        String res, temp;
        int pre = 0;
        for (int i = 0; i < str.length(); i++) {
            queue.offer(str.charAt(i));
        }
        return "";
    }
}
