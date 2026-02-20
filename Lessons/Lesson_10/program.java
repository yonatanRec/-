package Lessons.Lesson_10;
import Other.Helper;
import Other.node.*;
import Other.Helper.Nodes.*;



public class program {
    public static void main(String[] args) {
        Integer[] arr = {3,3,5,3,9,5,3};
        Node<Integer> node = new Node<>(arr);
        Helper.Nodes.printList(node);
        removeDuplicates(node);
        Helper.Nodes.printList(node);
    }

    /*
    טענת כניסה: הפעולה מקבלת שרשרת חוליות של מספרים שלמים ממוינת בסדר עולה, ומספר שלם x
    טענת יציאה: הפעולה תוסיף חוליה חדשה עם הערך x, למקום המתאים
     */
    public static void insert(Node<Integer> sorted, int x) {
        // Handle head insertion
        if (x < sorted.getValue()) {
            Node<Integer> newNode = new Node<>(sorted.getValue(), sorted.getNext());
            sorted.setValue(x);
            sorted.setNext(newNode);
            return;
        }

        Node<Integer> pos = sorted;
        while (pos.hasNext()) {
            if (pos.getNext().getValue() > x) { // insert before first bigger value
                pos.setNext(new Node<>(x, pos.getNext()));
                return;
            }
            pos = pos.getNext();
        }

        // Insert at the end if x is the largest
        pos.setNext(new Node<>(x, null));
    }


    /*
    מקבלת מצביע לתחילת שרשרת חוליות של מספרים שלמים חיוביים
    הפעולה תוסיף חוליה עם הערך (1-) לאחר כל חוליה בעלת ערך זוגי
     */

    public static void insertAfterEven(Node<Integer> node){
        Node<Integer> pos = node;
        while (pos != null) {
            if (pos.getValue() % 2 == 0) {
                pos.setNext(new Node<>(-1, pos.getNext()));
            }
            pos = pos.getNext();
        }
    }


    /*
    הפעולה מקבלת שרשרת חוליות ממוינות בסדר עולה ללא חזרוצ, ומספר (קיים בשרשרת)
    הפעולה תסיר את החוליה בעלת הערך x מהשרשרת
     */

    public static void removeFirst(Node<Integer> list, int x){
        Node<Integer> pos = list;
        if(pos.getValue() == x){
            if(pos.hasNext()) {
                list.setValue(list.getNext().getValue());
                list.setNext(list.getNext().getNext());
            }
            else
                list.setValue(null);
            return;
        }

        while (pos.hasNext() && pos.getValue() < x) {
            if(pos.getNext().getValue() == x){
                pos.setNext(pos.getNext().getNext());
                return;
            }
            pos = pos.getNext();
        }
    }

    /*
    פעולה המקבלת שרשרת חוליות של מספרים שלמים, ומספר שלם
    הפעולה תמחק את *כל* המופעים של המספר מהשרשרת (כולל רצפים)
     */
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



    /*
    מקבלת שרשרת חולית של מספרים שלמים ומוחקת ממנו את כל הכפילויות
     */

    public static void removeDuplicates(Node<Integer> list){
        Node<Integer> pos = list;
        while (pos.hasNext()) {
            removeAll(pos.getNext(), pos.getValue());
            pos = pos.getNext();
        }
    }
}
