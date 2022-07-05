package ro.fasttrackit.customer.server.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.util.List;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.CascadeType.PERSIST;

@Entity
@Table(name = "customers")
@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
public class CustomerEntity {
    @Id
    @GeneratedValue
    private int id;

    private String name;
    @Min(0)
    private int age;

    @OneToOne(cascade = ALL)
    private AddressEntity address;

    @OneToMany(cascade = ALL)
    private List<OrderEntity> orders;

    CustomerEntity() {
    }

    public CustomerEntity(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
