package ru.javani;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class AuthTest {

    @BeforeAll
    static void prepareDrivers() {
        Utility.prepareDrivers();
    }

    @Test
    void checkSignUp() {
        final List<WebDriver> drivers = Utility.getDrivers();
        drivers.parallelStream().forEach(webDriver -> {
            final LoginPage loginPage = new LoginPage(webDriver);
            loginPage.testSite(webDriver);
            loginPage.goToSignUp();
            loginPage.doSignUp();
            assertEquals("An account with this email already exists", Utility.getElementBySelector(webDriver, By.xpath("//*[@id=\"email-helper-text\"]")).getText());
            webDriver.quit();
        });
        assertNotNull(drivers);
    }

    @Test
    void checkLogin() {
        final List<WebDriver> drivers = Utility.getDrivers();
        drivers.parallelStream().forEach(webDriver -> {
            final LoginPage loginPage = new LoginPage(webDriver);
            loginPage.testSite(webDriver);
            loginPage.goToLogin();
            loginPage.doLogin();
            Utility.getElementBySelector(webDriver, By.xpath("//*[@id='hs_cos_wrapper_widget_1674774617303_']/img"));
            assertEquals("https://my.photobucket.com/deactivation", webDriver.getCurrentUrl());
            webDriver.quit();
        });
        assertNotNull(drivers);
    }

    @Test
    void checkWrongLogin() {
        final List<WebDriver> drivers = Utility.getDrivers();
        drivers.parallelStream().forEach(webDriver -> {
            final LoginPage loginPage = new LoginPage(webDriver);
            loginPage.testSite(webDriver);
            loginPage.goToLogin();
            loginPage.doWrongLogin();
            assertEquals("Error logging in", Utility.getElementBySelector(webDriver, By.xpath(".//*[@id='root']/div/div/form/div[3]/div[2]/div")).getText());
            webDriver.quit();
        });
        assertNotNull(drivers);
    }
}
