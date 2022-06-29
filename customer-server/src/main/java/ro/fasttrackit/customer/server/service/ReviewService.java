package ro.fasttrackit.customer.server.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ro.fasttrackit.customer.server.entity.ReviewEntity;
import ro.fasttrackit.customer.server.repository.ReviewRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewService {
    private final ReviewRepository repository;

    public List<ReviewEntity> getAll() {
        return repository.findAll();
    }
}
