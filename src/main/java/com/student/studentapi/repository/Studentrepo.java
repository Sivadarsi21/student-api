package com.student.studentapi.repository;

import com.student.studentapi.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Studentrepo extends JpaRepository<Student, Long> {
}
