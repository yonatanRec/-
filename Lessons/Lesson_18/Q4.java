package Lessons.Lesson_18;

public class Q4 {



    public static class A{
        protected int a;
        protected int b;
        protected int sumIt;

        public A(int a, int b){
            this.a = a;
            this.b = b;
            sumIt = 0;

        }

        public void calc(){
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

    public static class B extends A{
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

        public void calc(){
            sumIt = a + b + c;
        }

        @Override
        public String toString(){
            return "B(" +  a + ", " + b + "," + c + ")";
        }
    }
}
