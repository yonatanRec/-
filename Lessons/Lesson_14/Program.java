package Lessons.Lesson_14;
import Other.binNode.*;
public class Program {

    public static void main(String[] args) {
        BinNode<Integer> root = new BinNode<>(
                new BinNode<>(
                        new BinNode<>(null, -9, null),
                        -5,
                        new BinNode<>(null, 1, null)
                ),
                8,
                new BinNode<>(
                        new BinNode<>(null, -2, null),
                        3,
                        new BinNode<>(null, -10, null)
                )
        );
        printLeaves(root);
    }

    public static void printEven(BinNode<Integer> tree){
        if(tree == null)
            return;
        if(tree.getValue() % 2 == 0)
            System.out.print(tree.getValue() + ", ");
        printEven(tree.getLeft());
        printEven(tree.getRight());
    }

    public static void printNegative(BinNode<Integer> tree){
        if(tree == null)
            return;
        printNegative(tree.getLeft());
        printNegative(tree.getRight());
        if(tree.getValue() < 0)
            System.out.println(tree.getValue() + ", ");
    }

    public static void printLeft(BinNode<Integer> tree){
        if(tree == null)
            return;
        if(tree.hasLeft()){
            System.out.println(tree.getLeft().getValue() + ", ");
        }
        printLeft(tree.getLeft());
        printLeft(tree.getRight());
    }

    public static <T> void printLeaves(BinNode<T> tree){
        if(tree == null)
            return;
        if (!tree.hasLeft() && !tree.hasRight())
            System.out.println(tree.getValue() + ", ");
        else {
            printLeaves(tree.getLeft());
            printLeaves(tree.getRight());
        }
    }

    public static void printEvenNoOdd(BinNode<Integer> tree){
        if(tree == null)
            return;
        if(tree.getValue() % 2 == 0) {
            if (!((tree.hasLeft()  && tree.getLeft().getValue()  % 2 != 0) ||
                    (tree.hasRight() && tree.getRight().getValue() % 2 != 0))) {
                System.out.println(tree.getValue() + ", ");
            }

        }
        printEvenNoOdd(tree.getLeft());
        printEvenNoOdd(tree.getRight());
    }

    public static int countBetween(BinNode<Integer> tree, int n1, int n2){
        if(tree == null)
            return 0;
        if(tree.getValue() >= n1 && tree.getValue() <= n2)
            return 1 + countBetween(tree.getLeft(), n1, n2);
        return countBetween(tree.getRight(), n2, n1);
    }

    public static <T> int count(BinNode<T> tree){
        if(tree == null)
            return 0;
        return 1 +  count(tree.getLeft()) + count(tree.getRight());
    }

    public static int countMultiples(BinNode<Integer> tree, int num){
        if(tree == null)
            return 0;
        if(tree.getValue() % num == 0)
            return 1 + countMultiples(tree.getLeft(), num) +  countMultiples(tree.getRight(), num);
        return countMultiples(tree.getLeft(), num) + countMultiples(tree.getRight(), num);
    }


}