package Lessons.Lesson_5;
import Other.stack.Stack;

import java.util.Scanner;
public class practice {
    public static Scanner reader = new Scanner(System.in);
    public static void main(String[] args) {

    }

    public static void insertRing(Stack<Ring> s, Ring ring){
        double size = ring.getSize();
        Stack<Ring> temp = new Stack<>();
        boolean stopCheck = false;
        while (!s.isEmpty()){
            Ring r = s.pop();
            double tempSize = r.getSize();
            temp.push(r);
            if (tempSize < size && !stopCheck){
                temp.push(ring);
                stopCheck = true;
            }
        }

        while (!temp.isEmpty())
            s.push(temp.pop());
    }


    public static void game(Stack<Ring> s){
        String color;
        Ring r;
        double size = reader.nextDouble();
        while (size != -999){
            color = reader.next();
            r = new Ring(color, size);
            insertRing(s,r);
            size = reader.nextDouble();
        }
    }

    public static int sharedParts(Stack<DominoBrick> heap, DominoBrick stone){
        boolean isX = false, isY = false;
        while (!heap.isEmpty() && !(isX && isY)){
            DominoBrick db = heap.pop();
            if (db.getX() == stone.getX())
                isX = true;
            if (db.getY() == stone.getY())
                isY = true;
        }
        return isX && isY ? 2 : isX || isY ? 1 : 0;
    }



    public static Stack<Integer> runCouple(Stack<Couple> couples){
        Stack<Integer> result = new Stack<>();
        while (!couples.isEmpty()){
            Couple couple = couples.pop();
            for (int i = 0; i < couple.getAppears(); i++)
                result.push(couple.getNum());
        }
        return sortStack(result);

    }




    public static Stack<Integer> sortStack(Stack<Integer> s) {
        Stack<Integer> temp = new Stack<>();

        while (!s.isEmpty()) {
            int current = s.pop();
            while (!temp.isEmpty() && temp.top() > current) {
                s.push(temp.pop());
            }

            temp.push(current);
        }

        while (!temp.isEmpty()) {
            s.push(temp.pop());
        }

        return s;
    }
}

class Couple{
    private int num;
    private int appears;

    public Couple(int num, int appears) {
        this.num = num;
        this.appears = appears;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getAppears() {
        return appears;
    }

    public void setAppears(int appears) {
        this.appears = appears;
    }
}

class HiTec{
    static Scanner reader = new Scanner(System.in);
    public static void main(String[] args) {

    }

    private Stack<Worker>[] workers;

    public HiTec() {
        workers = new Stack[9];
    }

    public void addWorker(Worker worker, int branch){
        workers[branch-1].push(worker);
    }

    public void cancelWorker(int branch){
        workers[branch-1].pop();
    }

    public void massLayoff(int branch,int count){
        for (int i = 0; i < count && !workers[branch-1].isEmpty(); i++) {
            String firedId = workers[branch-1].pop().getId();
            System.out.print(firedId + ", ");
        }
    }

}

class Worker{
    private String name;
    private String id;


    public Worker(String name, String id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }
}

class DominoBrick{
    private int x;
    private int y;
    public DominoBrick(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }


}

class Ring{
    private String color;
    private double size;

    public Ring(String color, double size) {
        this.color = color;
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }
}