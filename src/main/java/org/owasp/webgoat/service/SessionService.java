/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.owasp.webgoat.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author rlawson
 */
@Controller
public class SessionService extends BaseService {

    /**
     * Displays session details for the current HTTP session.
     *
     * @param request the HTTP request object
     * @param session the HTTP session object
     * @return a string containing session details
     */
    @RequestMapping(value = "/session.mvc", produces = "application/json")
    public @ResponseBody String showSession(HttpServletRequest request, HttpSession session) {
        var sb = new StringBuilder();
        sb.append("id = ").append(session.getId()).append("\n")
          .append("created = ").append(new Date(session.getCreationTime())).append("\n")
          .append("last access = ").append(new Date(session.getLastAccessedTime())).append("\n")
          .append("timeout (secs) = ").append(session.getMaxInactiveInterval()).append("\n")
          .append("session from cookie? = ").append(request.isRequestedSessionIdFromCookie()).append("\n")
          .append("session from url? = ").append(request.isRequestedSessionIdFromURL()).append("\n")
          .append("=====================================\n");

        var attributes = Collections.list(session.getAttributeNames());
        Collections.sort(attributes);
        for (var attribute : attributes) {
            var value = session.getAttribute(attribute) + "";
            sb.append(attribute).append(" = ").append(value).append("\n");
        }
        return sb.toString();
    }
}
