package Other.practice;
import Other.Helper;
import Other.stack.*;
public class Recursion {
    public static void main(String[] args) {
        String str = "abc";
    }


    public static class RecursionOnNumbers{
        public static int sumToNum(int n){
            if(n <= 1)
                return 1;
            return n + sumToNum(n-1);
        }

        public static int productToNum(int n){
            if (n%2 == 0)
                n--;
            if(n <= 1)
                return 1;
            return n * productToNum(n-2);
        }

        public static int factorial(int n){
            if (n <= 1)
                return 1;
            return n * factorial(n-1);
        }

        public static int digitCount(int n){
            if (n < 10)
                return 1;
            return 1 + digitCount(n/10);
        }

        public static int sumEvenDigits(int n){
            //return n < 10 ? n % 2 == 0 ? n : sumEvenDigits(n/10) : n % 2 == 0 ? n%10 + sumEvenDigits(n/10) : sumEvenDigits(n/10);
            if (n<10) {
                if (n % 2 == 0)
                    return n;
                return sumEvenDigits(n/10);
            }
            if (n % 2 == 0)
                return n%10 + sumEvenDigits(n/10);
            return sumEvenDigits(n/10);
        }

        public static int majorNumber(int n){
            if (n < 10)
                return n;
            return majorNumber(n/10);
        }

        public static int recursiveDivision(int top, int bottom){
            if (top < bottom)
                return 0;
            return 1 + recursiveDivision(top-bottom, bottom);
        }

        public static int recursiveModulo(int top, int bottom){
            if (top < bottom)
                return top;
            return recursiveModulo(top-bottom, bottom);
        }

        public static boolean inNumber(int num, int digit){
            if (num < 10)
                return num % 10 == digit;
            return inNumber(num/10, digit);
        }

        public static boolean multipleOf(int x, int y){
            if (x == y)
                return true;
            if (x < y)
                return false;
            return multipleOf(x-y,y);
        }

        public static boolean isPrime(int n){
            if (n < 2)
                return false;
            return isPrime(2,n);
        }
        private static boolean isPrime(int curr, int n){
            if (curr > Math.sqrt(n))
                return true;
            if (n%curr == 0)
                return false;
            return isPrime(curr+1, n);
        }

        public static boolean allEvenOrOdd(int n) {
            if (n < 10)
                return true;
            if ((n % 2) != ((n / 10) % 2))
                return false;
            return allEvenOrOdd(n / 10);
        }


        public static boolean sameLength(int x, int y){
            if (x < 10 && y < 10)
                return true;
            if (x < 10 || y < 10)
                return false;
            return sameLength(x / 10, y / 10);
        }
    }

    public static class RecursionOnArithmeticExpressions{
        public static int expression1(int n){
            if (n<=0)
                return 0;
            if(n%2==0)
                return (int) Math.pow(n,2) + expression1(n-1);
            return 2 * n + expression1(n-1);
        }

        public static double expression2(int n){
            if (n<=0)
                return 0;
            if(n%2==0)
                return -Math.sqrt(2*n - 1) + expression2(n-1);
            return 2*n - 1 + expression2(n-1);
        }

        public static int sumMultiplesSmaller(int n1, int n2){
            return sumMultiplesSmaller(n1, n2, n1);
        }
        private static int sumMultiplesSmaller(int n1, int n2, int OG){
            if (n1 >= n2)
                return 0;
            return n1 + sumMultiplesSmaller(n1+OG, n2, OG);
        }

        public static int numPlace(int n){
            if (n <= 1)
                return 0;
            if (n==2)
                return 1;
            return numPlace(0,1,n-2,0);
        }
        private static int numPlace(int x1, int x2, int n, int i){
            if (i == n)
                return x2;
            return numPlace(x2,x1*x1 + x2*x2,n,i+1);
        }

        public static int sumSeries(int n){
            if (n <= 1)
                return 0;
            return numPlace(n) + sumSeries(n-1);
        }
    }

    public static class RecursionOnArrays{
        public static int sumToIndex(int[] arr, int i){
            if (i <= 0)
                return arr[0];
            return arr[i] + sumToIndex(arr, i-1);
        }

