package com.hjznb.student.service;

import com.hjznb.student.entity.Student;

import java.util.List;

public interface StudentService {
    List<Student> findStudents();

    Student findOne(int id);

    Student saveStudent(Student student);

    boolean deleteOne(Integer id);

    Student changeStudent(Integer id, Student student);
}
