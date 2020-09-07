package xilalu.linked;

public class MySingleLinked<T> implements MyLinked {

    public int size;
    public MySNode head;

    public MySingleLinked() {
        this.size = 0;
        this.head = null;
    }

    class MySNode<T> {
        public Object t;
        public MySNode next;

        public MySNode(T t) {
            this.t = t;
            this.next = null;
        }
    }

    /**
     * 插入到头节点.
     */
    @Override
    public void insertHead(Object o) {
        MySNode<Object> mySNode = new MySNode<>(o);
        mySNode.next = head;
        head = mySNode;
        size++;
    }

    /**
     * 根据索引插入元素.
     * @param o
     * @param n
     */
    @Override
    public void insertIndex(Object o, int n) {
        if (n == 0) {
            insertHead(o);
        } else {
            MySNode<Object> mySNode = new MySNode<>(o);
            MySNode cur = head;
            for (int i = 1; i < n; i++) {
                cur = cur.next;
            }
            mySNode.next = cur.next;
            cur.next = mySNode;
            size++;
        }
    }

    /**
     * 移除头节点.
     */
    @Override
    public void removeHead() {
        if (size == 0) {
            return;
        } else {
           head = head.next;
           size--;
        }
    }

    /**
     * 移除指定节点.
     * @param n
     */
    @Override
    public void removeIndex(int n) {
        if (n == 0) {
            removeHead();
        } else {
            MySNode cur = head;
            for (int i = 1; i < n; i++) {
                cur = cur.next;
            }
            cur.next = cur.next.next;
            size--;
        }
    }

    /**
     * 移除指定定素.
     * @param o
     */
    @Override
    public void removeData(Object o) {
        if (size == 0) {
            return;
        } else {
            MySNode cur = head;
            int index = 0;
            while (cur != null) {
                if (cur.t.equals(o)) {
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
        if (size == 0) {
            return null;
        }
        MySNode cur = head;
        for (int i = 0; i < n; i++) {
            cur = cur.next;
        }
        return (T) cur.t;
    }

    @Override
    public void print() {
        if (size == 0) {
            return;
        }
        MySNode cur = head;
        for (int i = 0; i < size; i++) {
            System.out.print(cur.t + " ");
            cur = cur.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        MySingleLinked<String> mySLinked = new MySingleLinked<>();
        mySLinked.insertHead("xialu");
        mySLinked.insertHead("hi");
        mySLinked.insertHead("hello");
        mySLinked.insertIndex("go", 2);
        mySLinked.insertIndex("go", 2);
        mySLinked.insertIndex("to", 1);
        mySLinked.print();
        mySLinked.removeHead();
        mySLinked.removeHead();
        mySLinked.print();
        mySLinked.removeIndex(1);
        mySLinked.removeData("hi");
        mySLinked.removeData("go");
        mySLinked.print();
        String str = mySLinked.get(0);
        System.out.println(str);
    }
}
