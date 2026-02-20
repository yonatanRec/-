package Lessons.Lesson_19;

import Other.binNode.*;

public class Q2 {

    public static void main(String[] args) {
        BinNode<Integer> root = new BinNode<>(
                new BinNode<>(
                        new BinNode<>(
                                null,
                                3,
                                new BinNode<>(
                                        new BinNode<>(null, 5, null),
                                        8,
                                        null
                                )
                        ),
                        6,
                        new BinNode<>(null, 4, null)
                ),
                1,
                new BinNode<>(
                        new BinNode<>(
                                new BinNode<>(null, 19, null),
                                17,
                                new BinNode<>(null, 17, null)
                        ),
                        2,
                        new BinNode<>(
                                null,
                                11,
                                new BinNode<>(null, 10, null)
                        )
                )
        );

        System.out.println(upPath(root));
    }


    public static boolean upPath(BinNode<Integer> tree){
        if(!tree.hasLeft() && !tree.hasRight())
            return true;
        boolean right = false;
        if(tree.hasRight() && tree.getRight().getValue() > tree.getValue())
            right = upPath(tree.getRight());
        boolean left = false;
        if(tree.hasLeft() && tree.getLeft().getValue() > tree.getValue())
            left = upPath(tree.getLeft());
        return right || left;
    }

}
