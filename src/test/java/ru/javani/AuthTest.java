package ru.javani;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class AuthTest {
    final private List<WebDriver> drivers = Utility.getDrivers(2);

    @Test
    void checkSignUp() {
        drivers.parallelStream().forEach(webDriver -> {
            final LoginPage loginPage = new LoginPage(webDriver);
            loginPage.testSite(webDriver);
            loginPage.goToSignUp();
            assertEquals("An account with this email already exists", loginPage.doSignUp());
            webDriver.quit();
        });
        assertNotNull(drivers);
    }

    @Test
    void checkLogin() {
        drivers.parallelStream().forEach(webDriver -> {
            final LoginPage loginPage = new LoginPage(webDriver);
            loginPage.testSite(webDriver);
            loginPage.goToLogin();
            assertEquals("https://my.photobucket.com/deactivation", loginPage.doLogin());
            webDriver.quit();
        });
        assertNotNull(drivers);
    }

    @Test
    void checkWrongLogin() {
        drivers.parallelStream().forEach(webDriver -> {
            final LoginPage loginPage = new LoginPage(webDriver);
            loginPage.testSite(webDriver);
            loginPage.goToLogin();
            assertEquals("Error logging in", loginPage.doWrongLogin());
            webDriver.quit();
        });
        assertNotNull(drivers);
    }
}
