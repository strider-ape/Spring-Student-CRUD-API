package com.dip.Spring_Student_CRUD_API.rest;

import com.dip.Spring_Student_CRUD_API.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student> theStudents;

    @PostConstruct
    public void loadData() {

        theStudents = new ArrayList<>();
        theStudents.add(new Student("Dip", "Goswami"));
        theStudents.add(new Student("Jip", "Goswami"));
        theStudents.add(new Student("Pip", "Goswami"));
    }

    @GetMapping("/students/{studentId}")
    public Student getStudents(@PathVariable int studentId) {

        // check the student id against list size
        if(studentId >= theStudents.size() || studentId < 0) {
            throw new StudentNotFoundException("Student ID not found: " + studentId);
        }

        return theStudents.get(studentId);
    }
}
