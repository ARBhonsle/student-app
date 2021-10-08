package com.example.studentapp.controller;

import com.example.studentapp.entity.StudentEntity;
import com.example.studentapp.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
public class StudentController {
// CRUD - create read update delete
    @Autowired
    private StudentService studentService;
//    private StudentRepository studentRepository;

    @GetMapping(value = "/students/display-list")
    public List<StudentEntity> students(){
        return studentService.students();
    }

    @PostMapping(value = "/students/add-student")
    public StudentEntity addStudent(@RequestBody StudentEntity student){
        return studentService.addStudent(student);
    }

    @PutMapping(value = "/students/update-student")
    public StudentEntity updateStudent(@RequestBody StudentEntity student){
        return studentService.updateStudent(student);
    }

    @DeleteMapping(value = "/students/delete-student")
    public String deleteStudent(@RequestParam int id){
        return studentService.deleteStudent(id);
    }

}
