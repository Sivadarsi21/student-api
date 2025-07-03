package com.student.studentapi.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Marks {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Student student;

    @ManyToOne
    private Course course;

    private int score;

    public Marks(Student student, Course course, int score) {
        this.student = student;
        this.course = course;
        this.score = score;
    }

}
