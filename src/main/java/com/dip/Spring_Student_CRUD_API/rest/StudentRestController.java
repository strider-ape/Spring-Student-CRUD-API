package com.dip.Spring_Student_CRUD_API.rest;

import com.dip.Spring_Student_CRUD_API.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("/students")
    public List<Student> getStudents() {
        return theStudents;
    }
}
