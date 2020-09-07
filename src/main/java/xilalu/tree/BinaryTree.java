package xilalu.tree;

import xilalu.queue.MyArrayQueue;

public class BinaryTree {
    public static void main(String[] args) {
        MyTreeNode D = new MyTreeNode('D', null, null);
        MyTreeNode H = new MyTreeNode('H', null, null);
        MyTreeNode K = new MyTreeNode('K', null, null);
        MyTreeNode C = new MyTreeNode('C', D, null);
        MyTreeNode G = new MyTreeNode('G', H, K);
        MyTreeNode B = new MyTreeNode('B', null, C);
        MyTreeNode F = new MyTreeNode('F', G, null);
        MyTreeNode E = new MyTreeNode('E', null, F);
        MyTreeNode A = new MyTreeNode('A', B, E);
        pre(A);
        System.out.println();
        level(A);
    }

    public static void print(MyTreeNode node) {
        System.out.print(node.getData() + " ");
    }

    /**
     * 前序.
     * @param node
     */
    public static void pre(MyTreeNode node) {
        print(node);
        if (node.getLeft() != null) {
            pre(node.getLeft());
        }
        if (node.getRight() != null) {
            pre(node.getRight());
        }
    }

    /**
     * 后序.
     *
     * @param node
     */
    public static void after(MyTreeNode node) {
        if (node.getLeft() != null) {
            pre(node.getLeft());
        }
        if (node.getRight() != null) {
            pre(node.getRight());
        }
        print(node);
    }

    /**
     * 中序.
     * @param node
     */
    public static void in(MyTreeNode node) {
        if (node.getLeft() != null) {
            pre(node.getLeft());
        }
        print(node);
        if (node.getRight() != null) {
            pre(node.getRight());
        }
    }

    public static void level(MyTreeNode node) {
        MyArrayQueue<MyTreeNode> queue = new MyArrayQueue<>(24);
        queue.enqueue(node);
        while (!queue.isEmpty()) {
            MyTreeNode dequeue = queue.dequeue();
            System.out.print(dequeue.getData() + " ");
            if (dequeue.getLeft() != null) {
                queue.enqueue(dequeue.getLeft());
            }
            if (dequeue.getRight() != null) {
                queue.enqueue(dequeue.getRight());
            }
        }
    }
}
