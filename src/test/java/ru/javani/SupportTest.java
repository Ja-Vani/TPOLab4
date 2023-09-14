package ru.javani;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class SupportTest {
    final private List<WebDriver> drivers = Utility.getDrivers(2);

    @Test
    void checkQuestion() {
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
}
