package xilalu.code;

import xilalu.linked.Main1;

import java.util.*;

/**
 * @author lds
 * @date 2020/11/9 11:30
 */
public class Main111 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        Main111 main111 = new Main111();
        System.out.println(main111.testStr(str));
    }

    public  String testStr(String str) {
        Map<Character, LinkSort> map = new HashMap<>(str.length());
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            LinkSort linkSort = map.get(c);
            if (Objects.isNull(map.get(c))) {
                linkSort = new LinkSort();
            }
            linkSort.add(c);
            map.put(c,linkSort);
        }
        StringBuilder sb = new StringBuilder();
        map.values().stream().sorted(Comparator.comparing(LinkSort::getIndex)).forEach(v -> sb.append(v.getChars()));

        return sb.toString();
    }

    class LinkSort {
        StringBuilder chars;
        int index;
        public LinkSort() {
            this.chars = new StringBuilder();
            this.index = chars.length();
        }

        public void add(char ch) {
            String.valueOf(ch);
            this.chars.append(ch);
            this.index++;
        }

        public String getChars() {
            return chars.toString();
        }

        public void setChars(StringBuilder chars) {
            this.chars = chars;
        }

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }
    }

}
