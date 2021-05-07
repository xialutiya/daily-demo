package xilalu.linked;

/**
 * @author lds
 * @date 2020/10/13 22:38
 */
public class MyRountLinkedTwo<T> implements MyLinkedTwo {

    private int size;
    private MyRNode head;

    public MyRountLinkedTwo() {
        this.size = 0;
        this.head = null;
    }

    class MyRNode<T> {
        private Object data;
        private MyRNode next;

        public MyRNode(Object data) {
            this.data = data;
            this.next = null;
        }
    }

    @Override
    public void insertHead(Object o) {
        MyRNode<Object> myRNode = new MyRNode<>(o);
        if (head == null) {
            myRNode.next = head;
            head = myRNode;
        } else {
            MyRNode cur = head;
            for (int i = 0; i < size - 1; i++) {
                cur = cur.next;
            }
            cur.next = myRNode;
            myRNode.next = head;
            head = myRNode;
        }
        size++;
    }

    public void insertTail(Object o) {
        if (head == null) {
            insertHead(o);
        } else {
            MyRNode cur = head;
            MyRNode myRNode = new MyRNode(o);
            for (int i = 0; i < size - 1; i++) {
                cur = cur.next;
            }
            cur.next = myRNode;
            myRNode.next = head;
            size++;
        }
    }

    @Override
    public void insertIndex(Object o, int n) {
        if (n == 0) {
            insertHead(o);
        } else if (n >= size) {
            insertTail(o );
        } else {
            MyRNode myRNode = new MyRNode(o);
            MyRNode cur = head;
            for (int i = 1; i < n; i++) {
                cur = cur.next;
            }
            myRNode.next = cur.next;
            cur.next = myRNode;
            size++;
        }
    }

    @Override
    public void removeHead() {

    }

    @Override
    public void removeIndex(int n) {

    }

    @Override
    public void removeData(Object o) {

    }

    @Override
    public Object get(int n) {
        return null;
    }

    @Override
    public void print() {

    }
}
