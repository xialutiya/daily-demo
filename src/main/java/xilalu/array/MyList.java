package xilalu.array;

/**
 * @author lds
 * @date 2021/1/12 22:37
 */
public interface MyList<E> {

    /**
     * 添加元素.
     *
     * @param e
     */
    void add(E e);

    /**
     * 指定索引插入元素.
     *
     * @param i
     * @param e
     */
    void insert(int i, E e);

    /**
     * 删除指定索引元素.
     *
     * @param i
     * @return
     */
    E delete(int i);

    /**
     * 指定索引修改元素.
     *
     * @param i
     * @param e
     */
    void update(int i, E e);

    /**
     * 获取指定索引元素.
     *
     * @param i
     * @return
     */
    E get(int i);

    /**
     * 扩容.
     */
    void resize();

    /**
     * 打印数组.
     */
    void print();
}
