package com.student.studentapi.controller;

import com.student.studentapi.model.Student;
import com.student.studentapi.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping
    public List<Student> getAll() { return studentService.getAll(); }

    @PostMapping
    public Student add(@RequestBody Student student) { return studentService.add(student); }

    @PutMapping("/{id}")
    public Student update(@PathVariable Long id, @RequestBody Student s) {
        return studentService.update(id, s);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        studentService.delete(id);
        return "Deleted.";
    }

    @PostMapping("/{sid}/courses/{cid}")
    public Student assign(@PathVariable Long sid, @PathVariable Long cid) {
        return studentService.assignCourse(sid, cid);
    }
}
