package xilalu.test;

public class MainTwo {

    public static void main(String[] args) {
        int index = 0;
        for (int i = 0; i < 10; i++) {
            index++;
            for (int j = 0; j < 10000; j++) {
                index++;
            }
        }
        System.out.println(index);
        index = 0;
        for (int i = 0; i < 10000; i++) {
            index++;
            for (int j = 0; j < 10; j++) {
                index++;
            }
        }
        System.out.println(index);
    }
}
