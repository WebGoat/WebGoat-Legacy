package org.owasp.webgoat;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class EndToEndTests {

    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        // Set up the WebDriver (ChromeDriver in this case)
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        driver.get("http://localhost:8080/WebGoat");
    }

    @AfterEach
    public void tearDown() {
        // Close the browser after each test
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testLoginFunctionality() {
        // Locate and interact with login elements
        WebElement usernameField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("login-button"));

        usernameField.sendKeys("guest");
        passwordField.sendKeys("guest");
        loginButton.click();

        // Verify successful login by checking for a specific element
        WebElement dashboard = driver.findElement(By.id("dashboard"));
        assertTrue(dashboard.isDisplayed(), "Dashboard should be displayed after login");
    }

    @Test
    public void testLessonNavigation() {
        // Log in first
        testLoginFunctionality();

        // Navigate to a lesson
        WebElement lessonLink = driver.findElement(By.linkText("SQL Injection"));
        lessonLink.click();

        // Verify lesson content is displayed
        WebElement lessonContent = driver.findElement(By.id("lesson-content"));
        assertTrue(lessonContent.isDisplayed(), "Lesson content should be displayed");
    }
}