        public static int sumFromIndex(int[] arr, int i){
            if (i >= arr.length)
                return 0;
            return arr[i] + sumFromIndex(arr, i+1);
        }

        public static int countPositiveToIndex(int[] arr, int index){
            if (index <= 0)
                return 0;
            if (arr[index] > 0)
                return 1 + countPositiveToIndex(arr, index-1);
            return countPositiveToIndex(arr, index-1);
        }

        public static boolean isSortedUp(int[] arr){
            return isSortedUp(arr, 1);
        }
        private static boolean isSortedUp(int[] arr, int index){
            if(index >= arr.length)
                return true;
            if(arr[index] < arr[index-1])
                return false;
            return isSortedUp(arr, index+1);
        }

        public static int index(int[] arr, int num){
            for (int i = 0; i < arr.length; i++)
                if (arr[i] == num)
                    return i;
            return -1;
        }

        public static boolean isPalindromeRandom(char[] arr){
            int start = Helper.numbers.randomNum(0, arr.length-1);
            int end = Helper.numbers.randomNum(0, arr.length-1);
            System.out.println(start+" "+end);
            return isPalindromeRandom(arr,Math.min(start,end),Math.max(start,end));
        }
        private static boolean isPalindromeRandom(char[] arr, int index, int end){
            if (index >= end)
                return true;
            if (arr[index] != arr[end])
                return false;
            return isPalindromeRandom(arr, index+1, end-1);
        }

        public static boolean isPalindrome(char[] arr){
            return isPalindrome(arr,0,arr.length-1);
        }
        private static boolean isPalindrome(char[] arr, int start, int end){
            if (start >= end)
                return true;
            if (arr[start] != arr[end])
                return false;
            return isPalindrome(arr, start+1, end-1);
        }

        public static boolean hasPalindrome(int[] arr){
            return hasPalindrome(arr,0);
        }
        private static boolean hasPalindrome(int[] arr, int index){
            if (index >= arr.length)
                return false;
            if(RecursionOnNumbers.isPrime(arr[index]))
                return true;
            return hasPalindrome(arr,index+1);
        }

        public static boolean isEqual(int[] arr1, int[] arr2){
            if (arr1.length != arr2.length)
                return false;
            return isEqual(arr1, arr2, 0);
        }
        private static boolean isEqual(int[] arr1, int[] arr2, int index){
            if (index >= arr1.length)
                return true;
            if(arr1[index] != arr2[index])
                return false;
            return isEqual(arr1, arr2, index+1);
        }
    }

    public static class RecursionOnStrings{
        public static int countLowercase(String str){
            return countLowercase(str,0);
        }
        private static int countLowercase(String str,  int index){
            if (index >= str.length())
                return 0;
            if (str.charAt(index) >= 'a' && str.charAt(index) <= 'z')
                return 1 + countLowercase(str, index+1);
            return countLowercase(str, index+1);
        }

        public static boolean allLowerOrUpper(String s) {
            if(countLowercase(s) == s.length())
                return true;
            if (countLowercase(s) > 0 && countLowercase(s) < s.length())
                return false;
            return allUpper(s,0);
        }

        public static boolean allUpper(String s, int index) {
            if(index >= s.length())
                return true;
            if (s.charAt(index) >= 'A' && s.charAt(index) <= 'Z')
                return allUpper(s, index+1);
            return false;
        }

        public static String reverse(String str){
            return reverse(str,str.length()-1);
        }
        private static String reverse(String str, int index){
            if(index < 0)
                return "";
            return str.charAt(index) + reverse(str,index-1);
        }
    }

    public static class RecursionOnStacks{
        public static boolean isEqual(Stack<Integer> stack1, Stack<Integer> stack2){
            if(stack1.isEmpty() && stack2.isEmpty())
                return true;
            if(stack1.isEmpty() || stack2.isEmpty())
                return false;
            if(stack1.pop().equals(stack2.pop()))
                return false;
            return isEqual(stack1, stack2);
        }
    }


}