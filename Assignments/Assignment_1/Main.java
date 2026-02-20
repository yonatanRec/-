package Assignments.Assignment_1;
import java.util.Scanner;
public class Main {
    public static Scanner reader = new Scanner(System.in);

    public static void main(String[] args) {
    }

    public static int sumTo_n(int n){ // Question 1
        if (n == 0)
            return n;
        return n + sumTo_n(n-1);
    }

    public static int odd_product(int n){ // Question 2
        if(n <= 0)
            return  1;
        if (n%2 == 0)
            n-=1;
        return n * odd_product(n-2);
    }

    public static int factorial(int n){ // Question 3
        if (n == 1)
            return 1;
        return n * factorial(n-1);
    }

    public static int numDigits(int n){ // Question 4
        if (n<10)
            return 1;
        return  numDigits(n/10)+1;
    }

    public static int sumEvenNumbers(int n){ // Question 5
        if (n==0)
            return 0;
        if (n%2 == 0)
            return n%10 + sumEvenNumbers(n/10);
        return sumEvenNumbers(n/10);
    }

    public static int returnFirstDigit(int n){ // Question 6
        if (n<10)
            return n;
        return returnFirstDigit(n/10);
    }

    public static int divisionBySubtraction(int a, int b){ // Question 7
        System.out.println(a + "\t" + b);
        if (a<b)
            return 0;
        return 1 + divisionBySubtraction(a-b,b);
    }

    public static int moduloBySubtraction(int a, int b){ // Question 8
        if (b>a)
            return a;
        return  moduloBySubtraction(a-b,b);
    }

    public static boolean digitInNum(int num, int digit){ // Question 9
        if(num == 0)
            return false;
        if (num%10 == digit)
            return true;
        return  digitInNum(num/10, digit);
    }

    public static boolean XDivisibleByY(int x, int y){ // Question 10
        if (x<y)
            return false;
        if (x==y)
            return true;
        return XDivisibleByY(x-y,y);
    }

    public static void printEven(int n){ // Question 37
        if (n == 0)
            return;
        if (n%2==0)
            System.out.print(n%10);
        printEven(n/10);
    }

    public static void printDigits(int n){ // Question 38
        if (n==0)
            return;
        printDigits(n/10);
        System.out.println(n%10);

    }


}
