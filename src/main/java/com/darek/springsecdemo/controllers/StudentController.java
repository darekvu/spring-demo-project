package com.darek.springsecdemo.controllers;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {
    List<Student> studentList = new ArrayList<>(
            List.of(
                    new Student(1,"Darek","Java,Python, Javascript"),
                    new Student(2,"Aga","Node Js, Go"),
                    new Student(3,"Patryk","C#")
            )
    );

    @GetMapping("students")
    public List<Student> getStudents(){
        return studentList;
    }

    @PostMapping("students")
    public void getStudents(@RequestBody Student student){
         studentList.add(student);
    }
    @GetMapping("token")
    public CsrfToken getCsrfToken(HttpServletRequest request){
        return (CsrfToken) request.getAttribute("_csrf");
    }
}
