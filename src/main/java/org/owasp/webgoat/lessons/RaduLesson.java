package org.owasp.webgoat.lessons;

import org.owasp.webgoat.session.WebSession;
import org.owasp.webgoat.session.Screen;
import java.util.List;

/**
 * A new lesson for WebGoat.
 */
public class RaduLesson extends AbstractLesson {

    @Override
    public String getTitle() {
        return "Radu Lesson";
    }

    @Override
    protected void handleRequest(WebSession session) {
        // Lesson logic goes here
    }

    @Override
    public Category getDefaultCategory() {
        return Category.GENERAL;
    }

    @Override
    public String getInstructions(WebSession session) {
        return "Complete the tasks in this Radu lesson.";
    }

    @Override
    protected List<Screen> getScreens() {
        return List.of(new Screen("RaduLessonScreen", "Radu Lesson Screen"));
    }
}
