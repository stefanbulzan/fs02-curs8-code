package ro.fasttrackit.customer.server.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.fasttrackit.customer.server.entity.ReviewEntity;
import ro.fasttrackit.customer.server.service.ReviewService;

import java.util.List;

@RestController
@RequestMapping("reviews")
@RequiredArgsConstructor
public class ReviewController {
    private final ReviewService service;

    @GetMapping
    List<ReviewEntity> getAll() {
        return service.getAll();
    }
}
