package ro.fasttrackit.customer.server.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "products")
@Getter
@Setter
@Builder
@AllArgsConstructor
public class ProductEntity {
    @Id
    @GeneratedValue
    private int id;

    private String name;

    ProductEntity() {
    }

    public ProductEntity(String name) {
        this.name = name;
    }
}
