/**
 * *************************************************************************************************
 *
 *
 * This file is part of WebGoat, an Open Web Application Security Project
 * utility. For details, please see http://www.owasp.org/
 *
 * Copyright (c) 2002 - 20014 Bruce Mayhew
 *
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation; either version 2 of the License, or (at your option) any later
 * version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 *
 * You should have received a copy of the GNU General Public License along with
 * this program; if not, write to the Free Software Foundation, Inc., 59 Temple
 * Place - Suite 330, Boston, MA 02111-1307, USA.
 *
 * Getting Source ==============
 *
 * Source for this application is maintained at https://github.com/WebGoat/WebGoat, a repository
 * for free software projects.
 *
 * For details, please see http://webgoat.github.io
 */
package org.owasp.webgoat.service;

import javax.servlet.http.HttpSession;
import static org.owasp.webgoat.LessonSource.END_SOURCE_SKIP;
import static org.owasp.webgoat.LessonSource.START_SOURCE_SKIP;
import org.owasp.webgoat.lessons.AbstractLesson;
import org.owasp.webgoat.session.Course;
import org.owasp.webgoat.session.WebSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author rlawson
 */
@Controller
public class SourceService extends BaseService {

    /**
     * Retrieves the source code for the current attack.
     *
     * @param session the HTTP session object
     * @return the source code as a string, or a message indicating no source is available
     */
    @RequestMapping(value = "/source.mvc", produces = "application/text")
    public @ResponseBody String showSource(HttpSession session) {
        var ws = getWebSession(session);
        var source = getSource(ws);
        return source != null ? source : "No source listing found";
    }

    /**
     * Retrieves the raw source code for the current lesson.
     *
     * @param s the current web session
     * @return the raw source code with omitted sections replaced, or a message indicating no source is available
     */
    protected String getSource(WebSession s) {
        var scr = s.getCurrentScreen();
        var course = s.getCourse();

        if (s.isUser() || s.isChallenge()) {
            var lesson = course.getLesson(s, scr, AbstractLesson.USER_ROLE);
            if (lesson != null) {
                return lesson.getRawSource(s).replaceAll("(?s)" + START_SOURCE_SKIP + ".*" + END_SOURCE_SKIP,
                        "Code Section Deliberately Omitted");
            }
        }
        return "Source code is not available for this lesson.";
    }
}
