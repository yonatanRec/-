package Lessons.Lesson_13;
import Other.node.*;
import Other.Helper;
public class Program {
    public static void main(String[] args) {
        Integer[] arr = {1,7,3,10,2,5,8,1};
        Node<Integer> lst1 = new Node<>(arr);
        Pair[] arr2 = {new Pair(1,2), new Pair(7,10), new Pair(6,5)};
        Node<Pair> lst2 = new Node<>(arr2);
        lst1 = removeListPairs(lst1,lst2);
        System.out.println(lst1.fullString());
    }

    public static Node<Integer> remove(Node<Integer> head, int n) {
        while (head != null && head.getValue() == n) {
            head = head.getNext();
        }

        Node<Integer> current = head;
        while (current != null && current.hasNext()) {
            if (current.getNext().getValue() == n) {
                current.setNext(current.getNext().getNext());
                return head;
            } else
                current = current.getNext();
        }

        return head;
    }

    public static Node<Integer> removeListPairs(Node<Integer> lst1, Node<Pair> lst2) {
        Node<Pair> p2 = lst2;

        while (p2 != null) {
            int x = p2.getValue().getX();
            int y = p2.getValue().getY();

            Node<Integer> prev = null;
            Node<Integer> curr = lst1;

            // find X
            while (curr != null && curr.getValue() != x) {
                prev = curr;
                curr = curr.getNext();
            }

            // X found
            if (curr != null) {
                Node<Integer> afterX = curr.getNext();

                // remove X
                if (prev == null) {
                    lst1 = curr.getNext(); // X was head
                } else {
                    prev.setNext(curr.getNext());
                }

                // now remove the NEXT Y after X
                Node<Integer> prevY = null;
                Node<Integer> currY = afterX;

                while (currY != null && currY.getValue() != y) {
                    prevY = currY;
                    currY = currY.getNext();
                }

                if (currY != null) { // Y found
                    if (prevY == null) {
                        // Y was immediately after X
                        if (prev == null) {
                            lst1 = currY.getNext();
                        } else {
                            prev.setNext(currY.getNext());
                        }
                    } else {
                        prevY.setNext(currY.getNext());
                    }
                }
            }

            p2 = p2.getNext();
        }
        return lst1;
    }

    public static void stalinSort(Node<Integer> lst) {
        if (lst == null) return;
        Node<Integer> lastKept = lst;
        int prev = lst.getValue();
        while (lastKept.getNext() != null) {
            if (lastKept.getNext().getValue() < prev) {
                lastKept.setNext(lastKept.getNext().getNext());
            } else {
                lastKept = lastKept.getNext();
                prev = lastKept.getValue();
            }
        }
    }

}

class Pair{
    private int x;
    private int y;

    public Pair(int y, int x) {
        this.y = y;
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    @Override
    public String toString() {
        return x + "," + y;
    }
}