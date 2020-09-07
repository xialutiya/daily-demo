package xilalu.queue;

public class MyArrayQueue<T> implements MyQueue {

    private Object[] data;
    private int head;
    private int tail;

    public MyArrayQueue(int capacity) {
        this.data = new Object[capacity];
    }

    /**
     * 入队.
     * @param o
     */
    @Override
    public void enqueue(Object o) {
        if (tail == data.length) {
            return;
        }
        data[tail++] = o;
    }

    /**
     * 出队.
     * @return
     */
    @Override
    public T dequeue() {
        if (isEmpty()) {
            return null;
        }
        return (T) data[head++];
    }

    public Object dequeue2() {
        if (isEmpty()) {
            return null;
        }
        Object datum = data[head++];
        if (data.length == head + 1) {
            Object[] newArr = new Object[data.length];
            System.arraycopy(data, head, newArr, 0, 2);
            data = newArr;
        }
        return datum;
    }

    /**
     * 队列是否为空.
     * @return
     */
    @Override
    public boolean isEmpty() {
        if (head == tail) {
            return true;
        }
        return false;
    }

}
