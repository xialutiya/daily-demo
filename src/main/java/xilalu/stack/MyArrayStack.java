package xilalu.stack;

public class MyArrayStack<E> implements MyStack{

    private Object[] data;
    private int size;

    public MyArrayStack(int capacity) {
        this.size = 0;
        this.data = new Object[capacity];
    }

    @Override
    public void push(Object o) {
        judgeSize();
        data[size++] = o;
    }

    public void judgeSize() {
        if (size >= data.length) {
            resize(data.length * 2);
        }
    }

    public void resize(int capacity) {
        Object[] obj = new Object[capacity];
        System.arraycopy(data, 0, obj, 0, size);
        data = obj;
    }

    @Override
    public E pop() {
        if (isEmpty()) return null;
        Object obj = data[--size];
        data[size] = null;
        return (E) obj;
    }

    @Override
    public E peek() {
        if (isEmpty()) return null;
        int num = size - 1;
        return (E) data[num];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        if (size == 0) return true;
        return false;
    }

}
