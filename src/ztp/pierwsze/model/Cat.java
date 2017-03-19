package ztp.pierwsze.model;

/**
 * Created by Damian on 2017-03-15.
 */
public class Cat extends Animal {

    public Cat(String name, Position<Integer> positon, Owner owner) {
        super(name, positon, owner);
    }

    // polimorfizm inkluzyjny: nadpisywanie metody klasy nadtypu
    public String makeSound(){
        return "Meow";
    }
}
