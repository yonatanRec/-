package Lessons.Lesson_19.Q1;

public class Cow extends Mammal {
    protected int litter;

    public Cow(String name, int age, boolean apexPredator, int caloriesPerMeal, int birthMonths, int milkCalories, int litter) {
        super(name, age, apexPredator, caloriesPerMeal, birthMonths, milkCalories);
        this.litter = litter;
    }

    public int getLitter() {
        return litter;
    }

    public void setLitter(int litter) {
        this.litter = litter;
    }

    @Override
    public String toString() {
        return "Cow{" +
                "litter=" + litter +
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
        System.out.println("cow dance");
    }
    @Override
    public void sing() {
        System.out.println("cow sing");
    }

    @Override
    public int eat(){
        return super.eat()/4;
    }
}
