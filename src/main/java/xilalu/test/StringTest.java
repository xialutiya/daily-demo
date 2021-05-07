package xilalu.test;

import java.text.ParseException;

public class StringTest {
    public static void main(String[] args) throws ParseException {

        // javap -v输出字节码.

        String s1 = "ja";
        String s2 = "va";
        String s3 = "java";
        String s4 = s1 + s2; // +号会被重载.变成new StringBuild(),会new对象.
        System.out.println(s3 == s4);
        System.out.println(s3.equals(s4));
    }

    public static void strTest(String str) {
        System.out.println(str);
    }

    static final int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }
}
