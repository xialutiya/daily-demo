package xilalu.tree;

public class MyTreeNode<T> {
    private Object data;
    private MyTreeNode left;
    private MyTreeNode right;

    public MyTreeNode(Object data, MyTreeNode left, MyTreeNode right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    public T getData() {
        return (T) data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public MyTreeNode getLeft() {
        return left;
    }

    public void setLeft(MyTreeNode left) {
        this.left = left;
    }

    public MyTreeNode getRight() {
        return right;
    }

    public void setRight(MyTreeNode right) {
        this.right = right;
    }
}

