package com.student.studentapi.service;

import com.student.studentapi.model.*;
import com.student.studentapi.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class MarksService {

    @Autowired
    private Marksrepo marksRepository;

    @Autowired
    private Studentrepo studentrepo;

    @Autowired
    private Courserepo courserepo;

    public Marks addMarks(Long studentId, Long courseId, int score) {
        Student student = studentrepo.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found"));
        Course course = courserepo.findById(courseId)
                .orElseThrow(() -> new RuntimeException("Course not found"));

        Marks marks = new Marks(student, course, score);
        return marksRepository.save(marks);
    }

    public Map<String, Object> generateReport(Long studentId) {
        Student student = studentrepo.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        List<Marks> marksList = marksRepository.findByStudent(student);
        if (marksList.isEmpty()) throw new RuntimeException("No marks found");

        int total = 0;
        List<Map<String, Object>> subjects = new ArrayList<>();
        for (Marks m : marksList) {
            total += m.getScore();
            subjects.add(Map.of("course", m.getCourse().getCourseName(), "marks", m.getScore()));
        }

        double percent = total / (double) marksList.size();
        String grade = getGrade(percent);

        return Map.of(
                "student", student.getName(),
                "totalSubjects", marksList.size(),
                "totalMarks", total,
                "percentage", percent,
                "grade", grade,
                "details", subjects
        );
    }

    private String getGrade(double percent) {
        return percent >= 90 ? "S" :
                percent >= 85 ? "A+" :
                        percent >= 80 ? "A" :
                                percent >= 70 ? "B" :
                                        percent >= 60 ? "C" : "F";
    }
}
