package com.student.studentapi.service;

import com.student.studentapi.model.Course;
import com.student.studentapi.repository.Courserepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    @Autowired
    private Courserepo courserepo;

    public List<Course> getAll() {
        return courserepo.findAll();
    }

    public Course add(Course course) {
        return courserepo.save(course);
    }

    public Course update(Long id, Course updated) {
        Course course = courserepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Course not found"));
        course.setCourseName(updated.getCourseName());
        course.setDescription(updated.getDescription());
        return courserepo.save(course);
    }

    public void delete(Long id) {
        courserepo.deleteById(id);
    }
}
