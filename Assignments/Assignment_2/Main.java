package Assignments.Assignment_2;
import Other.Main.*;
import java.util.Scanner;

public class Main {

    public static int square_series(int n){
        if(n <= 0)
            return 0;
        if(n % 2 == 0)
            return (int) Math.pow(n,2) + square_series(n-1);
        return n * 2 +  square_series(n - 1);
    }

    public static double sqrt_series(int n){
        if (n <= 0)
            return 0;
        if (((n+1)/2)%2 == 0)
            return Math.sqrt(n) + sqrt_series(n-2);
        return n +  sqrt_series(n-2);
    }

    public static int countPositive(int[] arr, int i){ // שאלה 20
        if(i < 0)
            return 0;
        if(arr[i] > 0)
            return 1 + countPositive(arr, i-1);
        return countPositive(arr, i-1);
    }

    public static boolean isSorted(int[] arr){
        return isSorted(arr, 1);
    }

    public static boolean isSorted(int[] arr, int i){
        if(i >= arr.length-1)
            return true;
        if(arr[i] < arr[i-1])
            return false;
        return isSorted(arr, i + 1);
    }

    public static int findNum(int[] arr, int num){
        return findNum(arr, num, 0);
    }

    public static int findNum(int[] arr, int num, int i){
        if(i == arr.length)
            return -1;
        if(arr[i] == num)
            return i;
        return findNum(arr, num, i+1);
    }

    public static boolean isEqual(int[] arr, int[] arr2){
        if(arr.length != arr2.length)
            return false;
        return  isEqual(arr, arr2, 0);
    }

    public static boolean isEqual(int[] arr, int[] arr2,int i){ // שאלה 26
        if(i == arr.length)
            return true;
        if(arr[i] != arr2[i])
            return false;

        return isEqual(arr, arr2, i+1);
    }

    public static int countAppearance(int[][] matrix, int num){
        return  countAppearance(matrix, num, 0, 0);
    }

    public static int countAppearance(int[][] matrix, int num, int i, int j){
        if (i == matrix.length) return 0;
        if(j == matrix[i].length) return countAppearance(matrix, num, i+1, 0);
        if(matrix[i][j] == num)
            return 1 +  countAppearance(matrix, num, i, j+1);
        return countAppearance(matrix, num, i,j+1);
    }

    public static boolean allNumbersLargerThanNum(int[][] mat, int num){
        return  allNumbersLargerThanNum(mat, num, 0, 0);
    }

    public static boolean allNumbersLargerThanNum(int[][] mat, int num, int i, int j){
        if(i >= mat.length)
            return true;
        if(j >= mat[i].length)
            return allNumbersLargerThanNum(mat, num, i+1, 0);
        if(mat[i][j] > num)
            return false;
        return  allNumbersLargerThanNum(mat, num, i, j+1);
    }

}