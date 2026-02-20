package Lessons.Lesson_9;
import Other.node.Node;
import java.util.Scanner;
public class Nodes {
    public static Scanner reader = new Scanner(System.in);
    public static void main(String[] args){
        Node<Integer> node = createChain(6);
        System.out.println(isSorted(node));
    }

    public static void printList(Node<Integer> ch){

        Node<Integer> pos = ch;

        while(pos != null){
            System.out.print(pos.getValue() + (pos.hasNext() ? " → " : ""));
            pos = pos.getNext();
        }

        System.out.println();
    }

    public static void printSumEven(Node<Integer> ch){
        Node<Integer> pos = ch;
        int total = 0;
        while(pos != null){
            if(pos.getValue() % 2 == 0)
                total += pos.getValue();
            pos = pos.getNext();
        }
        System.out.println(total);
    }

    public static void printOddPlaces(Node<Integer> ch){
        Node<Integer> pos = ch;
        int place = 0;
        while(pos != null){
            if (place % 2 == 1)
                System.out.print(pos + (pos.hasNext() ? pos.getNext().hasNext() ? " → " : "" : ""));
            pos = pos.getNext();
            place++;
        }
    }

    public static Node<Integer> createChain(int n){
        Node<Integer> node = new Node<>(reader.nextInt());
        Node<Integer> pos = node;
        for (int i = 1; i < n; i++) {
            pos.setNext(new Node<>(reader.nextInt()));
            pos = pos.getNext();
        }
        return node;
    }

    public static void merge(Node<Integer> node1, Node<Integer> node2){
        Node<Integer> pos = node1;
        while(pos.hasNext())
            pos = pos.getNext();
        pos.setNext(node2);
    }


    public static int rowAppears(Node<Integer> node, int n){
        int count = 0;
        Node<Integer> pos = node;
        if(pos != null && pos.getValue() == n)
            count++;
        while(pos != null && pos.hasNext()){
            if(pos.getValue() != n && pos.getNext().getValue() == n)
                count++;
            pos = pos.getNext();
        }
        return count;
    }

    public static boolean isSorted(Node<Integer> node){
        Node<Integer> pos = node;
        while(pos.hasNext()){
            if(pos.getValue() > pos.getNext().getValue())
                return false;
            pos = pos.getNext();
        }
        return true;
    }
}
