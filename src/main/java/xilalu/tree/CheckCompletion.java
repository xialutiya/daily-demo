package xilalu.tree;

import xilalu.queue.MyArrayQueue;

/**
 * 判断二叉树是否是完全二叉树.
 */
public class CheckCompletion {

    public boolean chk(MyTreeNode root) {
        //①创建一个队列
        MyArrayQueue<MyTreeNode> queue = new MyArrayQueue<>(26);
        //②将根结点放入队列
        MyTreeNode temp = root;
        queue.enqueue(temp);
        //③循环：弹出--压入左右子节点
        boolean flag = true;
        while (!queue.isEmpty()) {
            temp = queue.dequeue();
            MyTreeNode left = temp.getLeft();
            MyTreeNode right = temp.getRight();
            //如果flag==false说明之前的结点只有左结点或者没有子节点，因此之后的结点都不能有子节点
            if ((!flag) && (left != null || right != null)) return false;
            if (left != null && right != null) {
                //左右结点都存在
                queue.enqueue(left);
                queue.enqueue(right);
            } else if (left == null && right != null) {
                //右结点存在，左结点不存在，一定为false
                return false;
            } else if (left != null && right == null) {
                //左结点存在右结点不存在则接着遍历，只是之后的结点都不能有孩子，作一个标记记录
                flag = false;
                //当然存在的子节点还是要放入到队列中
                queue.enqueue(left);
            } else {
                //左右结点都为空，则不需要放入队列，只要做标记，之后的结点都不能有子节点
                flag = false;
            }
        }
        //当队列为空时，说明遍历完成，此时还没有返回说明是完全二叉树
        return true;
    }
}
