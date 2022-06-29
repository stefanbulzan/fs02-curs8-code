package ro.fasttrackit.customer.server.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "orders")
@Getter
@Setter
@Builder
@AllArgsConstructor
public class OrderEntity {
    @Id
    @GeneratedValue
    private int id;
    private String description;

    @ManyToMany
    private List<ProductEntity> items;

    OrderEntity() {
    }
}
