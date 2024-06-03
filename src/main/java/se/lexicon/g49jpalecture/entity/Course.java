package se.lexicon.g49jpalecture.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

@Entity
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false)
    private Long id;

    @Column(nullable = false , length = 100)
    private String courseName;

    @OneToMany(mappedBy = "Course")
    private Set<Student> students = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "courses_instructors",
            joinColumns = @JoinColumn(name = "course_id"),
            inverseJoinColumns = @JoinColumn(name = "instructor_id")
    )
    private Set<Instructor> instructors = new HashSet<>();

    //Constructor
    public Course(String courseName) {
        this.courseName = courseName;
        instructors = new HashSet<>();
    }



    //Methods for adding and removing students

    public void addStudent(Student student) {
        students.add(student);
        student.setCourse(this);
    }

    public void removeStudent(Student student) {
        students.remove(student);
        student.setCourse(null);
    }
}
