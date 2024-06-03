package se.lexicon.g49jpalecture.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
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


    //Find all students by first name
    @Query("select s from Student s where s.firstName = :firstName")
    List<Student> findAllStudentsByFirstName(@Param("firstName") String name);


    //update a student status to true, finding by id
    @Modifying
    @Query("update Student s set s.status = :true where s.id = : studentId")
    void updateStudentStatusToTrue(@Param("studentId") String id);

    //find student by course id
    List<Student> findByCourse_Id(Long courseId);


    //find student by course name
    List<Student> findByCourse_CourseName(String courseName);

}
