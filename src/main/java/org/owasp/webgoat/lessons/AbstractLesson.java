package org.owasp.webgoat.lessons;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.apache.ecs.Element;
import org.apache.ecs.ElementContainer;
import org.apache.ecs.StringElement;
import org.apache.ecs.html.Body;
import org.apache.ecs.html.Form;
import org.apache.ecs.html.Head;
import org.apache.ecs.html.Html;
import org.apache.ecs.html.IMG;
import org.apache.ecs.html.PRE;
import org.apache.ecs.html.Title;
import org.owasp.webgoat.session.ParameterNotFoundException;
import org.owasp.webgoat.session.Screen;
import org.owasp.webgoat.session.WebSession;
import org.owasp.webgoat.session.WebgoatContext;
import org.owasp.webgoat.session.WebgoatProperties;
import org.owasp.webgoat.util.BeanProvider;
import org.owasp.webgoat.util.LabelManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * AbstractLesson serves as a base class for all lessons in WebGoat.
 * It provides common functionality such as handling lesson plans, solutions, and user roles.
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
 *
 * @author Bruce Mayhew <a href="http://code.google.com/p/webgoat">WebGoat</a>
 * @created October 28, 2003
 */
public sealed class AbstractLesson extends Screen implements Comparable<Object> permits BeginnerLesson, AdvancedLesson {

    private static final Logger logger = LoggerFactory.getLogger(AbstractLesson.class);

    /**
     * Description of the Field
     */
    public final static String ADMIN_ROLE = "admin";

    public final static String CHALLENGE_ROLE = "challenge";

    /**
     * Description of the Field
     */
    public final static String HACKED_ADMIN_ROLE = "hacked_admin";

    /**
     * Description of the Field
     */
    public final static String USER_ROLE = "user";

    private static int count = 1;

    private Integer id = null;

    final static IMG nextGrey = new IMG("images/right16.gif").setAlt("Next").setBorder(0).setHspace(0).setVspace(0);

    final static IMG previousGrey = new IMG("images/left14.gif").setAlt("Previous").setBorder(0).setHspace(0)
            .setVspace(0);

    private Integer ranking;

    private Category category;

    private boolean hidden;

    private String sourceFileName;

    private Map<String, String> lessonPlanFileName = new HashMap<String, String>();

    private String lessonSolutionFileName;

    private WebgoatContext webgoatContext;

    private LinkedList<String> availableLanguages = new LinkedList<String>();

    private String defaultLanguage = "en";

    private LabelManager labelManager = null;

    /**
     * Constructor for the Lesson object
     */
    public AbstractLesson() {
        id = new Integer(++count);
    }

    public String getName() {
        String className = getClass().getName();
        return className.substring(className.lastIndexOf('.') + 1);
    }

    public void setRanking(Integer ranking) {
        this.ranking = ranking;
    }

    public void setHidden(boolean hidden) {
        this.hidden = hidden;
    }

    public void update(WebgoatProperties properties) {
        String className = getClass().getName();
        className = className.substring(className.lastIndexOf(".") + 1);
        setRanking(new Integer(properties.getIntProperty("lesson." + className + ".ranking", getDefaultRanking()
                .intValue())));
        String categoryRankingKey = "category." + getDefaultCategory().getName() + ".ranking";
        // System.out.println("Category ranking key: " + categoryRankingKey);
        Category tempCategory = Category.getCategory(getDefaultCategory().getName());
        tempCategory.setRanking(new Integer(properties.getIntProperty(categoryRankingKey, getDefaultCategory()
                .getRanking().intValue())));
        category = tempCategory;
        setHidden(properties.getBooleanProperty("lesson." + className + ".hidden", getDefaultHidden()));
        // System.out.println(className + " in " + tempCategory.getName() + "
        // (Category Ranking: " + tempCategory.getRanking() + " Lesson ranking:
        // " + getRanking() + ", hidden:" + hidden +")");
    }

    public boolean isCompleted(WebSession s) {
        return getLessonTracker(s, this).getCompleted();
    }

    /**
     * Gets the credits attribute of the AbstractLesson object
     *
     * @return The credits value
     */
    public abstract Element getCredits();

    /**
     * Description of the Method
     *
     * @param obj Description of the Parameter
     * @return Description of the Return Value
     */
    public int compareTo(Object obj) {
        return this.getRanking().compareTo(((AbstractLesson) obj).getRanking());
    }

