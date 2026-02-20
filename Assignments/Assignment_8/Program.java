package Assignments.Assignment_8;

import Other.node.Node;

import java.util.Scanner;

public class Program {
    public static Scanner reader = new Scanner(System.in);


    public static void main(String[] args) {
        System.out.println(createSeriesChain(5,4).fullString());
    }


    // Q2 Page 89
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


    //Q3 Page 89
    public static boolean isSorted(Node<Integer> node){
        Node<Integer> pos = node;
        while(pos.hasNext()){
            if(pos.getValue() > pos.getNext().getValue())
                return false;
            pos = pos.getNext();
        }
        return true;
    }


    //Q4 Page 90
    public static char moreEvenOrOdd(Node<Integer> node){
        Node<Integer> pos = node;
        int even = 0, odd = 0;
        while(pos != null){
            if(pos.getValue() % 2 == 0)
                even++;
            else
                odd++;
            pos = pos.getNext();
        }
        if(even > odd)
            return 'z';
        if (even < odd)
            return 'e';
        return 's';
    }


    //Q5 Page 90
    public static void PrintLarger(Node<Integer> node){
        Node<Integer> pos = node;
        int prev = pos.getValue();
        while(pos != null){
            if (pos.getValue() > prev)
                System.out.println(pos.getValue());
            prev = pos.getValue();
            pos = pos.getNext();
        }
    }


    //Q6 Page 90
    public static boolean isBalanced(Node<Integer> node){
        Node<Integer> pos = node;
        int total = 0, count = 0;
        while(pos != null) {
            count++;
            total += pos.getValue();
            pos = pos.getNext();
        }
        pos = node;
        double avg = (double) total / count;
        int over = 0, under = 0;
        for(int i = 0; i < count; i++, pos = pos.getNext()){
            if (pos.getValue() > avg)
                over++;
            else
                under++;
        }
        return over == under;
    }


    //Q7 Page 90
    public static void printBetween(Node<Integer> node, int start, int end){
        Node<Integer> pos = node;
        int place = 1;
        while(pos != null){
            if (place > start && place < end)
                System.out.println(pos.getValue());
            place++;
            pos = pos.getNext();
        }
    }


    //Q8 Page 90
    public static Node<Integer> createChain(){
        Node<Integer> node = new Node<>(0);
        int input = reader.nextInt();
        while(input != -999){
            Node<Integer> newNode = new Node<>(input);
            newNode.setNext(node);
            node = newNode;
            input = reader.nextInt();
        }
        return node.getNext();
    }


    //Q9 Page 90
    public static Node<Integer> createRandomChain50() {
        Node<Integer> node = new Node<>(0);
        for (int i = 0; i < 50; i++) {
            boolean inserted = false;
            while (!inserted) {
                int value = randomNum(10, 99);
                boolean found = false;
                Node<Integer> cur = node.getNext();
                while (cur != null && !found) {
                    if (cur.getValue() == value)
                        found = true;
                    cur = cur.getNext();
                }
                if (!found) {
                    Node<Integer> newNode = new Node<>(value);
                    newNode.setNext(node.getNext());
                    node.setNext(newNode);
                    inserted = true;
                }
            }
        }
        return node.getNext();
    }
    //helper function
    public static int randomNum(int min, int max) {
        return (int) (Math.random() * (max - min + 1)) + min;
    }


    //Q10 Page 91
    public static Node<Integer> createSeriesChain(int beginning, int num) {
        Node<Integer> head = new Node<>(beginning);
        Node<Integer> tail = head;
        for (int i = 1; i < num; i++) {
            Node<Integer> newNode = new Node<>(beginning + i);
            tail.setNext(newNode);
            tail = newNode;
        }
        return head;
    }
}