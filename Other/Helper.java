package Other;


import Other.node.*;
import Other.stack.*;
import Other.queue.*;
import Other.binNode.*;


import java.util.Arrays;
import java.util.Scanner;
import java.math.BigInteger;

public class Helper {

    public static Scanner reader = new Scanner(System.in);

    public static void main(String[] args) {

    }

    public static class StackHelper {
        public static int countValue(Stack<Integer> stack, int value) {
            Stack<Integer> temp = new Stack<>();
            int count = 0;
            while (!stack.isEmpty()) {
                int temp_value = stack.pop();
                if (temp_value == value) {
                    count++;
                }
                temp.push(temp_value);
            }
            return count;
        }

        public static Stack<Integer> sortedStack() {
            Stack<Integer> stack = new Stack<>();
            System.out.println("enter number");
            int num = reader.nextInt();
            while (num != -999) {
                stack.push(num);
                num = reader.nextInt();
            }
            return sortStackDown(stack);
        }

        public static int sumOfStack(Stack<Integer> st) {
            Stack<Integer> tmp = new Stack<>();
            int sum = 0;
            while (!st.isEmpty()) {
                sum += st.top();
                tmp.push(st.pop());
            }
            while (!tmp.isEmpty()) {
                st.push(tmp.pop());
            }


            return sum;
        }

        public static Stack<Integer> sortStackDown(Stack<Integer> st) {
            Stack<Integer> helper = new Stack<>();
            Stack<Integer> copy = new Stack<>();

            while (!st.isEmpty()) {
                helper.push(st.pop());
            }

            while (!helper.isEmpty()) {
                int val = helper.pop();
                st.push(val);
                copy.push(val);
            }

            Stack<Integer> sorted = new Stack<>();
            while (!copy.isEmpty()) {
                int temp = copy.pop();
                while (!sorted.isEmpty() && sorted.top() > temp) {
                    copy.push(sorted.pop());
                }
                sorted.push(temp);
            }

            return sorted;
        }

        public static Stack<Integer> sortStackUp(Stack<Integer> st) {
            Stack<Integer> helper = new Stack<>();
            Stack<Integer> copy = new Stack<>();

            while (!st.isEmpty()) {
                helper.push(st.pop());
            }

            while (!helper.isEmpty()) {
                int val = helper.pop();
                st.push(val);
                copy.push(val);
            }

            Stack<Integer> sorted = new Stack<>();
            while (!copy.isEmpty()) {
                int temp = copy.pop();
                while (!sorted.isEmpty() && sorted.top() < temp) {
                    copy.push(sorted.pop());
                }
                sorted.push(temp);
            }

            return sorted;
        }

        public static boolean isSortedNotDown(Stack<Integer> st) {
            Stack<Integer> temp = new Stack<>();
            boolean sorted = true;
            int prev = st.pop();
            temp.push(prev);
            while (!st.isEmpty()) {
                int curr = st.pop();
                temp.push(curr);
                if (prev < curr)
                    sorted = false;
                prev = curr;
            }
            while (!temp.isEmpty()) {
                st.push(temp.pop());
            }

            return sorted;
        }

        public static void circularMovement(Stack<Integer> st) {
            int first = st.pop();
            Stack<Integer> temp = new Stack<>();
            while (!st.isEmpty()) {
                temp.push(st.pop());
            }
            st.push(first);
            while (!temp.isEmpty()) {
                st.push(temp.pop());
            }
        }

        public static String back(Stack<String> st, String back) {
            int num;
            if (back.equals("Back"))
                num = 1;
            else {
                System.out.println("enter how many back");
                num = reader.nextInt();
            }
            num++;
            String temp = st.top();
            for (int i = 0; i < num; i++) {
                temp = st.pop();
            }
            return temp;
        }

        public static boolean isSimilar(Stack<Integer> st1, Stack<Integer> st2) {
            Stack<Integer> temp1 = sortStackDown(st1);
            Stack<Integer> temp2 = sortStackDown(st2);
            while (!temp1.isEmpty() && !temp2.isEmpty()) {
                int t1 = temp1.pop();
                int t2 = temp2.pop();
                if (t1 != t2) {
                    return false;
                }
            }
            return temp1.isEmpty() && temp2.isEmpty();
        }

        public static int minNum1(Stack<Integer> st) { // With loops
            int min = st.pop();
            while (!st.isEmpty()) {
                min = Math.min(min, st.pop());
            }
            return min;
        }

        public static int minNum2(Stack<Integer> st) { // Recursive
            if (st.isEmpty())
                return Integer.MAX_VALUE;
            return Math.min(st.pop(), minNum2(st));
        }

        public static int longestStreak(Stack<Integer> st) {
            int longestCount = 0;
            int count = 0;
            while (!st.isEmpty()) {
                if (st.pop() == (int) st.top()) {
                    count++;
                    if (count > longestCount)
                        longestCount = count;
                } else
                    count = 0;
            }
            return longestCount;
        }

        public static Stack<Integer> reverse(Stack<Integer> st) {
            Stack<Integer> temp = new Stack<>();
            while (!st.isEmpty()) {
                temp.push(st.pop());
            }
            return temp;
        }

        public static void circle(Stack<Integer> s, int n) {
            Stack<Integer> temp = new Stack<>();
            int x;
            for (int i = 0; i < n; i++) {
                x = s.pop();
                spilledOn(temp, s);
                s.push(x);
                spilledOn(s, temp);
            }

        }

        public static void spilledOn(Stack<Integer> st1, Stack<Integer> st2) {
            while (!st2.isEmpty()) {
                st1.push(st2.pop());
            }
        }
    }

    public static class QueueHelper {

        public static <T> int length(Queue<T> q) {
            int len = length2(q);
            reverse(q);
            return len;
        }

        public static <T> void what(Queue<T> qu, T x) {
            Stack<T> temp = new Stack<>();
            while (!qu.isEmpty()) {
                if (!qu.head().equals(x))
                    temp.push(qu.head());
                qu.remove();
            }
            while (!temp.isEmpty())
                qu.insert(temp.pop());
        }

        private static <T> int length2(Queue<T> q) {
            if (q.isEmpty())
                return 0;
            T x = q.remove();
            int count = 1 + length2(q);
            q.insert(x);
            return count;
        }

        public static <T> void reverse(Queue<T> q) {
            if (q.isEmpty())
                return;
            T x = q.remove();
            reverse(q);
            q.insert(x);
        }
    }

    public static class Nodes {
        public static <T> void printList(Node<T> ch) {

            Node<T> pos = ch;

            while (pos != null) {
                System.out.print(pos.getValue() + (pos.hasNext() ? " → " : ""));
                pos = pos.getNext();
            }

            System.out.println();
        }

