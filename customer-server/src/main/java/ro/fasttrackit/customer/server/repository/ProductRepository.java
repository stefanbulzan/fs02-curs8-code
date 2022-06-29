package ro.fasttrackit.customer.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.fasttrackit.customer.server.entity.ProductEntity;

public interface ProductRepository extends JpaRepository<ProductEntity, Integer> {
}
