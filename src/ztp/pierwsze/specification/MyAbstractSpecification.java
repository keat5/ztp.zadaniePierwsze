package ztp.pierwsze.specification;

import ztp.pierwsze.abstractSpec.AndSpecification;
import ztp.pierwsze.abstractSpec.NotSpecification;
import ztp.pierwsze.abstractSpec.Specification;

/**
 * Created by DSERWATA on 05.04.2017.
 */
public class MyAbstractSpecification<T> {

        public boolean isSatisfiedBy(T t) {

        }

        public MyAbstractSpecification<T> or(Specification<T> s) {
            return new MyAbstractSpecification<T>();
        }

        public ztp.pierwsze.abstractSpec.AbstractSpecification<T> and(Specification<T> s) {
            return new AndSpecification<T>(this,s);
        }

        public ztp.pierwsze.abstractSpec.AbstractSpecification<T> not() {
            return new NotSpecification<T>(this);
        }

    }


}
