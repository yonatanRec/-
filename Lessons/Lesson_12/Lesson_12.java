package Lessons.Lesson_12;
import Other.Helper;
import Other.node.*;

public class Lesson_12 {

    public static int mostThrown(Node<Cube> cubes){
        int[] arr = new int[6];
        while(cubes!=null){
            arr[cubes.getValue().getThrow1() - 1]++;
            arr[cubes.getValue().getThrow2() - 1]++;
            cubes = cubes.getNext();
        }
        int highest = 0;
        int highestPlace = 0;
        for(int i = 0; i < 6; i++){
            if(arr[i] > highest){
                highest = arr[i];
                highestPlace = i;
            }
        }
        return highestPlace + 1;
    }

    public static int countConnectable(Node<Domino> lst, Domino domino){
        int count = 0;
        while(lst!=null){
            if(lst.getValue().isExist(domino.getNum1()) || lst.getValue().isExist(domino.getNum2()))
                count++;
            lst = lst.getNext();
        }
        return count;
    }

    public static Node<Character> fromCharIntToNode(Node<CharInt> lst){
        Node<Character> dummy = new Node<>('b');
        Node<Character> pos = dummy;
        while(lst!=null){
            char ch = lst.getValue().getTav();
            for (int i = 0; i < lst.getValue().getNum(); i++) {
                pos.setNext(new Node<>(ch));
                pos = pos.getNext();
            }
            lst = lst.getNext();
        }
        return dummy.getNext();
    }

}

class Cube{
    private int throw1;
    private int throw2;

    public int getThrow1() {
        return throw1;
    }

    public void setThrow1(int throw1) {
        this.throw1 = throw1;
    }

    public int getThrow2() {
        return throw2;
    }

    public void setThrow2(int throw2) {
        this.throw2 = throw2;
    }

    public Cube() {
        this.throw1 = Helper.numbers.randomNum(1,6);
        this.throw2 = Helper.numbers.randomNum(1,6);
    }
}

class Domino{
    private int num1;
    private int num2;

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

    public Domino(int num1, int num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    public boolean isExist(int num){
        return num == this.num1 || num == this.num2;
    }
}

class CharInt{
    private int num;
    private char tav;

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public char getTav() {
        return tav;
    }

    public void setTav(char tav) {
        this.tav = tav;
    }

    public CharInt(int num, char tav) {
        this.num = num;
        this.tav = tav;
    }
}