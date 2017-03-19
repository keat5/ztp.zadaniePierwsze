package ztp.pierwsze.model;

/**
 * Created by Damian on 2017-03-15.
 */
public class Owner {

    String name;
    Position<Integer> position;

    public Owner(String name, Position<Integer> position) {
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Position<Integer> getPosition() {
        return position;
    }

    public void setPosition(Position<Integer> position) {
        this.position = position;
    }
}
