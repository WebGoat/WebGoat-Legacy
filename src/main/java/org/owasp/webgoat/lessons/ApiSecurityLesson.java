package org.owasp.webgoat.lessons;

import org.owasp.webgoat.session.WebSession;
import org.owasp.webgoat.session.AbstractLesson;
import org.owasp.webgoat.session.Category;
import org.owasp.webgoat.session.LessonTracker;
import org.owasp.webgoat.session.Screen;

/**
 * API Security Lesson
 *
 * This lesson demonstrates common API security vulnerabilities and how to mitigate them.
 */
public class ApiSecurityLesson extends AbstractLesson {

    @Override
    protected Category getDefaultCategory() {
        return Category.SECURITY;
    }

    @Override
    protected Integer getDefaultRanking() {
        return 100;
    }

    @Override
    public String getTitle() {
        return "API Security";
    }

    @Override
    public String getInstructions(WebSession session) {
        return "In this lesson, you will learn about common API security vulnerabilities, such as improper authentication, excessive data exposure, and lack of rate limiting. Follow the steps to identify and mitigate these issues.";
    }

    @Override
    protected void createContent(WebSession session) {
        // Add lesson content here
        session.setMessage("Welcome to the API Security lesson!");
    }

    @Override
    public LessonTracker getLessonTracker(WebSession session, Screen screen) {
        return super.getLessonTracker(session, screen);
    }
}