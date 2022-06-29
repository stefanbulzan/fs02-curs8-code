package ro.fasttrackit.customer.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.fasttrackit.customer.server.entity.ReviewEntity;

public interface ReviewRepository extends JpaRepository<ReviewEntity, Integer> {
}
