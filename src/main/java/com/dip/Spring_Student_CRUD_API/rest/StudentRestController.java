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

    // adding an exception handlr using @ExceptionHandler
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleExcption(StudentNotFoundException exc) {

        // create a studnet error response
        StudentErrorResponse error = new StudentErrorResponse();

        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMseesage(exc.getMessage());
        error.setTimestamp(System.currentTimeMillis());

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    // adding another exception handler to catch all other exceptions
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(Exception exc) {

        StudentErrorResponse error = new StudentErrorResponse();

        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMseesage(exc.getMessage());
        error.setTimestamp(System.currentTimeMillis());

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

}
