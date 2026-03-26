package com.example.testq.in.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/quizzes")
public class QuizController {

    // Endpoint to retrieve all quizzes
    @GetMapping
    public List<String> getAllQuizzes() {
        // Implementation to retrieve quizzes from the database or any service goes here
        // For now, returning a simple static response as a placeholder
        return List.of("Quiz 1", "Quiz 2", "Quiz 3");
    }

    // Add more endpoints as needed for specific quiz retrieval, e.g. by ID
}