package com.my.app.student;

import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/management/api/v1/students")
public class StudentManagementController {
    private static final List<Student> students = Arrays.asList(
            new Student(1, "Shehroz"),
            new Student(2, "Saad"),
            new Student(3, "Ali")
    );

    @GetMapping
    public List<Student> getStudents() {
        return students;
    }

    @PostMapping
    public void registerNewStudent(@RequestBody Student student) {
        System.out.println(student);
    }

    @DeleteMapping(path = "{studentId}")
    public void deleteStudent(@PathVariable("studentId") Integer studentId) {
        System.out.println(String.format("%s, %s", studentId));
    }

    public void updateStudent(Integer studentId, Student student) {
        System.out.println(String.format("%s, %s", studentId, student));
    }
}
