package com.student.studentapi.controller;

import com.student.studentapi.model.Course;
import com.student.studentapi.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping
    public List<Course> getAll() { return courseService.getAll(); }

    @PostMapping
    public Course add(@RequestBody Course course) { return courseService.add(course); }

    @PutMapping("/{id}")
    public Course update(@PathVariable Long id, @RequestBody Course c) {
        return courseService.update(id, c);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        courseService.delete(id);
        return "Deleted.";
    }
}
