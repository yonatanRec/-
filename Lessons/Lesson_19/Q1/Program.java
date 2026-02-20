package Lessons.Lesson_19.Q1;

public class Program {



    public static int sumCalories(Animal[] animals){
        int sum = 0;
        for (Animal animal : animals){
            sum += animal.eat();
        }
        return sum;
    }


    public static void birdSing(Animal[] animals){
        for (Animal animal : animals){
            if(animal instanceof Bird)
                animal.sing();
        }
    }

    public static void letsDance(Animal[] animals){
        for (Animal animal : animals){
            if (animal instanceof Snake || animal instanceof Bird)
                animal.dance();
        }
    }


    public static String getFattest(Animal[] animals){
        int highestPercent = 0;
        String fattest = "";
        for (Animal animal : animals){
            if(animal instanceof Hipo)
                if(((Hipo)animal).getFatPercentage() > highestPercent)
                    fattest = animal.getName();
        }
        return fattest;
    }
}
