package Lessons.Lesson_19.Q1;

import Other.node.*;

public class Park {
    private Animal[] animals;
    private int current;
    public Park(){
        animals = new Animal[100];
        current = 0;
    }

    public void addAnimal(Animal animal){
        animals[current] = animal;
        current++;
    }

    public Animal[] getSpecificAnimals(){
        int count = 0;
        for (int i = 0; i<current; i++) {
            Animal animal = animals[i];
            if(animal.isApexPredator() && animal.getAge() > 10)
                count++;
        }

        Animal[] specificAnimals = new Animal[count];
        int index = 0;
        for (int i = 0; i<current; i++) {
            Animal animal = animals[i];
            if(animal.isApexPredator() && animal.getAge() > 10)
                specificAnimals[index++] = animal;
        }

        return specificAnimals;
    }


    public int countApexBirdsAndReptiles(){
        int count = 0;
        for (int i = 0; i<current; i++) {
            Animal animal = animals[i];
            if(animal.isApexPredator()){
                if(animal instanceof Bird){
                    count++;
                }
                else if(animal instanceof Reptile){
                    count++;
                }
            }
        }
        return count;
    }

    public Node<Animal> superPredator(){
        Node<Animal> superPredator = new Node<>();
        Node<Animal> pos = superPredator;
        for (int i = 0; i<current; i++) {
            Animal animal = animals[i];
            if(animal.isApexPredator() && animal.getAge() > 10){
                pos.setValue(animal);
                pos = pos.getNext();
            }
        }
        return superPredator;
    }

    public int countPredators(){
        int count = 0;
        for (int i = 0; i<current; i++) {
            Animal animal = animals[i];
            if(animal.isApexPredator()){
                if(animal instanceof Bird){
                    count++;
                }
                else if(animal instanceof Reptile){
                    count++;
                }
            }
        }
        return count;
    }

}
