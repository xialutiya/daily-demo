package xilalu.test;

import org.springframework.util.Assert;
import xilalu.array.ArrayTest;
import xilalu.entity.Person;

import java.util.Objects;

public class SwitchTest {
    public static void main(String[] args) {
        test();
    }

    public static void testTwo() {

        ArrayTest arrayTest = new ArrayTest(5);
        arrayTest.add(3);
        arrayTest.add(5);
        arrayTest.add(6);
        arrayTest.deleted(0);
        arrayTest.update(0, 3);
        arrayTest.insert(1, 7);
        arrayTest.insert(1, 2);
        arrayTest.insert(1, 5);
        arrayTest.insert(1, 6);
        arrayTest.toArrayTest();
    }

    public void testOne() {
        String str1 = "ja";
        String str2 = "va";
        String str3 = "java";
        String str5 = str1 + str2;
        System.out.println(str3 == str5);
        System.out.println(str3.equals(str5));
    }

    public static void testThree() {
        String str1 = "  [12  ,  16] | [18, 23] ".replaceAll(" ", "");
//        String str2 = "[56,77]";
        String[] split = str1.split("|");
        int index = str1.indexOf(",");
        System.out.println(index);
//        String[] split1 = str2.split("|");
//        System.out.println(Arrays.toString(split));
//        System.out.println(Arrays.toString(split1));
    }

    public static void testFive() {
//        boolean flag = false;
//        String test = "";
//        flag = testFour(flag, test);
//        System.out.println(flag);
//        System.out.println(test);
        Person person = new Person();
        testSix(person);
        System.out.println(person.getName());
    }

    public static boolean testFour(boolean flag, String test) {
        flag = true;
        test = "xialu";
        return flag;
    }

    public static void testSix(Person person) {
        person.setName("xialu");
    }

    public static boolean testSeven() {
        int number = 0;
        int compare = 2;
        switch (number) {
            case 0:
                if (compare == 1) {
                    return true;
                }
                return false;
            case 1:
                if (compare == -1) {
                    return true;
                }
                return false;
            case 2:
                if (compare == 0) {
                    return true;
                }
                return false;
            case 3:
                if (compare > -1) {
                    return true;
                }
                return false;
            case 4:
                if (compare < 1) {
                    return true;
                }
                return false;
            default:
                Assert.isTrue(false, "xialu");
        }
        return false;
    }

    public static void test() {
        String checkId = "495207759865511936 : 41";
//        String checkId = "1232";
        if (checkId != null && checkId != "") {
            String[] split = checkId.split(":");
            if (Objects.nonNull(split) && split.length >= 1) {
                System.out.println(split[0]);
            }
        }
    }
}
