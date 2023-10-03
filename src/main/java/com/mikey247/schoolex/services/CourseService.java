package com.mikey247.schoolex.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.mikey247.schoolex.models.Course;
import com.mikey247.schoolex.repositories.CourseRepository;
import com.mikey247.schoolex.utility.UtilityFunctions;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CourseService {
    private CourseRepository courseRepository;

    public Course createCourse(Course course){
        return courseRepository.save(course);
    }

    public Optional<Course> getCourse(Long courseId){
        return courseRepository.findById(courseId);
    }

    public List<Course> getCourses(){
        return (List<Course>)courseRepository.findAll();
    }

    public void deleteCourse(Long courseid){
        courseRepository.deleteById(courseid);
    }

    public Course addStudent (Long studentId, Long courseId){
        Course course = UtilityFunctions.unwrapOptional(courseRepository.findById(courseId));
        return course;
    }

}