        public static <T> boolean isExist(Node<T> lst, T x) {
            Node<T> pos = lst;
            while (pos != null) {
                if (pos.getValue().equals(x)) {
                    return true;
                }
                pos = pos.getNext();
            }
            return false;
        }

        public static <T> Node<T> copyNode(Node<T> lst) {
            return lst.Helper.copy();
        }

        public static <T> int size(Node<T> lst) {
            int s = 0;
            while (lst != null) {
                s++;
                lst = lst.getNext();
            }
            return s;
        }


        public static Node<Integer> getMin(Node<Integer> lst){
            Node<Integer> pos = lst;
            Node<Integer> min = pos;
            while (pos != null) {
                if (pos.getValue() < min.getValue())
                    min = pos;
                pos = pos.getNext();
            }
            return min;
        }

        public static Node<Integer> getMax(Node<Integer> lst){
            Node<Integer> pos = lst;
            Node<Integer> max = pos;
            while (pos != null) {
                if (pos.getValue() > max.getValue())
                    max = pos;
                pos = pos.getNext();
            }
            return max;
        }

        public static void sort(Node<Integer> lst) {
            Node<Integer> temp = lst;
            while (temp != null) {
                Node<Integer> min = getMin(temp);

                int tmp = temp.getValue();
                temp.setValue(min.getValue());
                min.setValue(tmp);
                temp = temp.getNext();
            }
        }


        public static void printSumEven(Node<Integer> ch) {
            Node<Integer> pos = ch;
            int total = 0;
            while (pos != null) {
                if (pos.getValue() % 2 == 0)
                    total += pos.getValue();
                pos = pos.getNext();
            }
            System.out.println(total);
        }

        public static void printOddPlaces(Node<Integer> ch) {
            Node<Integer> pos = ch;
            int place = 0;
            while (pos != null) {
                if (place % 2 == 1)
                    System.out.print(pos + (pos.hasNext() ? pos.getNext().hasNext() ? " → " : "" : ""));
                pos = pos.getNext();
                place++;
            }
        }

        public static Node<Integer> createChain(int n) {
            Node<Integer> node = new Node<>(reader.nextInt());
            Node<Integer> pos = node;
            for (int i = 1; i < n; i++) {
                pos.setNext(new Node<>(reader.nextInt()));
                pos = pos.getNext();
            }
            return node;
        }

        public static void merge(Node<Integer> node1, Node<Integer> node2) {
            Node<Integer> pos = node1;
            while (pos.hasNext())
                pos = pos.getNext();
            pos.setNext(node2);
        }

        public static int rowAppears(Node<Integer> node, int n) {
            int count = 0;
            Node<Integer> pos = node;
            if (pos != null && pos.getValue() == n)
                count++;
            while (pos != null && pos.hasNext()) {
                if (pos.getValue() != n && pos.getNext().getValue() == n)
                    count++;
                pos = pos.getNext();
            }
            return count;
        }

        public static boolean isSorted(Node<Integer> node) {
            Node<Integer> pos = node;
            while (pos.hasNext()) {
                if (pos.getValue() > pos.getNext().getValue())
                    return false;
                pos = pos.getNext();
            }
            return true;
        }

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

        public static void noDuplicates(Node<Integer> list) {
            Node<Integer> pos = list;
            while (pos.hasNext()) {
                removeAll(pos.getNext(), pos.getValue());
                pos = pos.getNext();
            }
        }

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

        public static void printCount(Node<Character> list, char ch) {
            Node<Character> pos = list;
            int count = 0;
            while (pos != null) {
                if (pos.getValue().equals(ch))
                    count++;
                pos = pos.getNext();
            }
            System.out.println(count);
        }

        public static Node<Integer> getIndex(Node<Integer> list, int num) {
            Node<Integer> pos = list;
            while (pos != null) {
                if (pos.getValue() == num)
                    return pos;
                pos = pos.getNext();
            }
            return null;
        }

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

    public static class BinNodeHelper{
        public static <T> boolean isExists(BinNode<T> tree, T value){
            if(tree == null)
                return false;
            if(tree.getValue().equals(value))
                return true;
            return isExists(tree.getLeft(), value) || isExists(tree.getRight(), value);
        }
        public static <T> void printTree(BinNode<T> tree) {
            if (tree == null)
                return;

            System.out.print(tree.getValue() + " "); // current
            printTree(tree.getRight());               // right
            printTree(tree.getLeft());                // left
        }

        public static <T> Queue<T> toQueue(BinNode<T> tree) {
            Queue<BinNode<T>> nodes = new Queue<>();
            Queue<T> result = new Queue<>();

            if (tree == null)
                return result;

            nodes.insert(tree);

            while (!nodes.isEmpty()) {
                BinNode<T> temp = nodes.remove();
                result.insert(temp.getValue());

                if (temp.getLeft() != null)
                    nodes.insert(temp.getLeft());
                if (temp.getRight() != null)
                    nodes.insert(temp.getRight());
            }

            return result;
        }




    }

    public static class MathHelper {

        public static final double PI = Math.PI;
        public static final double TAU = Math.TAU;
        public static final double E = Math.E;


        public static int round(double x) {
            return (int) Math.round(x);
        }


        public static int floor(double x) {
            return (int) Math.floor(x);
        }


        public static int ceil(double x) {
            return (int) Math.ceil(x);
        }


        public static double abs(double x) {
            return Math.abs(x);
        }


        public static int abs(int x) {
            return Math.abs(x);
        }


        public static double pow(double a, double b) {
            return Math.pow(a, b);
        }


        public static int pow(int a, int b) {
            return (int) Math.pow(a, b);
        }


        public static double sqrt(double a) {
            return Math.sqrt(a);
        }






        public static double nthRoot(double a, double b) {
            return Math.pow(a, 1.0 / b);
        }


        public static double ln(double x) {
            return Math.log(x);
        }


        public static double log(double num, double base) {
            // Handle edge cases explicitly
            if (num <= 0.0 || base <= 0.0 || base == 1.0)
                return Double.NaN; // log undefined for these

            // High-precision division of logs (IEEE-754 correctly rounded)
            double lnNum = Math.log(num);
            double lnBase = Math.log(base);

            return lnNum / lnBase;
        }


        public static double log10(double a) {
            return Math.log10(a);
        }


