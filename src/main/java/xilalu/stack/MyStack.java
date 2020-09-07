package xilalu.stack;

public interface MyStack<E> {

    /**
     * 入栈
     */
    void push(E e);
    /**
     * 出栈.
     * @return
     */
    E pop();
    /**
     *  查看栈顶元素.
     * @return
     */
    E peek();
    /**
     * 获取栈的大小.
     * @return
     */
    int size();
    /**
     * 查看栈是否为空.
     * @return
     */
    boolean isEmpty();
}
