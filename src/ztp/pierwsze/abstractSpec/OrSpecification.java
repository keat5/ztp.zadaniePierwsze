package ztp.pierwsze.abstractSpec;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by DSERWATA on 05.04.2017.
 */
public class OrSpecification<T> extends AbstractSpecification<T> {

    private Set<Specification<T>> set = new HashSet<Specification<T>>();

    public OrSpecification(Specification<T> a, Specification<T> b) {
        set.add(a);
        set.add(b);
    }

    public boolean isSatisfiedBy(T t) {
        for( Specification<T> s : set ) {
            if( s.isSatisfiedBy(t) ) {
                return true;
            }
        }
        return false;
    }

    @Override
    public AbstractSpecification<T> or(Specification<T> s) {
        set.add(s);
        return this;
    }

}
