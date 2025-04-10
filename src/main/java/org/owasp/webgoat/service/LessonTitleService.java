package org.owasp.webgoat.service;

import javax.servlet.http.HttpSession;

import org.owasp.webgoat.lessons.AbstractLesson;
import org.owasp.webgoat.session.Course;
import org.owasp.webgoat.session.WebSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LessonTitleService extends BaseService {
	
    /**
     * Retrieves the title for the current lesson.
     *
     * @param session the HTTP session object
     * @return the title of the current lesson
     */
    @RequestMapping(value = "/lessontitle.mvc", produces = "application/html")
    public @ResponseBody String showPlan(HttpSession session) {
        var ws = getWebSession(session);
        return getLessonTitle(ws);
    }

    /**
     * Retrieves the title of the current lesson.
     *
     * @param s the current web session
     * @return the title of the lesson, or an empty string if unavailable
     */
    private String getLessonTitle(WebSession s) {
        var scr = s.getCurrentScreen();
        var course = s.getCourse();

        if (s.isUser() || s.isChallenge()) {
            var lesson = course.getLesson(s, scr, AbstractLesson.USER_ROLE);
            return lesson != null ? lesson.getTitle() : "";
        }
        return "";
    }

}