        public static double highPrecisionDivide(double a, double b) {
            // Handle all IEEE-754 edge cases explicitly
            if (Double.isNaN(a) || Double.isNaN(b)) return Double.NaN;
            if (b == 0.0) {
                if (a == 0.0) return Double.NaN; // 0/0 is undefined
                return a > 0 ? Double.POSITIVE_INFINITY : Double.NEGATIVE_INFINITY;
            }
            if (Double.isInfinite(a) && Double.isInfinite(b)) return Double.NaN;
            if (Double.isInfinite(a)) return a > 0 ? Double.POSITIVE_INFINITY : Double.NEGATIVE_INFINITY;
            if (Double.isInfinite(b)) return 0.0 * Math.copySign(1.0, a * b); // preserves sign correctly

            // Perform hardware division — this is IEEE 754 correctly-rounded
            double result = a / b;

            // Optional: one step of Newton–Raphson refinement (may reduce rounding error slightly)
            // result ≈ result * (2 - b * result)
            // Useful when b is not a power of two, but rarely changes the result.
            double refined = result + (result - (a - b * result) / b);
            if (Double.isFinite(refined)) result = refined;

            return result;
        }

        public static double rint(double x) {

            long bits = Double.doubleToRawLongBits(x);
            long absBits = bits & 0x7FFFFFFFFFFFFFFFL;
            int exp = (int)((bits >>> 52) & 0x7FF) - 1023;

            // NaN or Infinity
            if (exp == 1024) {
                return x;
            }

            // |x| < 1 → result is ±0.0 or ±1.0
            if (exp < 0) {
                if (absBits == 0) return x; // preserves signed zero

                // If |x| == 0.5 exactly → tie to even → zero
                if (exp == -1 && (absBits & ((1L << 52) - 1)) == 0) {
                    return (bits < 0) ? -0.0 : 0.0;
                }

                // Otherwise rounds to zero
                return (bits < 0) ? -0.0 : 0.0;
            }

            // Already an integer
            if (exp >= 52) {
                return x;
            }

            long fracMask = (1L << (52 - exp)) - 1;
            if ((bits & fracMask) == 0) {
                return x; // already integral
            }

            long half = 1L << (51 - exp);
            long rounded = (bits + half) & ~fracMask;

            // Tie-to-even correction
            if ((bits & fracMask) == half) {
                if ((rounded & (1L << (52 - exp))) != 0) {
                    rounded -= (1L << (52 - exp));
                }
            }

            return Double.longBitsToDouble(rounded);
        }




        public static final class Factorial {

            private Factorial() {throw new UnsupportedOperationException();}

            private static final double PI = Math.PI;
            private static final double SQRT_2PI = 2.506628274631000502415765284811;

    /* =========================
       INTEGER FACTORIAL (FAST)
       ========================= */

            private static final double[] FACT_TABLE = {
                    1.0,                        // 0!
                    1.0,                        // 1!
                    2.0,                        // 2!
                    6.0,                        // 3!
                    24.0,                       // 4!
                    120.0,                      // 5!
                    720.0,                      // 6!
                    5040.0,                     // 7!
                    40320.0,                    // 8!
                    362880.0,                   // 9!
                    3628800.0,                  // 10!
                    39916800.0,                 // 11!
                    479001600.0,                // 12!
                    6227020800.0,               // 13!
                    87178291200.0,              // 14!
                    1307674368000.0,            // 15!
                    20922789888000.0,           // 16!
                    355687428096000.0,          // 17!
                    6402373705728000.0,         // 18!
                    121645100408832000.0,       // 19!
                    2432902008176640000.0       // 20!
            };

            public static double factorial(double x) {
                if (Double.isNaN(x)) return Double.NaN;
                if (x < 0 && x == MathHelper.rint(x)) return Double.NaN; // negative integer pole

                // exact integers
                if (x == Math.rint(x)) {
                    int n = (int) x;
                    if (n < 0) return Double.NaN;
                    if (n < FACT_TABLE.length) return FACT_TABLE[n];
                    if (n > 170) return Double.POSITIVE_INFINITY;
                }

                // general real factorial
                if (x > 170.624) return Double.POSITIVE_INFINITY;
                return gamma(x + 1.0);
            }

    /* =========================
       GAMMA FUNCTION
       ========================= */

            public static double gamma(double x) {
                if (Double.isNaN(x)) return Double.NaN;
                if (x == Double.POSITIVE_INFINITY) return Double.POSITIVE_INFINITY;
                if (x <= 0 && x == Math.rint(x)) return Double.NaN; // pole

                // Use reflection for x < 0.5
                if (x < 0.5) {
                    return PI / (Math.sin(PI * x) * gamma(1.0 - x));
                }

                return Math.exp(logGamma(x));
            }

    /* =========================
       LOG GAMMA (PRIMARY ENGINE)
       ========================= */
            public static final double[] p = {
                    0.99999999999980993,
                    676.5203681218851,
                    -1259.1392167224028,
                    771.32342877765313,
                    -176.61502916214059,
                    12.507343278686905,
                    -0.13857109526572012,
                    9.9843695780195716e-6,
                    1.5056327351493116e-7
            };
            public static double logGamma(double x) {
                if (Double.isNaN(x)) return Double.NaN;
                if (x <= 0 && x == Math.rint(x)) return Double.NaN;

                // Reflection
                if (x < 0.5) {
                    return Math.log(PI)
                            - Math.log(Math.abs(Math.sin(PI * x)))
                            - logGamma(1.0 - x);
                }

                // Lanczos approximation (g = 7, n = 9)
                x -= 1.0;



                double sum = p[0];
                for (int i = 1; i < p.length; i++) {
                    sum += p[i] / (x + i);
                }

                double t = x + 7.5;
                return 0.5 * Math.log(2 * PI)
                        + (x + 0.5) * Math.log(t)
                        - t
                        + Math.log(sum);
            }
        }


        public static double factorial(double x) {
            if(integer(x)) {
                if (x < 0)
                    return Double.NaN;
                return factorial((int) x);
            }
            if (x < 171.0) {
                return gamma(x + 1.0);
            } else {
                return Double.POSITIVE_INFINITY; // overflow
            }
        }
        private static final int[] FACT = {
                1,
                1,
                2,
                6,
                24,
                120,
                720,
                5040,
                40320,
                3628800,
                36288000,
                39916800,
                479001600
        };
        private static int factorial(int num){
            if (num < 0 || num > 12)
                throw new IllegalArgumentException("n must be between 0 and 12 (int overflow)");
            return FACT[num];
        }


