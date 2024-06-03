package se.lexicon.g49jpalecture.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.web.server.MimeMappings;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor


@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false)
    private Long id;

    @Column(nullable = false)
    private String street;

    @Column
    private String city;

    @Column(nullable = false, length = 6)
    private String zipCode;


    @OneToOne(mappedBy = "address")
    private Student student;

    public Address(String street, String city, String zipCode) {
        this.street = street;
        this.city = city;
        this.zipCode = zipCode;
    }
}
