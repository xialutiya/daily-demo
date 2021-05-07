package xilalu.test;

import org.springframework.util.StringUtils;

import java.lang.reflect.Field;

public class TestTwo {
    public static void main(String[] args) {

        Integer num = null;
        num = num == null ? 0 : 1;
        System.out.println(num);
    }

    public static void testOne(int n) {
        System.out.println(n);
//        testTwo(++n);
    }

    public static int testThree(int i) {
        return ++i;
    }

    public static void testTwo(int n) {
        System.out.println(n);
    }

    public static void objectToMap(Object objA, Object objB, Class<?> clazz) throws IllegalAccessException {

        for (Field field : clazz.getDeclaredFields()) {
            field.setAccessible(true);
            Object valueA = field.get(objA);
            Object valueB = field.get(objB);
            String name = field.getType().getName();
            if ("String".equalsIgnoreCase(name)
                    || "java.lang.String".equalsIgnoreCase(name)) {
                if (StringUtils.isEmpty(valueB)) {
                    field.set(objB, valueA);
                }
            }
        }
    }
}
