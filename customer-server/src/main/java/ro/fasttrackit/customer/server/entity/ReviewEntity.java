package ro.fasttrackit.customer.server.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "reviews")
@Getter
@Setter
public class ReviewEntity {
    @Id
    @GeneratedValue
    private int id;

    private String message;
    @ManyToOne
    private CustomerEntity customer;

    ReviewEntity() {
    }

    public ReviewEntity(String message, CustomerEntity customer) {
        this.message = message;
        this.customer = customer;
    }
}
