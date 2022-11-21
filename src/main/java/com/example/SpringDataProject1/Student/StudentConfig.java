//package com.example.SpringDataProject1.Student;
//
//
//import com.example.SpringDataProject1.Student.models.student;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.time.LocalDate;
//import java.time.Month;
//import java.util.List;
//
//@Configuration
//public class StudentConfig {
//
//    @Bean
//    CommandLineRunner commandLineRunner(StudentRepository repository){
//        return args -> {
//            student anurag = new student(
//                    "Anurag",
//                    "anurag01@gmail.com",
//                    LocalDate.of(2000, Month.JANUARY,8)
//            );
//
//            student anushant = new student(
//                    "Anushant",
//                    "anushant.2k16@gmail.com",
//                    LocalDate.of(2001, Month.JANUARY,8)
//            );
//
//            repository.saveAll(
//                    List.of(anurag,anushant)
//            );
//
//        };
//    }
//}
