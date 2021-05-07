package xilalu.linked;

/**
 * @author lds
 * @date 2020/10/12 22:37
 */
public interface MyLinkedTwo<T> {

    void insertHead(T t);

    void insertIndex(T t, int n);

    void removeHead();

    void removeIndex(int n);

    void removeData(T t);

    T get(int n);

    void print();
}
