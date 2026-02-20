package Lessons.Lesson_19.Q1;

public class Bird extends Animal {
    protected int flightHeight;
    protected int wingspan;

    public Bird(String name, int age, boolean apexPredator, int caloriesPerMeal, int flightHeight, int wingspan) {
        super(name, age, apexPredator, caloriesPerMeal);
        this.flightHeight = flightHeight;
        this.wingspan = wingspan;
    }

    public int getFlightHeight() {
        return flightHeight;
    }

    public void setFlightHeight(int flightHeight) {
        this.flightHeight = flightHeight;
    }

    public int getWingspan() {
        return wingspan;
    }

    public void setWingspan(int wingspan) {
        this.wingspan = wingspan;
    }

    @Override
    public String toString() {
        return "Bird{" +
                "wingspan=" + wingspan +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", apexPredator=" + apexPredator +
                ", caloriesPerMeal=" + caloriesPerMeal +
                ", flightHeight=" + flightHeight +
                '}';
    }
@Override
    public void sing(){
        System.out.println("bird sing");
    }
@Override
    public void dance(){
        System.out.println("bird dance");
    }

    @Override
    public int eat() {
        return super.eat();
    }
}
