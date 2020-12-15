package com.hjznb.student.controller;

import com.hjznb.student.entity.Student;
import com.hjznb.student.service.StudentService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping(value = "/student", produces = "application/json")
public class StudentController {
    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    @GetMapping
    public Map<String, Object> findAll() {
        Map<String, Object> map = new HashMap<>();
        List<Student> students = service.findStudents();
        String msg;
        if (students != null) {
            if (students.size() == 0) {
                msg = "学生信息为空！";
            } else msg = "查询成功！";
            map.put("success", true);
        } else {
            msg = "查询失败！";
            map.put("success", false);
        }
        map.put("students", students);
        map.put("msg", msg);
        return map;
    }

    @GetMapping("/{id}")
    public Map<String, Object> findStudent(@PathVariable int id) {
        Student one = service.findOne(id);
        String msg = "不存在该学生！";
        boolean success = false;
        HashMap<String, Object> map = new HashMap<>();

        if (one != null) {
            msg = "查询成功！";
            success = true;
        }
        map.put("entity", one);
        map.put("success", success);
        map.put("msg", msg);

        return map;
    }

    @PostMapping
    public Map<String, Object> addStudent(@RequestBody Student student) {
        Student stu = service.saveStudent(student);
        HashMap<String, Object> map = new HashMap<>();
        String msg = "添加失败！";
        boolean success = false;

        if (stu != null) {
            msg = "添加成功！";
            success = true;
        }

        map.put("msg", msg);
        map.put("success", success);
        map.put("entity", stu);
        return map;
    }

    @PatchMapping(value = "/{id}", consumes = "application/json")
    public Map<String, Object> patchStudent(@PathVariable Integer id, @RequestBody Student student) {
        Student change = service.changeStudent(id, student);
        HashMap<String, Object> map = new HashMap<>();
        String msg = "修改失败!";
        boolean success = false;

        if (change != null) {
            msg = "修改成功";
            success = true;
        }

        map.put("msg", msg);
        map.put("success", success);
        map.put("entity", change);
        return map;
    }

    @DeleteMapping("/{id}")
    public Map<String, Object> deleteStudent(@PathVariable Integer id) {
        HashMap<String, Object> map = new HashMap<>();
        String msg = "删除失败!";
        boolean success = false;
        if (service.deleteOne(id)) {
            msg = "删除成功！";
            success = true;
        }
        map.put("msg", msg);
        map.put("success", success);
        return map;
    }
}
