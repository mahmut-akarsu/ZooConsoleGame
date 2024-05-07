import org.ietf.jgss.GSSName;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ZooGeneralOperaitons {

    public static List<Animal> animals=new ArrayList<>();

    public ZooGeneralOperaitons() {
        createZoo();
        simulateMovement(1000);
        displayRemainingAnimalCount();
    }

    private void simulateMovement(int remainUnit) {
        Random random = new Random();
        while (remainUnit > 0 && !animals.isEmpty()) {
            for (Animal animal:animals){
                animal.moveRandom();
                remainUnit-=animal.getUnitMovement();
            }
            checkReproduce();
            checkHunt();

        }
    }

    public void createZoo(){
        for (int i=0;i<15;i++){
            animals.add(new Sheep(Position.RandomPositionGenerator(),2,Gender.MALE));
            animals.add(new Sheep(Position.RandomPositionGenerator(),2,Gender.FEMALE));

        }

        for (int i=0;i<5;i++){
            animals.add(new Cow(Position.RandomPositionGenerator(),2,Gender.MALE));
            animals.add(new Cow(Position.RandomPositionGenerator(),2,Gender.FEMALE));
            animals.add(new Wolf(Position.RandomPositionGenerator(),3,Gender.MALE));
            animals.add(new Wolf(Position.RandomPositionGenerator(),3,Gender.FEMALE));
        }

        for (int i=0;i<10;i++){
            animals.add(new Chicken(Position.RandomPositionGenerator(),1));
            animals.add(new Rooster(Position.RandomPositionGenerator(),1));
        }
        for (int i=0;i<4;i++){
            animals.add(new Lion(Position.RandomPositionGenerator(),4,Gender.MALE));
            animals.add(new Lion(Position.RandomPositionGenerator(),4,Gender.FEMALE));
        }
        animals.add(new Hunter(Position.RandomPositionGenerator(),1));
    }
    public static Gender getRandomGender(){
        return Math.random()<0.5 ? Gender.MALE: Gender.FEMALE;
        }

    public boolean distance(Animal animal1,Animal animal2, int targetDistance){
        int X1=animal1.getPosition().getX();
        int Y1=animal1.getPosition().getY();
        int X2=animal2.getPosition().getX();
        int Y2=animal2.getPosition().getY();

        return Math.abs(X1-X2)<=targetDistance || Math.abs(Y1-Y2)<=targetDistance;
    }


    public void checkHunt() {
        List<Animal> removeToAnimals = new ArrayList<>();

        for (int i=0;i<animals.size();i++){
            Animal animal=animals.get(i);
            for (int j=i+1;j<animals.size();j++){
                Animal animal2=animals.get(j);
                if (animal instanceof Hunter && distance(animal, animal2,8)) {
                    removeToAnimals.add(animal2);
                } else if (animal2 instanceof Hunter && distance(animal2, animal,8)) {
                    removeToAnimals.add(animal);
                } else if ((animal instanceof Wolf) && (animal2 instanceof Sheep || animal2 instanceof Chicken || animal2 instanceof Rooster) && distance(animal, animal2,4) ) {
                    removeToAnimals.add(animal2);
                } else if ((animal2 instanceof Wolf) && (animal instanceof Sheep || animal instanceof Chicken || animal instanceof Rooster) && distance(animal2, animal,4)) {
                    removeToAnimals.add(animal);
                } else if ((animal instanceof Lion) && (animal2 instanceof Sheep || animal2 instanceof Cow) && distance(animal, animal2,5) ) {
                    removeToAnimals.add(animal2);
                } else if ((animal2 instanceof Lion) && (animal instanceof Sheep || animal instanceof Cow) && distance(animal2, animal,5) ) {
                    removeToAnimals.add(animal);
                }


            }
        }
        animals.removeAll(removeToAnimals);
    }

    public void checkReproduce(){
        List<Animal> newAnimals = new ArrayList<>();

        for (int i=0; i<animals.size();i++){
            Animal firstAnimal=animals.get(i);
            for (int j=i+1;j<animals.size();j++){
                Animal secondAnimal=animals.get(j);
                if (firstAnimal.getClass().equals(secondAnimal.getClass()) && distance(firstAnimal,secondAnimal,3))
                {
                    if (firstAnimal instanceof Sheep) {
                        newAnimals.add(new Sheep(Position.RandomPositionGenerator(), 2, getRandomGender()));
                    } else if (firstAnimal instanceof Cow) {
                        newAnimals.add(new Cow(Position.RandomPositionGenerator(), 2, getRandomGender()));
                    } else if (firstAnimal instanceof Chicken) {
                        newAnimals.add(new Chicken(Position.RandomPositionGenerator(), 1));
                    } else if (firstAnimal instanceof Rooster) {
                        newAnimals.add(new Rooster(Position.RandomPositionGenerator(), 1));
                    } else if (firstAnimal instanceof Wolf) {
                        newAnimals.add(new Wolf(Position.RandomPositionGenerator(), 3, getRandomGender()));
                    } else if (firstAnimal instanceof Lion) {
                        newAnimals.add(new Lion(Position.RandomPositionGenerator(), 4, getRandomGender()));
                    } else {
                    }
                }
            }
        }


        animals.addAll(newAnimals);
    }
public void displayRemainingAnimalCount(){
        int hunterCount = 0,
                chickenCount = 0,
                lionCount = 0,
                wolfCount = 0,
                roosterCount = 0,
                sheepCount = 0,
                cowCount=0 ;

        for (Animal animal: animals){
            if (animal instanceof Hunter)
                hunterCount++;
            else if (animal instanceof Chicken )
                chickenCount++;
            else if (animal instanceof Lion )
                lionCount++;
            else if (animal instanceof Wolf )
                wolfCount++;
            else if (animal instanceof Rooster )
                roosterCount++;
            else if (animal instanceof Sheep )
                sheepCount++;
            else if (animal instanceof Cow )
                cowCount++;
        }

        System.out.println("Remaining animal counts:");
        System.out.println("Hunter: " + hunterCount);
        System.out.println("Chicken: " + chickenCount);
        System.out.println("Lion: " + lionCount);
        System.out.println("Wolf: " + wolfCount);
        System.out.println("Rooster: " + roosterCount);
        System.out.println("Cow: " + cowCount);
        System.out.println("Sheep: " + sheepCount);
    }





    }



