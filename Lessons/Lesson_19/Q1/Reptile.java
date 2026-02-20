package Lessons.Lesson_19.Q1;

public class Reptile extends Animal {
    protected int tailLength;

    public Reptile(String name, int age, boolean apexPredator, int caloriesPerMeal, int tailLength) {
        super(name, age, apexPredator, caloriesPerMeal);
        this.tailLength = tailLength;
    }

    public int getTailLength() {
        return tailLength;
    }

    public void setTailLength(int tailLength) {
        this.tailLength = tailLength;
    }

    @Override
    public String toString() {
        return "Reptile{" +
                "tailLength=" + tailLength +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", apexPredator=" + apexPredator +
                ", caloriesPerMeal=" + caloriesPerMeal +
                '}';
    }

    @Override
    public void dance() {
        System.out.println("reptile dance");
    }
    @Override
    public void sing() {
        System.out.println("reptile sing");
    }

    @Override
    public int eat() {
        return super.eat();
    }
}
