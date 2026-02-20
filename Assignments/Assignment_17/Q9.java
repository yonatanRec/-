package Assignments.Assignment_17;

public class Q9 {

    public static class Animal{
        protected String name;
        protected int birthYear;
        protected boolean predator;
        protected double dailyCalories;

        public Animal(String name, int birthYear, boolean predator, double dailyCalories) {
            this.name = name;
            this.birthYear = birthYear;
            this.predator = predator;
            this.dailyCalories = dailyCalories;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getBirthYear() {
            return birthYear;
        }

        public void setBirthYear(int birthYear) {
            this.birthYear = birthYear;
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
    }

    public static class Reptile extends Animal{
        protected int eggSize;
        protected int tailSize;

        public Reptile(String name, int birthYear, boolean predator, double dailyCalories, int eggSize, int tailSize) {
            super(name, birthYear, predator, dailyCalories);
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
    }

    public static class Bird extends Animal{
        protected int beakSize;
        protected int wingSpan;

        public Bird(String name, int birthYear, boolean predator, double dailyCalories, int beakSize, int wingSpan) {
            super(name, birthYear, predator, dailyCalories);
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
    }

    public static class Mammal extends Animal{
        protected int dailyMilk;
        protected int birthMonths;

        public Mammal(String name, int birthYear, boolean predator, double dailyCalories, int dailyMilk, int birthMonths) {
            super(name, birthYear, predator, dailyCalories);
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
    }

    public static class Turtle extends Reptile{


        public Turtle(String name, int birthYear, boolean predator, double dailyCalories, int eggSize, int tailSize) {
            super(name, birthYear, predator, dailyCalories, eggSize, tailSize);
        }
    }

    public static class Snake extends Reptile{


        public Snake(String name, int birthYear, boolean predator, double dailyCalories, int eggSize, int tailSize) {
            super(name, birthYear, predator, dailyCalories, eggSize, tailSize);
        }
    }

    public static class Parrot extends Bird{


        public Parrot(String name, int birthYear, boolean predator, double dailyCalories, int beakSize, int wingSpan) {
            super(name, birthYear, predator, dailyCalories, beakSize, wingSpan);
        }
    }

    public static class Peacock extends Bird{

        public Peacock(String name, int birthYear, boolean predator, double dailyCalories, int beakSize, int wingSpan) {
            super(name, birthYear, predator, dailyCalories, beakSize, wingSpan);
        }
    }

    public static class Dog extends Mammal{
        protected String type;
        protected String primaryColor;

        public Dog(String name, int birthYear, boolean predator, double dailyCalories, int dailyMilk, int birthMonths, String type, String primaryColor) {
            super(name, birthYear, predator, dailyCalories, dailyMilk, birthMonths);
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
    }

    public static class Whale extends Mammal{
        protected int diveDepth;
        protected int length;

        public Whale(String name, int birthYear, boolean predator, double dailyCalories, int dailyMilk, int birthMonths, int diveDepth, int length) {
            super(name, birthYear, predator, dailyCalories, dailyMilk, birthMonths);
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
    }

}
