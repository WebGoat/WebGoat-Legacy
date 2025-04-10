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
 * Source for this application is maintained at
 * https://github.com/WebGoat/WebGoat, a repository for free software projects.
 *
 * For details, please see http://webgoat.github.io
 */
package org.owasp.webgoat.service;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.owasp.webgoat.lessons.AbstractLesson;
import org.owasp.webgoat.lessons.Category;
import org.owasp.webgoat.lessons.RandomLessonAdapter;
import org.owasp.webgoat.lessons.model.LessonMenuItem;
import org.owasp.webgoat.lessons.model.LessonMenuItemType;
import org.owasp.webgoat.session.Course;
import org.owasp.webgoat.session.WebSession;
import org.owasp.webgoat.util.InputSanitizer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author rlawson
 */
@Controller
public class LessonMenuService extends BaseService {

    private static final Logger logger = LoggerFactory.getLogger(LessonMenuService.class);

    /**
     * Retrieves the lesson menu used to build the left navigation.
     *
     * @param session the HTTP session object
     * @return a list of lesson menu items
     */
    @RequestMapping(value = "/lessonmenu.mvc", produces = "application/json")
    public @ResponseBody List<LessonMenuItem> showLeftNav(HttpSession session) {
        var menu = new ArrayList<LessonMenuItem>();
        var ws = getWebSession(session);

        // Validate session object
        if (ws == null) {
            logger.warn("Invalid session: WebSession is null");
            return menu; // Return an empty menu if session is invalid
        }

        var course = ws.getCourse();
        if (course == null) {
            logger.warn("Invalid session: Course is null");
            return menu;
        }

        var categories = course.getCategories();
        for (var category : categories) {
            // Sanitize category name
            var sanitizedCategoryName = InputSanitizer.sanitize(category.getName());

            var categoryItem = new LessonMenuItem();
            categoryItem.setName(sanitizedCategoryName);
            categoryItem.setType(LessonMenuItemType.CATEGORY);

            var lessons = ws.getLessons(category);
            var role = ws.getRole();

            // Avoid logging sensitive information
            logger.debug("Processing role for category: " + sanitizedCategoryName);

            for (var lesson : lessons) {
                // Authorization check
                if (!lesson.isAuthorized(ws, role)) {
                    logger.warn("Unauthorized access attempt to lesson: " + lesson.getTitle());
                    continue;
                }

                var lessonItem = new LessonMenuItem();
                lessonItem.setName(InputSanitizer.sanitize(lesson.getTitle()));
                lessonItem.setLink(InputSanitizer.sanitize(lesson.getLink()));
                lessonItem.setType(LessonMenuItemType.LESSON);
                lessonItem.setComplete(lesson.isCompleted(ws));

                if (Category.CHALLENGE.equals(lesson.getCategory())) {
                    lessonItem.setShowHints(lesson.isAuthorized(ws, AbstractLesson.CHALLENGE_ROLE, WebSession.SHOWHINTS));
                    lessonItem.setShowSource(lesson.isAuthorized(ws, AbstractLesson.CHALLENGE_ROLE, WebSession.SHOWHINTS));
                }

                categoryItem.addChild(lessonItem);

                if (lesson instanceof RandomLessonAdapter rla) {
                    var stages = rla.getStages();
                    if (stages != null) {
                        var lessonLink = lesson.getLink();
                        for (int stageIdx = 1; stageIdx <= stages.length; stageIdx++) {
                            var stageItem = new LessonMenuItem();
                            stageItem.setName("Stage " + stageIdx + ": " + InputSanitizer.sanitize(stages[stageIdx - 1]));
                            stageItem.setLink(lessonLink + "&stage=" + stageIdx);
                            stageItem.setType(LessonMenuItemType.STAGE);
                            stageItem.setComplete(rla.isStageComplete(ws, stages[stageIdx - 1]));
                            lessonItem.addChild(stageItem);
                        }
                    }
                }
            }
            menu.add(categoryItem);
        }
        return menu;
    }
}
