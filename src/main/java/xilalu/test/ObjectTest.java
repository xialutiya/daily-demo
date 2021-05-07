package xilalu.test;

import xilalu.entity.Person;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lds
 * @date 2020/9/14 15:51
 */
public class ObjectTest {
    public static void main(String[] args) {
        Person person = new Person();
        System.out.println(testOne(person).size());
        System.out.println("1");
    }

    public static List<Person> testOne(Person person) {
        List<Person> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            person.setAge(i);
            person.setName("zhang" + i);
            list.add(person);
        }
        return list;
    }
}
