package xilalu.stack;

import xilalu.linked.MySingleLinked;

public class MyLinkedStack<T> implements MyStack {

    private int sHead;
    private int size;
    private MySingleLinked<T> mySLinked;

    public MyLinkedStack() {
        this.sHead = 0;
        mySLinked = new MySingleLinked();
    }

    @Override
    public void push(Object o) {
        mySLinked.insertHead(o);
        size++;
    }

    @Override
    public T pop() {
        if (isEmpty()) {
            return null;
        }
        T t = mySLinked.get(0);
        mySLinked.removeHead();
        size--;
        return t;
    }

    @Override
    public T peek() {
        if (isEmpty()) {
            return null;
        }
        return (T) mySLinked.get(0);
    }

    @Override
    public int size() {
        return mySLinked.size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0 ? true : false;
    }

    public static void main(String[] args) {
        MyLinkedStack<String> myLStack = new MyLinkedStack<>();
        myLStack.push("xialu");
        myLStack.push("hi");
        String one = myLStack.peek();
        String pop = myLStack.pop();
        String two = myLStack.peek();
        String pop1 = myLStack.pop();
        System.out.println(one + ":" + two + ":" + pop + ":" + pop1);
    }
}
