package com.agul.studentswebservice.dao;

import com.agul.studentswebservice.model.Student;
//import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.stream.Stream;

public interface StudentRepository extends CrudRepository<Student, Long> {

    Stream<Student> findByName(String name);

    Stream<Student> findByNameRegex(String regex);

    long countByName(String name);


}
