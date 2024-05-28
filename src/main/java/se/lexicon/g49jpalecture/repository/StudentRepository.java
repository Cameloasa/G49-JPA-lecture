package se.lexicon.g49jpalecture.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import se.lexicon.g49jpalecture.entity.Student;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, String> {

    //Query methods

    // select * from student where firstName = ?;
    List<Student> findByFirstName(String name);

    //select * from student where lastName = ?
    List<Student> findByLastName(String name);

    //
    Student findByEmailIgnoreCase(String email);

    //Find students by first name containing a keyword
    List<Student> findByFirstNameContaining(String name);

    //select * from student where createDate > ?;
    List<Student> findByCreateDateAfter(LocalDateTime createDate);

    //select * from student where status = 'true';
    List<Student> findByStatusTrue();
}
