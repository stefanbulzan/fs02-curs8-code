package ro.fasttrackit.customer.server.loader;

import com.devskiller.jfairy.Fairy;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import ro.fasttrackit.customer.server.entity.*;
import ro.fasttrackit.customer.server.repository.CustomerRepository;
import ro.fasttrackit.customer.server.repository.ProductRepository;
import ro.fasttrackit.customer.server.repository.ReviewRepository;

import java.util.List;
import java.util.stream.IntStream;

@Slf4j
@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {
    private final CustomerRepository repo;
    private final ProductRepository productRepository;
    private final ReviewRepository reviewRepository;

    @Override
    public void run(String... args) {
        Fairy fairy = Fairy.create();


        ProductEntity laptop = productRepository.save(new ProductEntity("laptop"));
        ProductEntity mouse = productRepository.save(new ProductEntity("mouse"));
        ProductEntity monitor = productRepository.save(new ProductEntity("monitor"));

        var savedCustomers = repo.saveAll(IntStream.range(0, 100)
                .mapToObj(index -> fairy.person())
                .map(person -> CustomerEntity.builder()
                        .name(person.getFullName())
                        .age(person.getAge())
                        .address(new AddressEntity(person.getAddress().getStreet(), person.getAddress().getCity()))
                        .orders(List.of(
                                OrderEntity.builder()
                                        .description("order1")
                                        .items(List.of(laptop, monitor))
                                        .build(),
                                OrderEntity.builder()
                                        .description("order2")
                                        .items(List.of(laptop, mouse))
                                        .build()
                        ))
                        .build())
                .toList());

        reviewRepository.saveAll(List.of(
                new ReviewEntity("Foarte bun", savedCustomers.get(0)),
                new ReviewEntity("Mediu. Se poate mai bine", savedCustomers.get(0)),
                new ReviewEntity("Super", savedCustomers.get(0)),
                new ReviewEntity("O experienta pozitiva", savedCustomers.get(3))
        ));

        CustomerEntity customerEntity = savedCustomers.get(0);
        Pageable pageable = Pageable.ofSize(3).withPage(0);
        Page<CustomerEntity> allByNameAndAge = repo.findByAgeLessThan(30, pageable);
        System.out.println(allByNameAndAge);
        log.info("" + allByNameAndAge);
        log.info("");
    }
}