    /**
     * Description of the Method
     *
     * @param obj Description of the Parameter
     * @return Description of the Return Value
     */
    public boolean equals(Object obj) {
        return this.getScreenId() == ((AbstractLesson) obj).getScreenId();
    }

    /**
     * Gets the category attribute of the Lesson object
     *
     * @return The category value
     */
    public Category getCategory() {
        return category;
    }

    protected abstract Integer getDefaultRanking();

    protected abstract Category getDefaultCategory();

    protected abstract boolean getDefaultHidden();

    /**
     * Reads text from a file into a String.
     * Each line in the file is represented in the String with a new-line character.
     *
     * @param reader BufferedReader to read the file.
     * @param numbers Whether to include line numbers in the output.
     * @return The content of the file as a String.
     */
    public static String readFromFile(BufferedReader reader, boolean numbers) {
        return (getFileText(reader, numbers));
    }

    /**
     * Gets the fileText attribute of the Screen class
     *
     * @param reader Description of the Parameter
     * @param numbers Description of the Parameter
     * @return The fileText value
     */
    public static String getFileText(BufferedReader reader, boolean numbers) {
        int count = 0;
        StringBuilder sb = new StringBuilder();

        try (reader) { // Use try-with-resources to ensure the reader is closed
            String line;
            while ((line = reader.readLine()) != null) {
                if (numbers) {
                    sb.append(pad(++count)).append("  ");
                }
                sb.append(line).append(System.lineSeparator());
            }
        } catch (IOException e) {
            logger.error("Error reading file: {}", e.getMessage(), e); // Log with meaningful message
        }

        return sb.toString();
    }

    /**
     * Gets the hintCount attribute of the Lesson object
     *
     * @param s The user's WebSession
     *
     * @return The hintCount value
     */
    public int getHintCount(WebSession s) {
        return getHints(s).size();
    }

    protected abstract List<String> getHints(WebSession s);

    /**
     * Fill in a minor hint that will help people who basically get it, but are
     * stuck on somthing silly.
     *
     * @param s The users WebSession
     *
     * @return The hint1 value
     */
    public String getHint(WebSession s, int hintNumber) {
        return "Hint: " + getHints(s).get(hintNumber);
    }

    /**
     * Gets the instructions attribute of the AbstractLesson object
     *
     * @return The instructions value
     */
    public abstract String getInstructions(WebSession s);

    /**
     * Gets the lessonPlan attribute of the Lesson object
     *
     * @return The lessonPlan value
     */
    public String getLessonPlan(WebSession s) {
        StringBuilder src = new StringBuilder();
        String lang = s.getCurrrentLanguage();

        try {
            String filename = getLessonPlanFileName(lang);
            if (filename == null) {
                filename = getLessonPlanFileName(getDefaultLanguage());
            }
            try (BufferedReader reader = new BufferedReader(new FileReader(s.getWebResource(filename)))) {
                src.append(readFromFile(reader, false));
            }
        } catch (IOException e) {
            logger.error("Could not find lesson plan for lesson '{}' and language '{}': {}", getLessonName(), lang, e.getMessage(), e);
            src.append("Could not find lesson plan for: ").append(getLessonName()).append(" and language ").append(lang);
        }

        return src.toString();
    }

    /**
     * Gets the ranking attribute of the Lesson object
     *
     * @return The ranking value
     */
    public Integer getRanking() {
        if (ranking != null) {
            return ranking;
        } else {
            return getDefaultRanking();
        }
    }

    /**
     * Gets the hidden value of the Lesson Object
     *
     * @return The hidden value
     */
    public boolean getHidden() {
        return this.hidden;
    }

    /**
     * Gets the role attribute of the AbstractLesson object
     *
     * @return The role value
     */
    public String getRole() {
        // FIXME: Each lesson should have a role assigned to it. Each
        // user/student
        // should also have a role(s) assigned. The user would only be allowed
        // to see lessons that correspond to their role. Eventually these roles
        // will be stored in the internal database. The user will be able to
        // hack
        // into the database and change their role. This will allow the user to
        // see the admin screens, once they figure out how to turn the admin
        // switch on.
        return USER_ROLE;
    }

