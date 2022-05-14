package com.example.accessingdatarest.Service;

import com.example.accessingdatarest.models.StudentProfile;
import com.example.accessingdatarest.repository.StudentProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
@Service
public class StudentProfileImpl {

    @Autowired
    private StudentProfileRepository studentProfileRepository;

    public StudentProfile findByNETID(String netID){
        StudentProfile student = studentProfileRepository.findStudentProfilesByNetID(netID);
        return student;
    }
    public List<StudentProfile> findByDepartment(String department){
        List<StudentProfile> studentList = studentProfileRepository.findStudentProfilesByDepartmentName(department);
        return studentList;
    }
    public StudentProfile insertStudent(StudentProfile studentProfile) {
        StudentProfile student = studentProfileRepository.save(new StudentProfile(studentProfile.getFirstName(), studentProfile.getLastName(), studentProfile.getNetID(),studentProfile.getDepartmentName(),studentProfile.getEmail(),studentProfile.getPhoneNumber(), LocalDateTime.now()));
        return student;
    }
    public StudentProfile updatePhoneNumber(String netID,StudentProfile studentProfile) {
        StudentProfile student = this.findByNETID(netID);
        if (student != null) {
            student.setPhoneNumber(studentProfile.getPhoneNumber());
            studentProfileRepository.save(student);
            return student;
        } else {
            return null;
        }
    }

}
