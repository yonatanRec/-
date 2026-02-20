package Assignments.Assignment_15;

public class Q2 {

    public static void main(String[] args) {
        ClassC c1 = new ClassC(9,0,5);
        System.out.println(c1);
        ClassA[] arr =  new ClassA[4];
        arr[0] = new ClassA(12);
        arr[1] = new ClassB(9,3);
        arr[2] = new ClassC(4,11,2);
        arr[3] = new ClassC(1,8,5);
        arr[3] = (ClassA)arr[2];

        int count = 0;
        for (ClassA a : arr) {
            System.out.println(a);
            if(a.getX() > 6)
                count++;
        }
        System.out.println("1# count is " + count);
        count = 0;
        for (ClassA a : arr) {
            System.out.println(a.Print());
            if(a instanceof ClassB)
                count++;
        }
        System.out.println("2# count is " + count);
    }

    public static class ClassA {
        protected int x;

        public ClassA(int x) {
            this.x = x;
        }
        public int getX() {
            return x;
        }
        @Override
        public String toString() {
            return "ClassA::x = " + this.x;
        }
        public String Print(){
            return "Print ClassA!";
        }
    }

    public static class ClassB extends ClassA {
        protected int y;
        public ClassB(int x, int y) {
            super(x);
            this.y = y;
        }
        @Override
        public String toString() {
            String str = "ClassB::x = " + this.x;
            str += " y = " + this.y;
            return str;
        }
    }

    public static class ClassC extends ClassB {
        protected int z;
        public ClassC(int x, int y, int z) {
            super(x, y);
            this.z = z;
        }

        @Override
        public String toString() {
            String str = "ClassC::x = " + this.x;
            str += " y = " + this.y;
            str += " z = " + this.z;
            return str;
        }

        @Override
        public String Print(){
            return "Print ClassC!";
        }
    }
}
