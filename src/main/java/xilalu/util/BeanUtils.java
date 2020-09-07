package xilalu.util;

import xilalu.entity.Person;

public class BeanUtils {

    private static Object object = new Object();
    private volatile static Person person;

    public static Person getPerson() {
        if (person == null) {
            synchronized (object) {
                if (person == null) {
                    person = new Person();
                }
            }
        }
        return person;
    }
}
