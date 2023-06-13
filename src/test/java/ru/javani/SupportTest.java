package ru.javani;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class SupportTest {

    @BeforeAll
    public static void prepareDrivers() {
        Utility.prepareDrivers();
    }

    @Test
    void checkQuestion() {
        final List<WebDriver> drivers = Utility.getDrivers();
        drivers.parallelStream().forEach(webDriver -> {
            final SupportCenter support = new SupportCenter(webDriver);
            support.testSite(webDriver);
            support.testSupport();
            support.selectQuestion();
            assertEquals("https://support.photobucket.com/hc/en-us/articles/", webDriver.getCurrentUrl().substring(0,50));
            webDriver.quit();
        });
        assertNotNull(drivers);
    }

    @Test
    void checkSection() {
        final List<WebDriver> drivers = Utility.getDrivers();
        drivers.parallelStream().forEach(webDriver -> {
            final SupportCenter support = new SupportCenter(webDriver);
            support.testSite(webDriver);
            support.testSupport();
            support.selectSection();
            assertEquals("https://support.photobucket.com/hc/en-us/categories/", webDriver.getCurrentUrl().substring(0,52));
            webDriver.quit();
        });
        assertNotNull(drivers);
    }

    @Test
    void checkChat() {
        final List<WebDriver> drivers = Utility.getDrivers();
        assertNotNull(drivers);
        drivers.parallelStream().forEach(webDriver -> {
            final SupportCenter support = new SupportCenter(webDriver);
            support.testSite(webDriver);
            support.testSupport();
            support.useChat();
            assertEquals("Are you looking for help with our mobile app or the mobile website?",
                    Utility.getElementBySelector(webDriver,
                            By.xpath("/html/body/div[1]/div/div/div/div[2]/div[1]/div/div[5]/div[1]/div/div/span/span[2]"))
                            .getText());
            webDriver.quit();
        });
    }


}
