package xilalu.tree;

public class MyBinaryNode {

        private int data;
        private MyBinaryNode left;
        private MyBinaryNode right;
        private MyBinaryNode parent;

        public MyBinaryNode(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
            this.parent = null;
        }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public MyBinaryNode getLeft() {
        return left;
    }

    public void setLeft(MyBinaryNode left) {
        this.left = left;
    }

    public MyBinaryNode getRight() {
        return right;
    }

    public void setRight(MyBinaryNode right) {
        this.right = right;
    }

    public MyBinaryNode getParent() {
        return parent;
    }

    public void setParent(MyBinaryNode parent) {
        this.parent = parent;
    }
}
