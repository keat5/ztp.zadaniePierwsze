package ztp.pierwsze.abstractSpec;

/**
 * Created by DSERWATA on 04.04.2017.
 */
public interface Specification<T> {
    public boolean isSatisfiedBy(T t);
}
