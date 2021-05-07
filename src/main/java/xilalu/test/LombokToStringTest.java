package xilalu.test;

import xilalu.entity.Person;
import xilalu.entity.Student;

/**
 * @author lds
 * @date 2021/1/29 8:44
 */
public class LombokToStringTest {

    public static void main(String[] args) {
        Person person = new Person();
        person.setName("xialu");
        person.setAge(13);
        System.out.println(person.toString());

        Student student = new Student();
        student.setStudentNo(123);
        student.setSchool("家里蹲");
        student.setName("xialu");
        System.out.println(student.toString());
    }
}
