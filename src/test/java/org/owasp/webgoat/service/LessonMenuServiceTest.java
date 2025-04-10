package org.owasp.webgoat.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.owasp.webgoat.lessons.model.LessonMenuItem;
import org.owasp.webgoat.session.Course;
import org.owasp.webgoat.session.WebSession;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class LessonMenuServiceTest {

    @InjectMocks
    private LessonMenuService lessonMenuService;

    @Mock
    private HttpSession httpSession;

    @Mock
    private WebSession webSession;

    @Mock
    private Course course;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testShowLeftNav() {
        // Mocking dependencies
        when(httpSession.getAttribute("webSession")).thenReturn(webSession);
        when(webSession.getCourse()).thenReturn(course);

        List<String> categories = List.of("Category1", "Category2");
        when(course.getCategories()).thenReturn(categories);

        // Mock lessons for each category
        List<String> lessons = List.of("Lesson1", "Lesson2");
        when(webSession.getLessons(anyString())).thenReturn(lessons);

        // Call the method under test
        List<LessonMenuItem> menu = lessonMenuService.showLeftNav(httpSession);

        // Assertions
        assertEquals(2, menu.size()); // Two categories
        assertEquals("Category1", menu.get(0).getName());
        assertEquals("Category2", menu.get(1).getName());

        verify(course, times(1)).getCategories();
        verify(webSession, times(2)).getLessons(anyString());
    }
}