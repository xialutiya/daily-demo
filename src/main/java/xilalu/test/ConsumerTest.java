package xilalu.test;

import org.springframework.util.Assert;
import xilalu.entity.NumObj;
import xilalu.entity.Person;

import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class ConsumerTest {
    public static void main(String[] args) {

//       List<Person> list = new ArrayList<>();
//       Consumer<Person> consumer = p -> {
//           if (p.getName().equals("xialu")) {
//               list.add(p);
//           }
//       };
//        consumer = consumer.andThen(
//                x -> list.removeIf(y -> y.getAge() < 13)
//        );
//        BiFunction<String, Integer, Person> person = Person::new;
//        Stream.of(
//                person.apply("xialu", 10),
//                person.apply("hi", 13),
//                person.apply("hello", 12),
//                person.apply("xialu", 15),
//                person.apply("xialu", 17)
//        ).forEach(consumer);
//        System.out.println(Arrays.toString(list.toArray()));

//        Person person = new Person();
//        Consumer<Person> personConsumer = (e) -> e.setName("xialu");
//        personConsumer.accept(person);
//        System.out.println(person.getName());
        List<NumObj> numObjs = new ArrayList<>();
//        NumObj one1 = new NumObj(3D, 7D);
        NumObj one2 = new NumObj(2D, 8D);
        NumObj one3 = new NumObj(0D, 1D);
//        NumObj one4 = new NumObj(7D, 3D);
        NumObj one5 = new NumObj(8D, 9D);
//        numObjs.add(one1);
        numObjs.add(one2);
        numObjs.add(one3);
//        numObjs.add(one4);
        numObjs.add(one5);
        Queue<Double> queueNum = new LinkedBlockingQueue<>();
        numObjs.sort(Comparator.comparing(NumObj::getStart));
        Consumer<NumObj> consumer = v -> {
            queueNum.offer(v.getStart());
            queueNum.offer(v.getEnd());
            Double poll = queueNum.poll();
            Double peek = queueNum.peek();
            Assert.isTrue(poll <= peek, "基准item属性配置值异常,数字需要保证单调递增:");
        };
        numObjs.forEach(consumer);
        System.out.println(Arrays.toString(numObjs.toArray()));
    }
}
