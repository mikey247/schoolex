package com.mikey247.schoolex.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.mikey247.schoolex.models.Student;
import com.mikey247.schoolex.repositories.StudentRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class StudentService {

    private StudentRepository studentRepository;

    public Student createStudent(Student student){
        studentRepository.save(student);
        return student;
    }

    public Optional<Student> getStudent(Long studentId){
        Optional<Student> student = studentRepository.findById(studentId);
        return student;
    }

    public void deleteStudent(Long studentId){
        studentRepository.deleteById(studentId);
    }
    
}
