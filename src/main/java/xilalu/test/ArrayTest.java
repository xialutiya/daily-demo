package xilalu.test;

import xilalu.entity.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author lds
 * @date 2020/9/7 9:09
 */
public class ArrayTest {
    public static void main(String[] args) {

       List<Person> list = new ArrayList<>(16);
        for (int i = 0; i < 10; i++) {
            Person person = new Person();
            person.setName(String.valueOf(i));
            list.add(person);
        }
        Person person = new Person();
        person.setName(null);
        list.add(person);
        List<String> collect = list.stream().map(Person::getName).distinct().collect(Collectors.toList());
        System.out.println(collect.toString());

//        int index = 10;
//        int num = 10;
//        int size = 11;
//        if (index++ < size) {
//            System.out.println(true);
//        }
//        if (++num < size) {
//            System.out.println(false);
//        }

    }
}
