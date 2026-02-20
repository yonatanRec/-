package Other;
import Other.stack.*;
import  java.util.Scanner;
import Other.Helper.MathHelper;
public class Main{
    public static Scanner reader = new Scanner(System.in);
    public static void main(String[] args){
        Stack<Integer> st1 = new Stack<>();
        Integer[] arr1 = {1,2,1,3};
        Integer[] arr2 = {4,5,1,9,9};
        st1.Helper.push(arr1);

        Stack<Integer> st2 = st1.Helper.copy();

        System.out.println(st1);
        System.out.println(st1.Helper.copyReverse());



        st1.Helper.insert(5,2);
        System.out.println(st1);
    }








    public static void printOneToNum(int n){
        if (n==0)
            return;
        System.out.println(n);
        printOneToNum(n-1);
    }

    public static int countDigits(int n){
        return n < 10 ? 1 : 1 + countDigits(n/10);

    }

    public static int sumDigits(int n){
        return n > 10 ? n : n % 10 + sumDigits(n / 10);
        /*if(n > 10)
            return n;
        return n%10 + sumDigits(n/10);*/
    }

    public static int fibonacci(int k){
        if (k==1)
            return 0;
        if (k==2)
            return 1;
        return (fibonacci(k-1) + fibonacci(k-2));
    }

    public static int reverse(int num){
        if (num < 10)
            return (num);
        else {
            int i = 10;
            while (num % i != num)
                i *= 10;
            return ((num % 10) * i / 10) + reverse(num / 10);
        }
    }

    public static int sumArr(int[] arr, int i){ // שאלה 19
        return arr.length == i ? 0 : arr[i] + sumArr(arr,i+1);
    }

    public static int sumArr_2(int[] arr, int i){// שאלה 18
        return i < 0 ? 0 : arr[i] + sumArr_2(arr, i-1);
    }

    public static int countPositive(int[] arr, int i){ // שאלה 20
        return i < 0 ? 0 : arr[i] > 0 ? 1 + countPositive(arr, i-1) : countPositive(arr, i-1);
        /*if(i < 0)
            return 0;
        if(arr[i] > 0)
            return 1 + countPositive(arr, i-1);
        return countPositive(arr, i-1);*/
    }

    public static int findNum(int[] arr, int num){
        return findNum(arr, num, 0);
    }

    public static int findNum(int[] arr, int num, int i){
        return i == arr.length ? -1 : arr[i] == num ? i : findNum(arr,num,i+1);
        /*if(i == arr.length)
            return -1;
        if(arr[i] == num)
            return i;
        return findNum(arr, num, i+1);*/
    }

    public static boolean isEqual(int[] arr, int[] arr2,int i){ // שאלה 26
        return i == arr.length || arr[i] == arr2[i] && isEqual(arr, arr2, i + 1);
    }

    public static boolean isEqual(int[] arr, int[] arr2){
        return arr.length == arr2.length && isEqual(arr, arr2, 0);
    }




}