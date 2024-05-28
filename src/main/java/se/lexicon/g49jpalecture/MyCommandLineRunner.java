package se.lexicon.g49jpalecture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import se.lexicon.g49jpalecture.entity.Student;
import se.lexicon.g49jpalecture.repository.StudentRepository;

@Component
public class MyCommandLineRunner implements CommandLineRunner {

    @Autowired
    StudentRepository studentRepository;
    @Override
    public void run(String... args) throws Exception {

            studentRepository.save(new Student("Test","Tetsson","test@test.com"));
    }
}
