package Lessons.Lesson_19.Q1;

public class Snake extends Reptile{
    protected boolean venomous;

    public Snake(String name, int age, boolean apexPredator, int caloriesPerMeal, int tailLength, boolean venomous) {
        super(name, age, apexPredator, caloriesPerMeal, tailLength);
        this.venomous = venomous;
    }

    public boolean isVenomous() {
        return venomous;
    }

    public void setVenomous(boolean venomous) {
        this.venomous = venomous;
    }

    @Override
    public String toString() {
        return "Snake{" +
                "venomous=" + venomous +
                ", tailLength=" + tailLength +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", apexPredator=" + apexPredator +
                ", caloriesPerMeal=" + caloriesPerMeal +
                '}';
    }
@Override
    public void dance(){
        System.out.println("snake dance");
    }
    @Override
    public void sing(){
        System.out.println("snake sing");
    }
}
