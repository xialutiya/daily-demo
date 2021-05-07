package xilalu.spring_ioc;

import java.util.Objects;

/**
 * Spring IoC实现机制.
 *
 * @author lds
 * @date 2021/2/20 20:58
 */
public interface Fruit {
    abstract void eat();
}

class Apple implements Fruit {

    @Override
    public void eat() {
        System.out.println("Apple");
    }
}

class Orange implements Fruit {

    @Override
    public void eat() {
        System.out.println("Orange");
    }
}

class Factory {

    public static Fruit getInstance(String className) {
        Fruit fruit = null;
        try {
            fruit = (Fruit) Class.forName(className).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return fruit;
    }
}

class Client {
    public static void main(String[] arg) {
        Fruit fruit = Factory.getInstance("xilalu.spring_ioc.Apple");
        if (Objects.nonNull(fruit)) {
            fruit.eat();
        }
    }
}
