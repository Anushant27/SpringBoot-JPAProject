package com.example.SpringDataProject1.Student.services;

import com.example.SpringDataProject1.Student.StudentRepository;
import com.example.SpringDataProject1.Student.models.student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentService {

   // public static List<student> studentList;

    private static StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public static List<student> studentList(){
        return studentRepository.findAll();
    }

    public void AddStudent(student Student){
        Optional<student> optionalStudent=studentRepository.findStudentByEmail(Student.getEmail());
        if(optionalStudent.isPresent()){
            throw new IllegalStateException("email is present");
        }
        studentRepository.save(Student);
    }

    public void deleteStudent(Long id) {
        boolean b = studentRepository.existsById(id);
        if(!b){
            throw new IllegalStateException("Student not found");
        }
        studentRepository.deleteById(id);
    }

    @Transactional
    public void updateStudent(Long id, String name, String email) {
        student Student=studentRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("Student is not present"));

        if(name != null && name.length()>0 && !Objects.equals(Student.getName(),name)){
            Student.setName(name);
        }

        if(email != null && email.length()>0 && !Objects.equals(Student.getEmail(),email)){
            Optional<student> OptionalStudent = studentRepository.findStudentByEmail(Student.getEmail());
            if(OptionalStudent.isPresent()){
                throw new IllegalStateException("Email is already present");
            }
            Student.setEmail(email);
        }
    }
}
