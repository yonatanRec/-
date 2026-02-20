package Other.binNode;


import Other.Helper;

public class BinNode <T> {

    private BinNode<T> left;
    private T value;
    private BinNode<T> right;



    public BinNode(BinNode<T> left, T value, BinNode<T> right) {

        this.left = left;
        this.value = value;
        this.right = right;
    }



    public BinNode(T value) {

        this.value = value;
        this.right = null;
        this.left = null;

    }



    public BinNode<T> getLeft() {

        return left;
    }



    public void setLeft(BinNode<T> left) {

        this.left = left;
    }



    public T getValue() {

        return value;
    }



    public void setValue(T value) {

        this.value = value;
    }



    public BinNode<T> getRight() {

        return right;
    }



    public void setRight(BinNode<T> right) {

        this.right = right;
    }

    public boolean hasLeft() {

        return left!=null;
    }

    public boolean hasRight() {

        return right!=null;
    }

    @Override
    public String toString() {
        return "" + this.value;
    }



}