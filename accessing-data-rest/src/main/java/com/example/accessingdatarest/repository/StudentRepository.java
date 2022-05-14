package com.example.accessingdatarest.repository;

import com.example.accessingdatarest.models.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
//import java.util.Optional;
//

//public interface StudentRepository extends MongoRepository<Student,String> {
//    List<Student> findStudentByID(String ID);
//
//}
public interface StudentRepository extends MongoRepository<Student, String> {
    List<Student> findByTitleContaining(String title);
    List<Student> findByPublished(boolean published);
}