    /**
     * Gets the uniqueID attribute of the AbstractLesson object
     *
     * @return The uniqueID value
     */
    public int getScreenId() {
        return id.intValue();
    }

    public String getSource(WebSession s) {
        String source = null;
        String src = null;

        try {
            // System.out.println("Loading source file: " +
            // getSourceFileName());
            src = convertMetacharsJavaCode(readFromFile(new BufferedReader(new FileReader(s
                    .getWebResource(getSourceFileName()))), true));

            // TODO: For styled line numbers and better memory efficiency,
            // use a custom FilterReader
            // that performs the convertMetacharsJavaCode() transform plus
            // optionally adds a styled
            // line number. Wouldn't color syntax be great too?
        } catch (Exception e) {
            s.setMessage("Could not find source file");
            src = ("Could not find the source file or source file does not exist.<br/>"
                    + "Send this message to: <a href=\"mailto:" + s.getWebgoatContext().getFeedbackAddress()
                    + "?subject=Source " + getSourceFileName() + " not found. Lesson: "
                    + s.getCurrentLesson().getLessonName() + "\">" + s.getWebgoatContext().getFeedbackAddress() + "</a>");
        }

        Html html = new Html();

        Head head = new Head();
        head.addElement(new Title(getSourceFileName()));

        Body body = new Body();
        body.addElement(new StringElement(src));

        html.addElement(head);
        html.addElement(body);

        source = html.toString();

        return source;
    }

    public String getSolution(WebSession s) {
        String src = null;

        try {
            // System.out.println("Solution: " + getLessonSolutionFileName());
            src = readFromFile(new BufferedReader(new FileReader(s.getWebResource(getLessonSolutionFileName()))), false);
        } catch (Exception e) {
            s.setMessage("Could not find the solution file");
            src = ("Could not find the solution file or solution file does not exist.<br/>"
                    + "Send this message to: <a href=\"mailto:" + s.getWebgoatContext().getFeedbackAddress()
                    + "?subject=Solution " + getLessonSolutionFileName() + " not found. Lesson: "
                    + s.getCurrentLesson().getLessonName() + "\">" + s.getWebgoatContext().getFeedbackAddress() + "</a>");
        }

        // Solutions are html files
        return src;
    }

    /**
     * <p>
     * Returns the default "path" portion of a lesson's URL.</p>
     *
     * <p>
     * Legacy webgoat lesson links are of the form
     * "attack?Screen=Xmenu=Ystage=Z". This method returns the path portion of
     * the url, i.e., "attack" in the string above.</p>
     *
     * <p>
     * Newer, Spring-Controller-based classes will override this method to
     * return "*.do"-styled paths.</p>
     */
    protected String getPath() {
        return "attack";
    }

    /**
     * Get the link that can be used to request this screen.
     *
     * @return
     */
    public String getLink() {
        StringBuffer link = new StringBuffer();

        // mvc update:
        link.append(getPath()).append("?");
        link.append(WebSession.SCREEN);
        link.append("=");
        link.append(getScreenId());
        link.append("&");
        link.append(WebSession.MENU);
        link.append("=");
        link.append(getCategory().getRanking());
        return link.toString();
    }

    /**
     * Get the link to the jsp page used to render this screen.
     *
     * @return
     */
    public String getPage(WebSession s) {
        return null;
    }

    /**
     * Get the link to the jsp template page used to render this screen.
     *
     * @return
     */
    public String getTemplatePage(WebSession s) {
        return null;
    }

    public abstract String getCurrentAction(WebSession s);

    public abstract void setCurrentAction(WebSession s, String lessonScreen);

    /**
     * Override this method to implement accesss control in a lesson.
     *
     * @param s
     * @param functionId
     * @return
     */
    public boolean isAuthorized(WebSession s, int employeeId, String functionId) {
        return false;
    }

    /**
     * Override this method to implement accesss control in a lesson.
     *
     * @param s
     * @param functionId
     * @return
     */
    public boolean isAuthorized(WebSession s, String role, String functionId) {
        logger.info("Checking if role '{}' is authorized for function '{}'", role, functionId);
        String query = "SELECT * FROM auth WHERE role = ? AND functionid = ?";
        boolean authorized = false;

        try (Connection connection = WebSession.getConnection(s);
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, role);
            statement.setString(2, functionId);
            try (ResultSet resultSet = statement.executeQuery()) {
                authorized = resultSet.next();
            }
        } catch (SQLException e) {
            logger.error("SQL error while authorizing role '{}' for function '{}': {}", role, functionId, e.getMessage(), e);
            s.setMessage("Error authorizing");
        } catch (Exception e) {
            logger.error("Unexpected error while authorizing role '{}' for function '{}': {}", role, functionId, e.getMessage(), e);
            s.setMessage("Error authorizing");
        }

