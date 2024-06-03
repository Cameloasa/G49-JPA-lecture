package se.lexicon.g49jpalecture.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import se.lexicon.g49jpalecture.entity.Instructor;

@Repository
public interface InstructorRepository extends JpaRepository<Instructor, Long> {
}
