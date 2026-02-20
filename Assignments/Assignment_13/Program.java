package Assignments.Assignment_13;
import Other.Helper;
import Other.binNode.*;
import Other.Helper.BinNodeHelper.*;
import Other.queue.Queue;
import Other.Date;

import java.util.Scanner;

public class Program {

    public static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        BinNode<Integer> root = new BinNode<>(
                new BinNode<>(null, 2, null),
                1,
                new BinNode<>(
                        new BinNode<>(null, 4, null),
                        3,
                        null
                )
        );

        System.out.println(Q41.findLayer(root,4));
    }

    //Page 209 Q34
    public static class Q34{
        public static void increaseEqual(BinNode<Integer> tree) {
            if (tree == null)
                return;

            // קודם מטפלים בתתי־העצים
            increaseEqual(tree.getLeft());
            increaseEqual(tree.getRight());

            int val = tree.getValue();

            BinNode<Integer> left = tree.getLeft();
            if (left != null && val == left.getValue()) {
                int newVal = val + 1;
                while (exists(left, newVal)) {
                    newVal++;
                }
                left.setValue(newVal);
            }

            BinNode<Integer> right = tree.getRight();
            if (right != null && val == right.getValue()) {
                int newVal = val + 1;
                while (exists(right, newVal)) {
                    newVal++;
                }
                right.setValue(newVal);
            }
        }


        public static <T> boolean exists(BinNode<T> tree, T value){
            if(tree == null)
                return false;
            if(tree.getValue().equals(value))
                return true;
            return exists(tree.getLeft(), value) || exists(tree.getRight(), value);
        }
    }


    //Page 210 Q36
    public static class Q36{

        public static boolean divisorTree(BinNode<Integer> tree, int num) {
            if (tree == null)
                return false;
            int val = tree.getValue();
            if(val != num)
                return false;
            if((!tree.hasLeft() && tree.hasRight()) || (!tree.hasRight() && tree.hasLeft()))
                return false;

            if(!tree.hasLeft() && !tree.hasRight())
                return isPrime(val);

            BinNode<Integer> left = tree.getLeft();
            BinNode<Integer> right = tree.getRight();
            int rightVal = right.getValue();
            int leftVal = left.getValue();
            if(rightVal * leftVal == num)
                return divisorTree(right, rightVal) && divisorTree(left, leftVal);
            return false;
        }


        public static void printPrimeDivisors(BinNode<Integer> tree) {
            if (tree == null)
                return;
            if(!tree.hasLeft() && !tree.hasRight())
                System.out.print(tree.getValue() + " ");
            printPrimeDivisors(tree.getLeft());
            printPrimeDivisors(tree.getRight());
        }


        public static boolean isPrime(int n){
            return Helper.numbers.Primes.isPrime(n);
        }
    }


    //Page 210 Q37
    public static class Q37{
        public static void copyBrothers(BinNode<Integer> tree) {
            if (tree == null)
                return;
            if(!tree.hasLeft() && tree.hasRight())
                tree.setLeft(new BinNode<>(tree.getRight().getValue()));
            if(!tree.hasRight() && tree.hasLeft())
                tree.setRight(new BinNode<>(tree.getLeft().getValue()));
            copyBrothers(tree.getLeft());
            copyBrothers(tree.getRight());
        }
    }


    //Page 213 Q38
    public static class Q38{

        //סיבוכיות זמן הריצה היא O(n) כי היא סורקת את כל האיברים בעץ פעמיים, אבל הפעמיים לא חשובים.

        public static boolean sorted(BinNode<Integer> tree) {
            if (tree == null)
                return false;

            Queue<BinNode<Integer>> nodes = new Queue<>();
            Queue<Integer> q = new Queue<>();

            nodes.insert(tree);

            // level-order
            while (!nodes.isEmpty()) {
                BinNode<Integer> temp = nodes.remove();
                q.insert(temp.getValue());

                if (temp.getLeft() != null)
                    nodes.insert(temp.getLeft());
                if (temp.getRight() != null)
                    nodes.insert(temp.getRight());
            }

            if (q.isEmpty())
                return true;

            int curr = q.remove();
            while (!q.isEmpty()) {
                int next = q.remove();
                if (next < curr) // אם הבא קטן מהנוכחי → לא עולה
                    return false;
                curr = next;
            }

            return true;
        }

    }


    //Page 213 Q39
    public static class Q39{
        public static void printLayer(BinNode<Integer> tree, int layer) {
            if (tree == null)
                return;
            if(layer == 1) {
                System.out.print(tree.getValue() + " ");
                return;
            }
            printLayer(tree.getLeft(), layer - 1);
            printLayer(tree.getRight(), layer - 1);
        }
    }


    //Page 213 Q40
    public static class Q40{
        public static void printEvenLayers(BinNode<Integer> tree) {
            printEvenLayers(tree, 1);
        }
        public static void printEvenLayers(BinNode<Integer> tree, int layer) {
            if (tree == null)
                return;
            if(layer%2 == 0)
                System.out.print(tree.getValue() + " ");
            printEvenLayers(tree.getRight(), layer + 1);
            printEvenLayers(tree.getLeft(), layer + 1);
        }
    }


    //Page 213 Q41
    public static class Q41{
        public static int findLayer(BinNode<Integer> tree, int num) {
            return findLayer(tree, num, 1);
        }

        private static int findLayer(BinNode<Integer> tree, int num, int layer) {
            if (tree == null)
                return 0;
            if (tree.getValue() == num)
                return layer;

            int left = findLayer(tree.getLeft(), num, layer + 1);
            if (left != 0)
                return left;

            return findLayer(tree.getRight(), num, layer + 1);
        }

    }


    //Page 213 Q42
    public static class Q42{
        public static int differenceOfLayers(BinNode<Integer> tree, int num1, int num2) {
            return findLayer(tree, num1) - findLayer(tree, num2);
        }
        public static int findLayer(BinNode<Integer> tree, int num1) {
            return Q41.findLayer(tree, num1);
        }
    }


    //Page 62 Q2
    public static class Q2{



         static class Car{
            protected String creator;
            protected String yearModel;
            protected String plateNumber;
            protected int mileage = 0;
            protected int speed = 0;

            public Car(String creator, String yearModel, String plateNumber) {
                this.creator = creator;
                this.yearModel = yearModel;
                this.plateNumber = plateNumber;
            }

            public Car(Car other) {
                this.creator = other.creator;
                this.yearModel = other.yearModel;
                this.plateNumber = other.plateNumber;
                this.mileage = other.mileage;
                this.speed = other.speed;
            }

            @Override
            public String toString() {
                return "Car{" +
                        "creator='" + creator + '\'' +
                        ", yearModel='" + yearModel + '\'' +
                        ", plateNumber='" + plateNumber + '\'' +
                        ", mileage='" + mileage + '\'' +
                        ", speed=" + speed +
                        '}';
            }

            public String getCreator() {
                return creator;
            }

            public String getYearModel() {
                return yearModel;
            }

            public String getPlateNumber() {
                return plateNumber;
            }

            public int getMileage() {
                return mileage;
            }

            public int getSpeed() {
                return speed;
            }

            public void setSpeed(int speed) {
                this.speed = speed;
            }

            public void accelerate(int speed) {
                this.speed += speed;
            }

            public void decelerate() {
                this.speed -= 10;
            }

            public void updateMileage(int minutes) {
                this.mileage += speed * minutes/60;
            }
        }

        static class ElectricCar extends Car{
            protected int nextBatteryReplacement;

            public ElectricCar(String creator, String yearModel, String plateNumber) {
                super(creator, yearModel, plateNumber);
            }

            public ElectricCar(ElectricCar other) {
                super(other);
                this.nextBatteryReplacement = other.nextBatteryReplacement;
            }

            @Override
            public String toString() {
                return "ElectricCar{" +
                        "nextBatteryReplacement='" + nextBatteryReplacement + '\'' +
                        ", creator='" + creator + '\'' +
                        ", yearModel='" + yearModel + '\'' +
                        ", plateNumber='" + plateNumber + '\'' +
                        ", mileage=" + mileage +
                        ", speed=" + speed +
                        '}';
            }

            public int getNextBatteryReplacement() {
                return nextBatteryReplacement;
            }

            public void replaceBattery() {
                this.nextBatteryReplacement++;
            }
        }

        public static void Main(String[] args) {
             Car car1 = new Car("Toyota", "2011", "123456789");
             Car car2 = new Car("Hyundai", "2023", "987654321");

            System.out.println(car1);
            System.out.println(car2);

            car1.accelerate(input.nextInt());
            for (int i = 0; i < 3; i++) {
                car2.decelerate();
            }

            car1.setSpeed(60);
            car1.updateMileage(90);

            car2.setSpeed(55);
            car2.updateMileage(45);

            System.out.println(car1);
            System.out.println(car2);

            car1.setSpeed(0);
            car2.setSpeed(0);
        }
    }


    //Page 63 Q3
    public static class Q3{
        static class Bike{
            protected String color;
            protected final int maxSpeed = 120;
            protected Double totalMileage;

            public void ride(double distance){}
        }

        static class MountainBike extends Bike{
            protected int maxHeight;
            protected boolean highGear;

            public void setGear(boolean highGear){}
        }

        static class SnowyMountainBike extends MountainBike{

        }

        static class RaceBike extends Bike{
            protected Date lastRepair;
            public void race(double distance, double speed){}
        }

        static class StuntBike extends Bike{
            protected boolean canRace;
            protected double maxJumpHeight;

            public void jump(double height){}
        }
    }


    //Page 64 Q4
    public static class Q4{
        static class A4PhotoAlbum{
            public final double PagePrice = 3;
            public final double PriceSoftBind = 7;
            public final double PriceHardBind = 10;

            protected int pageCount;
            protected double priceNis;
            protected String bindingType;

            public int getPageCount() {
                return this.pageCount;
            }

            public double calcAlbumPrice() {
                double initialPrice = pageCount * PagePrice;
                if(bindingType.equals("Hard"))
                    return initialPrice +  PriceHardBind;
                return initialPrice + PriceSoftBind;
            }

            public A4PhotoAlbum(){
                this.pageCount = 15;
                this.bindingType = "Soft";
            }

            public A4PhotoAlbum(int pageCount, String bindingType){
                this.pageCount = pageCount;
                this.bindingType = bindingType;
            }

        }

        static class A3PhotoAlbum extends A4PhotoAlbum{
            public final int FACTOR = 15;

            public A3PhotoAlbum(){
                super();
            }

            public A3PhotoAlbum(int pageCount, String bindingType){
                super(pageCount, bindingType);
            }

            @Override
            public double calcAlbumPrice() {
                return super.calcAlbumPrice() * (FACTOR + 100)/100;
            }
        }

        static class AlbumTest{
            public static void Main(String[] args){
                A4PhotoAlbum album = new A4PhotoAlbum();
                A4PhotoAlbum album2 = new A4PhotoAlbum(24, "Hard");
                A3PhotoAlbum album3 = new A3PhotoAlbum(17, "Hard");

                System.out.println(album.getPageCount() + album2.getPageCount() + album3.getPageCount());
                System.out.println(album.calcAlbumPrice() + album2.calcAlbumPrice() +  album3.calcAlbumPrice());
            }
        }
    }



}
