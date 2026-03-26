package com.example.testq.service.lessons;

import java.util.HashMap;
import java.util.Map;

public class LessonService {
    private Map<Integer, String> lessons = new HashMap<>();
    private int nextId = 1;

    // Create a new lesson
    public int createLesson(String lesson) {
        int id = nextId++;
        lessons.put(id, lesson);
        return id;
    }

    // Retrieve a lesson by ID
    public String getLesson(int id) {
        return lessons.get(id);
    }

    // Update an existing lesson
    public boolean updateLesson(int id, String lesson) {
        if (lessons.containsKey(id)) {
            lessons.put(id, lesson);
            return true;
        }
        return false;
    }
}