package com.example.studentapp.repository;

import com.example.studentapp.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, Integer> {
    Optional<StudentEntity> findByFname(String fname);

    Optional<StudentEntity> findByRollNo(int rollNo);
}
