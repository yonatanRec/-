package Assignments.Assignment_17;

public class Q9 {

    public static class Animal{
        protected String name;
        protected int age;
        protected boolean predator;
        protected double dailyCalories;

        public Animal(String name, int age, boolean predator, double dailyCalories) {
            this.name = name;
            this.age = age;
            this.predator = predator;
            this.dailyCalories = dailyCalories;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setBirthYear(int age) {
            this.age = age;
        }

        public boolean isPredator() {
            return predator;
        }

        public void setPredator(boolean predator) {
            this.predator = predator;
        }

        public double getDailyCalories() {
            return dailyCalories;
        }

        public void setDailyCalories(double dailyCalories) {
            this.dailyCalories = dailyCalories;
        }

        public void eat(int calories){
            this.dailyCalories += calories;
        }

        @Override
        public String toString() {
            return "Animal{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", predator=" + predator +
                    ", dailyCalories=" + dailyCalories +
                    '}';
        }

        public void speak(){
            System.out.println("i am an Animal");
        }
    }

    public static class Reptile extends Animal{
        protected int eggSize;
        protected int tailSize;

        public Reptile(String name, int age, boolean predator, double dailyCalories, int eggSize, int tailSize) {
            super(name, age, predator, dailyCalories);
            this.eggSize = eggSize;
            this.tailSize = tailSize;
        }

        public int getEggSize() {
            return eggSize;
        }

        public void setEggSize(int eggSize) {
            this.eggSize = eggSize;
        }

        public int getTailSize() {
            return tailSize;
        }

        public void setTailSize(int tailSize) {
            this.tailSize = tailSize;
        }

        @Override
        public String toString() {
            return "Reptile{" +
                    "tailSize=" + tailSize +
                    ", name='" + name + '\'' +
                    ", age=" + age +
                    ", predator=" + predator +
                    ", dailyCalories=" + dailyCalories +
                    ", eggSize=" + eggSize +
                    '}';
        }

        @Override
        public void speak() {
            System.out.println("i am a Reptile");
        }
    }

    public static class Bird extends Animal{
        protected int beakSize;
        protected int wingSpan;

        public Bird(String name, int age, boolean predator, double dailyCalories, int beakSize, int wingSpan) {
            super(name, age, predator, dailyCalories);
            this.beakSize = beakSize;
            this.wingSpan = wingSpan;
        }

        public int getBeakSize() {
            return beakSize;
        }

        public void setBeakSize(int beakSize) {
            this.beakSize = beakSize;
        }

        public int getWingSpan() {
            return wingSpan;
        }

        public void setWingSpan(int wingSpan) {
            this.wingSpan = wingSpan;
        }

        @Override
        public String toString() {
            return "Bird{" +
                    "beakSize=" + beakSize +
                    ", wingSpan=" + wingSpan +
                    ", name='" + name + '\'' +
                    ", age=" + age +
                    ", predator=" + predator +
                    ", dailyCalories=" + dailyCalories +
                    '}';
        }

        @Override
        public void speak() {
            System.out.println("i am a Bird");
        }
    }

    public static class Mammal extends Animal{
        protected int dailyMilk;
        protected int birthMonths;
        protected int caloriesPerLiter;

        public Mammal(String name, int age, boolean predator, double dailyCalories, int dailyMilk, int birthMonths) {
            super(name, age, predator, dailyCalories);
            this.dailyMilk = dailyMilk;
            this.birthMonths = birthMonths;
        }

        public int getDailyMilk() {
            return dailyMilk;
        }

        public void setDailyMilk(int dailyMilk) {
            this.dailyMilk = dailyMilk;
        }

        public int getBirthMonths() {
            return birthMonths;
        }

        public void setBirthMonths(int birthMonths) {
            this.birthMonths = birthMonths;
        }

        @Override
        public String toString() {
            return "Mammal{" +
                    "dailyMilk=" + dailyMilk +
                    ", birthMonths=" + birthMonths +
                    ", name='" + name + '\'' +
                    ", age=" + age +
                    ", predator=" + predator +
                    ", dailyCalories=" + dailyCalories +
                    '}';
        }

        @Override
        public void eat(int calories) {
            this.dailyCalories += caloriesPerLiter*dailyMilk;
        }

        @Override
        public void speak() {
            System.out.println("i am a Mammal");
        }
    }

    public static class Turtle extends Reptile{


        public Turtle(String name, int age, boolean predator, double dailyCalories, int eggSize, int tailSize) {
            super(name, age, predator, dailyCalories, eggSize, tailSize);
        }

