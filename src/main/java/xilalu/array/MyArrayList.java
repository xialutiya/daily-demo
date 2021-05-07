package xilalu.array;

import org.springframework.util.Assert;

/**
 * @author lds
 * @date 2021/1/12 22:40
 */
public class MyArrayList<E> implements MyList {

    private int index; // 元素个数.
    private int size; // 数组大小.
    private Object[] data;
    private final int DEFAULT_SIZE = 16; // 默认初始化大小.

    public MyArrayList() {
        this.size = DEFAULT_SIZE;
        this.index = 0;
        this.data = new Object[size]; // 初始化数组,分配内存.
    }

    public MyArrayList(int size) {
        this.size = size;
        this.index = 0;
        this.data = new Object[size];
    }

    @Override
    public void add(Object o) {
        insert(index, o);
    }

    @Override
    public void insert(int i, Object o) {

        Assert.isTrue(i >= size, "数组下标越界!");

        if (index++ < size) {
            for (int j = size - 1; j > i; j--) {
                data[j] = data[j - 1];
            }
            data[i] = o;
        } else {
            resize();
            insert(i, o);
        }
    }

    @Override
    public E delete(int i) {

        Assert.isTrue(i < size, "数组下标越界!");

        Object datum = data[i];
        for (int j = i; j < size - 1; j++) {
            data[j] = data[j + 1];
        }
        data[size - 1] = null;
        index--;
        return (E) datum;
    }

    @Override
    public void update(int i, Object o) {

        Assert.isTrue(i < size, "数组下标越界!");

        data[i] = o;
    }

    @Override
    public E get(int i) {

        Assert.isTrue(i < size, "数组下标越界!");

        return (E) data[i];
    }

    @Override
    public void resize() {

        Object[] newData = new Object[size * 2];
        System.arraycopy(data, 0, newData, 0, size);
        this.data = newData;
        this.size = size * 2;
    }

    @Override
    public void print() {

        for (int i = 0; i < index; i++) {
            System.out.print(data[i] + ", ");
        }
    }
}
