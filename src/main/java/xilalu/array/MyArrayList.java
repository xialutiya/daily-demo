package xilalu.array;

public class MyArrayList<E> implements MyList {

    private int size;
    private int value;
    private static final int DEFAULT_SIZE = 10;
    private Object[] data;

    @Override
    public void add(Object o) {

    }

    @Override
    public void insert(int n, Object o) {

    }

    @Override
    public void deleted(int n) {

    }

    @Override
    public void update(int n, Object o) {

    }

    @Override
    public E get(int i) {
        return (E) this.data[i];
    }
}
