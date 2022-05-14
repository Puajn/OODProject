package com.example.accessingdatarest;

import com.example.accessingdatarest.models.Student;
import com.example.accessingdatarest.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
//@EnableMongoRepositories
public class AccessingMongodbDataRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccessingMongodbDataRestApplication.class, args);
	}

//	@Bean
//	CommandLineRunner runner(StudentRepository ss){
//		return args -> {
//		Student student = new Student("Pujan","Prajapai","pprajapa");
//			ss.insert(student);
//		};
//	}

}
