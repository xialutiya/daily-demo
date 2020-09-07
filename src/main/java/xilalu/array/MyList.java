package xilalu.array;

public interface MyList<E> {

    void add(E e);

    void insert(int n, E e);

    void deleted(int n);

    void update(int n, E e);

    E get(int i);
}
