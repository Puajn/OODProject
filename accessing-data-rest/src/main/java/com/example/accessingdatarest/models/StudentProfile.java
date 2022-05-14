package com.example.accessingdatarest.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import java.time.LocalDateTime;

@Data
@Document(collection = "studentProfile")
public class StudentProfile {


    @Id
    private String SUID;
    private String firstName;
    private String lastName;
    @Size(max = 10)
    private String netID;
    @NotBlank
    private EnumDepartment departmentName;
    @Email
    private String email;
    private String phoneNumber;
    private LocalDateTime createdAt;
    public StudentProfile(String firstName, String lastName, String netID, EnumDepartment departmentName, String email, String phoneNumber , LocalDateTime createdAt) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.netID = netID;
        this.departmentName = departmentName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.createdAt = LocalDateTime.now();
    }


}

//@Data
//@Document(collection = "student")
//public class Student {
////    public Student(String firstName, String lastName, String email, String netID, EnumDepartment department, LocalDateTime createdAt) {
////        this.firstName = firstName;
////        this.lastName = lastName;
////        this.email = email;
////        this.netID = netID;
////        this.department = department;
////        this.createdAt = createdAt;
////    }
////    , String email, String netID, EnumDepartment department, LocalDateTime createdAt
//    public Student(String firstName, String lastName,String netID) {
//        this.firstName = firstName;
//        this.lastName = lastName;
////        this.email = email;
//        this.netID = netID;
////        this.department = department;
////        this.createdAt = createdAt;
//    }
//
//    @Id
//    private String SUID;
//    private String firstName;
//    private String lastName;
////    private String email;
//    private String netID;
////    private EnumDepartment department;
////    private LocalDateTime createdAt;
//}