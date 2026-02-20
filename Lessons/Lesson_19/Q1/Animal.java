package Lessons.Lesson_19.Q1;

public class Animal {

    protected String name;
    protected int age;
    protected boolean apexPredator;
    protected int caloriesPerMeal;

    public Animal(String name, int age, boolean apexPredator, int caloriesPerMeal) {
        this.name = name;
        this.age = age;
        this.apexPredator = apexPredator;
        this.caloriesPerMeal = caloriesPerMeal;
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

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isApexPredator() {
        return apexPredator;
    }

    public void setApexPredator(boolean apexPredator) {
        this.apexPredator = apexPredator;
    }

    public int getCaloriesPerMeal() {
        return caloriesPerMeal;
    }

    public void setCaloriesPerMeal(int caloriesPerMeal) {
        this.caloriesPerMeal = caloriesPerMeal;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", apexPredator=" + apexPredator +
                ", caloriesPerMeal=" + caloriesPerMeal +
                '}';
    }

    public void dance(){
        System.out.println("animal dance");
    }
    public void sing() {
        System.out.println("animal sing");
    }

    public int eat(){
        return caloriesPerMeal*3;
    }
}
