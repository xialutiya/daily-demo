package xilalu.test;

import java.math.BigDecimal;
import java.util.function.Function;

/**
 * @author lds
 * @date 2020/12/17 17:05
 */
public class FunctionTest {
    public static void main(String[] args) {
        FunctionTest test = new FunctionTest();
        BigDecimal result = test.compute(new BigDecimal(3), num -> num.add(num));
        System.out.println(result);
    }

    public BigDecimal compute(BigDecimal i, Function<BigDecimal, BigDecimal> function) {
        return function.apply(i);
    }
}
