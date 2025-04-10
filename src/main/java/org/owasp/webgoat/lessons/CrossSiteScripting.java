import org.apache.commons.lang3.StringEscapeUtils;

public class SafeOutputExample {

    public static void main(String[] args) {
        // Simulating user input
        String userInput = "<script>alert('XSS');</script>";

        // Added output encoding to prevent XSS
        String safeOutput = StringEscapeUtils.escapeHtml4(userInput);
        System.out.println("<div>" + safeOutput + "</div>");
    }
}