        private static double gamma(double z) {
            double[] p = {
                    676.5203681218851,
                    -1259.1392167224028,
                    771.32342877765313,
                    -176.61502916214059,
                    12.507343278686905,
                    -0.13857109526572012,
                    9.9843695780195716e-6,
                    1.5056327351493116e-7
            };

            if (z < 0.5)
                // Reflection formula for high precision near 0
                return Math.PI / (Math.sin(Math.PI * z) * gamma(1 - z));

            z -= 1;
            double x = 0.99999999999980993;
            for (int i = 0; i < p.length; i++)
                x += p[i] / (z + i + 1.0);

            double t = z + p.length - 0.5;
            return Math.sqrt(2 * Math.PI) * Math.pow(t, z + 0.5) * Math.exp(-t) * x;
        }


        public static final double EulerMascheroniConstant = 0.57721566490153286060651209008240243104215933593992;

        public static double H(double x) {
            if (x <= 0) return Double.NaN; // undefined for nonpositive
            if (integer(x))
                return H2(x);
            double inv = highPrecisionDivide(1.0, x);
            double inv2 = pow(inv, 2.0);
            // Full asymptotic expansion (4 terms keeps near-perfect double accuracy for x >= 1)
            return Math.log(x) + EulerMascheroniConstant
                    + 0.5 * inv
                    - (highPrecisionDivide(1.0, 12.0)) * inv2
                    + (highPrecisionDivide(1.0, 120.0)) * pow(inv2, 2.0)
                    - (highPrecisionDivide(1.0, 252.0)) * pow(inv2, 3.0);
        }


        private static double H2(double x) {
            double result = 0;
            for (int i = 1; i <= x; i++) result += 1.0 / i;
            return result;
        }


        public static boolean integer(double x) {
            return abs(x - Math.rint(x)) < 1e-10;
        }


        public static double sin(double x) {
            return Math.sin(x);
        }


        public static double cos(double x) {
            return Math.cos(x);
        }


        public static double tan(double x) {
            return Math.tan(x);
        }


        public static double tanh(double x) {
            return Math.tanh(x);
        }


        public static double cosh(double x) {
            return Math.cosh(x);
        }


        public static double sinh(double x) {
            return Math.sinh(x);
        }


        public static double atan(double x) {
            return Math.atan(x);
        }


        public static double asin(double x) {
            return Math.asin(x);
        }


        public static double acos(double x) {
            return Math.acos(x);
        }


        public static double atan2(double y, double x) {
            return Math.atan2(y, x);
        }


        public static double cot(double x) {
            return divideExact(1, tan(x));
        }


        public static double csc(double x) {
            return divideExact(1, sin(x));
        }


        public static double sec(double x) {
            return divideExact(1, cos(x));
        }


        public static double min(double x, double y) {
            return Math.min(x, y);
        }


        public static double max(double x, double y) {
            return Math.max(x, y);
        }


        public static double divideExact(double x, double y) {
            return x / y;
        }


        public static int fibonnacci(int n) {
            int a = 0;
            int b = 1;

            for (int i = 1; i <= n; i++) {
                int t = a + b;
                a = b;
                b = t;
            }
            return b;
        }

        public static double gcd(double a, double b) {
            long x = (long)(a >= 0 ? a : -a);
            long y = (long)(b >= 0 ? b : -b);

            if (x == 0) return y;
            if (y == 0) return x;

            int shift = Long.numberOfTrailingZeros(x | y);

            x >>= Long.numberOfTrailingZeros(x);

            while (y != 0) {
                y >>= Long.numberOfTrailingZeros(y);

                // Branchless swap to ensure x <= y
                long diff = x - y;
                long mask = diff >> 63;      // mask = 0xFFFFFFFFFFFFFFFF if x < y, else 0
                long nx = (x & mask) | (y & ~mask);
                long ny = (y & mask) | (x & ~mask);
                x = nx;
                y = ny - x;
            }

            return (double)(x << shift);
        }



        public static double lcm(double a, double b) {
            long x = (long)(a >= 0 ? a : -a);
            long y = (long)(b >= 0 ? b : -b);

            if (x == 0 || y == 0) return 0;

            long g = (long)gcd(x, y);

            // Multiply in long to preserve precision and avoid floating overflow
            return (double)((x / g) * y);
        }


        public static int gcd(int x, int y) {
            if (x == 0) return Math.abs(y);
            if (y == 0) return Math.abs(x);
            int a = x < 0 ? -x : x;
            int b = y < 0 ? -y : y;

            int shift = Integer.numberOfTrailingZeros(a | b);

            a >>= Integer.numberOfTrailingZeros(a);

            while (b != 0) {
                b >>= Integer.numberOfTrailingZeros(b);
                if (a > b) { int t = a; a = b; b = t; }
                b = b - a;
            }

            return a << shift;
        }

        public static int lcm(int a, int b) {
            a = Math.abs(a);
            b = Math.abs(b);
            if (a == 0 || b == 0) return 0;

            long result = (long)a / gcd(a, b) * (long)b;
            if (result > Integer.MAX_VALUE) throw new ArithmeticException("LCM overflow");
            return (int) result;
        }

        public static boolean coprime(int a, int b) {
            return gcd(a, b) == 1;
        }

        public static boolean coprime(double a, double b) {
            return gcd(a, b) == 1;
        }

        public static int R(int n) {
            int r = 7;
            for (int i = 2; i <= n; i++) {
                r += gcd(i, r);
            }
            return r;
        }
    }

    private static class MathHelper2 {

        // Constants and calculating them

        private static final double PI = 3.1415926535897932;
        public static final double TAU = Math.TAU;

        public static double pi(int digits) {
            // limit to double precision (~15 digits)
            if (digits > 15) digits = 15;

            double a = 1.0;
            double b = 1.0 / sqrt(2);
            double t = 0.25;
            double p = 1.0;

            // Gauss–Legendre algorithm
            for (int i = 0; i < 10; i++) { // 10 iterations ≈ 15 digits of precision
                double aNext = (a + b) / 2.0;
                double bNext = sqrt(a * b);
                double tNext = t - p * pow(a - aNext, 2);
                a = aNext;
                b = bNext;
                t = tNext;
                p *= 2.0;
            }

            double pi = pow(a + b, 2) / (4.0 * t);

            // Round to desired digits
            double scale = pow(10, digits);
            return round(pi * scale) / scale;
        }

        public static final double E = 2.7182818284590452;
        private static final int exp_terms = 18;

        public static double e(int digits) {
            double term = 1.0;
            double sum = 1.0;

            for (int n = 1; n < 100; n++) {
                term /= n;
                sum += term;
                if (term < 1e-16)
                    break;
            }

            double scale = pow(10, digits);
            return round(sum * scale) / scale;
        }

        private static final double[] c = {
                676.5203681218851,
                -1259.1392167224028,
                771.32342877765313,
                -176.61502916214059,
                12.507343278686905,
                -0.13857109526572012,
                9.9843695780195716e-6,
                1.5056327351493116e-7
        };

