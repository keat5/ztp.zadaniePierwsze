package ztp.pierwsze.model;

/**
 * Created by Damian on 2017-03-15.
 */
public class Dog extends Animal{


    public Dog(String name, Position<Integer> position, Owner owner) {
        super(name, position, owner);
    }

    // polimorfizm inkluzyjny: nadpisywanie metody klasy nadtypu
    public String makeSound(){
        return "Hau";
    }
}
