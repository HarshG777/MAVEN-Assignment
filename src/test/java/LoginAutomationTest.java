package com.example.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginAutomationTest {
    @Test
    public void testLogin() {
        // Set up the WebDriver for Windows (path to ChromeDriver executable)
        System.setProperty("webdriver.chrome.driver", "https://developer.chrome.com/docs/chromedriver/downloads#chromedriver_1120561549");

        WebDriver driver = new ChromeDriver();

        try {
            // Navigate to the login page
            driver.get("https://example.com/login");

            // Locate the username and password fields
            WebElement usernameField = driver.findElement(By.id("username"));
            WebElement passwordField = driver.findElement(By.id("password"));
            WebElement loginButton = driver.findElement(By.id("loginButton"));

            // Perform login
            usernameField.sendKeys("testUser");
            passwordField.sendKeys("testPassword");
            loginButton.click();

            // Validate successful login
            String expectedTitle = "Dashboard";
            String actualTitle = driver.getTitle();
            assertEquals(expectedTitle, actualTitle);

        } finally {
            // Close the browser
            driver.quit();
        }
    }
}