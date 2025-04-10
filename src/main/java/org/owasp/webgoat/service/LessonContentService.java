package org.owasp.webgoat.service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LessonContentService {

    @GetMapping("/api/lesson-content")
    public String getLessonContent() {
        // Replace this with the logic to fetch the content
        return "<p>This is the lesson content.</p>";
    }
}