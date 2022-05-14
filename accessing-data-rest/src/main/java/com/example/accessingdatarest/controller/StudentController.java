package com.example.accessingdatarest.controller;

import com.example.accessingdatarest.Service.StudentProfileImpl;
import com.example.accessingdatarest.models.Student;
import com.example.accessingdatarest.models.StudentProfile;
//import com.example.accessingdatarest.repository.StudentProfileRepository;
import com.example.accessingdatarest.repository.StudentProfileRepository;
import com.example.accessingdatarest.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.accessingdatarest.models.Student;;
import com.example.accessingdatarest.repository.StudentRepository;
@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class StudentController {
    @Autowired
    private StudentRepository studentRepo;
    @Autowired
    StudentProfileRepository proRepo;
    @Autowired
    StudentProfileImpl studentService;

    @PostMapping("/tutorials")
    public ResponseEntity<Student> createTutorial(@RequestBody Student tutorial) {
        try {
            Student _tutorial = studentRepo.save(new Student(tutorial.getTitle(), tutorial.getDescription(), false));
            return new ResponseEntity<>(_tutorial, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
//Final Code
    @PostMapping("/addStudent")
    public ResponseEntity<StudentProfile> addStudent(@RequestBody StudentProfile student) {
        try {
            System.out.println("Inside"+student.getFirstName()+student.getLastName()+student.getNetID());
            System.out.println("Inserted");
            StudentProfile studentProfile = studentService.insertStudent(student);
            return new ResponseEntity<>(studentProfile, HttpStatus.CREATED);
        } catch (Exception e) {
            System.out.println("Exception");
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/studentProfile/{netid}")
    public ResponseEntity<StudentProfile> getStudentProfileBySUID(@PathVariable("netid") String netid) {
        StudentProfile student = studentService.findByNETID(netid);
        if (student == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(student, HttpStatus.OK);
        }
    }
    @GetMapping("/studentProfileByDepartment/{department}")
    public ResponseEntity<List<StudentProfile>> getStudentProfileByDepartment(@PathVariable("department") String department) {
        List<StudentProfile> studentList = studentService.findByDepartment(department);
        if (studentList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(studentList, HttpStatus.OK);
        }
    }
    @PutMapping("/updateStudentProfile/{suid}")
    public ResponseEntity<StudentProfile> updateTutorial(@PathVariable("suid") String suid, @RequestBody StudentProfile studentPro) {StudentProfile tutorialData = proRepo.findStudentProfilesByNetID(suid);
        StudentProfile student = studentService.updatePhoneNumber(suid,studentPro);
        if (student != null) {
            return new ResponseEntity<>(student, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/tutorials")
    public ResponseEntity<List<StudentProfile>> getAllTutorials(@RequestParam(required = false) String fName) {
        try {
            List<StudentProfile> tutorials = new ArrayList<StudentProfile>();
            if (fName == null)
                proRepo.findAll().forEach(tutorials::add);
            else
                proRepo.findStudentProfilesByFirstName(fName).forEach(tutorials::add);
            if (tutorials.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(tutorials, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/tutorials21")
    public ResponseEntity<List<Student>> getAllTutorials2(@RequestParam(required = false) String title) {
        try {
            List<Student> tutorials = new ArrayList<Student>();
            if (title == null)
                studentRepo.findAll().forEach(tutorials::add);
            else
                studentRepo.findByTitleContaining(title).forEach(tutorials::add);
            if (tutorials.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(tutorials, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/tutorials/{id}")
    public ResponseEntity<Student> getTutorialById(@PathVariable("id") String id) {
        Optional<Student> tutorialData = studentRepo.findById(id);
        if (tutorialData.isPresent()) {
            return new ResponseEntity<>(tutorialData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


//    @PostMapping("/insertStudent")
//    public ResponseEntity<StudentProfile> createTutorial(@RequestBody StudentProfile student) {
//        try {
//            System.out.println("Inside"+student.getFirstName()+student.getLastName()+student.getNetID());
//
//
//            StudentProfile _tutorial = studentProRepo.save(new StudentProfile(student.getFirstName(), student.getLastName(),student.getNetID()));
////            Student _tutorial = stuedntrepo.save(new Student("Pujan", "Prajapati","pprajapa"));
//            System.out.println("Inserted");
//            return new ResponseEntity<>(_tutorial, HttpStatus.CREATED);
//        } catch (Exception e) {
//            System.out.println("Exception");
//            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
}
//@CrossOrigin(origins = "http://localhost:8081")
//@RestController
//public class StudentController {
//    @Autowired
//    StudentRepository stuedntrepo;
//
//    @PostMapping("/insertStudent")
//    public ResponseEntity<Student> createTutorial(@RequestBody Student student) {
//        try {
//            System.out.println("Inside"+student.getFirstName()+student.getLastName()+student.getNetID());
//
//
//            Student _tutorial = stuedntrepo.save(new Student(student.getFirstName(), student.getLastName(),student.getNetID()));
////            Student _tutorial = stuedntrepo.save(new Student("Pujan", "Prajapati","pprajapa"));
//            System.out.println("Inserted");
//            return new ResponseEntity<>(_tutorial, HttpStatus.CREATED);
//        } catch (Exception e) {
//            System.out.println("Exception");
//            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
//    @GetMapping("/findStudentById")
//    public ResponseEntity<List<Student>> getAllTutorials(@RequestParam(required = false) String title) {
//        try {
//            List<Student> tutorials = new ArrayList<>();
//            if (title == null)
//                stuedntrepo.findAll().forEach(tutorials::add);
//            else
//                stuedntrepo.findStudentByID(title).forEach(tutorials::add);
//            if (tutorials.isEmpty()) {
//                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//            }
//            return new ResponseEntity<>(tutorials, HttpStatus.OK);
//        } catch (Exception e) {
//            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }


