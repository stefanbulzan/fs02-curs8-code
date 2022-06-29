package ro.fasttrackit.customer.server.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ro.fasttrackit.customer.server.entity.CustomerEntity;

import java.util.List;

public interface CustomerRepository extends JpaRepository<CustomerEntity, Integer> {

    Page<CustomerEntity> findByAgeLessThan(int age, Pageable pageable);

    //SELECT * from customers where name=:name
    @Query("select c from CustomerEntity c where c.age>:age")
    List<CustomerEntity> findCustom(@Param("age") int age, Pageable pageable);

    @Query(value = "select * from customers where age>:age", nativeQuery = true)
    List<CustomerEntity> findSql(@Param("age") int age, Pageable pageable);
}
