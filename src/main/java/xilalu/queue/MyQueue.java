package xilalu.queue;

public interface MyQueue<T> {

    void enqueue(T t);

    T dequeue();

    boolean isEmpty();
}
