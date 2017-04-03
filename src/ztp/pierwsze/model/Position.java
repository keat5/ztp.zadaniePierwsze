package ztp.pierwsze.model;

/**
 * Created by Damian on 2017-03-16.
 */

//
// polimorfizm typów: ograniczeniowy - klasa generyczna
public class Position <T extends Number> {

    private T ns, we;

    public Position(T ns, T we) {
        this.ns = ns;
        this.we = we;
    }

    public void setNs(T ns) {
        this.ns = ns;
    }

    public void setWe(T we) {
        this.we = we;
    }

    public T getNs() {
        return ns;
    }

    public T getWe() {
        return we;
    }

    public String toString() {
        return "(" + ns + " NS, " + we + " WE)";
    }

    // metoda wymagajaca stoworzenia ograniczenia 'T extends Number' typu parametru klasy
    public double countDistance(Position<T> position){
        return Math.sqrt( Math.pow(this.ns.doubleValue() - position.getNs().doubleValue(), 2)
                        + Math.pow(this.we.doubleValue() - position.getWe().doubleValue(), 2));
    }
}
