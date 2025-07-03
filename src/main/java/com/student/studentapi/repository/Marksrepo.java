package com.student.studentapi.repository;

import com.student.studentapi.model.Marks;
import com.student.studentapi.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Marksrepo extends JpaRepository<Marks, Long> {
    List<Marks> findByStudent(Student student);
}
