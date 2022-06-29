package ro.fasttrackit.customer.server.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import ro.fasttrackit.customer.server.entity.CustomerEntity;
import ro.fasttrackit.customer.server.model.CustomerFilter;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

import static java.util.Optional.ofNullable;

@Repository
@RequiredArgsConstructor
public class CustomerDAO {
    private final EntityManager entityManager;

    public List<CustomerEntity> findByFilter(CustomerFilter filter) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<CustomerEntity> criteria = cb.createQuery(CustomerEntity.class);
        Root<CustomerEntity> root = criteria.from(CustomerEntity.class);
        CriteriaQuery<CustomerEntity> query = criteria.select(root);
        List<Predicate> whereCoditions = filterToConditions(cb, root, filter);
        query.where(whereCoditions.toArray(new Predicate[0]));

        return entityManager.createQuery(query).getResultList();
    }

    private List<Predicate> filterToConditions(CriteriaBuilder cb, Root<CustomerEntity> root, CustomerFilter filter) {
        List<Predicate> predicates = new ArrayList<>();
        ofNullable(filter.name())
                .map(names -> cb.like(root.get("name"), "%" + names + "%"))
                .ifPresent(predicates::add);
        ofNullable(filter.minAge())
                .map(minAge -> cb.gt(root.get("age"), minAge))
                .ifPresent(predicates::add);

        return predicates;
    }
}
