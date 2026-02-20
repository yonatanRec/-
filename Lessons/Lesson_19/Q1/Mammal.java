package Lessons.Lesson_19.Q1;

public class Mammal extends Animal {
    protected int milkCalories;
    protected int birthMonths;

    public Mammal(String name, int age, boolean apexPredator, int caloriesPerMeal, int birthMonths, int milkCalories) {
        super(name, age, apexPredator, caloriesPerMeal);
        this.birthMonths = birthMonths;
        this.milkCalories = milkCalories;
    }

    public int getMilkCalories() {
        return milkCalories;
    }

    public void setMilkCalories(int milkCalories) {
        this.milkCalories = milkCalories;
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
                "birthMonths=" + birthMonths +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", apexPredator=" + apexPredator +
                ", caloriesPerMeal=" + caloriesPerMeal +
                ", milkCalories=" + milkCalories +
                '}';
    }
    @Override
    public void dance(){
        System.out.println("mammal dance");
    }
    @Override
    public void sing(){
        System.out.println("mammal sing");
    }

    @Override
    public int eat(){
        return super.eat() + milkCalories;
    }

}
