package com.mikey247.schoolex.repositories;

import com.mikey247.schoolex.models.Student;

import org.springframework.data.repository.CrudRepository;


public interface StudentRepository extends CrudRepository<Student,Long> {
    
}
