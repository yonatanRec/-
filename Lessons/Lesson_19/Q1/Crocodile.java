package Lessons.Lesson_19.Q1;

public class Crocodile extends Reptile{
    protected boolean dental;

    public Crocodile(String name, int age, boolean apexPredator, int caloriesPerMeal, int tailLength, boolean dental) {
        super(name, age, apexPredator, caloriesPerMeal, tailLength);
        this.dental = dental;
    }

    public boolean isDental() {
        return dental;
    }

    public void setDental(boolean dental) {
        this.dental = dental;
    }

    @Override
    public String toString() {
        return "Crocodile{" +
                "dental=" + dental +
                ", tailLength=" + tailLength +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", apexPredator=" + apexPredator +
                ", caloriesPerMeal=" + caloriesPerMeal +
                '}';
    }

    @Override
    public void dance() {
        System.out.println("crocodile dance");
    }

    @Override
    public void sing() {
        System.out.println("crocodile sing");
    }

    @Override
    public int eat() {
        return super.eat()/10;
    }
}
