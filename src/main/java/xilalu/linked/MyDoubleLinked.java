package xilalu.linked;

public class MyDoubleLinked<T> implements MyLinked {

    private int size;
    private MyDNode head;
    private MyDNode tail;

    class MyDNode {
        private Object obj;
        private MyDNode pre;
        private MyDNode next;

        public MyDNode(Object obj) {
            this.obj = obj;
            this.pre = null;
            this.next = null;
        }
    }

    /**
     * 头部插入.
     *
     * @param o
     */
    @Override
    public void insertHead(Object o) {
        MyDNode newNode = new MyDNode(o);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            head.pre = newNode;
            newNode.next = head;
            head = newNode;
        }
        size++;
    }

    @Override
    public void insertIndex(Object o, int n) {
        if (n == 0) {
            insertHead(o);
        } else if (n == size) {
            MyDNode myDNode = new MyDNode(o);
            tail.next = myDNode;
            myDNode.pre = tail;
            tail = myDNode;
            size++;
        } else {
            MyDNode cur = head;
            MyDNode myDNode = new MyDNode(o);
            for (int i = 1; i < n; i++) {
                cur = cur.next;
            }
            cur.next.pre = myDNode;
            myDNode.next = cur.next;
            cur.next = myDNode;
            myDNode.pre = cur;
            size++;
        }
    }

    /**
     * 删除头节点.
     */
    @Override
    public void removeHead() {
        if (head == null) {
            return;
        } else if (head.next == null) {
            tail = null;
        } else {
            head.next.pre = null;
        }
        head = head.next;
        size--;
    }

    public void removeTail() {
        if (tail == null) {
            return;
        } else if(tail.pre == null) {
            head = null;
        } else {
           tail.pre.next = null;
        }
        tail = tail.pre;
        size--;
    }

    /**
     * 根据索引删除节点.
     *
     * @param n
     */
    @Override
    public void removeIndex(int n) {
        if (n == 0) {
            removeHead();
        } else if (n == size - 1) {
            removeTail();
        } else {
            MyDNode cur = head;
            for (int i = 1; i < n; i++) {
                cur = cur.next;
            }
            cur.next.next.pre = cur;
            cur.next = cur.next.next;
            size--;
        }
    }

    @Override
    public void removeData(Object o) {
        if (head == null) {
            return;
        } else {
            MyDNode cur = head;
            int index = 0;
            while (cur == null) {
                if (cur.obj.equals(o)) {
                    removeIndex(index);
                } else {
                    index++;
                }
                cur = cur.next;
            }
        }
    }

    @Override
    public T get(int n) {
        MyDNode cur = head;
        for (int i = 0; i < n; i++) {
            cur = cur.next;
        }
        return (T) cur.obj;
    }

    @Override
    public void print() {
        MyDNode cur = head;
        for (int i = 0; i < size; i++) {
            System.out.print(cur.obj + " ");
            cur = cur.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        MyDoubleLinked<String> myDLinked = new MyDoubleLinked();
        myDLinked.insertHead("xialu3");
        myDLinked.insertHead("xialu2");
        myDLinked.insertHead("xialu1");
        myDLinked.print();
        myDLinked.insertIndex("hi", 0);
        myDLinked.insertIndex("hello", 2);
        myDLinked.print();
        myDLinked.removeHead();
        myDLinked.print();
        myDLinked.removeIndex(0);
        myDLinked.removeIndex(2);
        myDLinked.print();
    }
}
