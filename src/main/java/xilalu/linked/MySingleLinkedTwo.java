package xilalu.linked;

/**
 * @author lds
 * @date 2020/10/12 22:47
 */
public class MySingleLinkedTwo<T> implements MyLinkedTwo {

    public int size;
    private MySNode head;

    class MySNode<T> {
        public Object t;
        public MySNode next;

        public MySNode(T t) {
            this.t = t;
            this.next = null;
        }
    }

    @Override
    public void insertHead(Object o) {
        MySNode<Object> sNode = new MySNode<>(o);
        sNode.next = head;
        head = sNode;
        size++;
    }

    @Override
    public void insertIndex(Object o, int n) {
        if (n == 0) {
            insertHead(o);
        } else {
            MySNode<Object> sNode = new MySNode<>(o);
            MySNode cur = head;
            for (int i = 1; i < n; i++) {
                cur = cur.next;
            }
            sNode.next = cur.next;
            cur.next = sNode;
            size++;
        }
    }

    @Override
    public void removeHead() {
        if (size == 0) {
            return;
        } else {
            head = head.next;
            size--;
        }
    }

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

    @Override
    public void removeData(Object o) {
        if (size == 0) {
            removeHead();
        } else {
            MySNode<Object> sNode = new MySNode<>(o);
            MySNode cur = head;
            int index = 0;
            while (cur != null) {
                if (o.equals(cur.t)) {
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
        } else {
            MySNode cur = head;
            for (int i = 0; i < n; i++) {
                cur = cur.next;
            }
            return (T) cur.t;
        }
    }

    @Override
    public void print() {
        if (size == 0) {
            return;
        } else {
            MySNode cur = head;
            while (cur != null) {
                System.out.print(cur.t + " ");
                cur = cur.next;
            }
            System.out.println();
        }
    }
}
