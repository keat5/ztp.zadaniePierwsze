package ztp.pierwsze.abstractSpec;

/**
 * Created by DSERWATA on 05.04.2017.
 */
public abstract class AbstractSpecification<T> implements Specification<T> {

    public abstract boolean isSatisfiedBy(T t);

    public AbstractSpecification<T> or(Specification<T> s) {
        return new OrSpecification<T>(this,s);
    }

    public AbstractSpecification<T> and(Specification<T> s) {
        return new AndSpecification<T>(this,s);
    }

    public AbstractSpecification<T> not() {
        return new NotSpecification<T>(this);
    }

}
