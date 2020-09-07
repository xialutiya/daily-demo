package xilalu.linked;

public interface MyLinked<T> {

    void insertHead(T t);

    void insertIndex(T t, int n);

    void removeHead();

    void removeIndex(int n);

    void removeData(T t);

    T get(int n);

    void print();
}
