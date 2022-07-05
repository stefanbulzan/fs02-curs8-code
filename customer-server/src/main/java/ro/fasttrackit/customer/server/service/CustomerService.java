package ro.fasttrackit.customer.server.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ro.fasttrackit.customer.server.entity.CustomerEntity;
import ro.fasttrackit.customer.server.model.CustomerFilter;
import ro.fasttrackit.customer.server.model.projections.CustomerNameProjection;
import ro.fasttrackit.customer.server.repository.CustomerDAO;
import ro.fasttrackit.customer.server.repository.CustomerRepository;

import java.util.List;

import static ro.fasttrackit.customer.server.repository.CustomerSpecifications.filteredBy;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository repository;
    private final CustomerDAO dao;

    public Page<CustomerEntity> getAll(CustomerFilter filter, Pageable pageable) {
        return repository.findAll(filteredBy(filter), pageable);
    }

    public List<CustomerEntity> getQueries(int age, Pageable pageable) {
//        return repository.findCustom(age, pageable);
        return repository.findSql(age, pageable);
    }

    public List<CustomerEntity> getCriteria(CustomerFilter filter, Pageable pageable) {
        return dao.findByFilter(filter);
    }

    public List<CustomerNameProjection> getProjection(CustomerFilter filter) {
        return repository.findByAgeGreaterThanAndAddressCity(filter.minAge(), filter.city());
    }
}
