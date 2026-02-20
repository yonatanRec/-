package Assignments.Assigment_11;
import Other.node.Node;
import Other.node.DoubleNode;
import java.util.Scanner;
public class Program {
    static Scanner reader = new Scanner(System.in);

    //Q48 Page 115
    public static class Q48{

        static class Domino{
            private int num1;
            private int num2;

            public int getNum1() {
                return num1;
            }

            public void setNum1(int num1) {
                this.num1 = num1;
            }

            public int getNum2() {
                return num2;
            }

            public void setNum2(int num2) {
                this.num2 = num2;
            }

            public Domino(int num1, int num2) {
                this.num1 = num1;
                this.num2 = num2;
            }

            public boolean isExist(int num){
                return num == this.num1 || num == this.num2;
            }
        }

        public static int countConnectable(Node<Domino> lst, Domino domino){
            int count = 0;
            while(lst!=null){
                if(lst.getValue().isExist(domino.getNum1()) || lst.getValue().isExist(domino.getNum2()))
                    count++;
                lst = lst.getNext();
            }
            return count;
        }
    }

    //Q49 Page 115
    public static class Q49{
        public static Node<Character> fromCharIntToNode(Node<CharInt> lst){
            Node<Character> dummy = new Node<>('b');
            Node<Character> pos = dummy;
            while(lst!=null){
                char ch = lst.getValue().getTav();
                for (int i = 0; i < lst.getValue().getNum(); i++) {
                    pos.setNext(new Node<>(ch));
                    pos = pos.getNext();
                }
                lst = lst.getNext();
            }
            return dummy.getNext();
        }

        static class CharInt {
            private int num;
            private char tav;

            public int getNum() {
                return num;
            }

            public void setNum(int num) {
                this.num = num;
            }

            public char getTav() {
                return tav;
            }

            public void setTav(char tav) {
                this.tav = tav;
            }

            public CharInt(int num, char tav) {
                this.num = num;
                this.tav = tav;
            }
        }
    }

    //Q51 Page 116
    public static class Q51{


        static class Birthday{
            private String name;
            private int day;
            private int month;

            public Birthday(String name, int day, int month) {
                this.name = name;
                this.day = day;
                this.month = month;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public int getDay() {
                return day;
            }

            public void setDay(int day) {
                this.day = day;
            }

            public int getMonth() {
                return month;
            }

            public void setMonth(int month) {
                this.month = month;
            }
        }

        static class AllBirthday{
            private Node<Birthday> birthdays;

            public AllBirthday() {
                this.birthdays = new Node<>(null);
            }

            public void addBirthday(String name, int day, int month) {
                this.birthdays = new Node<>(new Birthday(name,day,month),this.birthdays);
            }

            public void removeBirthday(String name, int day, int month) {
                if(birthdays.getValue().getName().equals(name) && birthdays.getValue().getDay() == day && birthdays.getValue().getMonth() == month){
                    birthdays = birthdays.getNext();
                }
                Node<Birthday> pos = this.birthdays;
                while(pos.hasNext()){
                    if(pos.getNext().getValue().getName().equals(name) && pos.getNext().getValue().getDay() == day && pos.getNext().getValue().getMonth() == month){
                        pos.setNext(pos.getNext().getNext());
                    }
                }
            }

            public int maxBirthdaysInMonth() {
                int[] months = new int[12];
                Node<Birthday> pos = birthdays;
                while (pos != null) {
                    Birthday b = pos.getValue();
                    if (b != null) {
                        months[b.getMonth() - 1]++;
                    }
                    pos = pos.getNext();
                }
                int max = 0;
                for (int month : months) {
                    if (month > max)
                        max = month;
                }
                return max;
            }

            public static void main2(String[] args) {
                AllBirthday all = new AllBirthday();

                System.out.print("הכנס מספר תלמידים: ");
                int n = reader.nextInt();
                reader.nextLine(); // ניקוי שורה

                for (int i = 0; i < n; i++) {
                    System.out.println("תלמיד מספר " + (i + 1));

                    System.out.print("שם: ");
                    String name = reader.nextLine();

                    System.out.print("חודש לידה (1-12): ");
                    int month = reader.nextInt();

                    System.out.print("יום בחודש: ");
                    int day = reader.nextInt();
                    reader.nextLine(); // ניקוי שורה

                    all.addBirthday(name, day, month);
                }

                // מציאת המקסימום
                int max = all.maxBirthdaysInMonth();

                System.out.println("החודש/ים עם מספר ימי ההולדת הגדול ביותר (" + max + "):");

                // ספירה מחדש לפי חודשים כדי להציג מי הם
                int[] months = new int[12];
                Node<Birthday> pos = all.birthdays;

                while (pos != null) {
                    if (pos.getValue() != null) {
                        months[pos.getValue().getMonth() - 1]++;
                    }
                    pos = pos.getNext();
                }

                for (int i = 0; i < 12; i++) {
                    if (months[i] == max) {
                        System.out.println("חודש " + (i + 1));
                    }
                }
            }
        }
    }

