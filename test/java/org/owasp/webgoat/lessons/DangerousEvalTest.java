package org.owasp.webgoat.lessons;

import org.junit.Test;
import static org.junit.Assert.*;

public class DangerousEvalTest {

    @Test
    public void testGetDefaultCategory() {
        DangerousEval lesson = new DangerousEval();
        assertEquals(Category.AJAX_SECURITY, lesson.getDefaultCategory());
    }

    @Test
    public void testCreateContent() {
        DangerousEval lesson = new DangerousEval();
        WebSession session = new WebSession();

        assertNotNull("Content should not be null", lesson.createContent(session));
    }
}