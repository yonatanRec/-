package Assignments.Assignment_4;
import java.util.Scanner;
import Other.stack.*;
import java.util.Arrays;

public class Program {
    public static Scanner reader = new  Scanner(System.in);

    public static void main(String[] args) {
        Stack<Integer> st1 = new Stack<>();
        Integer[] arr = {1,2,1,3,4,5,1,9,9};
        st1.Helper.push(arr);
        //System.out.println(st1);
        st1.Helper.push(st1.Helper.copy(1));
        //System.out.println(st1);
    }

    public static boolean isSortedNotDown(Stack<Integer> st){
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

    public static String back(Stack<String> st, String back){
        int num;
        if(back.equals("Back"))
            num = 1;
        else{
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
        Stack<Integer> sorted1 = new Stack<>();
        Stack<Integer> sorted2 = new Stack<>();
        Stack<Integer> temp = new Stack<>();
        while (!st1.isEmpty()) {
            int x = st1.pop();
            while (!sorted1.isEmpty() && sorted1.top() > x) {
                temp.push(sorted1.pop());
            }
            sorted1.push(x);
            while (!temp.isEmpty()) sorted1.push(temp.pop());
        }
        while (!st2.isEmpty()) {
            int x = st2.pop();
            while (!sorted2.isEmpty() && sorted2.top() > x) {
                temp.push(sorted2.pop());
            }
            sorted2.push(x);
            while (!temp.isEmpty()) sorted2.push(temp.pop());
        }
        while (!sorted1.isEmpty() && !sorted2.isEmpty()) {
            if (!sorted1.pop().equals(sorted2.pop())) return false;
        }

        return sorted1.isEmpty() && sorted2.isEmpty();
    }


    public static boolean digitsInStack(Stack<Integer> st, int num){
        int temp_num = num;
        int max_count = 0;
        while(temp_num > 0){
            max_count++;
            temp_num /= 10;
        }
        Stack<Integer> reverse = new Stack<>();
        temp_num = num;
        int count = 0;
        while(!st.isEmpty()){
            int temp  = st.pop();
            reverse.push(temp);
            if(temp == temp_num%10){
                count++;
                temp_num /= 10;
                if(count >= max_count) {
                    return true;
                }
            }
            else
                count = 0;
        }

        temp_num = num;
        count = 0;

        while(!reverse.isEmpty()){
            int temp  = reverse.pop();
            if(temp == temp_num%10){
                count++;
                temp_num /= 10;
                if(count >= max_count)
                    return true;
            }
            else
                count = 0;
        }

        return false;
    }

    public static void reverseEachFive(String s) {
        Stack<Character> st = new Stack<>();
        Stack<Character> temp = new Stack<>();
        for (int i = s.length() - 1; i >= 0; i--)
            st.push(s.charAt(i));
        while (!st.isEmpty()) {
            int count = 0;
            while (count < 5 && !st.isEmpty()) {
                temp.push(st.pop());
                count++;
            }
            while (!temp.isEmpty()) //looks better than .toString()
                System.out.print(temp.pop());
        }
    }


    public static int longestSeries(Stack<Integer> st) {
        int max_count = 1,count = 1;
        int prev = st.pop();
        while(!st.isEmpty()){
            int temp = st.pop();
            if(temp == prev-1){
                count++;
                max_count = Math.max(max_count,count);
            }
            else
                count = 1;
            prev = temp;
        }
        return max_count;
    }


    public static void circle(Stack<Integer> s, int n){
        Stack<Integer> temp = new Stack<>();
        int x;
        for (int i = 0; i < n; i++) {
            x=s.pop();
            spilledOn(temp,s);
            s.push(x);
            spilledOn(s,temp);
        }

    }

    public static Stack<Integer> buildStack(Stack<Integer> s)
    {
        int n1,n2;
        Stack<Integer> temp = new Stack<>();
        while (!s.isEmpty())
        {
            n1 = s.pop();
            if (!s.isEmpty())
            {
                n2 = s.pop();
                if(!s.isEmpty())
                    if(n1 != n2 && n2 != s.top())
                        temp.push(n2);
                else
                    if(n1 != n2)
                        temp.push(n2);
            }
        }
        return temp;
    }

    public static void spilledOn(Stack<Integer> st1, Stack<Integer> st2){
        while(!st2.isEmpty()){
            st1.push(st2.pop());
        }
    }
}
