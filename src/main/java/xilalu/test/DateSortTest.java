package xilalu.test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

/**
 * @author lds
 * @date 2021/3/4 16:46
 */
public class DateSortTest {
    public static void main(String[] args) {
        Date date = new Date();
        Date date1 = new Date();
        List<Date> list = new ArrayList<>();
        list.add(date);
        list.add(date1);
        Date date2 = list.stream().max(Comparator.comparing(v -> v)).get();
        System.out.println(date2);
    }
}
