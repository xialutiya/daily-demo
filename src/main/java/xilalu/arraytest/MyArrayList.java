package xilalu.arraytest;

/**
 * @author lds
 * @date 2021/2/7 18:03
 */
public class MyArrayList<E> implements MyListTwo {

    // 数组大小.
    private int size;
    // 数组元素个数.
    private int index;
    //数组默认初始化大小.
    private final int DEFAULT_SIZE = 16;
    private Object[] data;

    public MyArrayList() {
        this.data = new Object[DEFAULT_SIZE];
    }

    public MyArrayList(int size) {
        this.size = size;
        this.data = new Object[size];
    }

    @Override
    public void add(Object o) {
        if (index < size) {
            data[index++] = o;
        } else {
            resize();
            add(o);
        }
    }

    @Override
    public void insertIndex(int index, Object o) {
        if (index < size) {
            for (int i = size - 1; i > index; i--) {
                this.data[i] = this.data[i - 1];
            }
            this.data[index] = o;
            this.index++;
        } else {
            resize();
            insertIndex(index, o);
        }
    }

    @Override
    public void deleted(Object o) {

    }

    @Override
    public void removeIndex(int index) {

    }

    @Override
    public void updateIndex(int index) {

    }

    @Override
    public Object getIndex(int index) {
        return null;
    }

    @Override
    public void print() {

    }

    @Override
    public void resize() {
        Object[] newData = new Object[size * 2];
        System.arraycopy(data, 0, newData, 0, this.size);
        this.size = 2 * size;
        this.data = newData;
    }

    @Override
    public void isEmpty() {

    }
}
