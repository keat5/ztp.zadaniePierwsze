package ztp.pierwsze.model;

/**
 * Created by Damian on 2017-03-15.
 */
public class Animal {

    String name;
    Position<Integer> positon;
    Direction direction = Direction.NORTH;
    Owner owner;

    public Animal(String name, Position<Integer> positon, Owner owner) {
        this.owner = owner;
        this.name = name;
        this.positon = positon;
    }

    public String makeSound() {
        return "Grr";
    }

    public void move(int distance) {
        // do zamiany na case
        // polimorfizm ad-hoc: koercja - opakowanie typu pierwotnego int klasą Integer
        if(this.direction.equals(Direction.NORTH))  positon.setNs(positon.getNs() + new Integer(distance));
        else if(this.direction.equals(Direction.SOUTH)) positon.setNs(positon.getNs() - new Integer(distance));
        else if(this.direction.equals(Direction.WEST)) positon.setWe(positon.getWe() + new Integer(distance));
        else if(this.direction.equals(Direction.EAST)) positon.setWe(positon.getWe() - new Integer(distance));
    }

    // polimorfizm ad-hoc: przeciążanie - overloading metody z inną listą parametrów
    public void move(int distance, Direction direction) {
        this.direction = direction;
        move(distance);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Position<Integer> getPositon() {
        return positon;
    }

    public void setPositon(Position<Integer> positon) {
        this.positon = positon;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }


}
