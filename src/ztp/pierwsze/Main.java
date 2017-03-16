package ztp.pierwsze;

import ztp.pierwsze.model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static List<Animal> lostAnimals;
    private static Scanner odczyt = new Scanner(System.in);

    public static void main(String[] args) {
        lostAnimals = createLostAnimals();
        System.out.println("Pomóż trafić zwierzętom do właściciala");
        helpAnimals(lostAnimals);
    }

    // polimorfizm typów: parametryczny - klasa generyczna List<>
    private static List<Animal> createLostAnimals(){
        Owner owner = new Owner("Anna Kowalska", new Position<>(0,1));

        List<Animal> animals = new ArrayList<>();

        Animal a1 = new Dog("Reks", new Position<>(2,1), owner);
        Animal a2 = new Dog("Dżeki", new Position<>(-3,-5), owner);
        Animal a3 = new Cat("Mruczek", new Position<>(-1,6), owner);

        animals.add(a1);
        animals.add(a2);
        animals.add(a3);

        return animals;
    }

    private static Animal peekAnimal(){
        System.out.print("Podaj numer zwierzęcia: ");
        int index = odczyt.nextInt();
        odczyt.nextLine();
        return lostAnimals.get(index);
    }

    private static void helpAnimals(List<Animal> animals){
        while(!animals.isEmpty()){
            showLostAnimals(animals);
            Animal animal = peekAnimal();

            while (distanceFromOwner(animal) != 0.0) {
                System.out.println("Odległość od właściciela: " + String.format( "%.2f", distanceFromOwner(animal) ));

                System.out.print("Podaj kierunek ruchu (N, S, W, E): ");
                String directionName = odczyt.nextLine();
                Direction direction = null;
                switch (directionName){
                    case "N": direction = Direction.NORTH; break;
                    case "S": direction = Direction.SOUTH; break;
                    case "W": direction = Direction.WEST; break;
                    case "E": direction = Direction.EAST; break;
                }

                System.out.print("Podaj odległość do przebycia: ");
                int distance = odczyt.nextInt();
                odczyt.nextLine();

                try {
                    animal.move(distance, direction);
                } catch (Exception e) {
                    System.err.println("Błąd przy wykonywaniu ruchu: " + e.getMessage());
                }
            }

            System.out.println(animal.getName() + " znalazł właściciela !!!\n");
            lostAnimals.remove(animal);
        }

        System.out.println("Wszystkie zwierzęta znalazły właścicieli !!!");
    }

    private static void showLostAnimals(List<Animal> animals){
        System.out.println("Zagubione zwierzęta:");
        for (int i = 0; i < animals.size(); i++) {
            if (isLost(animals.get(i))) {
                System.out.println("  " + i + ". " + animals.get(i).getClass().getSimpleName() +
                        " " + animals.get(i).getName() + " - " + animals.get(i).makeSound());
            }
        }
    }

    private static boolean isLost(Animal animal){
        return !animal.getPositon().equals(animal.getOwner().getPosition());
    }

    private static double distanceFromOwner(Animal animal){
        return Math.sqrt(
                Math.pow(animal.getPositon().getNs() - animal.getOwner().getPosition().getNs(),2) +
                Math.pow(animal.getPositon().getWe() - animal.getOwner().getPosition().getWe(),2) );
    }
}