        logger.info("Authorization result for role '{}' and function '{}': {}", role, functionId, authorized);
        return authorized;
    }

    /**
     * Generates a JavaScript function to open a new browser window.
     *
     * @param windowName The name of the window to be opened.
     * @return A JavaScript function as a String.
     */
    public static String makeWindowScript(String windowName) {
        StringBuffer script = new StringBuffer();
        script.append("<script language=\"JavaScript\">\n");
        script.append(" <!--\n");
        script.append("   function makeWindow(url) {\n");
        script.append("\n");
        script.append("       agent = navigator.userAgent;\n");
        script.append("\n");
        script.append("       params  = \"\";\n");
        script.append("       params += \"toolbar=0,\";\n");
        script.append("       params += \"location=0,\";\n");
        script.append("       params += \"directories=0,\";\n");
        script.append("       params += \"status=0,\";\n");
        script.append("       params += \"menubar=0,\";\n");
        script.append("       params += \"scrollbars=1,\";\n");
        script.append("       params += \"resizable=1,\";\n");
        script.append("       params += \"width=500,\";\n");
        script.append("       params += \"height=350\";\n");
        script.append("\n");
        script.append("       // close the window to vary the window size\n");
        script.append("       if (typeof(win) == \"object\" && !win.closed){\n");
        script.append("            win.close();\n");
        script.append("       }\n");
        script.append("\n");
        script.append("       win = window.open(url, '" + windowName + "' , params);\n");
        script.append("\n");
        script.append("           // bring the window to the front\n");
        script.append("       win.focus();\n");
        script.append("   }\n");
        script.append(" //-->\n");
        script.append(" </script>\n");

        return script.toString();
    }

    /**
     * Handles the HTTP request for the lesson.
     *
     * @param s The current WebSession.
     */
    public void handleRequest(WebSession s) {
        Form form = new Form(getLink(), Form.POST).setName("form").setEncType("");
        form.addElement(createContent(s));
        setContent(form);
    }

    /**
     * Description of the Method
     *
     * @param s Description of the Parameter
     * @return Description of the Return Value
     */
    public String toString() {
        return getTitle();
    }

    public String getDefaultLanguage() {
        return this.defaultLanguage;
    }

    public String getLessonPlanFileName(String lang) {
        String ret = lessonPlanFileName.get(lang);
        if (ret == null) {
            ret = lessonPlanFileName.get(getDefaultLanguage());
        }
        return ret;
    }

    public void setLessonPlanFileName(String lang, String lessonPlanFileName) {
        this.lessonPlanFileName.put(lang, lessonPlanFileName);
        this.availableLanguages.add(lang);
    }

    public List<String> getAvailableLanguages() {
        return this.availableLanguages;
    }

    public String getLessonSolutionFileName() {
        return lessonSolutionFileName;
    }

    public void setLessonSolutionFileName(String lessonSolutionFileName) {
        this.lessonSolutionFileName = lessonSolutionFileName;
    }

    public String getSourceFileName() {
        return sourceFileName;
    }

    public void setSourceFileName(String sourceFileName) {
        logger.debug("Setting source file of lesson " + this + " to: " + sourceFileName);
        this.sourceFileName = sourceFileName;
    }

    public WebgoatContext getWebgoatContext() {
        return webgoatContext;
    }

    public void setWebgoatContext(WebgoatContext webgoatContext) {
        this.webgoatContext = webgoatContext;
    }
    
    protected LabelManager getLabelManager() {
    	if(labelManager == null) {
    		labelManager = BeanProvider.getBean("labelManager", LabelManager.class);
    	}
    	return labelManager;
    }
}

public final class BeginnerLesson extends AbstractLesson {
    // Implementation specific to BeginnerLesson
}

public final class AdvancedLesson extends AbstractLesson {
    // Implementation specific to AdvancedLesson
}