        public static double[] calculateLanczosCoeffs(int n, double g) {
            double[] coeffs = new double[n];
            for (int k = 0; k < n; k++) {
                double numerator = factorial(2 * g - 1 - k);
                double denominator = factorial(k) * pow(factorial(g - 1 - k), 2);
                coeffs[k] = pow(-1, k) * numerator / denominator;
            }
            return coeffs;
        }

        public static final double EulerMascheroniConstant = 0.57721566490153286060651209008240243104215933593992;

        public static double eulerMascheroni(int digits) {
            // Estimate number of terms needed for the desired precision
            int n = (int) Math.pow(10, digits + 1); // slightly more for safety

            double sum = 0.0;
            for (int k = 1; k <= n; k++) {
                sum += 1.0 / k;
            }

            double gamma = sum - ln(n); // use your ln() implementation

            // Round to the requested number of digits
            double scale = pow(10, digits);
            return round(gamma * scale) / scale;
        }

        // functions
        public static double exp(double x) {
            return pow(E, (int) x);
        }

        public static int round(double x) {
            return (int) (x + (x >= 0 ? 0.5 : -0.5));
        }

        public static int floor(double x) {
            int i = (int) x;
            return x < 0 && x != i ? i - 1 : i;
        }

        public static int ceiling(double x) {
            int i = (int) x;
            return x > 0 && x != i ? i + 1 : i;
        }

        public static double abs(double x) {
            return x > 0 ? x : -x;
        }

        public static int abs(int x) {
            return x > 0 ? x : -x;
        }

        public static double normalizeTrig(double x) {
            x = x % TAU;
            if (x > PI) x -= TAU;
            if (x < -PI) x += TAU;
            return x;
        }

        private static final int sin_terms = 14;

        public static double sin(double x) {
            x = normalizeTrig(x);
            double term = x;
            double sum = x;
            for (int i = 1; i <= sin_terms; i++) {
                term *= -x * x / ((2 * i) * (2 * i + 1));
                sum += term;
            }
            return sum;
        }

        private static final int cos_terms = 14;

        public static double cos(double x) {
            x = normalizeTrig(x);
            double term = 1;
            double sum = 1;
            for (int i = 1; i <= cos_terms; i++) {
                term *= -x * x / ((2 * i - 1) * (2 * i));
                sum += term;
            }
            return sum;
        }

        public static double tan(double x) {
            double c = cos(x);
            if (Math.abs(c) < 1e-10) {
                throw new ArithmeticException("tan(x) undefined for cos = 0");
            }
            return sin(x) / c;
        }

        public static double cot(double x) {
            return 1 / tan(x);
        }

        public static double csc(double x) {
            return 1 / sin(x);
        }

        public static double sec(double x) {
            return 1 / cos(x);
        }

        private static final double[] coeffs = {1.0 / 6.0, 3.0 / 40.0, 5.0 / 112.0, 35.0 / 1152.0, 63.0 / 2816.0, 231.0 / 13312.0, 143.0 / 10240.0};

        public static double[] generateArcsinCoeffs(int length) {
            double[] coeffs = new double[length];
            for (int n = 0; n < length; n++) {
                double numerator = factorial(2 * n);
                double denominator = pow(2, 2 * n) * pow(factorial(n), 2) * (2 * n + 1);
                coeffs[n] = numerator / denominator;
            }
            return coeffs;
        }

        public static double arcsin(double x) {
            if (x < -1 || x > 1)
                throw new IllegalArgumentException("arcsin domain is [-1,1]");
            double result = x;
            double term = x;
            double x2 = x * x;
            for (double coeff : coeffs) {
                term *= x2;
                result += coeff * term;
            }
            return result;
        }

        public static double arccos(double x) {
            if (x < -1 || x > 1)
                throw new IllegalArgumentException("arccos domain is [-1,1]");
            return (PI / 2) - arcsin(x);
        }


        public static int fibonacci(int num) {

            int a = 0;
            int b = 1;

            for (int i = 1; i <= num; i++) {
                int t = a + b;
                a = b;
                b = t;
            }
            return b;
        }

        public static int gcd(int a, int b) {
            return b == 0 ? a : gcd(b, a % b);
        }

        public static int lcm(int a, int b) {
            return a * b / gcd(a, b);
        }

        public static int R(int n) {
            if (n == 1)
                return 7;
            return R(n - 1) + gcd(n, R(n - 1));
        }

        public static int factorial(int x) {
            int result = 1;
            for (int i = 1; i <= x; i++)
                result *= i;
            return result;
        }

        public static double factorial(double x) {
            if (x == floor(x) && x >= 0) return factorial(floor(x));
            if (x < 0.5) return PI / (sin(PI * x) * factorial(1 - x));

            x -= 1;
            double a = 0.99999999999980993;
            for (int i = 0; i < c.length; i++)
                a += c[i] / (x + i + 1);
            double t = x + c.length + 0.5;
            double sqrtTwoPi = sqrt(TAU);
            return sqrtTwoPi * pow(t, floor(x + 0.5)) * exp(-t) * a;
        }

        public static double pow(double base, int exponent) {
            double result = 1;
            for (int i = 1; i <= exponent; i++) result *= base;
            return result;
        }

        public static double pow(double base, double exponent) {
            if (base == 0) {
                if (exponent <= 0) return Double.NaN; // 0^0 or 0^negative is undefined
                return 0;
            }
            if (base < 0) {
                // Negative base with non-integer exponent is complex; we can return NaN
                if (exponent != floor(exponent)) return Double.NaN;
                // otherwise treat as integer exponent
                return pow((int) base, (int) exponent);
            }
            // x^y = e^(y * ln(x))
            return exp(exponent * ln(base));
        }


        public static double sqrt(double x) {
            if (x < 0) return Double.NaN;
            if (x == 0) return 0;
            double result = x / 2.0;
            for (int i = 0; i < 20; i++) {
                result = 0.5 * (result + x / result);
            }
            return result;
        }

        public static double nthRoot(double x, int n) {
            if (n <= 0) return Double.NaN;  // invalid root
            if (x == 0) return 0;
            if (n == 1) return x;
            if (n == 2) return sqrt(x);     // reuse your sqrt()

            boolean neg = x < 0 && n % 2 != 0; // allow odd roots of negatives
            if (neg) x = -x;

            double guess = x / n;  // initial approximation

            for (int i = 0; i < 30; i++) {
                guess = ((n - 1.0) * guess + x / pow(guess, n - 1)) / n;
            }

            return neg ? -guess : guess;
        }

        private static final int ln_terms = 50;

