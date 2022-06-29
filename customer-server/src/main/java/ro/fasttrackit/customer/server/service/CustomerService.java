package ro.fasttrackit.customer.server.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ro.fasttrackit.customer.server.entity.CustomerEntity;
import ro.fasttrackit.customer.server.model.CustomerFilter;
import ro.fasttrackit.customer.server.repository.CustomerDAO;
import ro.fasttrackit.customer.server.repository.CustomerRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository repository;
    private final CustomerDAO dao;

    public List<CustomerEntity> getAll() {
        return repository.findAll();
    }

    public List<CustomerEntity> getQueries(int age, Pageable pageable) {
//        return repository.findCustom(age, pageable);
        return repository.findSql(age, pageable);
    }

    public List<CustomerEntity> getCriteria(CustomerFilter filter, Pageable pageable) {
        return dao.findByFilter(filter);
    }
}