        @Override
        public String toString() {
            return "Turtle{" +
                    "eggSize=" + eggSize +
                    ", tailSize=" + tailSize +
                    ", name='" + name + '\'' +
                    ", age=" + age +
                    ", predator=" + predator +
                    ", dailyCalories=" + dailyCalories +
                    '}';
        }

        @Override
        public void speak() {
            System.out.println("i am a Turtle");
        }
    }

    public static class Snake extends Reptile{


        public Snake(String name, int age, boolean predator, double dailyCalories, int eggSize, int tailSize) {
            super(name, age, predator, dailyCalories, eggSize, tailSize);
        }

        @Override
        public String toString() {
            return "Snake{" +
                    "eggSize=" + eggSize +
                    ", tailSize=" + tailSize +
                    ", name='" + name + '\'' +
                    ", age=" + age +
                    ", predator=" + predator +
                    ", dailyCalories=" + dailyCalories +
                    '}';
        }

        @Override
        public void speak(){
            System.out.println("i am a Snake");
        }
    }

    public static class Parrot extends Bird{


        public Parrot(String name, int age, boolean predator, double dailyCalories, int beakSize, int wingSpan) {
            super(name, age, predator, dailyCalories, beakSize, wingSpan);
        }

        @Override
        public String toString() {
            return "Parrot{" +
                    "beakSize=" + beakSize +
                    ", wingSpan=" + wingSpan +
                    ", name='" + name + '\'' +
                    ", age=" + age +
                    ", predator=" + predator +
                    ", dailyCalories=" + dailyCalories +
                    '}';
        }

        @Override
        public void speak() {
            System.out.println("i am a Parrot");
        }
    }

    public static class Peacock extends Bird{

        public Peacock(String name, int age, boolean predator, double dailyCalories, int beakSize, int wingSpan) {
            super(name, age, predator, dailyCalories, beakSize, wingSpan);
        }

        @Override
        public String toString() {
            return "Peacock{" +
                    "beakSize=" + beakSize +
                    ", wingSpan=" + wingSpan +
                    ", name='" + name + '\'' +
                    ", age=" + age +
                    ", predator=" + predator +
                    ", dailyCalories=" + dailyCalories +
                    '}';
        }

        @Override
        public void speak() {
            System.out.println("i am a Peacock");
        }
    }

    public static class Dog extends Mammal{
        protected String type;
        protected String primaryColor;

        public Dog(String name, int age, boolean predator, double dailyCalories, int dailyMilk, int birthMonths, String type, String primaryColor) {
            super(name, age, predator, dailyCalories, dailyMilk, birthMonths);
            this.type = type;
            this.primaryColor = primaryColor;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getPrimaryColor() {
            return primaryColor;
        }

        public void setPrimaryColor(String primaryColor) {
            this.primaryColor = primaryColor;
        }

        @Override
        public String toString() {
            return "Dog{" +
                    "type='" + type + '\'' +
                    ", primaryColor='" + primaryColor + '\'' +
                    ", dailyMilk=" + dailyMilk +
                    ", birthMonths=" + birthMonths +
                    ", name='" + name + '\'' +
                    ", age=" + age +
                    ", predator=" + predator +
                    ", dailyCalories=" + dailyCalories +
                    '}';
        }

        @Override
        public void speak() {
            System.out.println("i am a Dog");
        }
    }

    public static class Whale extends Mammal{
        protected int diveDepth;
        protected int length;

        public Whale(String name, int age, boolean predator, double dailyCalories, int dailyMilk, int birthMonths, int diveDepth, int length) {
            super(name, age, predator, dailyCalories, dailyMilk, birthMonths);
            this.diveDepth = diveDepth;
            this.length = length;
        }

        public int getDiveDepth() {
            return diveDepth;
        }

        public void setDiveDepth(int diveDepth) {
            this.diveDepth = diveDepth;
        }

        public int getLength() {
            return length;
        }

        public void setLength(int length) {
            this.length = length;
        }

        @Override
        public String toString() {
            return "Whale{" +
                    "diveDepth=" + diveDepth +
                    ", length=" + length +
                    ", dailyMilk=" + dailyMilk +
                    ", birthMonths=" + birthMonths +
                    ", name='" + name + '\'' +
                    ", age=" + age +
                    ", predator=" + predator +
                    ", dailyCalories=" + dailyCalories +
                    '}';
        }

        @Override
        public void speak() {
            System.out.println("i am a Whale");
        }
    }

}
