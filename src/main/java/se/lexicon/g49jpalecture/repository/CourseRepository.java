package se.lexicon.g49jpalecture.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import se.lexicon.g49jpalecture.entity.Course;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

    //find course by instructor id
    List<Course> findByInstructors_Id(Long instructorId);

    //select * from course c
    // join courses_instructors ci on ci.course_id = c.id
    // join instructor i on i.id= ci.instructor_id where i.id = :instructorId;

    //Find courses by instructor id
    @Query("select c from Course c join Instructor i where i.id = :instructorId")
    List<Course> findCoursesByInstructors_Id(@Param("instructorId") Long instructorId);
}
