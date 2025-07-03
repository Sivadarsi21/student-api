package com.student.studentapi.repository;

import com.student.studentapi.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Courserepo extends JpaRepository<Course, Long> {
}