        public static double ln(double x) {
            if (x <= 0) return Double.NaN;
            if (x == 1.0) return 0.0;

            // Normalize x closer to 1 using powers of e for faster convergence
            int k = 0;
            while (x > E) {
                x /= E;
                k++;
            }
            while (x < 1.0 / E) {
                x *= E;
                k--;
            }

            // Taylor series using y = (x - 1) / (x + 1)
            double y = (x - 1) / (x + 1);
            double y2 = y * y;
            double term = y;
            double sum = 0.0;

            for (int n = 1; n < ln_terms * 2; n += 2) {
                sum += term / n;
                term *= y2;
                if (abs(term) < 1e-16) break;
            }

            return 2 * sum + k;
        }

        public static double log10(double x) {
            return ln(x) / ln(10);
        }

        public static double log(double x, int base) {
            return ln(x) / ln(base);
        }

        public static double log(double x, double base) {
            return ln(x) / ln(base);
        }

        private static double H2(int x) {
            double result = 0;
            for (int i = 1; i <= x; i++) result += 1.0 / i;
            return result;
        }

        public static double H(double x) {
            if (x <= 0) return Double.NaN;
            if (integer(x))
                return H2((int) x);
            return ln(x) + EulerMascheroniConstant + 1.0 / (2.0 * x) + 1.0 / (12.0 * pow(x, 2)) + 1.0 / (120 * pow(x, 4));
        }

        public static boolean integer(double x) {
            return abs(x - Math.rint(x)) < 1e-10;
        }

    }

    public static class ArraysHelper {
        public static int[] randomFillArr(int length, int min, int max) {

            int[] arr = new int[length];
            for (int i = 0; i < length; i++)
                arr[i] = numbers.randomNum(min, max);
            return arr;
        }


        public static int[] randomArr(int min_length, int max_length, int min, int max) {
            return randomFillArr(numbers.randomNum(min_length, max_length), min, max);
        }

        public static int[] sortArr(int[] arr) {
            return sortArr(arr, arr.length);
        }

        public static int[] sortArr(int[] a, int n) {
            if (n == 1) return a;
            for (int i = 0; i < n - 1; i++)
                if (a[i] > a[i + 1]) {
                    int t = a[i];
                    a[i] = a[i + 1];
                    a[i + 1] = t;
                }
            return sortArr(a, n - 1);
        }

        public static int[] createRandomSortedArr(int length, int min, int max) {
            return sortArr(randomFillArr(length, min, max));
        }

        public static int[] createRandomSortedArr(int min_length, int max_length, int min, int max) {
            return createRandomSortedArr(numbers.randomNum(min_length, max_length), min, max);
        }

        public static void printArr(int[] a) {
            System.out.print("{");
            for (int i = 0; i < a.length; i++)
                System.out.print((i > 0 ? ", " : "") + a[i]);
            System.out.println("}");
        }

        public static <T> String arrString(T[] arr){
            StringBuilder sb = new StringBuilder();
            sb.append('{');
            for (int i = 0; i < arr.length; i++) {
                sb.append(i > 0 ? ", " : "");
                sb.append(arr[i].toString());
            }
            sb.append('}');
            return sb.toString();
        }

        public static int randomNumInArr(int[] arr) {
            return arr[numbers.randomNum(0, arr.length - 1)];
        }

        public static int[] duplicateArr(int[] a) {
            int[] b = new int[a.length];
            System.arraycopy(a, 0, b, 0, a.length);
            return b;
        }

        public static int[][] randomFillMatrix(int rows, int cols, int min, int max) {
            int[][] arr = new int[rows][cols];
            for (int i = 0; i < rows; i++) {
                arr[i] = randomFillArr(cols, min, max);
            }
            return arr;
        }

        public static void printMatrix(int[][] matrix) {
            for (int[] i : matrix) {
                printArr(i);
            }
        }

        public static char[] StringToCharArray(String str) {
            char[] arr = new char[str.length()];
            for (int i = 0; i < str.length(); i++) {
                arr[i] = str.charAt(i);
            }
            return arr;
        }

        public static Integer[] toIntegerArray(int[] arr) {
            Integer[] result = new Integer[arr.length];
            for (int i = 0; i < arr.length; i++) {
                result[i] = arr[i];
            }
            return result;
        }

        public static int[] toIntArray(Integer[] arr) {
            int[] result = new int[arr.length];
            for (int i = 0; i < arr.length; i++) {
                result[i] = arr[i];
            }
            return result;
        }

        public static int[] intToArray(int n) {
            int length = numbers.countDigits(n);
            int[] arr = new int[length];
            for (int i = length - 1; i >= 0; i--) {
                arr[i] = n % 10;
                n /= 10;
            }
            return arr;
        }

        public static int arrayToInt(int[] arr) {
            int n = 0;
            for (int digit : arr) {
                n = n * 10 + digit;
            }
            return n;
        }
    }

    public static final class ArraysAdvanced{
        private ArraysAdvanced() {}

        // ============================
        //        GENERIC  T[]
        // ============================

        // ----------------------
        // Append: add at end
        // ----------------------
        public static <T> T[] append(T[] array, T value) {
            T[] result = Arrays.copyOf(array, array.length + 1);
            result[array.length] = value;
            return result;
        }

        // ----------------------
        // Prepend: add at start
        // ----------------------
        public static <T> T[] prepend(T[] array, T value) {
            T[] result = Arrays.copyOf(array, array.length + 1);
            System.arraycopy(result, 0, result, 1, array.length);
            result[0] = value;
            return result;
        }

        // ----------------------
        // Insert at index
        // ----------------------
        public static <T> T[] insert(T[] array, int index, T value) {
            if (index < 0 || index > array.length)
                throw new IndexOutOfBoundsException("Index: " + index + ", Length: " + array.length);
            T[] result = Arrays.copyOf(array, array.length + 1);
            System.arraycopy(result, index, result, index + 1, array.length - index);
            result[index] = value;
            return result;
        }

        // ----------------------
        // Remove element at index
        // ----------------------
        public static <T> T[] remove(T[] array, int index) {
            if (index < 0 || index >= array.length)
                throw new IndexOutOfBoundsException("Index: " + index + ", Length: " + array.length);
            T[] result = Arrays.copyOf(array, array.length - 1);
            System.arraycopy(array, 0, result, 0, index);
            System.arraycopy(array, index + 1, result, index, array.length - index - 1);
            return result;
        }

        // ----------------------
        // Concatenate two arrays
        // ----------------------
        public static <T> T[] concat(T[] a, T[] b) {
            T[] result = Arrays.copyOf(a, a.length + b.length);
            System.arraycopy(b, 0, result, a.length, b.length);
            return result;
        }



