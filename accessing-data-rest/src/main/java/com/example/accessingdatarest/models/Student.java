//package com.example.accessingdatarest.models;
//
//import lombok.Data;
//import org.springframework.data.annotation.Id;
//import org.springframework.data.mongodb.core.mapping.Document;
//
//import java.time.LocalDateTime;
//import java.time.ZonedDateTime;
//
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

package com.example.accessingdatarest.models;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Document(collection = "tutorials")

public class Student {
    @Id
    private String SUID;
    private String title;
    private String description;
    private boolean published;
    public Student() {
    }
    public Student(String title, String description, boolean published) {
        this.title = title;
        this.description = description;
        this.published = published;
    }
    public String getSUID() {
        return SUID;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public boolean isPublished() {
        return published;
    }
    public void setPublished(boolean isPublished) {
        this.published = isPublished;
    }
    @Override
    public String toString() {
        return "Tutorial [id=" + SUID + ", title=" + title + ", desc=" + description + ", published=" + published + "]";
    }
}