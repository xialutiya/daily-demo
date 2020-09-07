package xilalu.tree;

import org.springframework.util.Assert;

/**
 * 二叉搜索树.
 */
public class MyBinarySearchTree {

    /**
     * 添加节点.
     */
    public void insert(MyBinaryNode root, int data) {
        if (root == null) {
            return;
        } else {
            if (root.getData() < data) {
                if (root.getRight() != null) {
                    insert(root.getRight(), data);
                } else {
                    MyBinaryNode cur = new MyBinaryNode(data);
                    cur.setParent(root);
                    root.setRight(cur);
                }
            } else {
                if (root.getLeft() != null) {
                    insert(root.getLeft(), data);
                } else {
                    MyBinaryNode cur = new MyBinaryNode(data);
                    cur.setParent(root);
                    root.setLeft(cur);
                }
            }
        }
    }

    /**
     * 搜索节点.
     *
     * @param node
     * @param data
     * @return
     */
    public MyBinaryNode search(MyBinaryNode node, int data) {
        if (node == null) {
            return null;
        }
//        if (node.getData() < data) {
//            if (node.getRight() != null) {
//                return search(node.getRight(), data);
//            } else {
//                return null;
//            }
//        } else if (node.getData() > data) {
//            if (node.getLeft() != null) {
//                return search(node.getLeft(), data);
//            } else {
//                return null;
//            }
//        } else {
//            return node;
//        }
        MyBinaryNode next = node;
        while (next != null) {
            if (next.getData() < data) {
                next = next.getRight();
            } else if (next.getData() > data) {
                next = next.getLeft();
            } else {
                return next;
            }
        }
        return null;
    }

    /**
     * 获取树的高度.
     *
     * @param node
     * @return
     */
    public int getCount(MyBinaryNode node) {
        return node == null ? 0 : (1 + Math.max(getCount(node.getLeft()), getCount(node.getRight())));
    }

    /**
     * 获取后继节点.
     *
     * @param node
     * @return
     */
    public MyBinaryNode getAfterNode(MyBinaryNode node, MyBinaryNode parent) {
        if (node == null) {
            Assert.isTrue(false, "不能传入空节点.");
        }
        if (node.getLeft() == null) {
            return parent;
        } else {
            return getAfterNode(node.getLeft(), node);
        }
    }

    /**
     * 移除节点.
     *
     * @param node
     * @param data
     */
    public void remove(MyBinaryNode node, int data) {
        Assert.isTrue(node != null, "传入节点不能为空.");
        MyBinaryNode cur = search(node, data);
        Assert.isTrue(cur == null, "要删除的节点不存在.");
        if (cur.getLeft() == null && cur.getRight() == null) {
            MyBinaryNode parent = cur.getParent();
            if (parent == null) {
                cur = null;
            } else {
                cur.setParent(null);
                if (parent.getData() < cur.getData()) {
                    parent.setRight(null);
                } else {
                    parent.setLeft(null);
                }
            }
        } else if (cur.getLeft() == null && cur.getRight() != null) {
            MyBinaryNode parent = cur.getParent();
            if (parent == null) {
                cur.getRight().setParent(null);
                cur.setRight(null);
            } else {
                if (parent.getData() < cur.getData()) {
                    parent.setRight(cur.getRight());
                } else {
                    parent.setLeft(cur.getRight());
                }
                cur.getRight().setParent(parent);
            }
        } else if (cur.getLeft() != null && cur.getRight() == null) {
            MyBinaryNode parent = cur.getParent();
            if (parent == null) {
                cur.getLeft().setParent(null);
                cur.setLeft(null);
            } else {
                if (parent.getData() < cur.getData()) {
                    parent.setRight(cur.getLeft());
                } else {
                    parent.setLeft(cur.getLeft());
                }
                cur.getLeft().setParent(parent);
            }
        } else {
            MyBinaryNode parent = cur.getParent();
            if (parent == null) {
                cur.getRight().setLeft(cur.getLeft());
                cur.getLeft().setParent(cur.getRight());
                cur.getRight().setParent(null);
            } else {
                // 获取后继节点.
                MyBinaryNode afterNode = getAfterNode(cur, cur.getParent());
                if (afterNode.getRight() == null) {
                    parent.setRight(afterNode);
                } else {
                    parent.setLeft(afterNode);
                }
                MyBinaryNode afterParent = afterNode.getParent();
                if (afterParent.getData() < afterNode.getData()) {
                    afterParent.setRight(null);
                } else {
                    afterParent.setLeft(null);
                }
            }
        }
    }
}
