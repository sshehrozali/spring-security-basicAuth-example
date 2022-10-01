package com.my.app.student;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("api/v1")
public class StudentController {
    private static final List<Student> students = Arrays.asList(
            new Student(1, "Shehroz"),
            new Student(2, "Saad"),
            new Student(3, "Ali")
    );

    @GetMapping("/student/{studentId}")
    public Student getStudent(@PathVariable("studentId") Integer studentId) {
        return students.stream()
                .filter(student -> studentId.equals(student.getStudentId()))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Student not found by ID: " + studentId));
    }
}
