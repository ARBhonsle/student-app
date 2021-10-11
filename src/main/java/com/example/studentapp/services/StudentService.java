package com.example.studentapp.services;

import com.example.studentapp.dto.StudentDTO;
import com.example.studentapp.entity.StudentEntity;
import com.example.studentapp.repository.StudentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public List<StudentEntity> students() {
        return studentRepository.findAll();
    }

    public StudentEntity addStudent(StudentDTO studentDTO) {
        StudentEntity student = new StudentEntity();
        student.setFname(studentDTO.getFname());
        student.setLname(studentDTO.getLname());
        student.setRollNo(studentDTO.getRollNo());
        return studentRepository.save(student);
    }

    public StudentEntity updateStudent(int id,StudentDTO studentDTO) {
        Optional<StudentEntity> optionalStudentEntity = studentRepository.findById(id);
        if(optionalStudentEntity.isPresent()) {
            StudentEntity studentEntity = optionalStudentEntity.get();
            studentEntity.setFname(studentDTO.getFname());
            studentEntity.setLname(studentDTO.getLname());
            studentEntity.setRollNo(studentDTO.getRollNo());
            return studentRepository.save(studentEntity);
        }
        return this.addStudent(studentDTO);
    }

    public String deleteStudent(int id) {
        Optional<StudentEntity> student = studentRepository.findById(id);
        if (student.isPresent()) {
            studentRepository.delete(student.get());
            return "Record deleted successfully";
        }

        return "Record with given id: " + id + " does not exist";
    }

    public String findStudentById(int id) {
        Optional<StudentEntity> student = studentRepository.findById(id);
        if (student.isPresent()) {
            student.get();
            return "Found Student record with this id:" + id;
        }
        return "Cannot find Record with this id: " + id;
    }

    public String findStudentByFname(String fname) {
        Optional<StudentEntity> student = studentRepository.findByFname(fname);
        if (student.isPresent()) {
            student.get();
            return "Found Student record with this first name:" + fname;
        }
        return "Cannot find Record with this first name: " + fname;
    }

    public String findStudentByRollNo(int rollNo){
        Optional<StudentEntity> student = studentRepository.findByRollNo(rollNo);
        if (student.isPresent()) {
            student.get();
            return "Found Student record with this rollNo:" + rollNo;
        }
        return "Cannot find Record with this first rollNo: " + rollNo;
    }
}
