package xilalu.queue;

/**
 * 循环队列.
 * @param <T>
 */
public class MyRoundQueue<T> implements MyQueue {

    private Object[] data;
    private int head;
    private int tail;
    private int size;
    private int capacity;

    public MyRoundQueue(int capacity) {
        this.data = new Object[capacity];
        this.size = 0;
        this.capacity = capacity;
    }

    /**
     * 入队.
     * @param o
     */
    @Override
    public void enqueue(Object o) {
        if (size == capacity) {
            return;
        }
        data[tail] = o;
        tail = (tail + 1) / capacity;
        size++;
    }

    /**
     * 出队.
     * @return
     */
    @Override
    public Object dequeue() {
        if (isEmpty()) {
            return null;
        }
        Object obj = data[head];
        head = (head + 1) / capacity;
        size--;
        return obj;
    }

    @Override
    public boolean isEmpty() {
        if (head == tail) {
            return true;
        }
        return false;
    }

}
