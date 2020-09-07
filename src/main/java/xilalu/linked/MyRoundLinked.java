package xilalu.linked;

public class MyRoundLinked<T> implements MyLinked {

    private int size;
    private MyRNode head;

    public MyRoundLinked() {
        this.size = 0;
        this.head = null;
    }

    class MyRNode {
        private Object obj;
        private MyRNode next;

        public MyRNode(Object obj) {
            this.obj = obj;
            this.next = null;
        }
    }

    @Override
    public void insertHead(Object o) {
        MyRNode myRNode = new MyRNode(o);
        if (head == null) {
            head = myRNode;
            head.next = head;
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
            for (int i = 1; i < size; i++) {
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
            insertTail(o);
        } else {
            MyRNode cur = head;
            MyRNode myRNode = new MyRNode(o);
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
        if (head == null) {
            return;
        } else if (head == head.next) {
            head = null;
        } else {
            MyRNode cur = head;
            for (int i = 0; i < size - 1; i++) {
                cur = cur.next;
            }
            cur.next = head.next;
            head = head.next;
        }
        size--;
    }


    @Override
    public void removeIndex(int n) {
        if (n == 0) {
            removeHead();
        } else {
            MyRNode cur = head;
            for (int i = 1; i < n; i++) {
                cur = cur.next;
            }
            cur.next = cur.next.next;
            size--;
        }
    }

    @Override
    public void removeData(Object o) {

    }

    /**
     * 约瑟夫问题.
     *
     * @param n
     */
    public void josephus(int n) {
        if (n == 0) {
            return;
        } else if (size == 0) {
            System.out.println(0);
        } else if (size == 1) {
            System.out.println(head.obj);
        } else {
            MyRNode cur = head;
            while (cur != cur.next) {
                for (int i = 1; i < n - 1; i++) {
                    cur = cur.next;
                }
                cur.next = cur.next.next;
                cur = cur.next;
            }
            System.out.println(cur.obj);
        }
    }

    @Override
    public Object get(int n) {
        if (n == 0) {
            return null;
        }
        MyRNode cur = head;
        for (int i = 0; i < n; i++) {
            cur = cur.next;
        }
        return (T) cur.obj;
    }

    @Override
    public void print() {
        MyRNode cur = head;
        for (int i = 0; i < size; i++) {
            System.out.print(cur.obj + " ");
            cur = cur.next;
        }
        System.out.println();
    }
}
