package com.mikey247.schoolex.repositories;

import org.springframework.data.repository.CrudRepository;

import com.mikey247.schoolex.models.Course;

/**
 * CourseRepository
 */
public interface CourseRepository extends CrudRepository<Course, Long> {
 
    
}