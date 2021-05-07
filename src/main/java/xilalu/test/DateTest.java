package xilalu.test;

import java.util.Calendar;
import java.util.Date;

/**
 * @author lds
 * @date 2020/10/19 14:50
 */
public class DateTest {

    public static void main(String[] args) {
        Date add = add(new Date(), 5, -1);
        Date date = new Date();
        boolean before = add.before(date);
        System.out.println(before);
    }

    /** @deprecated */
    public static Date add(Date date, int calendarField, int amount) {
        if (date == null) {
            throw new IllegalArgumentException("The date must not be null");
        } else {
            Calendar c = Calendar.getInstance();
            c.setTime(date);
            c.add(calendarField, amount);
            return c.getTime();
        }
    }
}
