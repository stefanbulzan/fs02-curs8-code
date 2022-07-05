package ro.fasttrackit.customer.server.repository;

import org.springframework.data.jpa.domain.Specification;
import ro.fasttrackit.customer.server.entity.CustomerEntity;
import ro.fasttrackit.customer.server.model.CustomerFilter;

import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

import static java.util.Optional.ofNullable;

public class CustomerSpecifications {

    public static Specification<CustomerEntity> filteredBy(CustomerFilter filter) {
        return (root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();
            ofNullable(filter.name())
                    .map(names -> cb.like(root.get("name"), "%" + names + "%"))
                    .ifPresent(predicates::add);
            ofNullable(filter.minAge())
                    .map(minAge -> cb.gt(root.get("age"), minAge))
                    .ifPresent(predicates::add);

            ofNullable(filter.city())
                    .map(city -> cb.equal(root.join("address").get("city"), city))
                    .ifPresent(predicates::add);

            return cb.and(predicates.toArray(new Predicate[0]));
        };
    }
}
