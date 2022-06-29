package ro.fasttrackit.customer.server.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "addresses")
@Getter
@Setter
public class AddressEntity {
    @Id
    @GeneratedValue
    private int id;
    private String street;
    private String city;

    AddressEntity() {
    }

    public AddressEntity(String street, String city) {
        this.street = street;
        this.city = city;
    }
}
