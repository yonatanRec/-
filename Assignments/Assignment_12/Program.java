package Assignments.Assignment_12;
import Other.binNode.*;


public class Program {

    public static void main(String[] args) {
        BinNode<Integer> root = new BinNode<>(
                new BinNode<>(null, 7, null),
                15,
                new BinNode<>(
                        null,
                        20,
                        new BinNode<>(
                                new BinNode<>(
                                        new BinNode<>(null, 25, null),
                                        28,
                                        null
                                ),
                                35,
                                new BinNode<>(
                                        null,
                                        40,
                                        new BinNode<>(
                                                null,
                                                42,
                                                new BinNode<>(null, 45, null)
                                        )
                                )
                        )
                )
        );
        System.out.println(Q24.countSingleChildrenWithSingleChildren(root));
    }

    //Page 203 Q8
    public static class Q8{
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
    }


    //Page 204 Q10
    public static class Q10{
        public static <T> void printLTR(BinNode<T> tree){
            if(tree == null)
                return;
            if (!tree.hasLeft() && !tree.hasRight())
                System.out.println(tree.getValue() + ", ");
            else {
                printLTR(tree.getLeft());
                printLTR(tree.getRight());
            }
        }
    }


    //Page 204 Q11
    public static class Q11{
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
    }


    //Page 204 Q12
    public static class Q12{
        public static int countBetween(BinNode<Integer> tree, int n1, int n2){
            if(tree == null)
                return 0;
            if(tree.getValue() >= n1 && tree.getValue() <= n2)
                return 1 + countBetween(tree.getLeft(), n1, n2);
            return countBetween(tree.getRight(), n2, n1);
        }
    }


    //Page 204 Q15
    public static class Q15{
        public static int countMultiples(BinNode<Integer> tree, int num){
            if(tree == null)
                return 0;
            int shorten = countMultiples(tree.getLeft(), num) +  countMultiples(tree.getRight(), num);
            if(tree.getValue() % num == 0)
                return 1 + shorten;
            return shorten;
        }
    }


    //Page 204 Q16
    public static class Q16{
        public static int sumParents(BinNode<Integer> tree){
            if(tree == null)
                return 0;
            if(tree.hasLeft() && tree.hasRight())
                return tree.getValue() + sumParents(tree.getLeft()) + sumParents(tree.getRight());
            return sumParents(tree.getLeft()) + sumParents(tree.getRight());
        }
    }


    //Page 204 Q17
    public static class Q17{
        public static int countBranches(BinNode<Integer> tree){
            if(tree == null)
                return 0;
            if(!tree.hasLeft() && !tree.hasRight())
                return 0;
            return 1 + countBranches(tree.getLeft()) + countBranches(tree.getRight());
        }
    }


    //Page 205 Q20
    public static class Q20{
        public static int sum(BinNode<Integer> tree){
            if(tree == null)
                return 0;
            return tree.getValue() + sum(tree.getLeft()) + sum(tree.getRight());
        }
    }


    //Page 205 Q22
    public static class Q22{
        public static boolean balancedChildren(BinNode<Integer> tree){
            if(tree == null)
                return true;
            if((tree.hasLeft() && !tree.hasRight()) || (tree.hasRight() && !tree.hasLeft()))
                return false;
            return balancedChildren(tree.getLeft()) && balancedChildren(tree.getRight());
        }
    }


    //Page 205 Q23
    public static class Q23{
        public static double max(BinNode<Double> tree){
             if(tree == null)
                return Integer.MIN_VALUE;
             return Math.max(tree.getValue(),
                     Math.max(max(tree.getLeft()),
                             max(tree.getRight())));
        }

        public static double min(BinNode<Double> tree){
            if(tree == null)
                return Integer.MAX_VALUE;
            return Math.min(tree.getValue(),
                    Math.min(min(tree.getLeft()),
                            min(tree.getRight())));
        }
    }


    //Page 205 Q24
    public static class Q24{
        public static <T> boolean onlyOneChild(BinNode<T> tree){
            if(tree == null)
                return false;
            return (tree.hasLeft() && !tree.hasRight()) || (tree.hasRight() && !tree.hasLeft());
        }

        public static <T> int countSingleChildren(BinNode<T> tree){
            if(tree == null)
                return 0;
            if(onlyOneChild(tree))
                return 1 + countSingleChildren(tree.getLeft()) + countSingleChildren(tree.getRight());
            return countSingleChildren(tree.getLeft()) + countSingleChildren(tree.getRight());
        }

        public static <T> int countSingleChildrenWithSingleChildren(BinNode<T> tree){
            if(tree == null)
                return 0;
            if(onlyOneChild(tree))
                if(onlyOneChild(tree.getLeft()) || onlyOneChild(tree.getRight()))
                    return 1 + countSingleChildrenWithSingleChildren(tree.getLeft()) + countSingleChildrenWithSingleChildren(tree.getRight());
            return countSingleChildrenWithSingleChildren(tree.getLeft()) + countSingleChildrenWithSingleChildren(tree.getRight());
        }
    }
}
