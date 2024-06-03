package se.lexicon.g49jpalecture.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString(exclude = "createDate")
//Data- for getter, setter, toString, hash&equals

@Entity
public class Student {

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @GeneratedValue(strategy=GenerationType.UUID)
    @Column(updatable = false)
    private String id;

    @Column(nullable = false, length = 100)
    @Setter private String firstName;

    @Column(nullable = false , length = 100)
    @Setter private String lastName;

    @Column(nullable = false ,  unique = true)
    @Setter private String email;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "address_id")
    @Setter private Address address;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "course_id")
    @Setter private Course course;


    @Column
    private boolean status;

    @Column
    private LocalDateTime createDate;

    public Student(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.status = true;
        this.createDate = LocalDateTime.now();
    }

    //Constructor using address
    public Student(String firstName, String lastName, String email, Address address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
        this.status = true;
        this.createDate = LocalDateTime.now();
    }
}
