package xilalu.arraytest;

/**
 * @author lds
 * @date 2021/2/7 17:59
 */
public interface MyListTwo<E> {

    /**
     * 插入元素.
     *
     * @param e
     */
    void add(E e);

    /**
     * 在指定位置插入元素.
     *
     * @param index
     * @param e
     */
    void insertIndex(int index, E e);

    /**
     * 删除元素.
     *
     * @param e
     */
    void deleted(E e);

    /**
     * 移除指定位置元素.
     *
     * @param index
     */
    void removeIndex(int index);

    /**
     * 修改指定索引元素.
     *
     * @param index
     */
    void updateIndex(int index);

    /**
     * 获取指定索引元素.
     *
     * @param index
     * @return
     */
    E getIndex(int index);

    /**
     * 输出数组.
     */
    void print();

    /**
     * 数组扩容.
     */
    void resize();

    /**
     * 数组是否为空.
     */
    void isEmpty();
}
