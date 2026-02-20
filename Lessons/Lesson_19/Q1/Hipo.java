package Lessons.Lesson_19.Q1;

public class Hipo extends Mammal{
    protected int fatPercentage;

    public Hipo(String name, int age, boolean apexPredator, int caloriesPerMeal, int birthMonths, int milkCalories, int fatPercentage) {
        super(name, age, apexPredator, caloriesPerMeal, birthMonths, milkCalories);
        this.fatPercentage = fatPercentage;
    }

    public int getFatPercentage() {
        return fatPercentage;
    }

    public void setFatPercentage(int fatPercentage) {
        this.fatPercentage = fatPercentage;
    }

    @Override
    public String toString() {
        return "Hipo{" +
                "fatPercentage=" + fatPercentage +
                ", milkCalories=" + milkCalories +
                ", birthMonths=" + birthMonths +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", apexPredator=" + apexPredator +
                ", caloriesPerMeal=" + caloriesPerMeal +
                '}';
    }
    @Override
    public void dance(){
        System.out.println("Hipo dance");
    }

    @Override
    public void sing(){
        System.out.println("hipo sing");
    }
}
