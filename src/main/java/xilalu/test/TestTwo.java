package xilalu.test;

import xilalu.entity.Person;
import xilalu.util.BeanUtils;

public class TestTwo {
    public static void main(String[] args) throws InterruptedException {
//        Person person = BeanUtils.getPerson();
//        new Thread(() -> {
//           person.setAge(11);
//            System.out.println(person);
//        }).start();
//        new Thread(() -> {
//           person.setAge(13);
//            System.out.println(person);
//        }).start();
//        Thread.sleep(2000);
//        System.out.println(person);

        int num = 100;
        System.out.println((100 % 32) == (100 & 31));
    }
}
