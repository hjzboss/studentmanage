package com.hjznb.student.service.impl;

import com.hjznb.student.entity.Student;
import com.hjznb.student.repository.StudentRepository;
import com.hjznb.student.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepository repository;

    public StudentServiceImpl(StudentRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Student> findStudents() {
        Iterable<Student> all = repository.findAll();
        ArrayList<Student> students = new ArrayList<>();
        all.forEach(i -> students.add(i));
        return students;
    }

    @Override
    public Student findOne(int id) {
        Optional<Student> byId = repository.findById(id);
        Student student = null;
        if (byId.isPresent()) {
            student = byId.get();
        }
        return student;
    }

    @Override
    public Student saveStudent(Student student) {
        if (student != null) {
            Student save = repository.save(student);
            return save;
        }

        return null;
    }

    @Override
    public boolean deleteOne(Integer id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        } else return false;
    }

    @Override
    public Student changeStudent(Integer id, Student student) {
        Optional<Student> byId = repository.findById(id);
        if (byId.isPresent()) {
            Student old = byId.get();
            if (student.getAge() != null) {
                old.setAge(student.getAge());
            }
            if (student.getName() != null) {
                old.setName(student.getName());
            }
            if (student.getBir() != null) {
                old.setBir(student.getBir());
            }

            Student save = repository.save(old);
            return save;
        }
        return null;
    }
}
