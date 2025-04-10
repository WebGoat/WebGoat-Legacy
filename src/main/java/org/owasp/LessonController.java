package org.owasp;

import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/api/lessons")
public class LessonController {

    // Example in-memory lesson store
    private Map<Integer, String> lessons = new HashMap<>();

    // Get all lessons
    @GetMapping
    public List<String> getAllLessons() {
        return new ArrayList<>(lessons.values());
    }

    // Get a lesson by ID
    @GetMapping("/{id}")
    public String getLessonById(@PathVariable int id) {
        return lessons.getOrDefault(id, "Lesson not found");
    }

    // Create a new lesson
    @PostMapping
    public String createLesson(@RequestParam String title) {
        int id = lessons.size() + 1;
        lessons.put(id, title);
        return "Lesson created with ID: " + id;
    }

    // Update an existing lesson
    @PutMapping("/{id}")
    public String updateLesson(@PathVariable int id, @RequestParam String title) {
        if (lessons.containsKey(id)) {
            lessons.put(id, title);
            return "Lesson updated";
        } else {
            return "Lesson not found";
        }
    }

    // Delete a lesson
    @DeleteMapping("/{id}")
    public String deleteLesson(@PathVariable int id) {
        if (lessons.containsKey(id)) {
            lessons.remove(id);
            return "Lesson deleted";
        } else {
            return "Lesson not found";
        }
    }
}