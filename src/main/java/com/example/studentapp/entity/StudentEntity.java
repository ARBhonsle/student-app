package com.example.studentapp.entity;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class StudentEntity {
    @Id
    private int id;
    private String fName,lName;
    private int rollNo;
}
