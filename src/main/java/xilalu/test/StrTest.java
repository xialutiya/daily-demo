package xilalu.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author lds
 * @date 2021/1/21 19:53
 */
public class StrTest {
    public static void main(String[] args) {

        StringBuffer sb = new StringBuffer();
        String str = "OPL榕江县OPL20191000002非标样C ";
        int index = str.lastIndexOf("非标");
        String strTwo = str.substring(0, index);
        char[] chars = strTwo.toCharArray();
        for (int i = chars.length - 1; i >= 0; i--) {
            String val = String.valueOf(chars[i]);
            if (!isContainChinese(val)) {
                sb.append(val);
            } else {
                System.out.println(sb.reverse().toString());
                return;
            }
        }
    }

    public static boolean isContainChinese(String str) {

        Pattern p = Pattern.compile("[\u4e00-\u9fa5]");
        Matcher m = p.matcher(str);
        if (m.find()) {
            return true;
        }
        return false;
    }

}
