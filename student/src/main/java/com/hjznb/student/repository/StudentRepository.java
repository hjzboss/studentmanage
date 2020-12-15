package com.hjznb.student.repository;

import com.hjznb.student.entity.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository
        extends CrudRepository<Student, Integer> {

}
