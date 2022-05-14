package com.example.accessingdatarest.repository;

import com.example.accessingdatarest.models.StudentProfile;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentProfileRepository extends MongoRepository<StudentProfile,String> {
    StudentProfile findStudentProfilesByNetID(String SUID);
    List<StudentProfile> findStudentProfilesByDepartmentName(String Department);
    List<StudentProfile> findStudentProfilesByFirstName(String firstName);

}
////@Repository
//public interface StudentRepository extends MongoRepository<Student,String> {
//    List<Student> findStudentByID(String ID);
//
//}