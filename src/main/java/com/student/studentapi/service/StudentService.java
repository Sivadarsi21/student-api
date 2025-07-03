package com.student.studentapi.service;

import com.student.studentapi.model.Student;
import com.student.studentapi.model.Course;
import com.student.studentapi.repository.Studentrepo;
import com.student.studentapi.repository.Courserepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private Studentrepo studentrepo;

    @Autowired
    private Courserepo courserepo;

    public List<Student> getAll() {
        return studentrepo.findAll();
    }

    public Student add(Student student) {
        return studentrepo.save(student);
    }

    public Student update(Long id, Student updated) {
        Student student = studentrepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));
        student.setName(updated.getName());
        student.setEmail(updated.getEmail());
        student.setAge(updated.getAge());
        return studentrepo.save(student);
    }

    public void delete(Long id) {
        studentrepo.deleteById(id);
    }

    public Student assignCourse(Long studentId, Long courseId) {
        Student student = studentrepo.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found"));
        Course course = courserepo.findById(courseId)
                .orElseThrow(() -> new RuntimeException("Course not found"));
        student.getCourses().add(course);
        return studentrepo.save(student);
    }
}
