package org.owasp.webgoat.service;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Controller
public class ExportService {

    @GetMapping(value = "/export", produces = "text/csv")
    public void exportData(HttpServletResponse response) throws IOException {
        // Set response headers
        response.setContentType("text/csv");
        response.setHeader("Content-Disposition", "attachment; filename=export.csv");

        // Write CSV data
        try (PrintWriter writer = response.getWriter()) {
            writer.println("ID,Name,Role");
            writer.println("1,John Doe,Manager");
            writer.println("2,Jane Smith,Employee");
            writer.println("3,Bob Johnson,HR");
        }
    }
}