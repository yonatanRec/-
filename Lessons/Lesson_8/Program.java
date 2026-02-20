package Lessons.Lesson_8;

import Other.stack.*;

public class Program {
    public static void main(String[] args){
        Integer[] arr = {15,-4,-4,3,5,0,0,0,5,5,15,14};
        Stack<Integer> stack = new Stack<>();
        stack.Helper.push(arr);
        System.out.println(stack);
        Program.stack.removeBlocks(stack);
        System.out.println(stack);
    }

    static class sum {
        public static int sumArr(int[] arr) {
            return sumArr(arr, 0);
        }

        private static int sumArr(int[] arr, int index) {
            if (index >= arr.length)
                return 0;
            return arr[index] + sumArr(arr, index + 1);
        }
    }


    static class sorted {
        public static boolean isSorted(int[] arr) {
            return isSorted(arr, 1);
        }

        private static boolean isSorted(int[] arr, int index) {
            if (index >= arr.length)
                return true;
            return arr[index] >= arr[index - 1] && isSorted(arr, index + 1);
        }
    }

    static class series {
        public static boolean isSeries(int[] arr) {
            return isSeries(arr, 1);
        }

        private static boolean isSeries(int[] arr, int index) {
            if (index >= arr.length - 1)
                return true;
            return arr[index] - arr[index - 1] == arr[index + 1] - arr[index] && isSeries(arr, index + 1);
        }
    }

    public static int reverse(int num){
        if (num < 10)
            return num;
        int i = 10;
        while (num%i != num)
            i*=10;
        return (num%10 * i/10) + reverse(num/10);
    }

    public static int mult(int a, int b){
        if (b == 0)
            return 0;
        if (b%2 == 0)
            return mult(a+a, b/2);
        return mult(a+a,b/2)+a;
    }

    public static boolean isDigitExist(int num, int digit){
        boolean ans = num%10 == digit;
        if (num < 10)
            return ans;
        return isDigitExist(num/10, digit);
    }

    public static boolean isAllDigitsEven(int num){
        boolean ans = num%2 == 0;
        if  (num < 10)
            return ans;
        return ans && isAllDigitsEven(num/10);
    }

    static class sod {
        public static int sod1(int[] a, int k) {
            if (k == 0)
                return a[k];
            return a[k] + sod1(a, k - 1);
        }

        public static boolean sod2(int[] a, int n) {
            if (n == 0)
                return true;
            if (a[n] % 10 != sod1(a, n - 1))
                return false;
            return sod2(a, n - 1);
        }

        static class Sum {
            public static int fullSum(int x) {
                if (sum(x) < 10)
                    return sum(x);
                return fullSum(sum(x));
            }

            public static int sum(int x) {
                if (x < 10)
                    return x;
                return x % 10 + sum(x / 10);
            }
        }
    }

    static class stack {
        public static int largestSum(Stack<Integer> st1, Stack<Integer> st2) {
            int largestSum = 0, prev = st2.pop();
            while (!st2.isEmpty()) {
                int curr = st2.top();
                int sum = prev + curr;
                if (sum > largestSum)
                    largestSum = sum;
                prev = st2.pop();
            }
            prev = st1.pop();
            while (!st1.isEmpty()) {
                int curr = st1.top();
                int sum = prev + curr;
                if (sum > largestSum)
                    return sum;
                prev = st1.pop();
            }
            return 0;
        }

        public static int lastAndRemove(Stack<Integer> stack) {
            Stack<Integer> temp = new Stack<>();
            int last = stack.pop();
            while (!stack.isEmpty()) {
                temp.push(last);
                last = stack.pop();
            }
            while (!temp.isEmpty())
                stack.push(temp.pop());
            return last;
        }

        public static boolean isExist(Stack<Integer> stack, int digit) {
            Stack<Integer> temp = new Stack<>();
            boolean isExist = false;
            while (!stack.isEmpty()) {
                int curr = stack.pop();
                if (curr == digit)
                    isExist = true;
                temp.push(curr);
            }
            return isExist;
        }

        public static Stack<Integer> clone(Stack<Integer> stack) {
            Stack<Integer> temp = new Stack<>();
            while (!stack.isEmpty()) {
                temp.push(stack.pop());
            }
            Stack<Integer> clone = new Stack<>();
            while (!temp.isEmpty()) {
                int curr = temp.pop();
                clone.push(curr);
                stack.push(curr);
            }
            return clone;
        }

        public static void removeBlocks(Stack<Integer> stack) {
            if (stack.isEmpty()) return;

            Stack<Integer> temp = new Stack<>();
            int prev = stack.pop();

            while (!stack.isEmpty()) {
                int curr = stack.top();

                if (curr == prev) {
                    // skip all numbers equal to prev
                    while (!stack.isEmpty() && stack.top() == prev)
                        stack.pop();

                    // move to next number (if any)
                    if (!stack.isEmpty())
                        prev = stack.pop();
                    else
                        return; // all cleared, done
                } else {
                    temp.push(prev);
                    prev = stack.pop();
                }
            }

            // push the last remaining number
            temp.push(prev);

            // restore the original order
            while (!temp.isEmpty())
                stack.push(temp.pop());
        }

    }

    static class twoItems{
        public static Stack<TwoItems> stackTwoItems(Stack<Integer> stk1) {
            Stack<TwoItems> stackTwoItems = new Stack<>();
            while (!stk1.isEmpty()) {
                int top = stk1.top(), last = stack.lastAndRemove(stk1);
                stackTwoItems.push(new TwoItems(top, last));
            }
            return stackTwoItems;
        }
    }





}

class TwoItems {
    private int num1;
    private int num2;

    public TwoItems(int num1, int num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

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


}
