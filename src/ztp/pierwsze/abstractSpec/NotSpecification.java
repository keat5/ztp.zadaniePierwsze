package ztp.pierwsze.abstractSpec;

/**
 * Created by DSERWATA on 05.04.2017.
 */

public class NotSpecification<T> extends AbstractSpecification<T> {

    private Specification<T> spec;

    public NotSpecification(Specification<T> s) {
        this.spec=s;
    }

    @Override
    public boolean isSatisfiedBy(T t) {
        return !spec.isSatisfiedBy(t);
    }

}
