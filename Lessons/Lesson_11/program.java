package Lessons.Lesson_11;
import Other.node.*;
import Other.Helper.*;
public class program {

    public static void main(String[] args) {
        Integer[] arr = {1,2,3,2,1};
        Node<Integer> node = new Node<>(arr);
        System.out.println(isPalindrome(node,5));
    }

    public static int countFullSorted(Node<Integer> lst){
        Node<Integer> prev = lst;
        Node<Integer> pos = prev.getNext();

        int count = 0;

        boolean sortedUp = true;
        boolean sortedDown = true;

        while(pos.hasNext()){
            if(pos.getValue() == -999){
                if(sortedUp || sortedDown)
                    count++;
                sortedUp = true;
                sortedDown = true;
                prev = pos;
                pos = prev.getNext();
            }

            else{
            if(pos.getValue().equals(prev.getValue())){
                sortedUp = false;
                sortedDown = false;
            }

            else if (prev.getValue() > pos.getValue()) {
                sortedUp = false;
            }

            else
                sortedDown = false;
            }

            prev = pos;
            pos = prev.getNext();
        }

        if(sortedUp || sortedDown)
            count++;

        return count;
    }

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

    public static Node<Integer> addNodes(Node<Integer> lst1, Node<Integer> lst2) {
        Node<Integer> dummy = new Node<>(0);
        Node<Integer> curr = dummy;
        int carry = 0;

        while (lst1 != null || lst2 != null || carry != 0) {
            int val1;
            if(lst1 != null)
                val1 = lst1.getValue();
            else
                val1 = 0;
            int val2;
            if(lst2 != null)
                val2 = lst2.getValue();
            else
                val2 = 0;

            int sum = val1 + val2 + carry;
            carry = sum / 10;

            curr.setNext(new Node<>(sum % 10));
            curr = curr.getNext();

            if (lst1 != null) lst1 = lst1.getNext();
            if (lst2 != null) lst2 = lst2.getNext();
        }

        return dummy.getNext();
    }
}
