package Lessons.Lesson_6;
import Other.stack.*;
public class Program {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        Integer[] arr = {77, 568, 251, 162};
        stack.Helper.push(arr);
        System.out.println(stack);
        System.out.println(isExist(stack,8));
        System.out.println(stack);
    }

    public static boolean isExist(Stack<Integer> stk, int num){
        if(stk.isEmpty())
            return false;
        int val = stk.pop(), digit = val % 10;
        if(digit == num) {
            stk.push(val);
            return true;
        }
        boolean result = isExist(stk,num);
        stk.push(val);
        return result;
    }

    public static void stackSod1(Stack<Integer> st, int element){
        if(st.isEmpty()){
            st.push(element);
        }
        else{
            int val =  st.pop();
            stackSod1(st,val);
            st.push(val);
        }
    }

    public static void stackSod2(Stack<Integer> st){
        if(!st.isEmpty()){
            int val = st.pop();
            stackSod2(st);
            stackSod1(st,val);
            st.push(val);
        }
    }

}

class TwoStack{
    public TwoStack(Stack<Integer> numbers, Stack<Integer> sums) {
        this.numbers = numbers;
        this.sums = sums;
    }

    private Stack<Integer> numbers;
    private Stack<Integer> sums;

    public Stack<Integer> getNums(int x){
        Stack<Integer> res = new Stack<>();
        boolean found = false;
        while(!sums.isEmpty()){
            int currentSum = sums.pop();
            int num = numbers.pop();
            if(currentSum == x)
                found = true;
            if(found)
                res.push(num);
        }
        return res;
    }

    public void eraseNum(int x){
        Stack<Integer> sumsReverse = new Stack<>();
        Stack<Integer> numbersReverse = new Stack<>();
        while(!numbers.isEmpty()){
            int currentNum = numbers.pop();
            int currentSum = sums.pop();
            if(currentNum == x) {
                continue;/*
                currentNum = numbers.pop();
                currentSum = sums.pop();*/
            }
            sumsReverse.push(currentSum);
            numbersReverse.push(currentNum);
        }

        Stack<Integer> newSums = new Stack<>();
        Stack<Integer> newNumbers = new Stack<>();
        int currentNum = numbersReverse.pop();
        int sum = currentNum;
        newSums.push(sum);
        newNumbers.push(currentNum);
        while (!numbersReverse.isEmpty()){
            currentNum = numbersReverse.pop();
            sum += currentNum;
            newSums.push(sum);
            newNumbers.push(currentNum);
        }
        sums =  newSums;
        numbers = newNumbers;
    }


    @Override
    public String toString() {
        return "TwoStack{" +
                "numbers=" + numbers +
                ", sums=" + sums +
                '}';
    }
}