package xilalu.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternTest {

    public static void main(String[] args) {
        String str = "123893748937486";
        String regEx = "[^0-9]";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(str);
        String trim = m.replaceAll("").trim();
        System.out.println(trim);
    }
}
