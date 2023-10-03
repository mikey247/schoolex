package com.mikey247.schoolex.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mikey247.schoolex.models.Course;
import com.mikey247.schoolex.services.CourseService;

import lombok.AllArgsConstructor;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@AllArgsConstructor
@RestController
@RequestMapping("/course")
public class CourseController {

    CourseService courseService;

    @PostMapping("/create")
    public ResponseEntity<Course> createCourse( @RequestBody Course course){
        Course newCourse = courseService.createCourse(course);
        return new ResponseEntity<>(newCourse, HttpStatus.CREATED);
    }
    @GetMapping("/{courseId}")
    public ResponseEntity<Course> getCourse(@PathVariable Long courseId){
        Optional<Course> course = courseService.getCourse(courseId);
        return new ResponseEntity<>(course.get(), HttpStatus.OK);

    }

    @GetMapping("/all")
    public ResponseEntity<List<Course>> getCourses (){
        return new ResponseEntity<>(courseService.getCourses(), HttpStatus.OK);
    }

    @DeleteMapping("/{courseId}")
    public ResponseEntity<HttpStatus> deleteCourse(@PathVariable Long courseId){
        courseService.deleteCourse(courseId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{courseId}/student/{studentId}")
    public ResponseEntity<Course> enrolStudent(@PathVariable Long courseId, @PathVariable Long studentId){
        Course course = courseService.addStudent(studentId, courseId);
        return new ResponseEntity<>(course, HttpStatus.OK);
    }
}
