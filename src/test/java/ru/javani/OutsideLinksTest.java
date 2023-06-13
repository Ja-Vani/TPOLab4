package ru.javani;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class OutsideLinksTest {
    @BeforeAll
    public static void prepareDrivers() {
        Utility.prepareDrivers();
    }
    @Test
    void checkPrintShop() {
        final List<WebDriver> drivers = Utility.getDrivers();
        drivers.parallelStream().forEach(webDriver -> {
            final SiteFooter siteFooter = new SiteFooter(webDriver);
            siteFooter.testSite(webDriver);
            siteFooter.goToPrintShop();
            final ArrayList<String> tabs = new ArrayList<> (webDriver.getWindowHandles());
            webDriver.switchTo().window(tabs.get(1));
            assertEquals("https://www.printshoplab.com", webDriver.getCurrentUrl().substring(0, 28));
            webDriver.quit();
        });
        assertNotNull(drivers);
    }

    @Test
    void checkSocial() {
        final List<WebDriver> drivers = Utility.getDrivers();
        drivers.parallelStream().forEach(webDriver -> {
            final SiteFooter siteFooter = new SiteFooter(webDriver);
            siteFooter.testSite(webDriver);
            siteFooter.goToSocialMedia();
            final ArrayList<String> tabs = new ArrayList<> (webDriver.getWindowHandles());
            webDriver.switchTo().window(tabs.get(1));
            assertEquals("https://www.youtube.com/", webDriver.getCurrentUrl().substring(0, 24));
            webDriver.quit();
        });
        assertNotNull(drivers);
    }

    @Test
    void checkContact() {
        final List<WebDriver> drivers = Utility.getDrivers();
        drivers.parallelStream().forEach(webDriver -> {
            final SiteFooter siteFooter = new SiteFooter(webDriver);
            siteFooter.testSite(webDriver);
            siteFooter.goToContact();
            assertEquals("https://zendesk.photobucket.com", webDriver.getCurrentUrl().substring(0, 31));
            webDriver.quit();
        });
        assertNotNull(drivers);
    }

    @Test
    void checkBlog() {
        final List<WebDriver> drivers = Utility.getDrivers();
        drivers.parallelStream().forEach(webDriver -> {
            final SiteFooter siteFooter = new SiteFooter(webDriver);
            siteFooter.testSite(webDriver);
            siteFooter.goToBlog();
            assertEquals("https://blog.photobucket.com", webDriver.getCurrentUrl().substring(0, 28));
            webDriver.quit();
        });
        assertNotNull(drivers);
    }

    @Test
    void checkAppAndroid() {
        final List<WebDriver> drivers = Utility.getDrivers();
        drivers.parallelStream().forEach(webDriver -> {
            final SiteHeader siteHeader = new SiteHeader(webDriver);
            siteHeader.testSite(webDriver);
            siteHeader.goToAppAndroid();
            final ArrayList<String> tabs = new ArrayList<> (webDriver.getWindowHandles());
            webDriver.switchTo().window(tabs.get(1));
            assertEquals("https://play.google.com/store/apps/details?id=com.photobucket.android", webDriver.getCurrentUrl().substring(0, 69));
            webDriver.quit();
        });
        assertNotNull(drivers);
    }

    @Test
    void checkAppIos() {
        final List<WebDriver> drivers = Utility.getDrivers();
        drivers.parallelStream().forEach(webDriver -> {
            final SiteHeader siteHeader = new SiteHeader(webDriver);
            siteHeader.testSite(webDriver);
            siteHeader.goToAppIos();
            final ArrayList<String> tabs = new ArrayList<> (webDriver.getWindowHandles());
            webDriver.switchTo().window(tabs.get(1));
            assertEquals("https://apps.apple.com/us/app/photobucket-backup/", webDriver.getCurrentUrl().substring(0, 49));
            webDriver.quit();
        });
        assertNotNull(drivers);
    }

}
