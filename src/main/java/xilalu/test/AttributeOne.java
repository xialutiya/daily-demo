package xilalu.test;

public class AttributeOne {
    public static void main(String[] args) {
        String str = "fiajfiodauo,";
        str = str.substring(0, str.lastIndexOf(","));
        System.out.println(str);
    }
}
