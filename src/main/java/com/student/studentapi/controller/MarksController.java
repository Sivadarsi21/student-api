package com.student.studentapi.controller;

import com.student.studentapi.model.Marks;
import com.student.studentapi.service.MarksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/marks")
public class MarksController {

    @Autowired
    private MarksService marksService;

    @PostMapping("/add")
    public Marks addMarks(@RequestParam Long studentId, @RequestParam Long courseId, @RequestParam int score) {
        return marksService.addMarks(studentId, courseId, score);
    }

    @GetMapping("/report/{studentId}")
    public Map<String, Object> getReport(@PathVariable Long studentId) {
        return marksService.generateReport(studentId);
    }
}
