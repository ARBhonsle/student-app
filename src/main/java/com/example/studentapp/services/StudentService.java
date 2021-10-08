package com.example.studentapp.services;

import com.example.studentapp.entity.StudentEntity;
import com.example.studentapp.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public List<StudentEntity> students() {
        return studentRepository.findAll();
    }

    public StudentEntity addStudent(StudentEntity student) {
        return studentRepository.save(student);
    }

    public StudentEntity updateStudent(StudentEntity student) {
        return studentRepository.save(student);
    }

    public String deleteStudent(int id) {
        Optional<StudentEntity> student = studentRepository.findById(id);
        if (student.isPresent()) {
            studentRepository.delete(student.get());
            return "Record deleted successfully";
        }
        return "Record with given id: " + id + " does not exist";
    }
}
