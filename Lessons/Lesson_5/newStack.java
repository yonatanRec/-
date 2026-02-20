package Lessons.Lesson_5;

public class newStack {
    public static void main(String[] args) {
        MyStack<Integer> stack = new MyStack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(0);
        stack.push(4);
        for (int i = 1; i <= 6; i++) {
            System.out.println(stack.pop());
        }
    }
}

class MyStack<T>{
    private T[] arr;
    private int lp=0;

    public MyStack(){
        arr = (T[]) new Object[100];
    }
    public boolean isEmpty(){
        return lp == 0;
    }

    public void checkCrash(){
        if (!isEmpty())
            return;
        System.out.println("Error");
        System.out.println(arr[-1]);
    }

    public void push(T num) {
        for (int i = lp; i > 0; i--)
            arr[i] = arr[i - 1];
        arr[0] = num;
        lp++;
    }

    public T top(){
        checkCrash();
        return arr[0];
    }

    public T pop(){
        checkCrash();
        T num = arr[0];
        for (int i = 0; i < lp - 1; i++)
            arr[i] = arr[i + 1];
        lp--;
        return num;
    }

    public String toString(){
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < lp; i++) {
            str.append(arr[i]);
            str.append(" ");
        }
        return str.toString().trim();
    }
}