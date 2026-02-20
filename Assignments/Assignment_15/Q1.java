package Assignments.Assignment_15;

public class Q1 {

    public static void main(String[] args) {
        A a =  new B();
    }

    public static class A{
        public A(){
            System.out.println("A C'tor");
            printMe();
        }

        public void printMe(){
            System.out.println("A Print Me");
        }
    }

    public static class B extends A{
        public B(){
            System.out.println("B C'tor");
            printMe();
        }

        @Override
        public void printMe() {
            System.out.println("B Print Me");
        }
    }
}
