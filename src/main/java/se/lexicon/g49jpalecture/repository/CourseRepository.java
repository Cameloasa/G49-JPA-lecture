package se.lexicon.g49jpalecture.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import se.lexicon.g49jpalecture.entity.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
}
