package Assignments.Assignment_16;

public class Q4 {


    public static void main(String[] args) {
        A[] myArr = new A[4];
        A a1 = new A(1, 2);
        B b1 = new B(10, 20, 30);
        myArr[0] = a1;
        myArr[1] = b1;
        myArr[2] = new B(-10, 20, -30);
        myArr[3] = new B(2, 4, 8);

        for (int i = 0; i < myArr.length; i++) {
            myArr[i].calcMe();
            System.out.println(myArr[i]);
            System.out.println("myArr #" + i + " Sum is: " + myArr[i].getSumIt());
        }
    }



    public static class A{
        protected int a;
        protected int b;
        protected int sumIt;

        public A(int a, int b){
            this.a = a;
            this.b = b;
            sumIt = 0;

        }

        public void calcMe(){
            sumIt = a + b;
        }

        public int getA() {
            return a;
        }

        public void setA(int a) {
            this.a = a;
        }

        public int getB() {
            return b;
        }

        public void setB(int b) {
            this.b = b;
        }

        public int getSumIt(){
            return sumIt;
        }

        @Override
        public String toString(){
            return "A(" +  a + ", " + b + ")";
        }
    }

    public static class B extends A {
        protected int c;

        public B(int a, int b, int c){
            super(a, b);
            this.c = c;
        }

        public int getC() {
            return c;
        }

        public void setC(int c) {
            this.c = c;
        }
        @Override
        public void calcMe(){
            sumIt = a + b + c;
        }

        @Override
        public String toString(){
            return "B(" +  a + ", " + b + "," + c + ")";
        }
    }
}
