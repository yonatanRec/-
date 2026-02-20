package Assignments.Assignment_10;
import Other.node.*;
import Other.Helper.*;
import java.util.Scanner;
public class Program {

    public static void main(String[] args){
        Integer[] arr = {1,2,3,4,5,6,7};
        Node<Integer> lst = new Node<>(arr);
        Node<Integer> p = lst.Helper.get(2);
        Node<Integer> q = lst.Helper.get(5);
        System.out.println(Q45.sum(lst,p,q));
    }

    //Q27 Page 109
    public static class Q27{
        public static boolean isPalindrome(Node<Integer> lst, int n){
            Node<Integer> pos = lst;
            int[] arr = new int[n];
            while(pos != null){
                Node<Integer> temp = pos;
                for (int i = 0; i < n; i++) {
                    if(temp == null) {
                        return false;
                    }
                    arr[i] = temp.getValue();
                    temp = temp.getNext();
                }
                if(isPalindrome(arr))
                    return true;

                pos = pos.getNext();
            }
            return false;
        }
        public static boolean isPalindrome(int[] arr){
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] != arr[arr.length - i - 1]) return false;
            }
            return true;
        }

        public static int longestPalindrome(Node<Integer> lst) {
            int n = Nodes.size(lst);
            for (int len = n; len >= 1; len--) {
                if (isPalindrome(lst, len)) {
                    return len;
                }
            }
            return 1;
        }
    }

    //Q28 Page 109
    public static class Q28{
        public static int what(Node<Integer> lst){
            Node<Integer> p = lst;
            int num = 2;
            while (p != null) {
                num = 3-num;
                p = p.getNext();
            }
            return num;
        }

        public static void answer(){
            /*
            סעיף א
            1
            1 → 5

            סעיף ב
            הפעולה מחזירה 2 אם אורך השרשרת חוליות זוגי ו1 אם אורך שרשרת חוליות אי זוגי
            */
        }
    }

    //Q29 Page 110
    public static class Q29{
        public static void update(Node<Integer> lst){
            Node<Integer> p = lst;
            Node<Integer> r = p.getNext();
            while (r != null) {
                assert p != null;
                if (p.getValue() > r.getValue())
                    r.setValue(p.getValue());
                else
                    p.setValue(r.getValue());
                p =  p.getNext().getNext();
                if (p != null) //*
                    r = p.getNext();
            }
        }
    }

    //Q30 Page 110
    public static class Q30{
        public static Node<Integer> intersection(Node<Integer> a, Node<Integer> b) {
            Node<Integer> result = null;
            Node<Integer> tail = null;
            Node<Integer> pos = a;
            while (pos != null) {
                int val = pos.getValue();
                if (Nodes.isExist(b, val)) {
                    Node<Integer> newNode = new Node<>(val);
                    if (result == null) {
                        result = tail = newNode;
                    } else {
                        tail.setNext(newNode);
                        tail = newNode;
                    }
                }
                pos = pos.getNext();
            }
            if (result != null)
                Nodes.noDuplicates(result);
            return result;
        }
    }

    //Q31 Page 110
    public static class Q31{
        public static int bigger(Node<Integer> lst1, Node<Integer> lst2){
            int size1 = Nodes.size(lst1), size2 = Nodes.size(lst2);
            if(size1 > size2)
                return 1;
            if(size1 < size2)
                return 2;
            for (int i = 0; i < size1; i++) {
                if(lst1.getValue() > lst2.getValue())
                    return 1;
                if(lst1.getValue() < lst2.getValue())
                    return 2;
                lst1 = lst1.getNext();
                lst2 = lst2.getNext();
            }
            return 0;
        }
    }

    //Q32 Page 111
    public static class Q32{
        public static void removeAppearance(Node<Integer> lst1, Node<Integer> lst2) {
            Node<Integer> dummy = new Node<>(0);
            dummy.setNext(lst1);
            Node<Integer> prev = dummy;
            Node<Integer> curr = lst1;
            while (curr != null) {
                Node<Integer> p1 = curr;
                Node<Integer> p2 = lst2;
                while (p1 != null && p2 != null && p1.getValue().equals(p2.getValue())) {
                    p1 = p1.getNext();
                    p2 = p2.getNext();
                }
                if (p2 == null) {
                    prev.setNext(p1);
                    curr = p1;
                }
                else {
                    prev = curr;
                    curr = curr.getNext();
                }
            }
        }
    }

    //Q34 Page 111
    public static class Q34{
        public static Node<Integer> merge(Node<Integer> lst1, Node<Integer> lst2) {
            Node<Integer> pos1 = lst1;
            Node<Integer> pos2 = lst2;
            Node<Integer> pos;
            Node<Integer> temp;
            if (pos1.getValue() <= pos2.getValue()) {
                pos = new Node<>(pos1.getValue());
                pos1 = pos1.getNext();
            } else {
                pos = new Node<>(pos2.getValue());
                pos2 = pos2.getNext();
            }
            temp = pos;
            while (pos1 != null && pos2 != null) {
                if (pos1.getValue() <= pos2.getValue()) {
                    temp.setNext(new Node<>(pos1.getValue()));
                    pos1 = pos1.getNext();
                } else {
                    temp.setNext(new Node<>(pos2.getValue()));
                    pos2 = pos2.getNext();
                }
                temp = temp.getNext();
            }
            while (pos1 != null) {
                temp.setNext(new Node<>(pos1.getValue()));
                temp = temp.getNext();
                pos1 = pos1.getNext();
            }
            while (pos2 != null) {
                temp.setNext(new Node<>(pos2.getValue()));
                temp = temp.getNext();
                pos2 = pos2.getNext();
            }
            return pos;
        }
    }

    //Q35 Page 111
    public static class Q35{
        public static Scanner reader = new Scanner(System.in);
        public static Node<Integer> buildSortedList() {
            int num = reader.nextInt();
            if (num == -999)
                return null;
            Node<Integer> pos = new Node<>(num);
            Node<Integer> temp;
            num = reader.nextInt();
            while (num != -999) {
                Node<Integer> newNode = new Node<>(num);
                if (num < pos.getValue()) {
                    newNode.setNext(pos);
                    pos = newNode;
                } else {
                    temp = pos;
                    while (temp.getNext() != null && temp.getNext().getValue() < num)
                        temp = temp.getNext();
                    newNode.setNext(temp.getNext());
                    temp.setNext(newNode);
                }
                num = reader.nextInt();
            }
            return pos;
        }
    }

    //Q36 Page 111
    public static class Q36{
        public static Node<Integer> sortList(Node<Integer> lst) {
            Node<Integer> pos = null;
            Node<Integer> temp = lst;
            while (temp != null) {
                Node<Integer> newNode = new Node<>(temp.getValue());
                if (pos == null || newNode.getValue() < pos.getValue()) {
                    newNode.setNext(pos);
                    pos = newNode;
                }
                else {
                    Node<Integer> p = pos;
                    while (p.getNext() != null && p.getNext().getValue() < newNode.getValue()) {
                        p = p.getNext();
                    }
                    newNode.setNext(p.getNext());
                    p.setNext(newNode);
                }
                temp = temp.getNext();
            }
            return pos;
        }
    }

    //Q43 Page 114
    public static class Q43{
        public static int countEven(Node<Integer> lst1, Node<Integer> node) {
            if (lst1 == null)
                return 0;
            if (lst1 != node && node != null)
                return countEven(lst1.getNext(), node);
            if (lst1.getValue() % 2 == 0)
                return 1 + countEven(lst1.getNext(), null);
            return countEven(lst1.getNext(), null);
        }
    }

    //Q44 Page 114
    public static class Q44{
        public static void printEvenPlaces(Node<Integer> lst) {
            if (lst == null)
                return;
            System.out.println(lst.getValue());
            if(lst.hasNext())
                printEvenPlaces(lst.getNext().getNext());
        }
    }

    //Q45 Page 114
    public static class Q45{
        public static int sum(Node<Integer> lst,  Node<Integer> p, Node<Integer> q) {
            if (lst == q)
                return q.getValue();
            if (p == null)
                return lst.getValue() + sum(lst.getNext(), p, q);
            if (lst == p)
                return p.getValue() + sum(lst.getNext(), null, q);
            return sum(lst.getNext(),p,q);
        }
    }
}
