package Lessons.Lesson_19;
import Other.node.*;
public class Q3 {

    public static void main(String[] args) {
        Integer[] arr = {2,5,3,7,2,5,3,7,2,5,3,7};
        Node<Integer> node = new Node<>(arr);
        System.out.println(triple(node));
    }

    public static boolean triple(Node<Integer> node) {
        if (node == null)
            return false;
        int count = 0;
        Node<Integer> temp = node;
        while (temp != null) {
            count++;
            temp = temp.getNext();
        }
        int size = count / 3;
        Node<Integer> second = node;
        for (int i = 0; i < size; i++)
            second = second.getNext();
        Node<Integer> third = second;
        for (int i = 0; i < size; i++)
            third = third.getNext();
        Node<Integer> first = node;
        for (int i = 0; i < size; i++) {
            if (!first.getValue().equals(second.getValue()) ||
                    !first.getValue().equals(third.getValue())) {
                return false;
            }
            first = first.getNext();
            second = second.getNext();
            third = third.getNext();
        }
        return true;
    }

}
