package com.example.studentapp.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class StudentDTO {
    private String fname;
    private String lname;
    private int rollNo;
}