    //Q56 Page 119
    public static class Q56{
        static class Student{
            private String name;
            private String id;
            private int year;
            private Node<Course> courses;

            public String getName() {
                return name;
            }

            public String getId() {
                return id;
            }

            public int getYear() {
                return year;
            }

            public Node<Course> getCourses() {
                return courses;
            }
        }

        static class Course{
            private String code;
            private int grade;

            public Course(int grade) {
                this.grade = grade;
            }

            public String getCode() {
                return code;
            }

            public void setCode(String code) {
                this.code = code;
            }

            public int getGrade() {
                return grade;
            }

            public void setGrade(int grade) {
                this.grade = grade;
            }
        }

        public static void printAvg(Node<Student> students){
            while(students != null){
                int total = 0;
                int count = 0;
                Node<Course> pos = students.getValue().getCourses();
                while (pos != null){
                    total += pos.getValue().getGrade();
                    count++;
                    pos = pos.getNext();
                }
                System.out.println("average grade for " + students.getValue().getName() + ": " + (double)total / count);
                students = students.getNext();
            }
        }

        public static int bestCourseAvg(Node<Student> students) {
            int[] sums = new int[10];
            int[] counts = new int[10];
            Node<Student> posStudent = students;
            while (posStudent != null) {
                Node<Course> posCourse = posStudent.getValue().getCourses();
                while (posCourse != null) {
                    int code = Integer.parseInt(posCourse.getValue().getCode());
                    int grade = posCourse.getValue().getGrade();

                    sums[code-1] += grade;
                    counts[code-1]++;
                    posCourse = posCourse.getNext();
                }
                posStudent = posStudent.getNext();
            }
            int bestCode = -1;
            double maxAvg = -1;
            for (int i = 1; i <= 10; i++) {
                if (counts[i-1] > 0) {
                    double avg = (double) sums[i-1] / counts[i-1];
                    if (avg > maxAvg) {
                        maxAvg = avg;
                        bestCode = i-1;
                    }
                }
            }
            return bestCode;
        }
    }

    //Q60 Page 129
    public static class Q60{
        public static <T> boolean isPalindrome(Node<T> node) { // סיבוכיות זמן ריצה: O(n)
            if (node == null || !node.hasNext())
                return true;
            DoubleNode<T> head = null;
            DoubleNode<T> tail = null;
            Node<T> pos = node;
            while (pos != null) {
                DoubleNode<T> newNode = new DoubleNode<>(pos.getValue());

                if (head == null) {
                    head = newNode;
                } else {
                    tail.setRight(newNode);
                    newNode.setLeft(tail);
                }
                tail = newNode;

                pos = pos.getNext();
            }
            DoubleNode<T> left = head;
            DoubleNode<T> right = tail;
            while (left != right && left.getLeft() != right) {
                if (!left.getValue().equals(right.getValue()))
                    return false;
                left = left.getRight();
                right = right.getLeft();
            }
            return true;
        }
    }

    //Q61 Page 129
    public static class Q61{
        public static <T> Node<T> getMiddle(Node<T> head) {// סיבוכיות זמן ריצה: O(n) n = כמות האיברים שהפעולה מקבלת קקלט
            Node<T> one = head;
            Node<T> two = head;
            while (one.getNext() != null && one.getNext().getNext() != null) {
                two = two.getNext();
                one = one.getNext().getNext();
            }
            return two;
        }

        public static <T> DoubleNode<T> getMiddle(DoubleNode<T> head) {
            DoubleNode<T> one = head;
            DoubleNode<T> two = head;
            while (one.getRight() != null && one.getRight().getLeft() != null) {
                two = two.getRight();
                one = one.getRight().getRight();
            }
            return two;
        }

    }

    //Q63 Page 129
    public static class Q63{
        public static DoubleNode<Integer> createReverse() {
            DoubleNode<Integer> head = null;
            int input = reader.nextInt();
            while (input != -999) {
                DoubleNode<Integer> newNode = new DoubleNode<>(input);
                newNode.setRight(head);
                if (head != null)
                    head.setLeft(newNode);
                head = newNode;
                input = reader.nextInt();
            }
            return head;
        }
    }

    //Q64 Page 129
    public static class Q64{
        public static void putInMiddle(DoubleNode<Integer> lst1, DoubleNode<Integer> lst2) {
            DoubleNode<Integer> last = lst2;
            while(last.hasRight()) {
                last =  last.getRight();
            }
            DoubleNode<Integer> middle = Q61.getMiddle(lst1.getRight()).getLeft();
            lst2.setLeft(middle);
            last.setRight(middle.getRight());
            middle.getRight().setLeft(last);
            middle.setRight(lst2);
        }
    }
}