package ro.fasttrackit.customer.server.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ro.fasttrackit.customer.server.entity.CustomerEntity;
import ro.fasttrackit.customer.server.model.CustomerFilter;
import ro.fasttrackit.customer.server.model.projections.CustomerNameProjection;
import ro.fasttrackit.customer.server.service.CustomerService;

import java.util.List;

@RestController
@RequestMapping("customers")
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService service;

    @GetMapping
    Page<CustomerEntity> getAll(CustomerFilter filter, Pageable pageable) {
        return service.getAll(filter, pageable);
    }

    @GetMapping("projection")
    List<CustomerNameProjection> getProjection(CustomerFilter filter){
        return service.getProjection(filter);
    }

    @GetMapping("/queries")
    List<CustomerEntity> getQueries(@RequestParam int age, Pageable pageable) {
        return service.getQueries(age, pageable);
    }

    @GetMapping("criteria")
    List<CustomerEntity> getCriteria(CustomerFilter filter, Pageable pageable){
        return service.getCriteria(filter, pageable);
    }
}