        // ============================
        //     PRIMITIVE ARRAYS
        // ============================

        // ====================
        // BOOLEAN
        // ====================
        public static boolean[] append(boolean[] arr, boolean value) {
            boolean[] result = Arrays.copyOf(arr, arr.length + 1);
            result[arr.length] = value;
            return result;
        }

        public static boolean[] prepend(boolean[] arr, boolean value) {
            boolean[] result = Arrays.copyOf(arr, arr.length + 1);
            System.arraycopy(result, 0, result, 1, arr.length);
            result[0] = value;
            return result;
        }

        public static boolean[] insert(boolean[] arr, int index, boolean value) {
            if (index < 0 || index > arr.length) throw new IndexOutOfBoundsException();
            boolean[] result = Arrays.copyOf(arr, arr.length + 1);
            System.arraycopy(result, index, result, index + 1, arr.length - index);
            result[index] = value;
            return result;
        }

        public static boolean[] remove(boolean[] arr, int index) {
            if (index < 0 || index >= arr.length) throw new IndexOutOfBoundsException();
            boolean[] result = new boolean[arr.length - 1];
            System.arraycopy(arr, 0, result, 0, index);
            System.arraycopy(arr, index + 1, result, index, arr.length - index - 1);
            return result;
        }

        public static boolean[] concat(boolean[] a, boolean[] b) {
            boolean[] result = Arrays.copyOf(a, a.length + b.length);
            System.arraycopy(b, 0, result, a.length, b.length);
            return result;
        }

        // ====================
        // BYTE
        // ====================
        public static byte[] append(byte[] arr, byte value) {
            byte[] result = Arrays.copyOf(arr, arr.length + 1);
            result[arr.length] = value;
            return result;
        }

        public static byte[] prepend(byte[] arr, byte value) {
            byte[] result = Arrays.copyOf(arr, arr.length + 1);
            System.arraycopy(result, 0, result, 1, arr.length);
            result[0] = value;
            return result;
        }

        public static byte[] insert(byte[] arr, int index, byte value) {
            if (index < 0 || index > arr.length) throw new IndexOutOfBoundsException();
            byte[] result = Arrays.copyOf(arr, arr.length + 1);
            System.arraycopy(result, index, result, index + 1, arr.length - index);
            result[index] = value;
            return result;
        }

        public static byte[] remove(byte[] arr, int index) {
            if (index < 0 || index >= arr.length) throw new IndexOutOfBoundsException();
            byte[] result = new byte[arr.length - 1];
            System.arraycopy(arr, 0, result, 0, index);
            System.arraycopy(arr, index + 1, result, index, arr.length - index - 1);
            return result;
        }

        public static byte[] concat(byte[] a, byte[] b) {
            byte[] result = Arrays.copyOf(a, a.length + b.length);
            System.arraycopy(b, 0, result, a.length, b.length);
            return result;
        }

        // ====================
        // SHORT
        // ====================
        public static short[] append(short[] arr, short value) {
            short[] result = Arrays.copyOf(arr, arr.length + 1);
            result[arr.length] = value;
            return result;
        }

        public static short[] prepend(short[] arr, short value) {
            short[] result = Arrays.copyOf(arr, arr.length + 1);
            System.arraycopy(result, 0, result, 1, arr.length);
            result[0] = value;
            return result;
        }

        public static short[] insert(short[] arr, int index, short value) {
            if (index < 0 || index > arr.length) throw new IndexOutOfBoundsException();
            short[] result = Arrays.copyOf(arr, arr.length + 1);
            System.arraycopy(result, index, result, index + 1, arr.length - index);
            result[index] = value;
            return result;
        }

        public static short[] remove(short[] arr, int index) {
            if (index < 0 || index >= arr.length) throw new IndexOutOfBoundsException();
            short[] result = new short[arr.length - 1];
            System.arraycopy(arr, 0, result, 0, index);
            System.arraycopy(arr, index + 1, result, index, arr.length - index - 1);
            return result;
        }

        public static short[] concat(short[] a, short[] b) {
            short[] result = Arrays.copyOf(a, a.length + b.length);
            System.arraycopy(b, 0, result, a.length, b.length);
            return result;
        }

        // ====================
        // CHAR
        // ====================
        public static char[] append(char[] arr, char value) {
            char[] result = Arrays.copyOf(arr, arr.length + 1);
            result[arr.length] = value;
            return result;
        }

        public static char[] prepend(char[] arr, char value) {
            char[] result = Arrays.copyOf(arr, arr.length + 1);
            System.arraycopy(result, 0, result, 1, arr.length);
            result[0] = value;
            return result;
        }

        public static char[] insert(char[] arr, int index, char value) {
            if (index < 0 || index > arr.length) throw new IndexOutOfBoundsException();
            char[] result = Arrays.copyOf(arr, arr.length + 1);
            System.arraycopy(result, index, result, index + 1, arr.length - index);
            result[index] = value;
            return result;
        }

        public static char[] remove(char[] arr, int index) {
            if (index < 0 || index >= arr.length) throw new IndexOutOfBoundsException();
            char[] result = new char[arr.length - 1];
            System.arraycopy(arr, 0, result, 0, index);
            System.arraycopy(arr, index + 1, result, index, arr.length - index - 1);
            return result;
        }

        public static char[] concat(char[] a, char[] b) {
            char[] result = Arrays.copyOf(a, a.length + b.length);
            System.arraycopy(b, 0, result, a.length, b.length);
            return result;
        }

        // ====================
        // INT
        // ====================
        public static int[] append(int[] arr, int value) {
            int[] result = Arrays.copyOf(arr, arr.length + 1);
            result[arr.length] = value;
            return result;
        }

        public static int[] prepend(int[] arr, int value) {
            int[] result = Arrays.copyOf(arr, arr.length + 1);
            System.arraycopy(result, 0, result, 1, arr.length);
            result[0] = value;
            return result;
        }

        public static int[] insert(int[] arr, int index, int value) {
            if (index < 0 || index > arr.length) throw new IndexOutOfBoundsException();
            int[] result = Arrays.copyOf(arr, arr.length + 1);
            System.arraycopy(result, index, result, index + 1, arr.length - index);
            result[index] = value;
            return result;
        }

        public static int[] remove(int[] arr, int index) {
            if (index < 0 || index >= arr.length) throw new IndexOutOfBoundsException();
            int[] result = new int[arr.length - 1];
            System.arraycopy(arr, 0, result, 0, index);
            System.arraycopy(arr, index + 1, result, index, arr.length - index - 1);
            return result;
        }

