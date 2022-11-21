package com.example.SpringDataProject1.Student.controller;

import com.example.SpringDataProject1.Student.models.student;
import com.example.SpringDataProject1.Student.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@RestController
@RequestMapping("/api/v1/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping
    public List<student> getStudentList() {
        return StudentService.studentList();
    }

    @PostMapping
    public void addstudentdetails(@RequestBody student Student){
        studentService.AddStudent(Student);
    }

    @DeleteMapping("/{id}")
    //pathparam is unique to the api
    public void deleteStudentById(@PathVariable("id") Long id){
        studentService.deleteStudent(id);
    }

    @PutMapping("/{id}")
    public void modifyStudent(@PathVariable("id") Long id,
                                  @RequestParam(required = false) String name,
                                  @RequestParam(required = false) String email){
        studentService.updateStudent(id,name,email);

    }
}
