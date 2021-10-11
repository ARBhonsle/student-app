package com.example.studentapp.controller;

import com.example.studentapp.dto.StudentDTO;
import com.example.studentapp.entity.StudentEntity;
import com.example.studentapp.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class StudentController {
    // CRUD - create read update delete
    // Find by id, first name, rollNo

    @Autowired
    private StudentService studentService;

    private StudentDTO studentDTO;

    @GetMapping(value = "/students/display-list")
    public List<StudentEntity> students() {
        return studentService.students();
    }

    @PostMapping(value = "/students/add-student")
    public StudentEntity addStudent(@RequestBody StudentEntity student) {
        return studentService.addStudent(studentDTO);
    }

    @PutMapping(value = "/students/update-student")
    public StudentEntity updateStudent(@PathVariable int id, @RequestBody StudentEntity student) {
        return studentService.updateStudent(id,studentDTO);
    }

    @DeleteMapping(value = "/students/delete-student")
    public String deleteStudent(@RequestParam int id) {
        return studentService.deleteStudent(id);
    }

    @GetMapping(value = "/students/get-student-by-id")
    public String findStudentById(@RequestParam int id) {
        return studentService.findStudentById(id);
    }

    @GetMapping(value = "/students/get-student-by-fname")
    public String findStudentByFName(@RequestParam String fname) {
        return studentService.findStudentByFname(fname);
    }

    @GetMapping(value = "/students/get-student-by-rollNo")
    public String findStudentByRollNo(@RequestParam int rollNo){
        return studentService.findStudentByRollNo(rollNo);
    }
}
