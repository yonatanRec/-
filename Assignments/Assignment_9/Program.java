package Assignments.Assignment_9;


import Other.Helper;
import Other.node.*;
import java.util.Scanner;



public class Program {

    public static void main(String[] args) {
        Integer[] array = {40,39,12,13,14,15,24};
        Node<Integer> node = new Node<>(array);
        Helper.Nodes.printList(node);
        System.out.println(Q23.hasSeries(node,4));
        Helper.Nodes.printList(node);
    }


    public static class Q11 {

        // Q11, Page 91
        public static void removeAll(Node<Integer> head, int x) {
            Node<Integer> dummy = new Node<>(0, head);

            Node<Integer> pos = dummy;
            while (pos.hasNext()) {
                if (pos.getNext().getValue() == x) {
                    pos.setNext(pos.getNext().getNext());
                } else {
                    pos = pos.getNext();
                }
            }
            head.setValue(dummy.getNext().getValue());
            head.setNext(dummy.getNext().getNext());
        }
    }


    public static class Q12 {
        // Q12, Page 91
        public static Node<Integer> noDuplicates(Node<Integer> list) {
            Node<Integer> pos = list;
            while (pos.hasNext()) {
                Q11.removeAll(pos.getNext(), pos.getValue());
                pos = pos.getNext();
            }
            return list;
        }
    }


    public static class Q13 {
        //Q13 Page 91
        public static void removeEndsOrMiddle(Node<Integer> list) {
            int length = 0;
            Node<Integer> pos = list;
            Node<Integer> last = pos;
            while (pos != null) {
                length++;
                if (pos.hasNext())
                    last = pos;
                pos = pos.getNext();
            }

            pos = list;
            if (length % 2 == 0) {
                for (int i = 1; i < length / 2 - 1; i++) {
                    pos = pos.getNext();
                }
                pos.setNext(pos.getNext().getNext().getNext());
            } else {
                last.setNext(null);
                list.setValue(list.getNext().getValue());
                list.setNext(list.getNext().getNext());
            }
        }
    }


    public static class Q14{
        //Q14 Page 91
        public static void removeTogether(Node<Integer> list1, Node<Integer> list2) {
            Node<Integer> pos1 = list1;
            while (pos1 != null && pos1.getNext() != null) {
                Node<Integer> pos2 = list2;
                boolean found = false;
                while (pos2 != null) {
                    if (pos2.getValue().equals(pos1.getValue())) {
                        found = true;
                        break;
                    }
                    pos2 = pos2.getNext();
                }
                if (found) {
                    pos1.setValue(pos1.getNext().getValue());
                    pos1.setNext(pos1.getNext().getNext());
                } else {
                    pos1 = pos1.getNext();
                }
            }
            if (pos1 != null) {
                Node<Integer> pos2 = list2;
                boolean found = false;
                while (pos2 != null) {
                    if (pos2.getValue().equals(pos1.getValue())) {
                        found = true;
                        break;
                    }
                    pos2 = pos2.getNext();
                }
                if (found) {
                    Node<Integer> prev = list1;
                    if (prev != pos1) {
                        while (prev.getNext() != pos1) {
                            prev = prev.getNext();
                        }
                        prev.setNext(null);
                    } else {
                        pos1.setValue(null);
                    }
                }
            }
        }
    }


    public static class Q15{
        static Scanner reader = new Scanner(System.in);
        //Q15 Page 107
        public static void printCount(Node<Character> list, char ch){
            Node<Character> pos = list;
            int count = 0;
            while (pos != null) {
                if (pos.getValue().equals(ch))
                    count++;
                pos = pos.getNext();
            }
            System.out.println(count);
        }


        public static void run(){
            String input = reader.next();
            Node<Character> node = new Node<>(input.charAt(0));
            Node<Character> pos = node;
            for(int i = 1; i < input.length(); i++){
                pos.setNext(new Node<>(input.charAt(i)));
                pos = pos.getNext();
            }
            Helper.Nodes.printList(node);
            for(char ch = 'a'; ch <= 'z'; ch++){
                System.out.print(ch + ": ");
                printCount(node, ch);
                System.out.print((char)(ch-32) + ": ");
                printCount(node, (char)(ch-32));
            }
        }
    }


    public static class Q18{
        //Q18 Page 107
        public static int count(Node<String> names, String surname){
            Node<String> pos = names;
            int count = 0;
            while (pos != null) {
                if (pos.getValue().split(" ")[0].equals(surname))
                    count++;
                pos = pos.getNext();
            }
            return count;
        }
    }


    public static class Q22{
        //Q22 Page 108
        public static Node<Integer> getIndex(Node<Integer> list, int num){
            Node<Integer> pos = list;
            while (pos != null) {
                if(pos.getValue() == num)
                    return pos;
                pos = pos.getNext();
            }
            return null;
        }
    }


    public static class Q23{
        //Q23 Page 108
        public static boolean hasSeries(Node<Integer> lis, int num) {
            int count = 1;
            Node<Integer> prev = lis;
            Node<Integer> pos = lis.getNext();
            while (pos != null) {
                if (pos.getValue() == prev.getValue() + 1) {
                    count++;
                    if (count >= num)
                        return true;
                } else {
                    count = 1;
                }
                prev = pos;
                pos = pos.getNext();
            }
            return false;
        }

    }


    public static class Q25{
        //Q25 Page 109

        public static void evenFrontOddBack(Node<Integer> head) {
            Node<Integer> evenHead = null, evenTail = null;
            Node<Integer> oddHead = null, oddTail = null;
            Node<Integer> current = head;
            while (current != null) {
                Node<Integer> next = current.getNext();
                current.setNext(null);
                if (current.getValue() % 2 == 0) {
                    if (evenHead == null) {
                        evenHead = evenTail = current;
                    } else {
                        evenTail.setNext(current);
                        evenTail = current;
                    }
                } else {
                    if (oddHead == null) {
                        oddHead = oddTail = current;
                    } else {
                        oddTail.setNext(current);
                        oddTail = current;
                    }
                }
                current = next;
            }
            if (evenTail != null) {
                evenTail.setNext(oddHead);
                head.setValue(evenHead.getValue());
                head.setNext(evenHead.getNext());
            } else {
                if (head != null) {
                    head.setValue(oddHead.getValue());
                }
                if (head != null) {
                    head.setNext(oddHead.getNext());
                }
            }
        }

    }

}
