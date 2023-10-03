package com.mikey247.schoolex.controllers;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mikey247.schoolex.models.Student;
import com.mikey247.schoolex.services.StudentService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/student")
@AllArgsConstructor
public class StudentController {
    StudentService studentService;
    
    @PostMapping("/create")
    public ResponseEntity<Student> createStudent( @RequestBody Student student){
        Student newStudent = studentService.createStudent(student);
        return new ResponseEntity<>(newStudent, HttpStatus.CREATED);
    }

    @GetMapping("/{studentId}")
    public ResponseEntity<Student> getStudent(@PathVariable Long studentId){
        Optional<Student> student = studentService.getStudent(studentId);
        return new ResponseEntity<>(student.get(), HttpStatus.OK);
    }

    @DeleteMapping("/{studentId}")
    public ResponseEntity<HttpStatus> deleteStudent (@PathVariable Long studentId){
        studentService.deleteStudent(studentId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
