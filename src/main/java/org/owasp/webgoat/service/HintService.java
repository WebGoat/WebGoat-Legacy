/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.owasp.webgoat.service;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.owasp.webgoat.lessons.AbstractLesson;
import org.owasp.webgoat.lessons.model.Hint;
import org.owasp.webgoat.session.WebSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author rlawson
 */
@Controller
public class HintService extends BaseService {

    /**
     * Returns hints for current lesson
     *
     * @param session
     * @return
     */
    @RequestMapping(value = "/hint.mvc", produces = "application/json")
    public @ResponseBody List<Hint> showHint(HttpSession session) {
        var listHints = new ArrayList<Hint>();
        var ws = getWebSession(session);
        var lesson = ws.getCurrentLesson();
        if (lesson == null) return listHints;

        var hints = lesson.getHintsPublic(ws);
        if (hints == null) return listHints;

        int maxHintViewed = lesson.getLessonTracker(ws).getMaxHintLevel();
        System.out.println("maxHintViewed: " + maxHintViewed);

        for (int idx = 0; idx < hints.size(); idx++) {
            var hint = new Hint();
            hint.setHint(hints.get(idx));
            hint.setLesson(lesson.getName());
            hint.setNumber(idx);
            hint.setViewed(idx <= maxHintViewed);
            listHints.add(hint);
        }
        return listHints;
    }

    /**
     * Marks hint as viewed on the current lesson Yes this is not very RESTish -
     * clean this up in next version
     *
     * @param hintNumber
     * @param session
     * @return
     */
    @RequestMapping(value = "/hint_mark_as_viewed.mvc", produces = "application/json", method = RequestMethod.POST)
    public @ResponseBody
    boolean markHintAsViewed(HttpSession session, @RequestBody Integer hintNumber) {
        if (hintNumber == null) {
            return false;
        }
        WebSession ws = getWebSession(session);
        AbstractLesson l = ws.getCurrentLesson();
        l.getLessonTracker(ws).setMaxHintLevel(hintNumber);
        return true;
    }

    /**
     * Returns max hint viewed for current lesson
     *
     * @param session
     * @return
     */
    @RequestMapping(value = "/max_hint_viewed.mvc", produces = "application/json")
    public @ResponseBody
    Integer getMaxHintViewed(HttpSession session) {
        WebSession ws = getWebSession(session);
        AbstractLesson l = ws.getCurrentLesson();
        int maxHintViewed = l.getLessonTracker(ws).getMaxHintLevel();
        return maxHintViewed;
    }

}
