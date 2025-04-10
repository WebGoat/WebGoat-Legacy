package org.owasp.webgoat.lessons;

import org.junit.Test;
import static org.junit.Assert.*;

public class AbstractLessonTest {

    @Test
    public void testGetSolution() {
        AbstractLesson lesson = new BeginnerLesson();
        WebSession session = new WebSession();
        session.setWebgoatContext(new WebgoatContext());
        lesson.setLessonSolutionFileName("testSolution.html");

        String solution = lesson.getSolution(session);
        assertNotNull("Solution should not be null", solution);
    }

    @Test
    public void testSetLessonPlanFileName() {
        AbstractLesson lesson = new BeginnerLesson();
        lesson.setLessonPlanFileName("en", "lessonPlan.html");

        assertEquals("lessonPlan.html", lesson.getLessonPlanFileName("en"));
    }
}