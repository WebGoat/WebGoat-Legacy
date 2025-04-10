package org.owasp.webgoat.lessons;

import org.junit.Test;
import static org.junit.Assert.*;
import org.owasp.webgoat.session.WebSession;
import org.owasp.webgoat.service.SolutionService;

public class IntegrationTest {

    @Test
    public void testLessonSolutionIntegration() {
        // Initialize components
        WebSession session = new WebSession();
        SolutionService solutionService = new SolutionService();
        AbstractLesson lesson = new DangerousEval();

        // Set up lesson and session
        session.setWebgoatContext(new WebgoatContext());
        lesson.setLessonSolutionFileName("testSolution.html");

        // Simulate interaction
        String solution = solutionService.getSolution(lesson, session);

        // Validate integration
        assertNotNull("Solution should not be null", solution);
        assertTrue("Solution should contain expected content", solution.contains("Expected Content"));
    }

    @Test
    public void testSessionAndLessonInteraction() {
        // Initialize components
        WebSession session = new WebSession();
        AbstractLesson lesson = new DangerousEval();

        // Simulate session and lesson interaction
        session.setCurrentLesson(lesson);
        AbstractLesson currentLesson = session.getCurrentLesson();

        // Validate interaction
        assertNotNull("Current lesson should not be null", currentLesson);
        assertEquals("Lesson should match the one set in session", lesson, currentLesson);
    }
}