        public static int[] concat(int[] a, int[] b) {
            int[] result = Arrays.copyOf(a, a.length + b.length);
            System.arraycopy(b, 0, result, a.length, b.length);
            return result;
        }

        // ====================
        // LONG
        // ====================
        public static long[] append(long[] arr, long value) {
            long[] result = Arrays.copyOf(arr, arr.length + 1);
            result[arr.length] = value;
            return result;
        }

        public static long[] prepend(long[] arr, long value) {
            long[] result = Arrays.copyOf(arr, arr.length + 1);
            System.arraycopy(result, 0, result, 1, arr.length);
            result[0] = value;
            return result;
        }

        public static long[] insert(long[] arr, int index, long value) {
            if (index < 0 || index > arr.length) throw new IndexOutOfBoundsException();
            long[] result = Arrays.copyOf(arr, arr.length + 1);
            System.arraycopy(result, index, result, index + 1, arr.length - index);
            result[index] = value;
            return result;
        }

        public static long[] remove(long[] arr, int index) {
            if (index < 0 || index >= arr.length) throw new IndexOutOfBoundsException();
            long[] result = new long[arr.length - 1];
            System.arraycopy(arr, 0, result, 0, index);
            System.arraycopy(arr, index + 1, result, index, arr.length - index - 1);
            return result;
        }

        public static long[] concat(long[] a, long[] b) {
            long[] result = Arrays.copyOf(a, a.length + b.length);
            System.arraycopy(b, 0, result, a.length, b.length);
            return result;
        }

        // ====================
        // FLOAT
        // ====================
        public static float[] append(float[] arr, float value) {
            float[] result = Arrays.copyOf(arr, arr.length + 1);
            result[arr.length] = value;
            return result;
        }

        public static float[] prepend(float[] arr, float value) {
            float[] result = Arrays.copyOf(arr, arr.length + 1);
            System.arraycopy(result, 0, result, 1, arr.length);
            result[0] = value;
            return result;
        }

        public static float[] insert(float[] arr, int index, float value) {
            if (index < 0 || index > arr.length) throw new IndexOutOfBoundsException();
            float[] result = Arrays.copyOf(arr, arr.length + 1);
            System.arraycopy(result, index, result, index + 1, arr.length - index);
            result[index] = value;
            return result;
        }

        public static float[] remove(float[] arr, int index) {
            if (index < 0 || index >= arr.length) throw new IndexOutOfBoundsException();
            float[] result = new float[arr.length - 1];
            System.arraycopy(arr, 0, result, 0, index);
            System.arraycopy(arr, index + 1, result, index, arr.length - index - 1);
            return result;
        }

        public static float[] concat(float[] a, float[] b) {
            float[] result = Arrays.copyOf(a, a.length + b.length);
            System.arraycopy(b, 0, result, a.length, b.length);
            return result;
        }

        // ====================
        // DOUBLE
        // ====================
        public static double[] append(double[] arr, double value) {
            double[] result = Arrays.copyOf(arr, arr.length + 1);
            result[arr.length] = value;
            return result;
        }

        public static double[] prepend(double[] arr, double value) {
            double[] result = Arrays.copyOf(arr, arr.length + 1);
            System.arraycopy(result, 0, result, 1, arr.length);
            result[0] = value;
            return result;
        }

        public static double[] insert(double[] arr, int index, double value) {
            if (index < 0 || index > arr.length) throw new IndexOutOfBoundsException();
            double[] result = Arrays.copyOf(arr, arr.length + 1);
            System.arraycopy(result, index, result, index + 1, arr.length - index);
            result[index] = value;
            return result;
        }

        public static double[] remove(double[] arr, int index) {
            if (index < 0 || index >= arr.length) throw new IndexOutOfBoundsException();
            double[] result = new double[arr.length - 1];
            System.arraycopy(arr, 0, result, 0, index);
            System.arraycopy(arr, index + 1, result, index, arr.length - index - 1);
            return result;
        }

        public static double[] concat(double[] a, double[] b) {
            double[] result = Arrays.copyOf(a, a.length + b.length);
            System.arraycopy(b, 0, result, a.length, b.length);
            return result;
        }
    }

    public static class numbers {
        public static int randomNum(int min, int max) {
            return (int) (Math.random() * (max - min + 1)) + min;
        }

        public static int countDigits(double n) {
            String s = Double.toString(n);
            s = s.replace("-", "").replace(".", ""); // remove minus and decimal point
            return s.length();
        }

        public static int countFraction(double n) {
            String s = Double.toString(Math.abs(n));
            int dotIndex = s.indexOf('.');
            if (dotIndex == -1) return 0; // no fractional part
            String fracPart = s.substring(dotIndex + 1);

            // Remove trailing zeros
            fracPart = fracPart.replaceAll("0+$", "");
            return fracPart.length();
        }
        public static int reverse(int num) {
            boolean negative = num < 0;
            String s = new StringBuilder(Integer.toString(Math.abs(num))).reverse().toString();
            int reversed = Integer.parseInt(s);
            return negative ? -reversed : reversed;
        }

        public static class Combinatorics {

            private static int minCalc(int n, int r){
                return MathHelper.factorial(n-r);
            }

            public static int nCr(int n, int r) {
                return MathHelper.factorial(n) / (MathHelper.factorial(r) * minCalc(n, r));
            }

            public static int nPr(int n, int r) {
                return MathHelper.factorial(n) / minCalc(n, r);
            }
        }

        public static class percentages{
            // convert whole number percent → decimal
            public static double toPercent(double percent) {
                return percent / 100.0;  // 5 -> 0.05
            }

            // convert decimal percent → whole number percent
            public static double toNumber(double decimal) {
                return decimal * 100.0;  // 0.05 -> 5
            }

            // how much percent is part out of whole?
            public static double percentOf(double part, double whole) {
                if (whole == 0){
                    System.out.println("Whole cannot be 0");
                    return Double.NaN;
                }
                return (part / whole) * 100.0;
            }

            // what is X% of Y?
            public static double xPercentOfY(double percent, double number) {
                return (percent / 100.0) * number;
            }


        }

        public static class Primes {

            public static boolean isPrime(long n) {
                if (n < 2) return false;
                return BigInteger.valueOf(n).isProbablePrime(20);
            }
        }

    }

    public static char changeBy(char ch, int num) {
        return (char) ((int) ch + num);
    }

    public static boolean allUpper(String str) {
        return str.equals(str.toUpperCase());
    }

    public static boolean allLower(String str) {
        return str.equals(str.toLowerCase());
    }

    public static boolean allLowerOrUpper(String str) {
        return str.equals(str.toUpperCase()) || str.equals(str.toLowerCase());
    }

}