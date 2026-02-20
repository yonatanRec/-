package Assignments.Assignment_3;
import Other.Main.*;
public class Main {
    public static void main(String[] args) {
        printSeries(2,3,5);
    }

    public static int countLowerCase(String str) {
        return countLowerCase(str, 0);
    }
    public static int countLowerCase(String str, int i){
        if(i >= str.length())
            return 0;
        if(str.charAt(i) >= 'a'  && str.charAt(i) <= 'z')
            return 1 + countLowerCase(str, i+1);
        return countLowerCase(str, i+1);
    }

    public static boolean allLowerOrUpper(String str) {
        int count = countLowerCase(str);
        if(count == str.length() || count == 0)
            return true;
        return allLowerOrUpper(str, 0);
    }

    public static boolean allLowerOrUpper(String str, int i){
        if(i >= str.length())
            return true;
        char ch = str.charAt(i);
        if(ch < 'A' || ch > 'Z')
            return false;
        return allLowerOrUpper(str, i+1);
    }

    public static void printBetween(char a,  char b){
        char next = (char)(a+1);
        if (next >= b)
            return;
        System.out.print(next);
        printBetween(next, b);
    }

    public static void printSeries(int a1, int d, int parts){
        printSeries(a1, d, parts, 1);
    }

    public static void printSeries(int a1, int d, int parts, int place){
        if (place > parts)
            return;
        System.out.println(a1 + (place-1)*d);
        printSeries(a1,d,parts,place+1);
    }

    public static void printEvenArr(int[] arr){
        printEvenArr(arr, 0);
    }

    public static void printEvenArr(int[] arr, int i){
        if(i >= arr.length)
            return;
        System.out.println(arr[i]);
        printEvenArr(arr, i+2);
    }
}
